package com.br.blog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.blog.model.Post;
import com.br.blog.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	public List<Post> findAll(){
		return postRepository.findAll();
	}
	
	public Post findById(Long id){
		return postRepository.findOne(id);
	}
	
	public Post save(Post post){
		return postRepository.saveAndFlush(post);
	}
	
	public void  delete(Long id){
	   postRepository.delete(id);
	}
}
