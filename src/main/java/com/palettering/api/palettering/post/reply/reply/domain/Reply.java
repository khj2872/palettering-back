package com.palettering.api.palettering.post.reply.reply.domain;

import com.palettering.api.palettering.BaseTimeEntity;
import com.palettering.api.palettering.post.post.domain.Post;
import com.palettering.api.palettering.post.reply.reply_like.domain.ReplyLike;
import com.palettering.api.palettering.user.user.domain.User;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

@Entity
public class Reply extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REPLY_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PARENT_ID")
    private Reply parent;

    @OneToMany(mappedBy = "parent")
    private List<Reply> children = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "POST_ID")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "UID")
    private User user;

    @OneToMany(mappedBy = "reply")
    private List<ReplyLike> replyLikes = new ArrayList<>();

    @Column(nullable = false)
    private String contents;

    private int count;

    @Column(columnDefinition = "boolean default false")
    private boolean isDelete;

    @Builder
    public Reply(Reply parent, List<Reply> children, Post post,
                 User user, List<ReplyLike> replyLikes, String contents,
                 int count, boolean isDelete) {
        this.parent = parent;
        this.children = children;
        this.post = post;
        this.user = user;
        this.replyLikes = replyLikes;
        this.contents = contents;
        this.count = count;
        this.isDelete = isDelete;
    }
}
