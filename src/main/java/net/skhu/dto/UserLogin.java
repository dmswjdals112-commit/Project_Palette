package net.skhu.dto;

import lombok.Data;

@Data
public class UserLogin {
	 private String email;
	 private String passwordHash;
}
