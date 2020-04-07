package com.palettering.api.palettering.post.reply.reply.repository;

import com.palettering.api.palettering.post.reply.reply.domain.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
