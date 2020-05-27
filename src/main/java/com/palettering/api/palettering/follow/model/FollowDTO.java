package com.palettering.api.palettering.follow.model;

import com.palettering.api.palettering.follow.domain.Follow;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;


public class FollowDTO {

    @Builder
    @Getter
    public static class Create {
        private Long id;
        private String uid;
        private String targetUid;
        private String userId;
        private String targetId;
        private int status;

    }

    @Builder
    @Getter
    public static class GetFollowList {
        private List<User> follows;
        @Builder
        @Getter
        public static class User {
            private String uid;
            private String image;
            private String id;
        }

        public static List<User> followList(List<Follow> follows) {
            return follows.stream()
                    .map(follow ->
                            FollowDTO.GetFollowList.User
                                    .builder()
                                    .uid(follow.getTargetUser().getUid())
                                    .id(follow.getTargetUser().getId())
                                    .image(follow.getTargetUser().getImage())
                                    .build())
                    .collect(Collectors.toList());
        }
    }
}
