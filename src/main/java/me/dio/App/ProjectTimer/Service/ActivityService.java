package me.dio.App.ProjectTimer.Service;

import me.dio.App.ProjectTimer.models.DailyActivity;
import me.dio.App.ProjectTimer.models.WeekActivity;

import java.time.LocalDate;
import java.util.List;

public interface ActivityService {
    DailyActivity logActivity(DailyActivity activity);
    WeekActivity generateWeeklyReport(Long userId, LocalDate weekStart);
    List<DailyActivity> getActivitiesBetweenDates(Long userId, LocalDate start, LocalDate end);
}
