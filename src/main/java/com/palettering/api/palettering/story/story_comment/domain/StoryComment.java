package com.palettering.api.palettering.story.story_comment.domain;

import com.palettering.api.palettering.story.story.domain.Story;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

@Entity
public class StoryComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STORY_COMMENT_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "STORY_ID")
    private Story story;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String contentsColor;

    @Column(nullable = false)
    private String contentsFont;

    @Column(nullable = false)
    private String contentsSize;

    @Column(nullable = false)
    private String contentsX;

    @Column(nullable = false)
    private String contentsY;

    @Builder
    public StoryComment(Story story, String contents, String contentsColor,
                        String contentsFont, String contentsSize, String contentsX,
                        String contentsY) {
        this.story = story;
        this.contents = contents;
        this.contentsColor = contentsColor;
        this.contentsFont = contentsFont;
        this.contentsSize = contentsSize;
        this.contentsX = contentsX;
        this.contentsY = contentsY;
    }
}
