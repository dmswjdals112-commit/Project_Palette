package net.skhu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import net.skhu.model.UserEdit;

@Mapper
public interface UserMapper {
	// myPage에서 표시할 사용자 정보 조회
	@Select("SELECT userId, username, email, profileImage FROM users WHERE userId = #{userId}")
	UserEdit getUserMyPage(@Param("userId") Long userId);
}
