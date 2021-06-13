package br.com.pousadaSossego.models;

public class Funcionario {
	private String nome;
	private String id;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param nome
	 * @param id
	 */
	public Funcionario(String nome, String id) {
		this.nome = nome;
		this.id = id;
	}
}
