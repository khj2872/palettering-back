package com.palettering.api.palettering.story.story_comment.repository;

import com.palettering.api.palettering.story.story_comment.domain.StoryComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryCommentRepository extends JpaRepository<StoryComment, Long> {
}
