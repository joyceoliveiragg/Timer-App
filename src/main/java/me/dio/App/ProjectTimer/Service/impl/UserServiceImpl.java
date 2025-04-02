package me.dio.App.ProjectTimer.Service.impl;

import me.dio.App.ProjectTimer.Repository.UserRepository;
import me.dio.App.ProjectTimer.Service.UserService;
import me.dio.App.ProjectTimer.models.DailyActivity;
import me.dio.App.ProjectTimer.models.LeaveRequest;
import me.dio.App.ProjectTimer.models.User;
import me.dio.App.ProjectTimer.models.Workload;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public User create(User user) {
        if (userRepository.existsByUserInfoEmail(user.getUserInfo().getEmail())) {
            throw new IllegalArgumentException("Email já cadastrado");
        }

        if (userRepository.existsByUserInfoEmployeeId(user.getUserInfo().getEmployeeId())) {
            throw new IllegalArgumentException("Matrícula já existe");
        }

        return userRepository.save(user);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /**
     * @param user
     * @return
     */
    @Override
    public User updateUser(User user) {
        return null;
    }

    /**
     * @param id
     */
    @Override
    public void deleteUser(Long id) {

    }

    /**
     * @param userId
     * @param workload
     * @return
     */
    @Override
    public User updateWorkload(Long userId, Workload workload) {
        return null;
    }

    /**
     * @param userId
     * @param start
     * @param end
     * @return
     */
    @Override
    public List<DailyActivity> getUserActivities(Long userId, LocalDate start, LocalDate end) {
        return List.of();
    }

    /**
     * @param userId
     * @param leaveRequest
     */
    @Override
    public void requestLeave(Long userId, LeaveRequest leaveRequest) {

    }

    @Transactional
    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}