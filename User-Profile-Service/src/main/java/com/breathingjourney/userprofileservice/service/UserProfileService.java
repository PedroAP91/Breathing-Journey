package com.breathingjourney.userprofileservice.service;

import com.breathingjourney.userprofileservice.dto.UserProfileDTO;

public interface UserProfileService {
    UserProfileDTO getUserProfileById(Long id);
    UserProfileDTO createUserProfile(UserProfileDTO userProfileDTO);
    UserProfileDTO updateUserProfile(Long id, UserProfileDTO userProfileDTO);
    void deleteUserProfile(Long id);
}
