package com.palettering.api.palettering.domain.user;

import com.palettering.api.palettering.domain.BaseTimeEntity;
import com.palettering.api.palettering.domain.alarm.Alarm;
import com.palettering.api.palettering.domain.bookmark.Bookmark;
import com.palettering.api.palettering.domain.follow.Follow;
import com.palettering.api.palettering.domain.post.Post;
import com.palettering.api.palettering.domain.post_friend.PostFriend;
import com.palettering.api.palettering.domain.post_like.PostLike;
import com.palettering.api.palettering.domain.reply.Reply;
import com.palettering.api.palettering.domain.reply_friend.ReplyFriend;
import com.palettering.api.palettering.domain.reply_like.ReplyLike;
import com.palettering.api.palettering.domain.report.Report;
import com.palettering.api.palettering.domain.story.Story;
import com.palettering.api.palettering.domain.story_read_user.StoryReadUser;
import com.palettering.api.palettering.domain.user_preference.UserPreference;
import lombok.*;
import org.hibernate.annotations.GeneratorType;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString

@Entity
public class User extends BaseTimeEntity {

    @Id
    @Column(name = "UID")
    private String uid;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserPreference userPreference;

    @OneToMany(mappedBy = "user")
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Bookmark> bookmarks = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Story> stories = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<StoryReadUser> storyReadUsers = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Follow> follows = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Report> reports = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<PostLike> postLikes = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Reply> replies = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<ReplyLike> replyLikes = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<ReplyFriend> replyFriends = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<PostFriend> postFriends = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Alarm> alarms = new ArrayList<>();

    private int socialType;

    private String socialId;

    private String email;

    private String password;

    private String phone;

    private int gender;

    private String name;

    private String id;

    private String website;

    private String intro;

    private String image;

    private int isPublic;

    private int isDelete;

}