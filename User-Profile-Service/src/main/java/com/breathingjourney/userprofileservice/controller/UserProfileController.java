package com.breathingjourney.userprofileservice.controller;

import com.breathingjourney.userprofileservice.dto.UserProfileDTO;
import com.breathingjourney.userprofileservice.service.UserProfileService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profiles")
public class UserProfileController {

    private final UserProfileService userProfileService;

    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    // Endpoint para obtener el perfil de un usuario por su ID
    @GetMapping("/{id}")
    public ResponseEntity<UserProfileDTO> getUserProfile(@PathVariable Long id) {
        UserProfileDTO userProfileDTO = userProfileService.getUserProfileById(id);
        return ResponseEntity.ok(userProfileDTO);
    }

    // Endpoint para crear un nuevo perfil de usuario
    @PostMapping
    public ResponseEntity<UserProfileDTO> createUserProfile(@Valid @RequestBody UserProfileDTO userProfileDTO) {
        UserProfileDTO createdProfile = userProfileService.createUserProfile(userProfileDTO);
        return new ResponseEntity<>(createdProfile, HttpStatus.CREATED);
    }

    // Endpoint para actualizar un perfil de usuario existente
    @PutMapping("/{id}")
    public ResponseEntity<UserProfileDTO> updateUserProfile(
            @PathVariable Long id,
            @Valid @RequestBody UserProfileDTO userProfileDTO) {
        UserProfileDTO updatedProfile = userProfileService.updateUserProfile(id, userProfileDTO);
        return ResponseEntity.ok(updatedProfile);
    }

    // Endpoint para eliminar un perfil de usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserProfile(@PathVariable Long id) {
        userProfileService.deleteUserProfile(id);
        return ResponseEntity.noContent().build();
    }
}
