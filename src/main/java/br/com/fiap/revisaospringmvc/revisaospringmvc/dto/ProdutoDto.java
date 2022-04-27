package br.com.fiap.revisaospringmvc.revisaospringmvc.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProdutoDto {

	private long id;
	
	@NotBlank
	@NotNull
	private String nome;
	
	private Integer quantidade;
	
	@DecimalMin(value="0.0")
	@NotNull
	private double valor;
	
	public ProdutoDto() {
		
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

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
