package br.com.fiap.visionsfuture.controller.api;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fiap.visionsfuture.model.Cliente;
import br.com.fiap.visionsfuture.repository.ClienteRepository;

@RestController
@RequestMapping("/api/task")
public class ApiClienteController {
	
	@Autowired
	private ClienteRepository repository;
	
	@PostMapping()
	public ResponseEntity<Cliente> create(@RequestBody Cliente cliente, UriComponentsBuilder uriBuilder) {
		repository.save(cliente);
		URI uri = uriBuilder
				.path("/api/task/{id}")
				.buildAndExpand(cliente.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Cliente> get(@PathVariable Long id) {
		Optional<Cliente> cliente = repository.findById(id);
		
		if(cliente.isPresent()) 
			return ResponseEntity.ok(cliente.get());
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Cliente> delete(@PathVariable Long id){
		Optional<Cliente> cliente = repository.findById(id);
		
		if(cliente.isEmpty()) 
			return ResponseEntity.notFound().build();
		
		repository.deleteById(id);	
		
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Cliente> update(@RequestBody Cliente newCliente, @PathVariable Long id){
		Optional<Cliente> optional = repository.findById(id);
		
		if(optional.isEmpty()) 
			return ResponseEntity.notFound().build();
		
		Cliente cliente = optional.get();
		
		repository.save(cliente);
		
		return ResponseEntity.ok(cliente);
	}
	
	
}
