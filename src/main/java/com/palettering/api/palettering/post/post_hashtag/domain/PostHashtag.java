package com.palettering.api.palettering.post.post_hashtag.domain;

import com.palettering.api.palettering.post.hashtag.domain.Hashtag;
import com.palettering.api.palettering.post.post.domain.Post;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

@Entity
@IdClass(PostHashtagId.class)
public class PostHashtag {

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "HASHTAG_ID")
    private Hashtag hashtag;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "POST_ID")
    private Post post;

    @Builder
    public PostHashtag(Hashtag hashtag, Post post) {
        this.hashtag = hashtag;
        this.post = post;
    }
}
