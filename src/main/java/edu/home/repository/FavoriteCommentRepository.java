package edu.home.repository;

import edu.home.model.FavoriteComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteCommentRepository extends JpaRepository<FavoriteComment, Integer> {
}