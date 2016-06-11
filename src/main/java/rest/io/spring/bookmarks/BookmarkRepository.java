package rest.io.spring.bookmarks;

/**
 * Created by kimi on 6/10/16.
 */

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    Collection<Bookmark> findByAccountUsername(String username);
}