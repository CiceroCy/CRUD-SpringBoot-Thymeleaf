package com.br.blog.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.blog.model.Post;
import com.br.blog.services.PostService;

@Controller
public class PostController {

	@Autowired
	private PostService postService;

	@GetMapping("/")
	public ModelAndView findAll() {
		ModelAndView mav = new ModelAndView("/post");
		mav.addObject("posts", postService.findAll());
		return mav;
	}


	@GetMapping("/add")
	public ModelAndView addPost(Post post){
		ModelAndView mav=new ModelAndView("/postAdd");
		mav.addObject("post", post);
		return mav;
	}
	
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id){
		
		return addPost(postService.findById(id));
		
	}
	
	
	@GetMapping("/delete/{id}")
	public ModelAndView deletar(@PathVariable("id") Long id){
		
		postService.delete(id);
		
		return findAll();
	}
	
	
	@PostMapping("/save")
	public ModelAndView save(@Valid Post post,BindingResult result){
		
		if(result.hasErrors()){
			return addPost(post);
		}
		
		postService.save(post);
		
		return findAll();
		
	}
}
