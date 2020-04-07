package com.palettering.api.palettering.story.story_read_user.domain;

import com.palettering.api.palettering.CreatedTimeEntity;
import com.palettering.api.palettering.story.story.domain.Story;
import com.palettering.api.palettering.user.user.domain.User;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

@Entity
public class StoryReadUser extends CreatedTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STORY_READ_USER_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "STORY_ID")
    private Story story;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "UID")
    private User user;

    @Builder
    public StoryReadUser(Story story, User user) {
        this.story = story;
        this.user = user;
    }
}
