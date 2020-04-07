package com.palettering.api.palettering.post.hashtag.domain;

import com.palettering.api.palettering.post.post_hashtag.domain.PostHashtag;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

@Entity
public class Hashtag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HASHTAG_ID")
    private Long id;

    @OneToMany(mappedBy = "hashtag")
    private List<PostHashtag> postHashtags = new ArrayList<>();

    @Column(nullable = false, unique = true)
    private String name;

    private int count;

    @Builder
    public Hashtag(List<PostHashtag> postHashtags, String name, int count) {
        this.postHashtags = postHashtags;
        this.name = name;
        this.count = count;
    }
}
