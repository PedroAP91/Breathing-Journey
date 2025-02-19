package com.breathingjourney.userprofileservice.service;

import com.breathingjourney.userprofileservice.dto.UserProfileDTO;
import com.breathingjourney.userprofileservice.exception.ResourceNotFoundException;
import com.breathingjourney.userprofileservice.model.UserProfile;
import com.breathingjourney.userprofileservice.repository.UserProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;

    public UserProfileServiceImpl(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public UserProfileDTO getUserProfileById(Long id) {
        UserProfile userProfile = userProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UserProfile", "id", id));
        return mapToDTO(userProfile);
    }

    @Override
    public UserProfileDTO createUserProfile(UserProfileDTO dto) {
        UserProfile userProfile = mapToEntity(dto);
        UserProfile savedUserProfile = userProfileRepository.save(userProfile);
        return mapToDTO(savedUserProfile);
    }

    @Override
    public UserProfileDTO updateUserProfile(Long id, UserProfileDTO dto) {
        UserProfile userProfile = userProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UserProfile", "id", id));

        // Actualizamos los campos con los valores del DTO
        userProfile.setFirstName(dto.getFirstName());
        userProfile.setLastName(dto.getLastName());
        userProfile.setEmail(dto.getEmail());
        userProfile.setAge(dto.getAge());
        userProfile.setAgeStartedSmoking(dto.getAgeStartedSmoking());
        userProfile.setCigarettesPerDay(dto.getCigarettesPerDay());
        userProfile.setYearsSmoking(dto.getYearsSmoking());
        userProfile.setSmokingType(dto.getSmokingType());
        userProfile.setNicotineDependencyLevel(dto.getNicotineDependencyLevel());
        userProfile.setQuitAttempts(dto.getQuitAttempts());
        userProfile.setTargetQuitDate(dto.getTargetQuitDate());
        userProfile.setPrimaryMotivation(dto.getPrimaryMotivation());
        userProfile.setPreviousMethods(dto.getPreviousMethods());
        userProfile.setSmokingTriggers(dto.getSmokingTriggers());
        userProfile.setDailyCravingIntensity(dto.getDailyCravingIntensity());
        userProfile.setMoodStatus(dto.getMoodStatus());
        userProfile.setLastSmokeDate(dto.getLastSmokeDate());
        userProfile.setConsecutiveSmokeFreeDays(dto.getConsecutiveSmokeFreeDays());
        userProfile.setCigarettesAvoided(dto.getCigarettesAvoided());
        userProfile.setMoneySaved(dto.getMoneySaved());
        userProfile.setLifeTimeGained(dto.getLifeTimeGained());
        userProfile.setSavingsGoalAmount(dto.getSavingsGoalAmount());
        userProfile.setCurrentSavings(dto.getCurrentSavings());

        UserProfile updatedUserProfile = userProfileRepository.save(userProfile);
        return mapToDTO(updatedUserProfile);
    }

    @Override
    public void deleteUserProfile(Long id) {
        UserProfile userProfile = userProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UserProfile", "id", id));
        userProfileRepository.delete(userProfile);
    }

    // Método para mapear de entidad a DTO
    private UserProfileDTO mapToDTO(UserProfile userProfile) {
        UserProfileDTO dto = new UserProfileDTO();
        dto.setId(userProfile.getId());
        dto.setFirstName(userProfile.getFirstName());
        dto.setLastName(userProfile.getLastName());
        dto.setEmail(userProfile.getEmail());
        dto.setAge(userProfile.getAge());
        dto.setAgeStartedSmoking(userProfile.getAgeStartedSmoking());
        dto.setCigarettesPerDay(userProfile.getCigarettesPerDay());
        dto.setYearsSmoking(userProfile.getYearsSmoking());
        dto.setSmokingType(userProfile.getSmokingType());
        dto.setNicotineDependencyLevel(userProfile.getNicotineDependencyLevel());
        dto.setQuitAttempts(userProfile.getQuitAttempts());
        dto.setTargetQuitDate(userProfile.getTargetQuitDate());
        dto.setPrimaryMotivation(userProfile.getPrimaryMotivation());
        dto.setPreviousMethods(userProfile.getPreviousMethods());
        dto.setSmokingTriggers(userProfile.getSmokingTriggers());
        dto.setDailyCravingIntensity(userProfile.getDailyCravingIntensity());
        dto.setMoodStatus(userProfile.getMoodStatus());
        dto.setLastSmokeDate(userProfile.getLastSmokeDate());
        dto.setConsecutiveSmokeFreeDays(userProfile.getConsecutiveSmokeFreeDays());
        dto.setCigarettesAvoided(userProfile.getCigarettesAvoided());
        dto.setMoneySaved(userProfile.getMoneySaved());
        dto.setLifeTimeGained(userProfile.getLifeTimeGained());
        dto.setSavingsGoalAmount(userProfile.getSavingsGoalAmount());
        dto.setCurrentSavings(userProfile.getCurrentSavings());
        return dto;
    }

    // Método para mapear de DTO a entidad
    private UserProfile mapToEntity(UserProfileDTO dto) {
        UserProfile userProfile = new UserProfile();
        userProfile.setFirstName(dto.getFirstName());
        userProfile.setLastName(dto.getLastName());
        userProfile.setEmail(dto.getEmail());
        userProfile.setAge(dto.getAge());
        userProfile.setAgeStartedSmoking(dto.getAgeStartedSmoking());
        userProfile.setCigarettesPerDay(dto.getCigarettesPerDay());
        userProfile.setYearsSmoking(dto.getYearsSmoking());
        userProfile.setSmokingType(dto.getSmokingType());
        userProfile.setNicotineDependencyLevel(dto.getNicotineDependencyLevel());
        userProfile.setQuitAttempts(dto.getQuitAttempts());
        userProfile.setTargetQuitDate(dto.getTargetQuitDate());
        userProfile.setPrimaryMotivation(dto.getPrimaryMotivation());
        userProfile.setPreviousMethods(dto.getPreviousMethods());
        userProfile.setSmokingTriggers(dto.getSmokingTriggers());
        userProfile.setDailyCravingIntensity(dto.getDailyCravingIntensity());
        userProfile.setMoodStatus(dto.getMoodStatus());
        userProfile.setLastSmokeDate(dto.getLastSmokeDate());
        userProfile.setConsecutiveSmokeFreeDays(dto.getConsecutiveSmokeFreeDays());
        userProfile.setCigarettesAvoided(dto.getCigarettesAvoided());
        userProfile.setMoneySaved(dto.getMoneySaved());
        userProfile.setLifeTimeGained(dto.getLifeTimeGained());
        userProfile.setSavingsGoalAmount(dto.getSavingsGoalAmount());
        userProfile.setCurrentSavings(dto.getCurrentSavings());
        return userProfile;
    }
}
