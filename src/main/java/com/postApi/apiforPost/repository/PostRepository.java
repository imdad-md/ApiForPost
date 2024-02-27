package com.postApi.apiforPost.repository;

import com.postApi.apiforPost.entities.Comment;
import com.postApi.apiforPost.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository <Post, Integer> {

}
