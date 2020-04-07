package com.palettering.api.palettering.story.story.repository;

import com.palettering.api.palettering.story.story.domain.Story;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<Story, Long> {
}
