package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Posts;
import com.example.demo.entity.Tags;
import com.example.demo.repository.PostsRepository;
import com.example.demo.repository.TagsRepository;

@SpringBootApplication
public class ManyToManyApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ManyToManyApplication.class, args);
	}
	
	@Autowired private PostsRepository postsRepository;
	@Autowired private TagsRepository tagsRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
	Posts posts=new Posts("manyTomany","manyTomany","manyTomany");
	Posts posts1=new Posts("many2many","many2many","many2many");
	
	Tags tag1=new Tags("india1");
	Tags tag2=new Tags("india2");
	Tags tag3=new Tags("india3");
		
	posts.getTags().add(tag1);
	posts.getTags().add(tag2);
	posts.getTags().add(tag3);
	
	tag1.getPosts().add(posts);
	tag2.getPosts().add(posts);
	tag3.getPosts().add(posts);
	
	posts1.getTags().add(tag1);
	tag1.getPosts().add(posts1);
	tag2.getPosts().add(posts1);
	tag3.getPosts().add(posts1);
	
	this.postsRepository.save(posts);
	this.postsRepository.save(posts1);
	}

}
