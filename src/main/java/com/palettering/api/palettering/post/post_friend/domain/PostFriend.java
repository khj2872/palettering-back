package com.palettering.api.palettering.post.post_friend.domain;

import com.palettering.api.palettering.post.photo.domain.Photo;
import com.palettering.api.palettering.user.user.domain.User;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

@Entity
public class PostFriend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POST_FRIEND_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "UID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PHOTO_ID")
    private Photo photo;

    @Column(columnDefinition = "boolean default false")
    private boolean isDelete;

    private int tagX;

    private int tagY;

    @Builder
    public PostFriend(User user, Photo photo, boolean isDelete, int tagX, int tagY) {
        this.user = user;
        this.photo = photo;
        this.isDelete = isDelete;
        this.tagX = tagX;
        this.tagY = tagY;
    }
}
