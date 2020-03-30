package com.palettering.api.palettering.domain.reply_like;

import com.palettering.api.palettering.domain.CreatedTimeEntity;
import com.palettering.api.palettering.domain.reply.Reply;
import com.palettering.api.palettering.domain.user.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString

@Entity
@IdClass(ReplyLikeId.class)
public class ReplyLike extends CreatedTimeEntity {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UID")
    private User user;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REPLY_ID")
    private Reply reply;

}
