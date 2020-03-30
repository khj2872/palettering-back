package com.palettering.api.palettering.domain.post_hashtag;

import com.palettering.api.palettering.domain.hashtag.Hashtag;
import com.palettering.api.palettering.domain.post.Post;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString

@Entity
@IdClass(PostHashtagId.class)
public class PostHashtag {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HASHTAG_ID")
    private Hashtag hashtag;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POST_ID")
    private Post post;

}
