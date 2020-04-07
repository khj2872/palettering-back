package com.palettering.api.palettering.post.post_like.domain;

import com.palettering.api.palettering.CreatedTimeEntity;
import com.palettering.api.palettering.post.post.domain.Post;
import com.palettering.api.palettering.user.user.domain.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

@Entity
@IdClass(PostLikeId.class)
public class PostLike extends CreatedTimeEntity {

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "UID")
    private User user;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "POST_ID")
    private Post post;

    @Builder
    public PostLike(User user, Post post) {
        this.user = user;
        this.post = post;
    }
}
