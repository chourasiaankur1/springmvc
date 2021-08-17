package com.ankur.springmvc;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ankur.springmvc.dao.AlienDao;
import com.ankur.springmvc.model.Alien;

@Controller
public class HomeController {
	
	@Autowired
	AlienDao dao;
	
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
	
	@GetMapping("getAliens")
	public String getAliens(Model m) {

		m.addAttribute("result", dao.getAliens());
		return "showAliens.jsp";
	}
	
	@GetMapping("getAlien")
	public String getAlien(@RequestParam int aid, Model m) {

		m.addAttribute("result", dao.getAlien(aid));
		return "showAliens.jsp";
	}
	
	@PostMapping("addAlien")
	public String addAlien(@ModelAttribute("result") Alien a) {
		
		dao.addAlien(a);
		return "showAliens.jsp";
	}
}
