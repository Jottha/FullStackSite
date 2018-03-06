package com.jack.curso.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jack.curso.model.Pessoa;

public interface PessoaRepository extends MongoRepository<Pessoa, String>{
	

	List<Pessoa> findByNomeLikeIgnoreCase(String nome);
	
}
