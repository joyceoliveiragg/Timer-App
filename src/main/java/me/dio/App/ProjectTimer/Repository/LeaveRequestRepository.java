package me.dio.App.ProjectTimer.Repository;

import me.dio.App.ProjectTimer.models.LeaveRequest;
import me.dio.App.ProjectTimer.models.enums.LeaveStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {
    List<LeaveRequest> findByStatus(LeaveStatus status);
    List<LeaveRequest> findByUserIdAndStartDateBetween(Long userId, LocalDate start, LocalDate end);
}