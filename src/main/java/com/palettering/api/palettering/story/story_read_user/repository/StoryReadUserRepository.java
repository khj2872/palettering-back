package com.palettering.api.palettering.story.story_read_user.repository;

import com.palettering.api.palettering.story.story_read_user.domain.StoryReadUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryReadUserRepository extends JpaRepository<StoryReadUser, Long> {
}
