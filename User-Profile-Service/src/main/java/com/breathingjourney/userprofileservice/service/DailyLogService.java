package com.breathingjourney.userprofileservice.service;

import com.breathingjourney.userprofileservice.dto.DailyLogDTO;
import java.util.List;

public interface DailyLogService {
    DailyLogDTO createDailyLog(DailyLogDTO dailyLogDTO);
    DailyLogDTO getDailyLogById(Long id);
    List<DailyLogDTO> getDailyLogsByUserProfileId(Long userProfileId);
    DailyLogDTO updateDailyLog(Long id, DailyLogDTO dailyLogDTO);
    void deleteDailyLog(Long id);
}
