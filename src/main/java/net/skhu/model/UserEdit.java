package net.skhu.model;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserEdit {

    private Long userId;  // 사용자 ID
    private String username; // 닉네임
    private String email; // 이메일 주소 == 아이디
    private String passwordHash; // 비밀번호 해시
    private String profileImage; // 프로필 이미지 URL
}
