package com.palettering.api.palettering.domain.story;

import com.palettering.api.palettering.domain.CreatedTimeEntity;
import com.palettering.api.palettering.domain.story_comment.StoryComment;
import com.palettering.api.palettering.domain.user.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString

@Entity
public class Story extends CreatedTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STORY_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UID")
    private User user;

    @OneToMany(mappedBy = "story")
    private List<StoryComment> storyComments = new ArrayList<>();

    private String image;

    private int isDelete;

}
