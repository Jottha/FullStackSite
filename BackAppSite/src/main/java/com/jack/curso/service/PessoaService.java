package com.jack.curso.service;

import java.util.List;

import com.jack.curso.model.Pessoa;

public interface PessoaService {

	List<Pessoa> listarPessoa();

	Pessoa listarPorCodigo(String codigo);

	List<Pessoa> listarPorNome(String nome);

	Pessoa salvarPessoa(Pessoa pessoa);

	Pessoa atualizarPessoa(Pessoa pessoa);

	void deletarPessoa(String codigo);
}