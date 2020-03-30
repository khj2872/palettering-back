package com.palettering.api.palettering.domain.reply;

import com.palettering.api.palettering.domain.BaseTimeEntity;
import com.palettering.api.palettering.domain.post.Post;
import com.palettering.api.palettering.domain.reply_like.ReplyLike;
import com.palettering.api.palettering.domain.user.User;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString

@Entity
public class Reply extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REPLY_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private Reply parent;

    @OneToMany(mappedBy = "parent")
    private List<Reply> children = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POST_ID")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UID")
    private User user;

    @OneToMany(mappedBy = "reply")
    private List<ReplyLike> replyLikes = new ArrayList<>();

    private String contents;

    private int isDelete;

}
