package me.dio.App.ProjectTimer.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class DailyActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<String> hours;

    @ElementCollection
    private List<String> projects;

    @ElementCollection
    private List<String> cards;

    // Getters e Setters
}