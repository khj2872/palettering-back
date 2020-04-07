package com.palettering.api.palettering.post.post_like.repository;

import com.palettering.api.palettering.post.post_like.domain.PostLike;
import com.palettering.api.palettering.post.post_like.domain.PostLikeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostLikeRepository extends JpaRepository<PostLike, PostLikeId> {
}
