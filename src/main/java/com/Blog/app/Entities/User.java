package com.Blog.app.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {

	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id;

	@Column(name=" User_name",nullable=	false, length=100)
	private String Name;
	private String 	email;
	private String password;
	private String About;

}
