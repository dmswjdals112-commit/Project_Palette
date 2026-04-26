package net.skhu.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserSignUp {
    @NotBlank(message="활동 닉네임을 입력하세요")
    @NotEmpty(message="활동 닉네임을 입력하세요")
    @Size(min=2, max=20)
    private String username;
    @NotBlank(message="이메일 주소를 입력하세요")
    @NotEmpty(message="이메일 주소를 입력하세요")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"
            , message = "이메일 형식이 유효하지 않습니다.")
    private String email;
    @NotBlank(message="비밀번호를 입력하세요")
    @NotEmpty(message="비밀번호를 입력하세요")
    @Size(min=10, max=20)
    private String passwordHash;
}
