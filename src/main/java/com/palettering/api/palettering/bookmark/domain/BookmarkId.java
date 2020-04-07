package com.palettering.api.palettering.bookmark.domain;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BookmarkId implements Serializable {

    @EqualsAndHashCode.Include
    private String user;

    @EqualsAndHashCode.Include
    private Long post;

}
