package me.dio.App.ProjectTimer.models.enums;

public enum LeaveStatus {
    PENDING, APPROVED, REJECTED, CANCELLED;

    public static LeaveStatus fromString(String value) {
        try {
            return LeaveStatus.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Status inválido: " + value);
        }
    }
}