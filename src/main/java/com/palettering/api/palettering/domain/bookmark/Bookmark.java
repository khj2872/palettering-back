package com.palettering.api.palettering.domain.bookmark;

import com.palettering.api.palettering.domain.post.Post;
import com.palettering.api.palettering.domain.reply.Reply;
import com.palettering.api.palettering.domain.user.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString

@Entity
@IdClass(BookmarkId.class)
public class Bookmark {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UID")
    private User user;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POST_ID")
    private Post post;

}
