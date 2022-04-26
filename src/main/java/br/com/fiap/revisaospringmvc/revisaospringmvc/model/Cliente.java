package br.com.fiap.revisaospringmvc.revisaospringmvc.model;

public class Cliente {

	private long id;
	private String nome;
	private String documento;
	private String endereco;
	
	public Cliente() {
		
	}
	
	public Cliente(long id, String nome, String documento, String endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.documento = documento;
		this.endereco = endereco;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String name) {
		this.nome = name;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
		
}
