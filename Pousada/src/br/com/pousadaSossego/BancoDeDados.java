package br.com.pousadaSossego;

import java.util.ArrayList;

import br.com.pousadaSossego.models.Funcionario;
import br.com.pousadaSossego.models.Hospedagem;
import br.com.pousadaSossego.models.Hospede;
import br.com.pousadaSossego.models.Quarto;


public class BancoDeDados {


	ArrayList<Hospede> listaHospede = new ArrayList<Hospede>();

	ArrayList<Hospedagem> listaHospedagens = new ArrayList<Hospedagem>();

	ArrayList<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
	
	ArrayList<Quarto> listaQuartos = new ArrayList<Quarto>();
	

	

	void setListaQuartos(ArrayList<Quarto> listaQuartos) {
		this.listaQuartos = listaQuartos;
	}


	public ArrayList<Quarto> getListaQuartos() {
		return listaQuartos;
	}

	public ArrayList<Hospede> getListaHospede() {
		return listaHospede;
	}

	public ArrayList<Hospedagem> getListaHospedagens() {
		return listaHospedagens;
	}

	public ArrayList<Funcionario> getListaFuncionarios() {
		return listaFuncionarios;
	}


}
