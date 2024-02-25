package com.Blog.app.Service;

import java.util.List;

import com.Blog.app.Entities.User;
import com.Blog.app.Payloads.UserDTO;

public interface UserService {

	UserDTO createUser(UserDTO user);

	UserDTO updateUser(UserDTO userDTO, Integer userId);

	UserDTO getUserByid(Integer userId);
	
	List<UserDTO>getAllUser();
	
	void deleteUser(Integer userId);
	

class abc{
	void sum(){

	}

	}
}
