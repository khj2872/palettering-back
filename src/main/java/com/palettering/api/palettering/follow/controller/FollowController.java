package com.palettering.api.palettering.follow.controller;

import com.palettering.api.core.response.Response;
import com.palettering.api.palettering.follow.domain.Follow;
import com.palettering.api.palettering.follow.model.FollowDTO;
import com.palettering.api.palettering.follow.service.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/follow")
@RequiredArgsConstructor
public class FollowController {

    private final FollowService followService;


    // 팔로워 정보
    @GetMapping(value = "/{uid}/follower")
    public Response<FollowDTO.GetFollowList> getFollowers(@PathVariable String uid){
        List<Follow> followers = followService.getFollowers(uid);
        List<FollowDTO.GetFollowList.User> followerList = FollowDTO.GetFollowList.followList(followers);
        return new Response<>(
                FollowDTO.GetFollowList
                        .builder()
                        .follows(followerList)
                        .build()
        );
    }

    @GetMapping(value = "/{uid}/following")
    public Response<FollowDTO.GetFollowList> getFollowings(@PathVariable String uid){
        List<Follow> followings = followService.getFollowings(uid);
        List<FollowDTO.GetFollowList.User> followingList = FollowDTO.GetFollowList.followList(followings);
        return new Response<>(
                FollowDTO.GetFollowList
                        .builder()
                        .follows(followingList)
                        .build()
        );
    }
}
