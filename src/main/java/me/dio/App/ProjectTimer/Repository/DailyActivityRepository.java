package me.dio.App.ProjectTimer.Repository;

import me.dio.App.ProjectTimer.models.DailyActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface DailyActivityRepository extends JpaRepository<DailyActivity, Long> {
    @Query("SELECT da FROM DailyActivity da WHERE da.user.id = :userId AND da.date BETWEEN :start AND :end")
    List<DailyActivity> findActivitiesByUserAndPeriod(
            @Param("userId") Long userId,
            @Param("start") LocalDate start,
            @Param("end") LocalDate end);


}