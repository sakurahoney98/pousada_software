package br.com.pousadaSossego.models;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Hospedagem {
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private LocalDate entrada;
	private LocalDate saida;
	private double valorTotal;
	private Quarto quarto;
	private Hospede hospede;

	/**
	 * @param entrada
	 * @param saida
	 * @param valorTotal
	 * @param quarto
	 * @param hospede
	 */
	public Hospedagem(LocalDate entrada, LocalDate saida, Quarto quarto, Hospede hospede) {
		this.entrada = entrada;
		this.saida = saida;
		this.valorTotal = setValorTotal();
		this.quarto = quarto;
		this.hospede = hospede;
	}

	public Hospedagem(String entrada, String saida, Quarto quarto, Hospede hospede) {
		this.entrada = LocalDate.parse(entrada, formatter);
		this.saida = LocalDate.parse(saida, formatter);
		this.quarto = quarto;
		this.hospede = hospede;
		this.valorTotal = setValorTotal();
	
	}

	public LocalDate getEntrada() {
		return entrada;
	}

	public void setEntrada(LocalDate entrada) {
		this.entrada = entrada;
	}

	public LocalDate getSaida() {
		return saida;
	}

	public void setSaida(LocalDate saida) {
		this.saida = saida;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	private double setValorTotal() {
		double valor = quarto.getValor() * calculaDias();
		
		return valor;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public Hospede getHospede() {
		return hospede;
	}

	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}
	
	public int calculaDias () {
		
		return Period.between(entrada, saida).getDays();
	}
	
	

}