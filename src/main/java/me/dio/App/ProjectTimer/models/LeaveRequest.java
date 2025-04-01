package me.dio.App.ProjectTimer.models;

import jakarta.persistence.*;

@Entity
public class LeaveRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String leaveType;
    private String startDate;
    private String endDate;
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public void approveLeave() {
        this.status = "Approved";
    }

    public void rejectLeave() {
        this.status = "Rejected";
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getLeaveType() { return leaveType; }
    public void setLeaveType(String leaveType) { this.leaveType = leaveType; }
    public String getStartDate() { return startDate; }
    public void setStartDate(String startDate) { this.startDate = startDate; }
    public String getEndDate() { return endDate; }
    public void setEndDate(String endDate) { this.endDate = endDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
