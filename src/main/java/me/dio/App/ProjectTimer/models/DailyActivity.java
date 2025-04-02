package me.dio.App.ProjectTimer.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class DailyActivity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date; // CAMPO FALTANTE ESSENCIAL

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ElementCollection
    private List<String> hours;

    @ElementCollection
    private List<String> projects;

    @ElementCollection
    private List<String> cards;

    // Adicionar getters/setters para o novo campo
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
}