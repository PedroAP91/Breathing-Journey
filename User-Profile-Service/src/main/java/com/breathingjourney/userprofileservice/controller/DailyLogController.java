package com.breathingjourney.userprofileservice.controller;

import com.breathingjourney.userprofileservice.dto.DailyLogDTO;
import com.breathingjourney.userprofileservice.service.DailyLogService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/daily-logs")
public class DailyLogController {

    private final DailyLogService dailyLogService;

    public DailyLogController(DailyLogService dailyLogService) {
        this.dailyLogService = dailyLogService;
    }

    // Crear un nuevo registro diario
    @PostMapping
    public ResponseEntity<DailyLogDTO> createDailyLog(@Valid @RequestBody DailyLogDTO dailyLogDTO) {
        DailyLogDTO createdLog = dailyLogService.createDailyLog(dailyLogDTO);
        return new ResponseEntity<>(createdLog, HttpStatus.CREATED);
    }

    // Obtener un registro diario por su ID
    @GetMapping("/{id}")
    public ResponseEntity<DailyLogDTO> getDailyLog(@PathVariable Long id) {
        DailyLogDTO logDTO = dailyLogService.getDailyLogById(id);
        return ResponseEntity.ok(logDTO);
    }

    // Obtener todos los registros diarios de un perfil de usuario
    @GetMapping("/user/{userProfileId}")
    public ResponseEntity<List<DailyLogDTO>> getDailyLogsByUserProfileId(@PathVariable Long userProfileId) {
        List<DailyLogDTO> logs = dailyLogService.getDailyLogsByUserProfileId(userProfileId);
        return ResponseEntity.ok(logs);
    }

    // Actualizar un registro diario
    @PutMapping("/{id}")
    public ResponseEntity<DailyLogDTO> updateDailyLog(
            @PathVariable Long id,
            @Valid @RequestBody DailyLogDTO dailyLogDTO) {
        DailyLogDTO updatedLog = dailyLogService.updateDailyLog(id, dailyLogDTO);
        return ResponseEntity.ok(updatedLog);
    }

    // Eliminar un registro diario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDailyLog(@PathVariable Long id) {
        dailyLogService.deleteDailyLog(id);
        return ResponseEntity.noContent().build();
    }
}
