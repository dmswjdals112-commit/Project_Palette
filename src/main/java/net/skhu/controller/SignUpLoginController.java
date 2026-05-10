package net.skhu.controller;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.skhu.dto.UserLogin;
import net.skhu.dto.UserSignUp;
import net.skhu.mapper.SignUpLoginMapper;
import net.skhu.model.UserEdit;

@Controller
@RequestMapping("palette")
@Slf4j
@RequiredArgsConstructor
public class SignUpLoginController {
    private ModelMapper modelMapper = new ModelMapper();
    
    
    private final PasswordEncoder passwordEncoder;
    private final SignUpLoginMapper signUpLoginMapper;

    //회원 가입 액션 메소드-----------------------------------------------------------------------------------
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
    //회원 가입 액션 메소드-----------------------------------------------------------------------------------
    
    
    //로그인 액션 메소드-----------------------------------------------------------------------------------
    @GetMapping("loginPage")
    public String login(Model model) {
    	UserLogin userLogin = new UserLogin();
    	userLogin.setEmail("");
    	userLogin.setPasswordHash("");
    	model.addAttribute("userLogin", userLogin); 
		return "palette/loginPage";
	}
    
    @PostMapping(value="loginPage", params="cmd=login")
    public String login(Model model, @ModelAttribute("userLogin") UserLogin userLogin, HttpServletRequest request) {
		try {
			log.info("로그인 시도 - 이메일: {}", userLogin.getEmail());
			
			// DB에서 사용자 정보 조회
			UserEdit user = signUpLoginMapper.findByEmail(userLogin.getEmail());
			
			if (user == null) {
				log.warn("로그인 실패 - 사용자 없음: {}", userLogin.getEmail());
				model.addAttribute("errorMessage", "사용자를 찾을 수 없습니다.");
				return "palette/loginPage";
			}
			
			// 비밀번호 검증
			if (!passwordEncoder.matches(userLogin.getPasswordHash(), user.getPasswordHash())) {
				log.warn("로그인 실패 - 비밀번호 불일치: {}", userLogin.getEmail());
				model.addAttribute("errorMessage", "비밀번호가 일치하지 않습니다.");
				return "palette/loginPage";
			}
			
			HttpSession session = request.getSession();
		    session.setAttribute("loginUser", user); 
			
			log.info("로그인 성공 - 이메일: {}", userLogin.getEmail());
			return "redirect:/palette/mainPage"; // 로그인 성공 후 메인 페이지로 리다이렉트
		}
		catch(Exception ex) {
			log.error("로그인 중 오류 발생: ", ex);
			model.addAttribute("errorMessage", "로그인 중 오류가 발생했습니다: " + ex.getMessage());
			return "palette/loginPage";
		}
	}
	//로그인 액션 메소드-----------------------------------------------------------------------------------	
    
    
    //로그아웃 액션 메소드-----------------------------------------------------------------------------------
    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); 
        
        log.info("로그아웃 완료");
        return "redirect:/palette/mainPage";
    }
    //로그아웃 액션 메소드-----------------------------------------------------------------------------------
    
    
}
