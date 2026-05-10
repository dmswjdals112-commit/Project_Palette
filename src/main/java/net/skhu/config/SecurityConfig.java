package net.skhu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                // 공개 페이지
                .requestMatchers("/palette/mainPage", "/palette/loginPage", 
                		"/palette/searchPage", "/palette/search", "/palette/signUpPage", "/palette/streamPage",
                		"/palette/upLoadPage", "/palette/editPage", "/palette/myPage", "/palette/logout").permitAll()
                .requestMatchers("/css/**", "/js/**", "/images/**", "/static/**", "/**/*.css", "/**/*.js").permitAll()
                .requestMatchers("/api/user/check").permitAll()
                // 그 외 모든 페이지는 인증 필요
                .anyRequest().authenticated()
            )
            .csrf(csrf -> csrf.disable())   // 회원가입 POST는 CSRF 검증 제외

            .logout(logout -> logout
                .permitAll()
            );

        return http.build();
    }
    
    @Bean // 사용자 비밀번호를 안전하게 암호화하기 위한 빈 등록 (BCrypt 해시 함수 사용)
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
