package com.Blog.app.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Blog.app.Entities.User;

public interface UserRepo extends JpaRepository<User,Integer>{
	

}
 