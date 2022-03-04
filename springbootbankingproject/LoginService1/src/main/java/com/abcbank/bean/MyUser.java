package com.abcbank.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class MyUser {
	
	@Id
	@Column(name="username",length = 100)
	private String username;
	private String password;
	private boolean active;
	private String roles;
	

}
