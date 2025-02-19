package com.breathingjourney.userprofileservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "daily_logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DailyLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private Integer anxietyLevel;
    private String mood;
    private String dailyObjective;

    // Campo para notas (asegúrate de que se llame "notes")
    @Column(length = 1000)
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_profile_id", nullable = false)
    private UserProfile userProfile;
}
