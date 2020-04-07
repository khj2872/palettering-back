package com.palettering.api.palettering.post.post_hashtag.domain;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PostHashtagId implements Serializable {

    @EqualsAndHashCode.Include
    private Long hashtag;

    @EqualsAndHashCode.Include
    private Long post;

}
