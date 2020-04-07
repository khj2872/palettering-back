package com.palettering.api.palettering.user.user.repository;

import com.palettering.api.palettering.user.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}