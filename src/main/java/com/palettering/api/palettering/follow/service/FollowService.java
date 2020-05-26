package com.palettering.api.palettering.follow.service;

import com.palettering.api.palettering.follow.domain.Follow;
import com.palettering.api.palettering.follow.repository.FollowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FollowService {
    private final FollowRepository followRepository;

    public List<Follow> getFollowers(String uid) {
        return followRepository.findByUser_uid(uid);
    }

    public List<Follow> getFollowings(String uid) {
        return followRepository.findByTargetUser_uid(uid);
    }
}
