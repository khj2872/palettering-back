package com.palettering.api.palettering.post.post_like.domain;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PostLikeId implements Serializable {

    @EqualsAndHashCode.Include
    private String user;

    @EqualsAndHashCode.Include
    private Long post;

}
