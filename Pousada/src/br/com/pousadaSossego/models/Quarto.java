package br.com.pousadaSossego.models;

import java.util.ArrayList;

public class Quarto {
	private int capacidade;
	private int numero;
	private double valor;
	private ArrayList<Hospedagem> lista = new ArrayList<Hospedagem>();
	private String tipo;

	/**
	 * @param capacidade
	 * @param numero
	 * @param valor
	 */
	public Quarto(int capacidade, int numero, double valor, String tipo, ArrayList<Hospedagem> lista) {
		this.capacidade = capacidade;
		this.numero = numero;
		this.valor = valor;
		this.lista = lista;
		this.tipo = tipo;
	}

	public void add(Hospedagem h) {
		lista.add(h);
	}

	public ArrayList<Hospedagem> getLista() {
		return lista;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setLista(ArrayList<Hospedagem> lista) {
		this.lista = lista;
	}

}