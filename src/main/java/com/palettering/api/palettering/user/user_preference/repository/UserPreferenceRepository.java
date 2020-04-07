package com.palettering.api.palettering.user.user_preference.repository;

import com.palettering.api.palettering.user.user_preference.domain.UserPreference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPreferenceRepository extends JpaRepository<UserPreference, Long> {
}
