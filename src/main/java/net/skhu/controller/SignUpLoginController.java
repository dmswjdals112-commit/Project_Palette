package net.skhu.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.skhu.dto.UserSignUp;
import net.skhu.mapper.SignUpLoginMapper;
import net.skhu.model.UserEdit;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("palette")
@Slf4j
@RequiredArgsConstructor
public class SignUpLoginController {
    private ModelMapper modelMapper = new ModelMapper();

    private final PasswordEncoder passwordEncoder;
    private final SignUpLoginMapper signUpLoginMapper;

    @GetMapping("signUpPage")
    public String signUp(Model model) {
        UserSignUp userSignUp = new UserSignUp();
        userSignUp.setUsername("");
        userSignUp.setEmail("");
        userSignUp.setPasswordHash("");
        model.addAttribute("userSignUp", userSignUp);
        return "palette/signUpPage";
    }

    @PostMapping(value="signUpPage", params="cmd=save")
    public String signUp(Model model, @Valid @ModelAttribute("userSignUp") UserSignUp userSignUp, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                log.error("Validation errors: {}", bindingResult.getAllErrors());
                return "palette/signUpPage";
            }

            log.info("회원가입 시작 - 이메일: {}, 닉네임: {}", userSignUp.getEmail(), userSignUp.getUsername());

            // UserSignUp(DTO)를 UserEdit(Model)로 변환
            UserEdit user = modelMapper.map(userSignUp, UserEdit.class);

            // 비밀번호 해시 암호화
            String encodedPassword = passwordEncoder.encode(userSignUp.getPasswordHash());
            user.setPasswordHash(encodedPassword);

            // DB에 저장
            signUpLoginMapper.insert(user);
            log.info("회원가입 성공 - 이메일: {}", user.getEmail());
            log.info("회원가입 성공 - 닉네임: {}", user.getUsername());

            return "redirect:/palette/loginPage"; // 회원가입 성공 후 로그인 페이지로 리다이렉트

        }
        catch(Exception ex) {
            log.error("회원가입 중 오류 발생: ", ex);
            model.addAttribute("errorMessage", "회원가입 중 오류가 발생했습니다: " + ex.getMessage());
            return "palette/signUpPage";
        }
    }
}
