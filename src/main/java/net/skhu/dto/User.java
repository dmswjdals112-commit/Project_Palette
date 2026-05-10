package net.skhu.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private Long userId;
    private String username;
    private String email;
    private String passwordHash;
    private String profileImage;
}
