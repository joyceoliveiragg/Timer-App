package me.dio.App.ProjectTimer.exception;

public class LeaveRequestNotFoundException extends RuntimeException {
    public LeaveRequestNotFoundException(Long id) {
        super("Solicitação de folga não encontrada com ID: " + id);
    }
}