package com.palettering.api.palettering.post.reply.reply_like.repository;

import com.palettering.api.palettering.post.reply.reply_like.domain.ReplyLike;
import com.palettering.api.palettering.post.reply.reply_like.domain.ReplyLikeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyLikeRepository extends JpaRepository<ReplyLike, ReplyLikeId> {
}
