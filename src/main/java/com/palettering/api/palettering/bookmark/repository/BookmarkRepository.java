package com.palettering.api.palettering.bookmark.repository;

import com.palettering.api.palettering.bookmark.domain.Bookmark;
import com.palettering.api.palettering.bookmark.domain.BookmarkId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<Bookmark, BookmarkId> {
}
