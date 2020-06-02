package com.palettering.api.palettering.follow.controller;

import com.palettering.api.core.response.Response;
import com.palettering.api.palettering.follow.domain.Follow;
import com.palettering.api.palettering.follow.model.FollowDTO;
import com.palettering.api.palettering.follow.service.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/follow")
@RequiredArgsConstructor
public class FollowController {

    private final FollowService followService;


    // 팔로워 정보
    @GetMapping(value = "/{id}/follower")
    public Response<FollowDTO.GetFollowList> getFollowers(@PathVariable String id){
        List<Follow> followers = followService.getFollowers(id);
//        List<FollowDTO.GetFollowList.User> followerList = FollowDTO.GetFollowList.followList(followers);
        List<FollowDTO.GetFollowList.User> followerList = followers.stream()
                .map(follow ->
                        FollowDTO.GetFollowList.User
                                .builder()
                                .uid(follow.getTargetUser().getUid())
                                .id(follow.getTargetUser().getId())
                                .image(follow.getTargetUser().getImage())
                                .build())
                .collect(Collectors.toList());
        return new Response<>(
                FollowDTO.GetFollowList
                        .builder()
                        .follows(followerList)
                        .build()
        );
    }

    // 팔로잉 정보
    @GetMapping(value = "/{id}/following")
    public Response<FollowDTO.GetFollowList> getFollowings(@PathVariable String id){
        List<Follow> followings = followService.getFollowings(id);
//        List<FollowDTO.GetFollowList.User> followingList = FollowDTO.GetFollowList.followList(followings);
        List<FollowDTO.GetFollowList.User> followingList = followings.stream()
                .map(follow ->
                        FollowDTO.GetFollowList.User
                                .builder()
                                .uid(follow.getUser().getUid())
                                .id(follow.getUser().getId())
                                .image(follow.getUser().getImage())
                                .build())
                .collect(Collectors.toList());
        return new Response<>(
                FollowDTO.GetFollowList
                        .builder()
                        .follows(followingList)
                        .build()
        );
    }

    // 팔로우 신청
    @PostMapping
    public Response<FollowDTO.Create> create(@Valid @RequestBody FollowDTO.Create create) {
        Follow follow = followService.createFollow(create.getUid(), create.getTargetUid());
        return new Response<>(
                FollowDTO.Create
                        .builder()
                        .id(follow.getId())
                        .uid(follow.getUser().getUid())
                        .userId(follow.getUser().getId())
                        .targetUid(follow.getTargetUser().getUid())
                        .targetId(follow.getTargetUser().getId())
                        .status(follow.getStatus())
                        .build()
        );
    }

}