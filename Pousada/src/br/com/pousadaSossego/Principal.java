package br.com.pousadaSossego;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import br.com.pousadaSossego.models.Funcionario;
import br.com.pousadaSossego.models.Hospedagem;
import br.com.pousadaSossego.models.Hospede;
import br.com.pousadaSossego.models.Quarto;
import br.com.pousadaSossego.view.Metodos;

public class Principal {

	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static void main(String[] args) {
		Metodos m = new Metodos();
		BancoDeDados bd = new BancoDeDados();
		bd.setListaQuartos(m.criarQuartos());
		int op = 0;
		Scanner num = new Scanner(System.in);

		do {
			System.out.println("Escolha uma op��o:");
			System.out.println("[1] Cadastrar h�spede");
			System.out.println("[2] Cadastrar hospedagem");
			System.out.println("[3] Exibir lista de h�spedes");
			System.out.println("[4] Exibir lista de hospedagens");
			System.out.println("[5] Exibir lista de detalhes dos quartos");
			System.out.println("[6] Exibir lista de quartos ocupados por data");
			System.out.println("[7] Cadastrar funcion�rio");
			System.out.println("[8] Exibir lista de funcion�rios");
			System.out.println("[0] Sair");
			System.out.print("\n\nOp��o: ");
			op = num.nextInt();

			switch (op) {
			case 0:
				System.out.println("\n\nPrograma finalizado.");
				break;
			case 1:
				m.cadastrarHospede(bd.getListaHospede());
				break;

			case 2:
				m.hospedagem(bd.getListaQuartos(), bd.getListaHospede(), bd.getListaHospedagens());
				break;

			case 3:
				m.listaHospedes(bd.getListaHospede());
				break;

			case 4:
				m.listaHospedagens(bd.getListaHospedagens());
				break;

			case 5:
				m.listaQuartos(bd.getListaQuartos());
				break;

			case 6:
				m.filtroData(bd.getListaQuartos());
				break;

			case 7:
				m.cadastrarFuncionario(bd.getListaFuncionarios());
				break;

			case 8:
				m.listaFuncionarios(bd.getListaFuncionarios());
				break;

			default:
				System.out.println("\n\nOp��o inv�lida!\n\n");
			}

		} while (op != 0);

	}

}
