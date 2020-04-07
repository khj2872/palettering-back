package com.palettering.api.palettering.post.post.repository;

import com.palettering.api.palettering.post.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
