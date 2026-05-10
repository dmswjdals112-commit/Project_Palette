package net.skhu.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import net.skhu.model.UserEdit;

@Mapper
public interface SignUpLoginMapper {
    @Insert("""
		       INSERT INTO users (username, email, passwordHash)
		       VALUES (#{username}, #{email}, #{passwordHash})
		       """)
    @Options(useGeneratedKeys = true, keyProperty = "userId")  // userId 자동 생성 및 반환
    void insert(UserEdit user);  // 사용자를 DB에 추가
    
    @Select("SELECT * FROM users WHERE email = #{email}")
    UserEdit findByEmail(@Param("email") String email);
}
