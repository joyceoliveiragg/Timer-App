package me.dio.App.ProjectTimer.models;

import jakarta.persistence.*;

@Entity
public class Workload {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String totalHours;
    @OneToOne(mappedBy = "workload")
    private User user;

    public void setUser(User user) {  this.user = user;}
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTotalHours() { return totalHours; }
    public void setTotalHours(String totalHours) { this.totalHours = totalHours; }
}

