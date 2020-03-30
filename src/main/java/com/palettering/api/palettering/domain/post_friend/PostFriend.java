package com.palettering.api.palettering.domain.post_friend;

import com.palettering.api.palettering.domain.photo.Photo;
import com.palettering.api.palettering.domain.user.User;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString

@Entity
public class PostFriend {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POST_FRIEND_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PHOTO_ID")
    private Photo photo;

    private int isDelete;

    private int tagX;

    private int tagY;

}
