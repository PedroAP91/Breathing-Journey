package com.breathingjourney.userprofileservice.repository;

import com.breathingjourney.userprofileservice.model.DailyLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DailyLogRepository extends JpaRepository<DailyLog, Long> {
    List<DailyLog> findByUserProfileId(Long userProfileId);
}
