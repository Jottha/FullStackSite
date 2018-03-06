package com.jack.curso.responses;



public class Response {
	
	private int codigo;
	private String mensagem;
		
//	private T data;
//	private List<String> erros;
	
	public Response() {
		
	}
	
//	public Response(T data)
//	{
//		this.data = data;
//	}
	
	public Response(String mensagem) {
		this.mensagem = mensagem;
	}

//	public Response(List<String> erros)
//	{
//		this.erros = erros;
//	}
//	
//	public T getData()
//	{
//		return data;
//	}
//	
//	public void setData(T data)
//	{
//		this.data = data;
//	}
//	
//	public List<String> getErros()
//	{
//		return erros;
//	}
//	
//	public void setErros(List<String> erros)
//	{
//		this.erros = erros;
//	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}