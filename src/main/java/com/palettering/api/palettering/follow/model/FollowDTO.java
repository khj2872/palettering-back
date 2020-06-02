package com.palettering.api.palettering.follow.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;


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
    }
}
