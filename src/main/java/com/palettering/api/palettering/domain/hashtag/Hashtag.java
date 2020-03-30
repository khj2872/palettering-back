package com.palettering.api.palettering.domain.hashtag;

import com.palettering.api.palettering.domain.post_hashtag.PostHashtag;
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
public class Hashtag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HASHTAG_ID")
    private Long id;

    @OneToMany(mappedBy = "hashtag")
    private List<PostHashtag> postHashtags = new ArrayList<>();

    private String name;

    private int count;

}
