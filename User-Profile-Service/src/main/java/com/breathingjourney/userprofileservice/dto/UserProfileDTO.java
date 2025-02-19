package com.breathingjourney.userprofileservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;

@Data
public class UserProfileDTO {

    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String firstName;

    @NotBlank(message = "El apellido es obligatorio")
    private String lastName;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email debe ser válido")
    private String email;

    @NotNull(message = "La edad es obligatoria")
    private Integer age;

    // Campos existentes para dejar de fumar...
    private Integer ageStartedSmoking;
    private Integer cigarettesPerDay;
    private Integer yearsSmoking;
    private String smokingType;
    private Integer nicotineDependencyLevel;
    private Integer quitAttempts;
    private LocalDate targetQuitDate;
    private String primaryMotivation;
    private String previousMethods;
    private String smokingTriggers;
    private Integer dailyCravingIntensity;
    private String moodStatus;

    // Nuevos campos para métricas de progreso
    private LocalDate lastSmokeDate;
    private Integer consecutiveSmokeFreeDays;
    private Integer cigarettesAvoided;
    private Double moneySaved;
    private Double lifeTimeGained;
    private Double savingsGoalAmount;
    private Double currentSavings;
}
