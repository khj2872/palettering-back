package com.palettering.api.palettering.follow.repository;

import com.palettering.api.palettering.follow.domain.Follow;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    Page<Follow> findByUser_id(String id, Pageable pageable);
    Page<Follow> findByTargetUser_id(String id, Pageable pageable);
}
