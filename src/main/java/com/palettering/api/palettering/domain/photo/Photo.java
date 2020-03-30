package com.palettering.api.palettering.domain.photo;

import com.palettering.api.palettering.domain.post.Post;
import com.palettering.api.palettering.domain.post_friend.PostFriend;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString

@Entity
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PHOTO_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POST_ID")
    private Post post;

    @OneToMany(mappedBy = "photo")
    private List<PostFriend> postFriends = new ArrayList<>();

    private int fileStatus;

    private String image;

}
