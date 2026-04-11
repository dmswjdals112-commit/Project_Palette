package net.skhu.controller;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("palette")
@Slf4j
public class MainController {
	private ModelMapper modelMapper = new ModelMapper();
	
	// mainPage, searchPage--------------------------------------------------
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
	// -----------------------------------------------------------------------
	
	
	// loginPage, signUpPage--------------------------------------------------
	// get요청, loginPage.html로 이동
	@GetMapping("loginPage")
	public String loginPage(Model model) {
		return "palette/loginPage";
	}
	
	// get요청, signUpPage.html로 이동
	@GetMapping("signUpPage")
	public String signUpPage(Model model) {
		return "palette/signUpPage";
	}
	// -----------------------------------------------------------------------
	
	
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
	
}
