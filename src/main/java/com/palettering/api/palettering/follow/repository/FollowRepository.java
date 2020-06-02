package com.palettering.api.palettering.follow.repository;

import com.palettering.api.palettering.follow.domain.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    List<Follow> findByUser_id(String id);
    List<Follow> findByTargetUser_id(String id);
}