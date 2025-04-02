package me.dio.App.ProjectTimer.Service;

import me.dio.App.ProjectTimer.models.LeaveRequest;
import me.dio.App.ProjectTimer.models.enums.LeaveStatus;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

public interface LeaveRequestService {
    LeaveRequest createRequest(LeaveRequest request);
    LeaveRequest updateStatus(Long id, LeaveStatus newStatus);

    LeaveRequest updateStatus(Long id, String status);

    @Transactional(readOnly = true)
    List<LeaveRequest> findByUserAndPeriod(Long userId, LocalDate startDate, LocalDate endDate);

    @Transactional(readOnly = true)
    List<LeaveRequest> findByStatus(LeaveStatus status);

    @Transactional
    void cancelRequest(Long id);
}