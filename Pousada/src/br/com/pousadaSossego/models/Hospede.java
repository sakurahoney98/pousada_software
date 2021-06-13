package br.com.pousadaSossego.models;

public class Hospede {
	private String nome;
	private String cpf;
	private String telefone;

	/**
	 * @param nome
	 * @param CPF
	 * @param telefone
	 */
	public Hospede(String nome, String CPF, String telefone) {
		this.nome = nome;
		this.cpf = CPF;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return cpf;
	}

	public void setCPF(String CPF) {
		this.cpf = CPF;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}