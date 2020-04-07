package com.palettering.api.palettering.story.story.domain;

import com.palettering.api.palettering.CreatedTimeEntity;
import com.palettering.api.palettering.story.story_comment.domain.StoryComment;
import com.palettering.api.palettering.user.user.domain.User;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

@Entity
public class Story extends CreatedTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STORY_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "UID")
    private User user;

    @OneToMany(mappedBy = "story")
    private List<StoryComment> storyComments = new ArrayList<>();

    @Column(nullable = false, unique = true)
    private String image;

    @Column(columnDefinition = "boolean default false")
    private boolean isDelete;

    @Builder
    public Story(User user, List<StoryComment> storyComments, String image, boolean isDelete) {
        this.user = user;
        this.storyComments = storyComments;
        this.image = image;
        this.isDelete = isDelete;
    }

}
