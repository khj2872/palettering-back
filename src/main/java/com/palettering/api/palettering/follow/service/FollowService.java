package com.palettering.api.palettering.follow.service;

import com.palettering.api.palettering.follow.domain.Follow;
import com.palettering.api.palettering.follow.repository.FollowRepository;
import com.palettering.api.palettering.user.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FollowService {
    private final FollowRepository followRepository;
    private final UserRepository userRepository;

    public List<Follow> getFollowers(String id) {
        return followRepository.findByUser_id(id);
    }

    public List<Follow> getFollowings(String id) {
        return followRepository.findByTargetUser_id(id);
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
