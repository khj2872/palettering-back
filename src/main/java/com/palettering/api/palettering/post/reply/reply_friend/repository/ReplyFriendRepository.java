package com.palettering.api.palettering.post.reply.reply_friend.repository;

import com.palettering.api.palettering.post.reply.reply_friend.domain.ReplyFriend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyFriendRepository extends JpaRepository<ReplyFriend, Long> {
}
