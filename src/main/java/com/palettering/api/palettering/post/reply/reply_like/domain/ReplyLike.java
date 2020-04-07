package com.palettering.api.palettering.post.reply.reply_like.domain;

import com.palettering.api.palettering.CreatedTimeEntity;
import com.palettering.api.palettering.post.reply.reply.domain.Reply;
import com.palettering.api.palettering.user.user.domain.User;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

@Entity
@IdClass(ReplyLikeId.class)
public class ReplyLike extends CreatedTimeEntity {

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "UID")
    private User user;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "REPLY_ID")
    private Reply reply;

    @Builder
    public ReplyLike(User user, Reply reply) {
        this.user = user;
        this.reply = reply;
    }
}
