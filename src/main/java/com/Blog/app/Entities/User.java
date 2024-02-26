package com.Blog.app.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User {

	
	@Id
	private int id;

	@Column(name="User_name",nullable=	false, length=100)
	private String Name;
	private String 	email;
	private String password;
	private String About;


	@OneToMany (mappedBy ="user" ,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Post>posts=new ArrayList<>();

}
