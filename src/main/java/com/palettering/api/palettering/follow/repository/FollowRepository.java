package com.palettering.api.palettering.follow.repository;

import com.palettering.api.palettering.follow.domain.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    List<Follow> findByUser_uid(String uid);
    List<Follow> findByTargetUser_uid(String uid);
}
