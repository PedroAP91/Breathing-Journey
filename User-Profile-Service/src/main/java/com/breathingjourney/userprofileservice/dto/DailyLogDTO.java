package com.breathingjourney.userprofileservice.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class DailyLogDTO {
    private Long id;
    private LocalDate date;
    private Integer anxietyLevel;
    private String mood;
    private String dailyObjective;
    private String notes;

    // Campo para relacionar el log con el UserProfile
    private Long userProfileId;
}
