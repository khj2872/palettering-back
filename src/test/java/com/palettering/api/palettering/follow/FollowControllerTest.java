package com.palettering.api.palettering.follow;

import com.palettering.api.palettering.follow.domain.Follow;
import com.palettering.api.palettering.follow.model.FollowDTO;
import com.palettering.api.palettering.follow.service.FollowService;
import com.palettering.api.palettering.user.user.domain.User;
import com.palettering.api.palettering.user.user.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FollowControllerTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FollowService followService;

    @Test
    @Transactional
    public void 팔로우_정보_생성() {
        // given
        User user = User.builder()
                .uid("aowcwacwa")
                .email("yhg8484@naver.com")
                .socialType(0)
                .id("nick_yu._.gyu")
                .build();
        User targetUser = User.builder()
                .uid("lmcwocmaw")
                .email("dbgusrb12@gmail.com")
                .socialType(0)
                .id("yu._.gyu")
                .build();
        // when
        userRepository.save(user);
        userRepository.save(targetUser);
        Follow follow = followService.createFollow("aowcwacwa", "lmcwocmaw");

        FollowDTO.Create followCreate = FollowDTO.Create
                .builder()
                .id(follow.getId())
                .uid(follow.getUser().getUid())
                .userId(follow.getUser().getId())
                .targetUid(follow.getTargetUser().getUid())
                .targetId(follow.getTargetUser().getId())
                .status(follow.getStatus())
                .build();

        // then
        assertThat(followCreate.getUid()).isEqualTo("aowcwacwa");
        assertThat(followCreate.getUserId()).isEqualTo("nick_yu._.gyu");
        assertThat(followCreate.getTargetUid()).isEqualTo("lmcwocmaw");
        assertThat(followCreate.getTargetId()).isEqualTo("yu._.gyu");
    }

    @Test
    @Transactional
    public void 팔로워_리스트_조회() {
        // given
        User user = User.builder()
                .uid("aowcwacwa")
                .email("yhg8484@naver.com")
                .socialType(0)
                .id("nick_yu._.gyu")
                .build();
        User targetUser = User.builder()
                .uid("lmcwocmaw")
                .email("dbgusrb12@gmail.com")
                .socialType(0)
                .id("yu._.gyu")
                .build();
        // when
        userRepository.save(user);
        userRepository.save(targetUser);
        Follow follow = followService.createFollow("aowcwacwa", "lmcwocmaw");

        Page<Follow> followers = followService.getFollowers("nick_yu._.gyu", PageRequest.of(0, 5));
        List<FollowDTO.GetFollowList.User> followerList = followers.stream()
                .map(follows ->
                        FollowDTO.GetFollowList.User
                                .builder()
                                .uid(follows.getTargetUser().getUid())
                                .id(follows.getTargetUser().getId())
                                .image(follows.getTargetUser().getImage())
                                .build())
                .collect(Collectors.toList());

        // then
        assertThat(followerList.size()).isEqualTo(1);
        assertThat(followerList.get(0).getId()).isEqualTo("yu._.gyu");
    }

    @Test
    @Transactional
    public void 팔로잉_리스트_조회() {
        // given
        User user = User.builder()
                .uid("aowcwacwa")
                .email("yhg8484@naver.com")
                .socialType(0)
                .id("nick_yu._.gyu")
                .build();
        User targetUser = User.builder()
                .uid("lmcwocmaw")
                .email("dbgusrb12@gmail.com")
                .socialType(0)
                .id("yu._.gyu")
                .build();
        // when
        userRepository.save(user);
        userRepository.save(targetUser);
        Follow follow = followService.createFollow("lmcwocmaw", "aowcwacwa");
        Page<Follow> followers = followService.getFollowings("nick_yu._.gyu", PageRequest.of(0, 5));
        List<FollowDTO.GetFollowList.User> followingList = followers.stream()
                .map(follows ->
                        FollowDTO.GetFollowList.User
                                .builder()
                                .uid(follows.getUser().getUid())
                                .id(follows.getUser().getId())
                                .image(follows.getUser().getImage())
                                .build())
                .collect(Collectors.toList());
        // then
        assertThat(followingList.size()).isEqualTo(1);
        assertThat(followingList.get(0).getId()).isEqualTo("yu._.gyu");
    }

}
