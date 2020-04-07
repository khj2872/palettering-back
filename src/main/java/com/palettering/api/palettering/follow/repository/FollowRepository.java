package com.palettering.api.palettering.follow.repository;

import com.palettering.api.palettering.follow.domain.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<Follow, Long> {
}
