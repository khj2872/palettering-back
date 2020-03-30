package com.palettering.api.palettering.domain.post;

import com.palettering.api.palettering.domain.BaseTimeEntity;
import com.palettering.api.palettering.domain.bookmark.Bookmark;
import com.palettering.api.palettering.domain.photo.Photo;
//import com.palettering.api.palettering.domain.post_hashtag.PostHashtag;
import com.palettering.api.palettering.domain.post_hashtag.PostHashtag;
import com.palettering.api.palettering.domain.post_like.PostLike;
import com.palettering.api.palettering.domain.reply.Reply;
import com.palettering.api.palettering.domain.user.User;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString

@Entity
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POST_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_UID")
    private User user;

    @OneToMany(mappedBy = "post")
    private List<PostHashtag> postHashtags = new ArrayList<>();

    @OneToMany(mappedBy = "post")
    private List<PostLike> postLikes = new ArrayList<>();

    @OneToMany(mappedBy = "post")
    private List<Bookmark> bookmarks = new ArrayList<>();

    @OneToMany(mappedBy = "post")
    private List<Photo> photos = new ArrayList<>();

    @OneToMany(mappedBy = "post")
    private List<Reply> replies = new ArrayList<>();

    private String contents;

    private int viewCount;

    private String locationX;

    private String locationY;

    private String address;

    private int isKeep;

    private int isDelete;

}
