package com.palettering.api.palettering.domain.post_hashtag;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class PostHashtagId implements Serializable {

    @EqualsAndHashCode.Include
    private Long hashtag;

    @EqualsAndHashCode.Include
    private Long post;

}
