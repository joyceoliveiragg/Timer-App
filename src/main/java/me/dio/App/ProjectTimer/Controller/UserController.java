package me.dio.App.ProjectTimer.Controller;


import jakarta.validation.Valid;
import me.dio.App.ProjectTimer.Dto.request.UserCreateDTO;
import me.dio.App.ProjectTimer.Dto.response.UserResponse;
import me.dio.App.ProjectTimer.Service.UserService;
import me.dio.App.ProjectTimer.models.User;
import me.dio.App.ProjectTimer.models.UserInfo;
import me.dio.App.ProjectTimer.models.Workload;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<?> createUser(
            @RequestBody @Valid UserCreateDTO dto,
            BindingResult bindingResult  // Captura os erros de validação
    ) {
        // Adicione este bloco para tratar erros de validação explicitamente
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(
                    Map.of(
                            "error", "Dados inválidos",
                            "details", bindingResult.getFieldErrors().stream()
                                    .map(error -> error.getField() + ": " + error.getDefaultMessage())
                                    .toList()
                    )
            );
        }

        try {
            User user = convertToEntity(dto);
            User savedUser = userService.create(user);
            return ResponseEntity.ok(convertToResponse(savedUser)); // Use o DTO de resposta
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Map.of("error", "Usuário já existe"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(Map.of("error", "Erro ao criar usuário", "message", e.getMessage()));
        }
    }
    private User convertToEntity(UserCreateDTO dto) {
        User user = new User();
        user.setUserName(dto.userName());

        // Converter UserInfoDTO para UserInfo
        UserInfo userInfo = new UserInfo();
        UserCreateDTO.UserInfoDTO infoDto = dto.userInfo();
        userInfo.setEmployeeId(infoDto.employeeId());
        userInfo.setEmail(infoDto.email());
        userInfo.setPassword(infoDto.password());
        userInfo.setRole(infoDto.role());
        userInfo.setContractType(infoDto.contractType());
        userInfo.setSector(infoDto.sector());
        userInfo.setManager(infoDto.manager());
        userInfo.setWeeklyWorkload(infoDto.weeklyWorkload());
        userInfo.setHireDate(infoDto.hireDate());
        user.setUserInfo(userInfo);

        // Converter WorkloadDTO para Workload
        Workload workload = new Workload();
        workload.setTotalHours(dto.workload().totalHours());
        user.setWorkload(workload);

        // Estabelecer relações bidirecionais
        userInfo.setUser(user);
        workload.setUser(user);

        return user;
    }

    private UserResponse convertToResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getUserName(),
                new UserResponse.UserInfoResponse(
                        user.getUserInfo().getEmployeeId(),
                        user.getUserInfo().getEmail(),
                        user.getUserInfo().getRole(),
                        user.getUserInfo().getContractType()
                ),
                new UserResponse.WorkloadResponse(
                        user.getWorkload().getTotalHours()
                )
        );
    }
}