package com.palettering.api.palettering.post.reply.reply_like.domain;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ReplyLikeId implements Serializable {

    @EqualsAndHashCode.Include
    private String user;

    @EqualsAndHashCode.Include
    private Long reply;

}
