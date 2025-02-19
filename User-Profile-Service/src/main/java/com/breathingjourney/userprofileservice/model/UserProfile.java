package com.breathingjourney.userprofileservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "user_profiles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String email;

    private Integer age;

    // Campos para dejar de fumar
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
