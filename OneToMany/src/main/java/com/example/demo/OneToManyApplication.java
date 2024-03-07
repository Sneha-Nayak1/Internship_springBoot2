package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Repository.CommentRepository;
import com.example.demo.Repository.PostRepository;
import com.example.demo.entity.Comment;
import com.example.demo.entity.Post;

@SpringBootApplication
public class OneToManyApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(OneToManyApplication.class, args);
	}
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	
	
	@Override
	public void run(String... args) throws Exception {
		Post post = new Post("OnetoMany","OnetoMany OnetoManyOnetoMany");
		
		Comment comment=new Comment("useful");
		Comment comment2=new Comment("informative");
		Comment comment3=new Comment("advantage");
		
		post.getComments().add(comment);
		post.getComments().add(comment2);
		post.getComments().add(comment3);
		
		postRepository.save(post);
		
	}

}
