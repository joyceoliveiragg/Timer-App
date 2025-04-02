package me.dio.App.ProjectTimer.Dto.response;


public record UserResponse(
        Long id,
        String userName,
        UserInfoResponse userInfo,
        WorkloadResponse workload
) {
    public record UserInfoResponse(
            String employeeId,
            String email,
            String role,
            String contractType
    ) {}

    public record WorkloadResponse(
            String totalHours
    ) {}
}