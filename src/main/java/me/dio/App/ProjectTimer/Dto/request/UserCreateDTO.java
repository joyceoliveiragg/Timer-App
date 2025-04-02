package me.dio.App.ProjectTimer.Dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import jakarta.validation.constraints.*;


public record UserCreateDTO(
        @NotBlank(message = "Nome do usuário é obrigatório")
        @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
        String userName,

        @NotNull(message = "Informações do usuário são obrigatórias")
        @Valid // Valida os campos internos do UserInfoDTO
        UserInfoDTO userInfo,

        @NotNull(message = "Carga horária é obrigatória")
        @Valid // Valida os campos internos do WorkloadDTO
        WorkloadDTO workload
) {
    public record UserInfoDTO(
            @NotBlank(message = "Matrícula é obrigatória")
            @Size(min = 5, max = 20, message = "Matrícula deve ter entre 5 e 20 caracteres")
            String employeeId,

            @NotBlank(message = "Email é obrigatório")
            @Email(message = "Email deve ser válido")
            String email,

            @NotBlank(message = "Senha é obrigatória")
            @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d).{8,}$",
                    message = "Senha deve ter pelo menos 8 caracteres com letras e números")
            String password,

            String role,  // Opcional

            @NotBlank(message = "Tipo de contrato é obrigatório")
            String contractType,

            String sector,  // Opcional

            String manager,  // Opcional

            @NotBlank(message = "Carga horária semanal é obrigatória")
            String weeklyWorkload,

            @NotNull(message = "Data de contratação é obrigatória")
            LocalDate hireDate
    ) {}

    public record WorkloadDTO(
            @NotBlank(message = "Carga horária total é obrigatória")
            String totalHours
    ) {}
}