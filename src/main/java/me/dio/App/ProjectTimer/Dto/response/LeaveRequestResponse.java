package me.dio.App.ProjectTimer.Dto.response;

import me.dio.App.ProjectTimer.models.enums.LeaveStatus;
import java.time.LocalDate;

public record LeaveRequestResponse(
        Long id,
        LeaveStatus status,
        LocalDate startDate,
        LocalDate endDate,
        String leaveType,
        String reason,
        String project
) {
    public Long getId() { return id; }
    public LeaveStatus getStatus() { return status; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public String getLeaveType() { return leaveType; }
    public String getReason() { return reason; }
    public String getProject() { return project; }
}