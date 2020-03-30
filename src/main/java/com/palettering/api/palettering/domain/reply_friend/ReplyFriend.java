package com.palettering.api.palettering.domain.reply_friend;

import com.palettering.api.palettering.domain.photo.Photo;
import com.palettering.api.palettering.domain.reply.Reply;
import com.palettering.api.palettering.domain.user.User;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString

@Entity
public class ReplyFriend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REPLY_FRIEND_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REPLY_ID")
    private Reply reply;

    private int requestType;

    private int isDelete;


}
