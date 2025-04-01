package me.dio.App.ProjectTimer.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Progress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String totalWorkedHoursMonth;
    private String totalWorkedHoursWeek;
    private String remainingLeaves;
    private String holidays;
    // Getters e Setters
}