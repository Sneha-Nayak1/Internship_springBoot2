package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Posts;

public interface PostsRepository extends JpaRepository<Posts,Long>{

}
