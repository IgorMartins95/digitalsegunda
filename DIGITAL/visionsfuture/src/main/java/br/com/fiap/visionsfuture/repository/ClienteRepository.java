package br.com.fiap.visionsfuture.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.visionsfuture.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	Page<Cliente> findByTitleLike(String title, Pageable pageable);	

}