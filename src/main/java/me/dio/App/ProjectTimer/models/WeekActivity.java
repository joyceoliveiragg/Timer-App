package me.dio.App.ProjectTimer.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class WeekActivity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<String> days;

    @ElementCollection
    private List<String> workedHours;

    @ElementCollection
    private List<String> workloads;

    @ElementCollection
    private List<String> projects;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public List<String> getDays() { return days; }
    public void setDays(List<String> days) { this.days = days; }
    public List<String> getWorkedHours() { return workedHours; }
    public void setWorkedHours(List<String> workedHours) { this.workedHours = workedHours; }
    public List<String> getWorkloads() { return workloads; }
    public void setWorkloads(List<String> workloads) { this.workloads = workloads; }
    public List<String> getProjects() { return projects; }
    public void setProjects(List<String> projects) { this.projects = projects; }
    }

