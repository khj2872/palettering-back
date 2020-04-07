package com.palettering.api.palettering.post.photo.repository;

import com.palettering.api.palettering.post.photo.domain.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
