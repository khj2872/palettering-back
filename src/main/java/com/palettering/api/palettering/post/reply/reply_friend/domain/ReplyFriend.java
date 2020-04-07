package com.palettering.api.palettering.post.reply.reply_friend.domain;

import com.palettering.api.palettering.post.reply.reply.domain.Reply;
import com.palettering.api.palettering.user.user.domain.User;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

@Entity
public class ReplyFriend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REPLY_FRIEND_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "UID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "REPLY_ID")
    private Reply reply;

//    @Column()
    private int requestType;

    @Column(columnDefinition = "boolean default false")
    private boolean isDelete;

    @Builder
    public ReplyFriend(User user, Reply reply, int requestType, boolean isDelete) {
        this.user = user;
        this.reply = reply;
        this.requestType = requestType;
        this.isDelete = isDelete;
    }
}
