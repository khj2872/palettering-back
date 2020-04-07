package com.palettering.api.palettering.post.post_hashtag.repository;

import com.palettering.api.palettering.post.post_hashtag.domain.PostHashtag;
import com.palettering.api.palettering.post.post_hashtag.domain.PostHashtagId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostHashtagRepository extends JpaRepository<PostHashtag, PostHashtagId> {
}
