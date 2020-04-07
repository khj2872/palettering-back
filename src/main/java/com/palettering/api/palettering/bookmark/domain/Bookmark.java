package com.palettering.api.palettering.bookmark.domain;

import com.palettering.api.palettering.post.post.domain.Post;
import com.palettering.api.palettering.user.user.domain.User;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

@Entity
@IdClass(BookmarkId.class)
public class Bookmark {

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "UID")
    private User user;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "POST_ID")
    private Post post;

    @Builder
    public Bookmark(User user, Post post) {
        this.user = user;
        this.post = post;
    }

}
