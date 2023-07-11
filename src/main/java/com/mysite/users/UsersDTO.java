package com.mysite.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UsersDTO {

	private String id;
	private String password;
	private String name;
	private String role;
}
