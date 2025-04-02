package me.dio.App.ProjectTimer.Service;

import me.dio.App.ProjectTimer.models.DailyActivity;
import me.dio.App.ProjectTimer.models.LeaveRequest;
import me.dio.App.ProjectTimer.models.User;
import me.dio.App.ProjectTimer.models.Workload;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findById(Long id);
    User create(User user);
    List<User> findAll();
    User updateUser(User user);
    void deleteUser(Long id);


    User updateWorkload(Long userId, Workload workload);
    List<DailyActivity> getUserActivities(Long userId, LocalDate start, LocalDate end);
    void requestLeave(Long userId, LeaveRequest leaveRequest);

    @Transactional
    User update(User user);

    @Transactional
    void delete(Long id);
}