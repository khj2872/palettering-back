package com.palettering.api.palettering.post.post_friend.repository;

import com.palettering.api.palettering.post.post_friend.domain.PostFriend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostFriendRepository extends JpaRepository<PostFriend, Long> {
}
