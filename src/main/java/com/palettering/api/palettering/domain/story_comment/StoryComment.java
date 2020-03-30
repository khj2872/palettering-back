package com.palettering.api.palettering.domain.story_comment;

import com.palettering.api.palettering.domain.story.Story;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString

@Entity
public class StoryComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STORY_COMMENT_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STORY_ID")
    private Story story;

    private String contents;

    private String contentsColor;

    private String contentsFont;

    private String contentsSize;

    private String contentsX;

    private String contentsY;

}
