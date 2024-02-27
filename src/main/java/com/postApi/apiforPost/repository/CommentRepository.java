package com.postApi.apiforPost.repository;

import com.postApi.apiforPost.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List <Comment> findCommentByPostId(int postId);
}
