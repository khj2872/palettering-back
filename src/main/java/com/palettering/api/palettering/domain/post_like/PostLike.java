package com.palettering.api.palettering.domain.post_like;

import com.palettering.api.palettering.domain.post.Post;
import com.palettering.api.palettering.domain.user.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString

@Entity
@IdClass(PostLikeId.class)
public class PostLike {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UID")
    private User user;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POST_ID")
    private Post post;

    private LocalDateTime createdDate;

}
