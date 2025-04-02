package me.dio.App.ProjectTimer.Dto.request;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import me.dio.App.ProjectTimer.models.enums.LeaveType;
import java.time.LocalDate;
import java.util.Arrays;

public record LeaveRequestCreateDTO(
        @NotNull Long userId,
        @NotNull String leaveType,
        @FutureOrPresent LocalDate startDate,
        @FutureOrPresent LocalDate endDate,
        String reason,
        String project
) {
    public LeaveRequestCreateDTO {
        try {
            LeaveType.valueOf(leaveType);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Tipo de folga inválido. Valores permitidos: "
                    + Arrays.toString(LeaveType.values()));
        }
    }
}