package me.dio.App.ProjectTimer.models;

import jakarta.persistence.*;
import me.dio.App.ProjectTimer.models.enums.LeaveStatus;
import me.dio.App.ProjectTimer.models.enums.LeaveType;
import java.time.LocalDate;

@Entity
public class LeaveRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private LeaveType leaveType;  // Usando o enum LeaveType

    private LocalDate startDate;
    private LocalDate endDate;
    private String project;
    private String reason;

    @Enumerated(EnumType.STRING)
    private LeaveStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public void approveLeave() {
        this.status = LeaveStatus.APPROVED;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public void rejectLeave() {
        this.status = LeaveStatus.REJECTED;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LeaveType getLeaveType() { return leaveType; }
    public void setLeaveType(LeaveType leaveType) { this.leaveType = leaveType; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public LeaveStatus getStatus() { return status; }
    public void setStatus(LeaveStatus status) { this.status = status; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public String getReason() { return reason; }
    public String getProject() { return project; }
}