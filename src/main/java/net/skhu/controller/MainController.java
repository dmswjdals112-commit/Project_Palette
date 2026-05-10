package net.skhu.controller;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.skhu.dto.User;
import net.skhu.mapper.SearchMapper;
import net.skhu.mapper.UserMapper;
import net.skhu.model.UserEdit;
@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("palette")
public class MainController {
	private ModelMapper modelMapper = new ModelMapper();

	private final SearchMapper searchMapper;
	private final UserMapper userMapper;

	// mainPage, searchPage---------------------------------------------------
	// get요청, mainPage.html로 이동
	@GetMapping("mainPage")
	public String mainPage(Model model) {
		return "palette/mainPage";
	}

	// get요청, searchPage.html로 이동
	@GetMapping("searchPage")
	public String searchPage(Model model) {
		return "palette/searchPage";
	}




		
	// streamPage-------------------------------------------------------------
	// get요청, streamPage.html로 이동
	@GetMapping("streamPage")
	public String streamPage(Model model) {
		return "palette/streamPage";
	}
	// -----------------------------------------------------------------------
	
	
	// upLoadPage, editPage---------------------------------------------------
	// get요청, upLoadPage.html로 이동
	@GetMapping("upLoadPage")
		public String upLoadPage(Model model) {
		return "palette/upLoadPage";
	}
	// get요청, editPage.html로 이동
	@GetMapping("editPage")
	public String editPage(Model model) {
		return "palette/editPage";
	}
	// -----------------------------------------------------------------------
	
	
	// myPage-----------------------------------------------------------------
	// get요청, myPage.html로 이동
	@GetMapping("myPage")
	public String myPage(Model model, HttpSession session) {
		UserEdit userEdit = (UserEdit) session.getAttribute("loginUser");
		UserEdit userEdit2 = userMapper.getUserMyPage(userEdit.getUserId());
		User user = modelMapper.map(userEdit2, User.class);

		model.addAttribute("user", user);
		//model.addAttribute("userId", user.getUserId());

		return "palette/myPage";
	}
	// -----------------------------------------------------------------------
	
	
	
}
