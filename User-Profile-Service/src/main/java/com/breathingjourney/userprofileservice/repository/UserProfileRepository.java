package com.breathingjourney.userprofileservice.repository;

import com.breathingjourney.userprofileservice.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    Optional<UserProfile> findByEmail(String email);
}
