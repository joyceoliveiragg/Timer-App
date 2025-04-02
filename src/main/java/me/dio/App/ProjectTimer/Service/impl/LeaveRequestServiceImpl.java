package me.dio.App.ProjectTimer.Service.impl;

import me.dio.App.ProjectTimer.exception.LeaveRequestNotFoundException;
import me.dio.App.ProjectTimer.models.LeaveRequest;
import me.dio.App.ProjectTimer.models.enums.LeaveStatus;
import me.dio.App.ProjectTimer.Repository.LeaveRequestRepository;
import me.dio.App.ProjectTimer.Repository.UserRepository;
import me.dio.App.ProjectTimer.Service.LeaveRequestService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {

    private final LeaveRequestRepository leaveRequestRepository;
    private final UserRepository userRepository;

    public LeaveRequestServiceImpl(LeaveRequestRepository leaveRequestRepository,
                                   UserRepository userRepository) {
        this.leaveRequestRepository = leaveRequestRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public LeaveRequest createRequest(LeaveRequest leaveRequest) {
        if (leaveRequest.getStartDate().isAfter(leaveRequest.getEndDate())) {
            throw new IllegalArgumentException("Start date must be before end date");
        }

        if (!userRepository.existsById(leaveRequest.getUser().getId())) {
            throw new IllegalArgumentException("User not found");
        }

        if (leaveRequest.getStatus() == null) {
            leaveRequest.setStatus(LeaveStatus.PENDING);
        }

        return leaveRequestRepository.save(leaveRequest);
    }

    @Override
    @Transactional
    public LeaveRequest updateStatus(Long id, LeaveStatus newStatus) {
        LeaveRequest request = leaveRequestRepository.findById(id)
                .orElseThrow(() -> new LeaveRequestNotFoundException(id));

        if (request.getStatus() == LeaveStatus.APPROVED && newStatus == LeaveStatus.PENDING) {
            throw new IllegalStateException("Cannot revert from APPROVED to PENDING");
        }

        request.setStatus(newStatus);
        return leaveRequestRepository.save(request);
    }

    public LeaveRequest updateStatus(Long id, String status) {
        // Implementação alternativa se necessário
        return updateStatus(id, LeaveStatus.valueOf(status.toUpperCase()));
    } //*

    @Transactional(readOnly = true)
    public List<LeaveRequest> findByUserAndPeriod(Long userId, LocalDate startDate, LocalDate endDate) {
        return leaveRequestRepository.findByUserIdAndStartDateBetween(userId, startDate, endDate);
    }

    @Transactional(readOnly = true)
    public List<LeaveRequest> findByStatus(LeaveStatus status) {
        return leaveRequestRepository.findByStatus(status);
    }

    @Transactional
    public void cancelRequest(Long id) {
        LeaveRequest request = leaveRequestRepository.findById(id)
                .orElseThrow(() -> new LeaveRequestNotFoundException(id));

        if (request.getStatus() != LeaveStatus.PENDING) {
            throw new IllegalStateException("Only pending requests can be cancelled");
        }

        request.setStatus(LeaveStatus.CANCELLED);
        leaveRequestRepository.save(request);
    }
}