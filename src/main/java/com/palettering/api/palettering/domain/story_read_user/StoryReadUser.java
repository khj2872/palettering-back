package com.palettering.api.palettering.domain.story_read_user;

import com.palettering.api.palettering.domain.CreatedTimeEntity;
import com.palettering.api.palettering.domain.story.Story;
import com.palettering.api.palettering.domain.user.User;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString

@Entity
public class StoryReadUser extends CreatedTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STORY_READ_USER_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STORY_ID")
    private Story story;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UID")
    private User user;

}
