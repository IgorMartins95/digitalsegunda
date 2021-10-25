package br.com.fiap.visionsfuture.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
public class Login {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O e-mail é obrigatório. Digite um e-mail.")
	private String email;
	
	@NotBlank(message = "A senha é obrigatória. Digite uma senha.")
	private String pass;

}
