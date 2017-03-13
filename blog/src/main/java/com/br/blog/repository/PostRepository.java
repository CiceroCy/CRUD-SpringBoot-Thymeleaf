package com.br.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.blog.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
