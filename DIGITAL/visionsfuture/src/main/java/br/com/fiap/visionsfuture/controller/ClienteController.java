package br.com.fiap.visionsfuture.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.visionsfuture.model.Cliente;
import br.com.fiap.visionsfuture.repository.ClienteRepository;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteRepository repository;
	
	@GetMapping("/cliente")
	public ModelAndView index() {
		List<Cliente> clientes = repository.findAll();
		ModelAndView modelAndView = new ModelAndView("clientes");
		modelAndView.addObject("clientes", clientes);
		return modelAndView;
	}
	
	@PostMapping("/cliente")
	public String save(@Valid Cliente cliente, BindingResult result) {
		if (result.hasErrors()) return "newcliente";
		repository.save(cliente);
		return "clientes";
	}
	
	@RequestMapping("/cliente/new")
	public String create(Cliente Cliente) {
		return "newcliente";
	}

}
