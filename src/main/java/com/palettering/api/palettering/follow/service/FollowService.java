package com.palettering.api.palettering.follow.service;

import com.palettering.api.palettering.follow.domain.Follow;
import com.palettering.api.palettering.follow.repository.FollowRepository;
import com.palettering.api.palettering.user.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FollowService {
    private final FollowRepository followRepository;
    private final UserRepository userRepository;

    public Page<Follow> getFollowers(String id, Pageable pageable) {
        return followRepository.findByUser_id(id, pageable);
    }

    public Page<Follow> getFollowings(String id, Pageable pageable) {

        return followRepository.findByTargetUser_id(id, pageable);
    }

    public Follow createFollow(String uid, String targetUid) {
        // TODO 추후 회원 가입되어 있는 회원인지 체크하고, 회원의 계정 공개 여부 판단하여 status 값 변경 해야함

        return followRepository.save(
                Follow
                        .builder()
                        .user(userRepository.findById(uid).orElseThrow(IllegalAccessError::new))
                        .targetUser(userRepository.findById(targetUid).orElseThrow(IllegalAccessError::new))
                        .build()
        );

    }
}
