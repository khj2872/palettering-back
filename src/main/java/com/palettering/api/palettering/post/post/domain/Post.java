package com.palettering.api.palettering.post.post.domain;

import com.palettering.api.palettering.BaseTimeEntity;
import com.palettering.api.palettering.bookmark.domain.Bookmark;
import com.palettering.api.palettering.post.photo.domain.Photo;
import com.palettering.api.palettering.post.post_hashtag.domain.PostHashtag;
import com.palettering.api.palettering.post.post_like.domain.PostLike;
import com.palettering.api.palettering.post.reply.reply.domain.Reply;
import com.palettering.api.palettering.user.user.domain.User;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

@Entity
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POST_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
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

    private int count;

    @Column(columnDefinition = "boolean default false")
    private boolean isKeep;

    @Column(columnDefinition = "boolean default false")
    private boolean isDelete;

    @Builder
    public Post(User user, List<PostHashtag> postHashtags, List<PostLike> postLikes,
                List<Bookmark> bookmarks, List<Photo> photos, List<Reply> replies,
                String contents, int viewCount, String locationX,
                String locationY, String address, int count,
                boolean isKeep, boolean isDelete) {
        this.user = user;
        this.postHashtags = postHashtags;
        this.postLikes = postLikes;
        this.bookmarks = bookmarks;
        this.photos = photos;
        this.replies = replies;
        this.contents = contents;
        this.viewCount = viewCount;
        this.locationX = locationX;
        this.locationY = locationY;
        this.address = address;
        this.count = count;
        this.isKeep = isKeep;
        this.isDelete = isDelete;
    }
}
