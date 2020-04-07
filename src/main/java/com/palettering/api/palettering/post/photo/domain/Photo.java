package com.palettering.api.palettering.post.photo.domain;

import com.palettering.api.palettering.post.post.domain.Post;
import com.palettering.api.palettering.post.post_friend.domain.PostFriend;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

@Entity
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PHOTO_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "POST_ID")
    private Post post;

    @OneToMany(mappedBy = "photo")
    private List<PostFriend> postFriends = new ArrayList<>();

    @Column(nullable = false)
    private int fileStatus;

    @Column(nullable = false, unique = true)
    private String image;

    @Builder
    public Photo(Post post, List<PostFriend> postFriends, int fileStatus, String image) {
        this.post = post;
        this.postFriends = postFriends;
        this.fileStatus = fileStatus;
        this.image = image;
    }
}
