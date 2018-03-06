package com.jack.curso.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jack.curso.model.Pessoa;
import com.jack.curso.repository.PessoaRepository;
import com.jack.curso.service.PessoaService;

@Service
public class PessoaServiceImpl implements PessoaService{
	
	@Autowired
	private PessoaRepository pessoaRepository;

	@Override
	public List<Pessoa> listarPessoa(){
		return pessoaRepository.findAll();
	}
	@Override
	public Pessoa listarPorCodigo(String codigo){
		return pessoaRepository.findOne(codigo);
	}
	@Override
	public List<Pessoa> listarPorNome(String nome){
		return pessoaRepository.findByNomeLikeIgnoreCase(nome);
	}
	@Override
	public Pessoa salvarPessoa(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	@Override
	public Pessoa atualizarPessoa(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	@Override
	public void deletarPessoa(String codigo) {
		pessoaRepository.delete(codigo);
	}
}
