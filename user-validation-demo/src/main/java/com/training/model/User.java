package com.training.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
	
	@Id
	private Long userId;
	@NotBlank(message = "Cannot be Blank")
	private String name;
	@Email(message = "email not in proper format")
	private String email;
	@Min(value = 18,message="Min age is 18")
	@Max(value = 58,message="Max age is 18")
	private int age;
	
	

}
