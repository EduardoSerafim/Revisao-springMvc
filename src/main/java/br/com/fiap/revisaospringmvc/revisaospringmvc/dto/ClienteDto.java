package br.com.fiap.revisaospringmvc.revisaospringmvc.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.fiap.revisaospringmvc.revisaospringmvc.model.Cliente;




public class ClienteDto {
	
	private long id;
	
	@NotNull
	@NotBlank
	private String nome;
	
	@NotNull
	@NotBlank
	private String documento;
	
	@NotNull
	@NotBlank
	private String endereco;
	
	public ClienteDto() {
		
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
	public void setNome(String nome) {
		this.nome = nome;
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
	
	public void fromCliente(Cliente cliente) {
		this.nome = cliente.getNome();
		this.documento = cliente.getDocumento();
		this.endereco = cliente.getEndereco();
	}
	
}
