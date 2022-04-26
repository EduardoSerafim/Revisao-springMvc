package br.com.fiap.revisaospringmvc.model;

import java.math.BigDecimal;

public class Produto {

	private long id;
	private String nome;
	private Integer quantidade;
	private double valor;
	
	public Produto() {
		
	}
	
	public Produto(long id, String nome, Integer quantidade, double valor) {
		super();
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.valor = valor;
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
