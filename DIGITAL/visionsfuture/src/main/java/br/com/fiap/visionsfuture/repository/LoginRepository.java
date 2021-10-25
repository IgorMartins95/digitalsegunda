package br.com.fiap.visionsfuture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.visionsfuture.model.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {

}
