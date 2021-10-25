package br.com.fiap.visionsfuture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiap.visionsfuture.model.Login;
import br.com.fiap.visionsfuture.repository.LoginRepository;

@Controller
public class LoginController {
	
	@Autowired
	private LoginRepository repository;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/login")
	public String save(Login login) {
		repository.save(login);
		return "login";
	}
	
	@RequestMapping("/login/new")
	public String create() {
		return "newuser";
	}
	
}
