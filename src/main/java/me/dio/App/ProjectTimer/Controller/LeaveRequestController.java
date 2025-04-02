package me.dio.App.ProjectTimer.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import me.dio.App.ProjectTimer.Service.LeaveRequestService;
import me.dio.App.ProjectTimer.models.LeaveRequest;
import me.dio.App.ProjectTimer.Dto.response.LeaveRequestResponse;

import me.dio.App.ProjectTimer.models.User;
import me.dio.App.ProjectTimer.models.enums.LeaveStatus;
import me.dio.App.ProjectTimer.models.enums.LeaveType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import me.dio.App.ProjectTimer.Dto.request.LeaveRequestCreateDTO;

import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("/api/leave-requests")
public class LeaveRequestController {


    private final LeaveRequestService leaveRequestService;
    private final ObjectMapper objectMapper;

    public LeaveRequestController(LeaveRequestService leaveRequestService, ObjectMapper objectMapper) {
        this.leaveRequestService = leaveRequestService;
        this.objectMapper = objectMapper;
    }
    @PostMapping
    public ResponseEntity<?> create(
            @RequestBody @Valid LeaveRequestCreateDTO dto,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest()
                    .body(bindingResult.getAllErrors());
        }

        try {
            LeaveRequest entity = convertToEntity(dto);
            LeaveRequest saved = leaveRequestService.createRequest(entity);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(convertToResponse(saved));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", e.getMessage()));
        }
    }

    private LeaveRequest convertToEntity(LeaveRequestCreateDTO dto) {
        LeaveRequest request = new LeaveRequest();

        try {
            request.setLeaveType(LeaveType.valueOf(dto.leaveType()));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Tipo de folga inválido. Valores aceitos: "
                    + Arrays.toString(LeaveType.values()));
        }

        request.setStartDate(dto.startDate());
        request.setEndDate(dto.endDate());
        request.setReason(dto.reason());
        request.setProject(dto.project());
        request.setStatus(LeaveStatus.PENDING);

        User user = new User();
        user.setId(dto.userId());
        request.setUser(user);

        return request;
    }

    private LeaveRequestResponse convertToResponse(LeaveRequest entity) {
        return new LeaveRequestResponse(
                entity.getId(),
                entity.getStatus(),
                entity.getStartDate(),
                entity.getEndDate(),
                entity.getLeaveType().toString(),
                entity.getReason(),
                entity.getProject()
        );
    }
}