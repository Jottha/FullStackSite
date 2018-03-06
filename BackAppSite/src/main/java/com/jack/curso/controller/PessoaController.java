package com.jack.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jack.curso.model.Pessoa;
import com.jack.curso.responses.Response;
import com.jack.curso.service.PessoaService;


@CrossOrigin(origins  = "http://localhost:4200")
@RestController
@RequestMapping("/controller")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	
	@RequestMapping(value="/pessoa", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Response salvar(@RequestBody Pessoa pessoa){
 
 
		try {
 
			this.pessoaService.salvarPessoa(pessoa);
 
			return new Response("Registro salvo com sucesso!");
 
		}catch(Exception e) {
 
			return new Response(e.getMessage());			
		}
	}
 
	/**
	 * ATUALIZAR O REGISTRO DE UMA PESSOA
	 * @param pessoa
	 * @return
	 */
	@RequestMapping(value="/pessoa", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Response atualizar(@RequestBody Pessoa pessoa){
 
		try {
 
			this.pessoaService.salvarPessoa(pessoa);		
 
			return new Response("Registro atualizado com sucesso!");
 
		}catch(Exception e) {
 
			return new Response(e.getMessage());
		}
	}
 
	/**
	 * CONSULTAR TODAS AS PESSOAS
	 * @return
	 */
	@RequestMapping(value="/pessoa", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Pessoa> consultar(){
 
		return this.pessoaService.listarPessoa();
	}
 
	/**
	 * BUSCAR UMA PESSOA PELO CÓDIGO
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value="/pessoa/{codigo}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Pessoa buscar(@PathVariable("codigo") String codigo){
 
		return this.pessoaService.listarPorCodigo(codigo);
	}
 
	/***
	 * EXCLUIR UM REGISTRO PELO CÓDIGO
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value="/pessoa/{codigo}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Response excluir(@PathVariable("codigo") String codigo){
 
		try {
 
			pessoaService.deletarPessoa(codigo);
 
			return new Response("Registro excluido com sucesso!");
 
		}catch(Exception e) {
			return new Response(e.getMessage());
		}
	}		
	
//	@GetMapping
//	public ResponseEntity<Response<List<Pessoa>>> listarPessoa(){
//		return ResponseEntity.ok(new Response<List<Pessoa>>(pessoaService.listarPessoa()));
//	}
//	
//	@GetMapping(path = "/{id}")
//	public ResponseEntity<Response<Pessoa>> listarPorCodigo(@PathVariable(name = "codigo") String codigo) {
//		return ResponseEntity.ok(new Response<Pessoa>(pessoaService.listarPorCodigo(codigo)));
//	}
//	
//	@GetMapping(path = "/nome")
//	public ResponseEntity<Response<List<Pessoa>>> listarPorNome(@PathVariable String nome) {
//		return ResponseEntity.ok(new Response<List<Pessoa>>(pessoaService.listarPorNome(nome)));
//	}
//	
//	@PostMapping
//	public ResponseEntity<Response<Pessoa>> salvarPessoa(@Valid @RequestBody Pessoa pessoa, BindingResult result) {
//		
//		if(result.hasErrors()) {
//			List<String> erros = new ArrayList<String>();
//			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
//			return ResponseEntity.badRequest().body(new Response<Pessoa>(erros));
//		}	
//		
//		return ResponseEntity.ok(new Response<Pessoa>(pessoaService.salvarPessoa(pessoa)));
//	}
//	
//	@PutMapping(path = "/{codigo}")
//	public ResponseEntity<Response<Pessoa>> atualizarPessoa(@PathVariable(name = "codigo") String codigo, @Valid @RequestBody Pessoa pessoa, BindingResult result) {
//		
//		if(result.hasErrors()) {
//			List<String> erros = new ArrayList<String>();
//			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
//			return ResponseEntity.badRequest().body(new Response<Pessoa>(erros));
//		}		
//		
//		pessoa.setCodigo(codigo);
//		return ResponseEntity.ok(new Response<Pessoa>(pessoaService.atualizarPessoa(pessoa)));
//	}
//	
//	@DeleteMapping(path = "/{id}")
//	public ResponseEntity<Response<Integer>> deletarPessoa(@PathVariable String codigo) {
//			
//		pessoaService.deletarPessoa(codigo);
//		return ResponseEntity.ok(new Response<Integer>(1));
//	}
}