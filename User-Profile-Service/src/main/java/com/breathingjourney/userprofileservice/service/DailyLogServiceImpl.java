package com.breathingjourney.userprofileservice.service;

import com.breathingjourney.userprofileservice.dto.DailyLogDTO;
import com.breathingjourney.userprofileservice.exception.ResourceNotFoundException;
import com.breathingjourney.userprofileservice.model.DailyLog;
import com.breathingjourney.userprofileservice.model.UserProfile;
import com.breathingjourney.userprofileservice.repository.DailyLogRepository;
import com.breathingjourney.userprofileservice.repository.UserProfileRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DailyLogServiceImpl implements DailyLogService {

    private final DailyLogRepository dailyLogRepository;
    private final UserProfileRepository userProfileRepository;

    public DailyLogServiceImpl(DailyLogRepository dailyLogRepository, UserProfileRepository userProfileRepository) {
        this.dailyLogRepository = dailyLogRepository;
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public DailyLogDTO createDailyLog(DailyLogDTO dto) {
        // Buscamos el perfil del usuario usando el userProfileId del DTO
        UserProfile userProfile = userProfileRepository.findById(dto.getUserProfileId())
                .orElseThrow(() -> new ResourceNotFoundException("UserProfile", "id", dto.getUserProfileId()));
        DailyLog dailyLog = mapToEntity(dto);
        dailyLog.setUserProfile(userProfile);
        DailyLog savedLog = dailyLogRepository.save(dailyLog);
        return mapToDTO(savedLog);
    }

    @Override
    public DailyLogDTO getDailyLogById(Long id) {
        DailyLog dailyLog = dailyLogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DailyLog", "id", id));
        return mapToDTO(dailyLog);
    }

    @Override
    public List<DailyLogDTO> getDailyLogsByUserProfileId(Long userProfileId) {
        List<DailyLog> logs = dailyLogRepository.findByUserProfileId(userProfileId);
        return logs.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public DailyLogDTO updateDailyLog(Long id, DailyLogDTO dto) {
        DailyLog dailyLog = dailyLogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DailyLog", "id", id));
        // Actualizamos los campos del log con los valores del DTO
        dailyLog.setDate(dto.getDate());
        dailyLog.setAnxietyLevel(dto.getAnxietyLevel());
        dailyLog.setMood(dto.getMood());
        dailyLog.setDailyObjective(dto.getDailyObjective());
        dailyLog.setNotes(dto.getNotes());
        DailyLog updatedLog = dailyLogRepository.save(dailyLog);
        return mapToDTO(updatedLog);
    }

    @Override
    public void deleteDailyLog(Long id) {
        DailyLog dailyLog = dailyLogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DailyLog", "id", id));
        dailyLogRepository.delete(dailyLog);
    }

    // Conversión de entidad a DTO
    private DailyLogDTO mapToDTO(DailyLog dailyLog) {
        DailyLogDTO dto = new DailyLogDTO();
        dto.setId(dailyLog.getId());
        dto.setDate(dailyLog.getDate());
        dto.setAnxietyLevel(dailyLog.getAnxietyLevel());
        dto.setMood(dailyLog.getMood());
        dto.setDailyObjective(dailyLog.getDailyObjective());
        dto.setNotes(dailyLog.getNotes());
        dto.setUserProfileId(dailyLog.getUserProfile().getId());
        return dto;
    }

    // Conversión de DTO a entidad
    private DailyLog mapToEntity(DailyLogDTO dto) {
        DailyLog dailyLog = new DailyLog();
        dailyLog.setDate(dto.getDate());
        dailyLog.setAnxietyLevel(dto.getAnxietyLevel());
        dailyLog.setMood(dto.getMood());
        dailyLog.setDailyObjective(dto.getDailyObjective());
        dailyLog.setNotes(dto.getNotes());
        // No seteamos el userProfile aquí, se asigna en createDailyLog
        return dailyLog;
    }
}
