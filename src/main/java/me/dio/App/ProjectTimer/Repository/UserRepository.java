package me.dio.App.ProjectTimer.Repository;

import me.dio.App.ProjectTimer.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT COUNT(u) > 0 FROM User u WHERE u.userInfo.employeeId = :employeeId")
    boolean existsByEmployeeId(@Param("employeeId") String employeeId);

    boolean existsByUserInfoEmail(String email);

    boolean existsByUserInfoEmployeeId(String employeeId);
}