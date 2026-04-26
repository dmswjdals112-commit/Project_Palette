package net.skhu.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import net.skhu.dto.SearchResult;
import net.skhu.dto.Album;
import net.skhu.dto.Artist;
import net.skhu.dto.Song;
import net.skhu.mapper.SearchMapper;

@Controller
@RequestMapping("palette")
@Slf4j
public class MainController {
	private ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private SearchMapper searchMapper;

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



	// -----------------------------------------------------------------------
	@GetMapping("loginPage")
	public String loginPage(Model model) {
		return "palette/loginPage";
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
	public String myPage(Model model) {
		return "palette/myPage";
	}
	// -----------------------------------------------------------------------
	
	
	
}
