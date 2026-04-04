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
	
	@GetMapping("list")
	public String mainPage(Model model) {
		return "palette/mainPage";
	}
}
