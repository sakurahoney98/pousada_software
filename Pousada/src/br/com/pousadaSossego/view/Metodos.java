package br.com.pousadaSossego.view;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import br.com.pousadaSossego.models.Funcionario;
import br.com.pousadaSossego.models.Hospedagem;
import br.com.pousadaSossego.models.Hospede;
import br.com.pousadaSossego.models.Quarto;

public class Metodos {
	private   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public void cadastrarFuncionario(ArrayList<Funcionario> listaFuncionarios) {
		Scanner sc = new Scanner(System.in);
		Scanner num = new Scanner(System.in);
		int tent2 = 0;
		boolean prox = true;
		String id = null, nome = null;

		do {
			prox = true;
			System.out.print("\n\nDigite a matrícula: ");
			id = sc.nextLine();

			for (Funcionario f : listaFuncionarios) {
				if (f.getId().equals(id)) {
					prox = false;
					break;
				}
			}
			if (prox) {
				System.out.print("\nDigite o nome completo do funcionário: ");
				nome = sc.nextLine();

				listaFuncionarios.add(new Funcionario(nome, id));
				System.out.println("\nFuncionário cadastrado com sucesso.\n\n");
			} else {
				System.out.println("\nA matrícula informada já está em uso.\n\n");
			}

			System.out.print("Deseja cadastrar outro funcionário? [1] Sim [0] Não: ");
			tent2 = num.nextInt();
		} while (tent2 == 1);

	}

	public void listaFuncionarios(ArrayList<Funcionario> listaFuncionarios) {

		if (!listaFuncionarios.isEmpty()) {
			System.out.println("\n\nFuncionários:");
			for (Funcionario f : listaFuncionarios) {
				System.out.println("Nome: " + f.getNome() + "\nMatrícula: " + f.getId());
				System.out.println("-------------------------------------------------------------------------------");
			}
		} else
			System.out.println("\n\nNão há funcionários cadastrados.\n\n");
	}

	public void filtroData(ArrayList<Quarto> listaQuartos) {

		String data1 = dataInicial();
		String data2 = dataFinal(data1);
		int achou = 0;
		String aux = "";
		for (Quarto q : listaQuartos) {

			if (q.getLista().isEmpty()) {
				break;
			} else {
				for (Hospedagem h : q.getLista()) {
					if ((h.getEntrada().isAfter(LocalDate.parse(data1, formatter))
							|| h.getEntrada().isEqual(LocalDate.parse(data1, formatter)))
							&& (h.getEntrada().isBefore(LocalDate.parse(data2, formatter))
									|| h.getEntrada().isEqual(LocalDate.parse(data2, formatter)))) {
						achou++;
						aux = aux + q.getNumero() + " ";
						break;
					}

				}
			}
		}

		if (achou == 0) {
			System.out.println("\nNão há quartos ocupados nessa data.\n\n");

		} else {
			System.out.println("Os quartos ocupados nessa data são:\n" + aux);
		}
	}

	public void listaQuartos(ArrayList<Quarto> listaQuartos) {
		Scanner num = new Scanner(System.in);
		int op = 0;

		do {
			System.out.println("\n\nEscolha uma opção: ");
			System.out.println("[1] Exibir todos os quartos e detalhes");
			System.out.println("[2] Filtrar quarto e exibir detalhes");
			System.out.println("[0] Sair");
			System.out.print("\n\nOpção: ");
			op = num.nextInt();
			switch (op) {
			case 0:
				System.out.println("\n\n");
				break;

			case 1:
				for (Quarto q : listaQuartos) {
					System.out.println("\nQuarto: " + q.getNumero());
					System.out.println("\nDetalhes do quarto:\nValor: " + q.getValor() + "\nCapacidade: "
							+ q.getCapacidade() + " pessoas\tTipo de quarto: " + q.getTipo());
					System.out.println("\nCronograma de ocupação: ");
					if (!q.getLista().isEmpty()) {
						for (Hospedagem h : q.getLista()) {
							System.out.println("Cliente: " + h.getHospede().getNome() + "\nDe: "
									+ formatter.format(h.getEntrada()) + "\tAté: " + formatter.format(h.getSaida()));
							System.out.println(
									"-------------------------------------------------------------------------------");
						}
					} else {
						System.out.println("Não há hospedagens agendadas para este quarto.");
					}

					System.out
							.println("_______________________________________________________________________________");
				}
				break;
			case 2:
				System.out.print("\n\nDigite o número do quarto: ");
				int quarto = num.nextInt();
				if (quarto > 0 && quarto < 11) {
					for (Quarto q : listaQuartos) {
						if (q.getNumero() == quarto) {
							System.out.println("\nQuarto: " + q.getNumero());
							System.out.println("\nDetalhes do quarto:\nValor: " + q.getValor() + "\nCapacidade: "
									+ q.getCapacidade() + " pessoas\tTipo de quarto: " + q.getTipo());
							System.out.println("\nCronograma de ocupação: ");
							if (!q.getLista().isEmpty()) {
								for (Hospedagem h : q.getLista()) {
									System.out.println("Cliente: " + h.getHospede().getNome() + "\nDe: "
											+ formatter.format(h.getEntrada()) + "\tAté: "
											+ formatter.format(h.getSaida()));
									System.out.println(
											"-------------------------------------------------------------------------------");
								}
							} else {
								System.out.println("Não há hospedagens agendadas para este quarto.");
							}
						}

					}
				} else {
					System.out.println("O quarto informado não existe. Os quartos são numerados de 1 à 10.\n\n");
				}
				break;
			default:
				System.out.println("\nOpção inválida!\n");
			}

		} while (op != 0);
	}

	public void listaHospedes(ArrayList<Hospede> listaHospede) {
		if (!listaHospede.isEmpty()) {

			for (Hospede h : listaHospede) {
				System.out.println("Nome: " + h.getNome() + "\nCPF: " + h.getCPF() + "\nTelefone: " + h.getTelefone());
				System.out.println("-------------------------------------------------------------------------------");
			}
		} else {
			System.out.println("\n\nVocê não possui hospedes cadastrados.\n\n");
		}
	}

	public void listaHospedagens(ArrayList<Hospedagem> listaHospedeagem) {
		if (!listaHospedeagem.isEmpty()) {

			for (Hospedagem h : listaHospedeagem) {
				System.out.println("Hóspede: " + h.getHospede().getNome() + "\nQuarto: " + h.getQuarto().getNumero()
						+ "\nValor total a pagar: " + h.getValorTotal() + "\nData de entrada: "
						+ formatter.format(h.getEntrada()) + "\tData de saída: " + formatter.format(h.getSaida()));
				System.out.println("-------------------------------------------------------------------------------");
			}
		} else {
			System.out.println("\n\nVocê não possui hospedagens cadastradas.\n\n");
		}
	}

	public   void cadastrarHospede(ArrayList<Hospede> listaHospede) {
		Scanner sc = new Scanner(System.in);
		Scanner num = new Scanner(System.in);
		boolean confirmacao = true;
		int tent2 = 0;

		do {
			System.out.print("\n\nDigite seu nome: ");
			String nomeCliente = sc.nextLine();
			System.out.print("\nDigite seu CPF: ");
			String cpfCliente = sc.nextLine();
			System.out.print("\nDigite seu telefone: ");
			String telefoneCliente = sc.nextLine();

			for (Hospede h : listaHospede) {
				if (h.getCPF().equals(cpfCliente)) {
					confirmacao = false;
					break;
				}
			}

			if (confirmacao == true) {
				listaHospede.add(new Hospede(nomeCliente, cpfCliente, telefoneCliente));
				System.out.println("\n\nHospede cadastrado com sucesso!\n\n");
			} else {
				System.out.println("\n\nCPF já cadastrado.\n\n");
			}

			System.out.print("Deseja cadastrar outro hospede? [1] Sim [0] Não: ");
			tent2 = num.nextInt();

		} while (tent2 == 1);
		System.out.println("\n\n");

	}

	public void hospedagem(ArrayList<Quarto> listaQuartos, ArrayList<Hospede> listaHospede,
			ArrayList<Hospedagem> listaHospedagens) {

		Scanner sc = new Scanner(System.in);
		Scanner scannerNum = new Scanner(System.in);
		Quarto quartoCliente = null;
		Hospede hos = null;
		int tent2 = 0;

		do {
			System.out.print("\n\nDigite o CPF: ");
			String cpfCliente = sc.nextLine();
			boolean duplicidade = false;
			boolean conf = false;
			for (Hospede h : listaHospede) {

				if (cpfCliente.equals(h.getCPF())) {
					conf = true;
					hos = h;
					break;
				}
			}

			if (conf == true) {
				int getOp = 1;
				ArrayList<Hospedagem> aux = new ArrayList<Hospedagem>();
				for (Hospedagem h : listaHospedagens) {
					if (h.getHospede().getCPF().equalsIgnoreCase(cpfCliente)) {
						aux.add(h);
						duplicidade = true;
					}

				}
				if (!aux.isEmpty()) {
					System.out.println("\nO cliente informado já tem hospedagem agendada. Na(s) seguinte(s) data(s):");
					for (Hospedagem h : aux) {
						System.out.println(
								"Quarto: " + h.getQuarto() + "\nData de entrada: " + formatter.format(h.getEntrada())
										+ "\tData de saída: " + formatter.format(h.getSaida()) + "\n");
					}
					System.out.print("\n\nDeseja realizar uma nova hospedagem? [1] Sim [0] Não: ");
					Scanner op = new Scanner(System.in);
					getOp = op.nextInt();
				}
				if (getOp == 1) {
					System.out.print("\nNúmero do quarto deseja se hospedar: ");
					int numeroQuartoDesejado = scannerNum.nextInt();

					if (numeroQuartoDesejado > 0 && numeroQuartoDesejado < 11) {
						for (Quarto q: listaQuartos) {
							if (q.getNumero() == numeroQuartoDesejado) {
								quartoCliente = q;
							}
						}
						
						String dataInicial = dataInicial();
						String dataFinal = dataFinal(dataInicial);
						boolean stop = false;
						if (duplicidade) {
							for (Hospedagem h : aux) {
								if ((h.getEntrada().isAfter(LocalDate.parse(dataInicial, formatter))
										|| h.getEntrada().isEqual(LocalDate.parse(dataInicial, formatter)))
										&& (h.getEntrada().isBefore(LocalDate.parse(dataFinal, formatter))
												|| h.getEntrada().isEqual(LocalDate.parse(dataFinal, formatter)))) {
									stop = true;
									break;
								}
							}
						}
						if (!stop) {
							boolean prox = true;

							
							
							
							for (Hospedagem h : quartoCliente.getLista()) {

								if ((h.getEntrada().isAfter(LocalDate.parse(dataInicial, formatter))
										|| h.getEntrada().isEqual(LocalDate.parse(dataInicial, formatter)))
										&& (h.getEntrada().isBefore(LocalDate.parse(dataFinal, formatter)) || h
												.getEntrada().isEqual(LocalDate.parse(dataFinal, formatter)))) {
									prox = false;
									break;
								}
							}
							
						

					

					if (prox == true) {
						System.out.print("\nInforme a quantidade de hospedes que o quarto terá: ");
						int quantHospedes = scannerNum.nextInt();

						if (quantHospedes <= quartoCliente.getCapacidade()) {
							
							Hospedagem h = new Hospedagem(dataInicial, dataFinal, quartoCliente,
									hos);
							listaHospedagens.add(h);
							quartoCliente.getLista().add(h);
							System.out.println("\n\nHospedagem cadastrada com sucesso!\n\n");

						} 
						else 
							System.out.println("\nO quarto não suporta essa quantidade de pessoas.\n\n");
						

					} else 
						System.out.println("\nQuarto estará ocupado nesta data.\n\n");
					
					}
					} else 
							System.out.println("\nO cliente já estará hospedado em outro quarto nesse período.\n\n");
						
					}
					 else 
						System.out.println("\nQuarto informado não existe!\n\n");
					
				}
				
				 else 
				System.out.println("\nCPF não foi encontrado!\n\n");
			
			System.out.print("Deseja fazer outra hospedagem? [1] Sim [0] Não: ");
			tent2 = scannerNum.nextInt();
		} while (tent2 == 1);
		System.out.println("\n\n");
	}

	public String dataInicial() {
		Scanner num = new Scanner(System.in);
		int diaI, mesI, anoI;
		boolean prox = false;
		String diaFormat = null, mesFormat = null, anoFormat = null;
		do {
			System.out.println("\n\nInformações sobre a data inicial:");
			System.out.print("\nDia: ");
			diaI = num.nextInt();
			System.out.print("\nMes: ");
			mesI = num.nextInt();
			System.out.print("\nAno: ");
			anoI = num.nextInt();

			diaFormat = String.valueOf(diaI);
			mesFormat = String.valueOf(mesI);
			anoFormat = String.valueOf(anoI);

			if (String.valueOf(anoI).length() == 2 || String.valueOf(mesI).length() < 2
					|| String.valueOf(diaI).length() < 2) {

				if (String.valueOf(anoI).length() == 2)
					anoFormat = "20" + anoFormat;

				if (String.valueOf(mesI).length() < 2)
					mesFormat = "0" + mesFormat;

				if (String.valueOf(diaI).length() < 2)
					diaFormat = "0" + diaFormat;

			}

			prox = dataValida(diaFormat + "/" + mesFormat + "/" + anoFormat);

			if (!prox)
				System.out.println("A data digitada não é válida!\n");
		} while (!prox);

		return diaFormat + "/" + mesFormat + "/" + anoFormat;
	}

	public String dataFinal(String dataInicial) {

		int diaF, mesF, anoF;
		Scanner num = new Scanner(System.in);
		boolean prox = false;
		String diaFormat = null, mesFormat = null, anoFormat = null;
		do {
			do {
				System.out.println("\n\nInformações sobre a data final:");
				System.out.print("\nDia: ");
				diaF = num.nextInt();
				System.out.print("\nMês: ");
				mesF = num.nextInt();
				System.out.print("\nAno: ");
				anoF = num.nextInt();

				diaFormat = String.valueOf(diaF);
				mesFormat = String.valueOf(mesF);
				anoFormat = String.valueOf(anoF);

				if (String.valueOf(anoF).length() == 2)
					anoFormat = "20" + anoFormat;

				if (String.valueOf(mesF).length() < 2)
					mesFormat = "0" + mesFormat;

				if (String.valueOf(diaF).length() < 2)
					diaFormat = "0" + diaFormat;

				prox = dataValida(diaFormat + "/" + mesFormat + "/" + anoFormat);
				if (!prox)
					System.out.println("A data digitada não é válida!\n");
			} while (!prox);

			prox = false;

			LocalDate dataI = LocalDate.parse(dataInicial, formatter);
			LocalDate dataF = LocalDate.parse(diaFormat + "/" + mesFormat + "/" + anoFormat, formatter);

			if (dataI.isBefore(dataF) || dataI.isEqual(dataF)) {
				prox = true;
			}

			if (!prox) {
				System.out.println("A data final não pode ser menor que a data de início.\n");
			}

		} while (!prox);

		return diaFormat + "/" + mesFormat + "/" + anoFormat;
	}

	public boolean dataValida(String data) {

		try {
			LocalDate d = LocalDate.parse(data, formatter);
			return true;
		} catch (Exception e) {

			return false;
		}
	}

	public   ArrayList<Quarto> criarQuartos() {
		ArrayList<Quarto> listaQuartos = new ArrayList<Quarto>();
		int quarto = 1;

		for (; quarto < 5; quarto++) {
			if (quarto % 2 == 0) {
				listaQuartos.add(new Quarto(4, quarto, 100, "casal", new ArrayList<Hospedagem>()));
			} else {
				listaQuartos.add(new Quarto(4, quarto, 100, "solteiro", new ArrayList<Hospedagem>()));
			}

		}

		for (; quarto < 11; quarto++) {
			if (quarto % 2 == 0) {
				listaQuartos.add(new Quarto(2, quarto, 80, "casal", new ArrayList<Hospedagem>()));
			} else {
				listaQuartos.add(new Quarto(2, quarto, 80, "solteiro", new ArrayList<Hospedagem>()));
			}

		}

		return listaQuartos;
	}
}
