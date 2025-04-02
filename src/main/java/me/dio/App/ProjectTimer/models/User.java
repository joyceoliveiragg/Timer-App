package me.dio.App.ProjectTimer.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    @OneToOne(cascade = CascadeType.ALL)
    private UserInfo userInfo;

    @OneToOne(cascade = CascadeType.ALL)
    private Workload workload;

    @OneToOne(cascade = CascadeType.ALL)
    private WeekActivity weekActivity;

    @OneToOne(cascade = CascadeType.ALL)
    private Progress progress;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DailyActivity> dailyActivities;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LeaveRequest> leaveRequests;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public UserInfo getUserInfo() { return userInfo; }
    public void setUserInfo(UserInfo userInfo) { this.userInfo = userInfo; }

    public Workload getWorkload() { return workload; }
    public void setWorkload(Workload workload) { this.workload = workload; }

    public WeekActivity getWeekActivity() { return weekActivity; }
    public void setWeekActivity(WeekActivity weekActivity) { this.weekActivity = weekActivity; }

    public List<DailyActivity> getDailyActivities() { return dailyActivities; }
    public void setDailyActivities(List<DailyActivity> dailyActivities) {
        this.dailyActivities = dailyActivities;
    }

    public Progress getProgress() { return progress; }
    public void setProgress(Progress progress) { this.progress = progress; }

    public List<LeaveRequest> getLeaveRequests() { return leaveRequests; }
    public void setLeaveRequests(List<LeaveRequest> leaveRequests) {
        this.leaveRequests = leaveRequests;
    }
}