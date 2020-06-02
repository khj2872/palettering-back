package com.palettering.api.palettering.user.user.domain;

import com.palettering.api.palettering.BaseTimeEntity;
import com.palettering.api.palettering.alarm.domain.Alarm;
import com.palettering.api.palettering.bookmark.domain.Bookmark;
import com.palettering.api.palettering.follow.domain.Follow;
import com.palettering.api.palettering.post.post.domain.Post;
import com.palettering.api.palettering.post.post_friend.domain.PostFriend;
import com.palettering.api.palettering.post.post_like.domain.PostLike;
import com.palettering.api.palettering.post.reply.reply.domain.Reply;
import com.palettering.api.palettering.post.reply.reply_friend.domain.ReplyFriend;
import com.palettering.api.palettering.post.reply.reply_like.domain.ReplyLike;
import com.palettering.api.palettering.report.domain.Report;
import com.palettering.api.palettering.story.story.domain.Story;
import com.palettering.api.palettering.story.story_read_user.domain.StoryReadUser;
import com.palettering.api.palettering.user.user_preference.domain.UserPreference;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

@Entity
public class User extends BaseTimeEntity {

    @Id
    @Column(name = "UID")
    private String uid;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, optional = false)
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
    private List<Follow> followers = new ArrayList<>();

    @OneToMany(mappedBy = "targetUser")
    private List<Follow> followings = new ArrayList<>();

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

    @Column(nullable = false)
    private int socialType;

    @Column(unique = true)
    private String socialId;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;

    private String phone;

    @Column(columnDefinition = "integer default 3")
    private int gender;

    private String name;

    @Column(nullable = false, unique = true)
    private String id;

    private String website;

    private String intro;

    private String image;

    @Column(columnDefinition = "boolean default false")
    private boolean isPublic;

    @Column(columnDefinition = "boolean default false")
    private boolean isDelete;

    @Builder
    public User(String uid, UserPreference userPreference, List<Post> posts,
                List<Bookmark> bookmarks, List<Story> stories, List<StoryReadUser> storyReadUsers,
                List<Follow> followers, List<Follow> followings, List<Report> reports, List<PostLike> postLikes,
                List<Reply> replies, List<ReplyLike> replyLikes, List<ReplyFriend> replyFriends,
                List<PostFriend> postFriends, List<Alarm> alarms, int socialType,
                String socialId, String email, String password,
                String phone, int gender, String name,
                String id, String website, String intro,
                String image, boolean isPublic, boolean isDelete) {
        this.uid = uid;
        this.userPreference = userPreference;
        this.posts = posts;
        this.bookmarks = bookmarks;
        this.stories = stories;
        this.storyReadUsers = storyReadUsers;
        this.followers = followers;
        this.followings = followings;
        this.reports = reports;
        this.postLikes = postLikes;
        this.replies = replies;
        this.replyLikes = replyLikes;
        this.replyFriends = replyFriends;
        this.postFriends = postFriends;
        this.alarms = alarms;
        this.socialType = socialType;
        this.socialId = socialId;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.gender = gender;
        this.name = name;
        this.id = id;
        this.website = website;
        this.intro = intro;
        this.image = image;
        this.isPublic = isPublic;
        this.isDelete = isDelete;
    }
}