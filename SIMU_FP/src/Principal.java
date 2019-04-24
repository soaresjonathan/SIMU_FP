import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		dadosCarga(); // CHAMANDO O MÉTODO DADOSCARGA
		
	}

	public static void dadosCarga() {// MÉTODO COM MENU PARA CARREGAR AS CARGAS ELETRICAS E SEUS DADOS

		int opcao = 0;// DECLARANDO VARIÁVEL DO TIPO INT USADO PARA ESCOLHA DA OPÇÃO
		Scanner sc = new Scanner(System.in);// INSTANCIANDO OBJETO SCANNER SC PARA USAR COMO ENTRADA DE DADOS
		ArrayList<Carga> listaCargas = new ArrayList<Carga>();// INSTANCIANDO LISTA DE OBJETOS CARGA
		SomaPotencia objSomaPotencias = new SomaPotencia();
		DecimalFormat df = new DecimalFormat("0.##");
		
		do {// INICIO DO LAÇO PARA ESCOLHA DA OPÇÃO DO MENU PRINCIPAL
			System.out.println("***** Escolha uma das opções abaixo *****");
			System.out.println("Opção 1 - Cadastrar cargas");
			System.out.println("Opção 2 - Descadastrar cargas");
			System.out.println("Opção 3 - Imprime cargas cadastradas");
			System.out.println("Opção 4 - Simular cargas");
			System.out.println("Opção 0 - Sair do programa");
			System.out.println("_______________________");
			System.out.print("Digite aqui sua opção: ");
			

			opcao = Integer.parseInt(sc.nextLine());// PEDE PARA ENTRAR COM UM INTEIRO PARA SELECIONAR QUAL OPÇÃO NO
													// MENU PRINCIPAL
//*******************************************************************************************************************************				
			if (opcao == 1) {

				int varSomaPotencias = 0;

				Carga objCarga = new Carga();// INSTANCIANDO OBJETO CARGA
				System.out.print("Digite o nome da carga: ");
				objCarga.setNome(sc.nextLine());
				System.out.print("Digite a potência da carga (W): ");
				objCarga.setPotencia(Integer.parseInt(sc.nextLine()));
				System.out.println();

				listaCargas.add(objCarga);// CHAMA MÉTODO ADICIONAR CARGA INSTANCIADA E SEUS DADOS NA LISTA DE OBJETOS
				
				for (int i = listaCargas.size(); i > 0; --i) {
					varSomaPotencias = varSomaPotencias + (listaCargas.get(i - 1).getPotencia());
				}
				objSomaPotencias.setSomaPotencias(varSomaPotencias);

// *******************************************************************************************************************************
			} else if (opcao == 2) { // OPÇÃO 2 DESCADASTRAR CARGAS NO ARRAY
				if (listaCargas.isEmpty()) {
					System.out.println("Não existem cargas cadastradas, pressione Enter para continuar!");
					sc.nextLine();
				} else {

					System.out.println("**************** Lista ****************");

					for (int i = listaCargas.size(), index = 0; i > 0; --i, ++index) {

						System.out.println("Índice: " + index + " - Nome carga: " + listaCargas.get(index).getNome()
								+ " - Potência: " + listaCargas.get(index).getPotencia());

					}
					
					
					System.out.println("_______________________");
					System.out.println("Digite o índice da carga que deseja retirar da lista:");
					
					listaCargas.remove(Integer.parseInt(sc.nextLine()));
					
					System.out.println("Carga selecionada descadastrada, pressione Enter para continuar.");	
					sc.nextLine();
				}

//*******************************************************************************************************************************				
			} else if (opcao == 3) { // OPÇÃO 3 IMPRIME CARGAS ARMAZENADAS NA LISTA DE OBJETOS
				if (listaCargas.isEmpty()) {
					System.out.println("Não existem cargas cadastradas, pressione Enter para continuar!");
					sc.nextLine();
				} else {
					System.out.println("**************** Lista ****************");

					for (int i = listaCargas.size(), index = 0; i > 0; --i, ++index) {

						System.out.println("Índice: " + index + " - Nome carga: " + listaCargas.get(index).getNome()
								+ " - Potência: " + listaCargas.get(index).getPotencia());

					}
					
					System.out.println("Pressione Enter para continuar.");
					sc.nextLine();
				}
//*******************************************************************************************************************************											
			} else if (opcao == 4) { // OPÇÃO 4 CHAMA METODO DA CLASSE SIMULAR CARGA

				Integer varDiasConsumo = 0;
				Double varKwh = 0.0;
				Double acumuladoKva = 0.0;
				
				Double acumuladoKvarFpAlto = 0.0;
				Double acumuladoKwFpAlto = 0.0;
				
				Double acumuladoKvarFpBaixo = 0.0;
				Double acumuladoKwFpBaixo = 0.0;
				
				Double varSomaKw = 0.0;
				Double varRandonSomaKw = 0.0;
				
				Double varFP_alto = 0.0;
				Double varFP_baixo = 0.0;
				
				Double varKvarFpAlto = 0.0;
				Double varKwFpAlto = 0.0;
				
				Double varKvarFpBaixo = 0.0;
				Double varKwFpBaixo = 0.0;
				
				SimuGrandEletrica objSimuGrandEletrica = new SimuGrandEletrica();

				System.out.print("Digite quantas horas de consumo irá simular: ");
				varDiasConsumo = Integer.parseInt(sc.nextLine());
				System.out.print("Digite valor do quilowatt hora(kW/h): ");
				varKwh = Double.parseDouble(sc.nextLine());

				while (varDiasConsumo > 0) {

					

					varSomaKw = (double) objSomaPotencias.getSomaPotencias();
					varRandonSomaKw = (double) objSomaPotencias.randonSomaPotencia();
					
					varFP_alto = objSimuGrandEletrica.randonFatorDePotenciaAlto();
					varFP_baixo = objSimuGrandEletrica.randonFatorDePotenciaBaixo();
					
					varKvarFpAlto = varRandonSomaKw * (1 - varFP_alto);
					varKwFpAlto = varRandonSomaKw * varFP_alto;
					
					varKvarFpBaixo = varRandonSomaKw * (1 - varFP_baixo);
					varKwFpBaixo = varRandonSomaKw * varFP_baixo;
					
				
					System.out.println("*********** FP igual ou acima de 0.92 ************");
					System.out.println("Somatório das potências: " + df.format(varSomaKw) + " kW");
					System.out.println("Potência aparente total medida: " + df.format(varRandonSomaKw));
					System.out.println("Fator de potência alto: " + df.format(varFP_alto));
					System.out.println("Potência reativa total medida: " + df.format(varKvarFpAlto) + " kVAr");
					System.out.println("Potência ativa total medida: " + df.format(varKwFpAlto) + " kW");
					System.out.println("*********** FP abaixo de 0.92 ************");
					System.out.println("Somatório das potências: " + df.format(varSomaKw) + " kW");
					System.out.println("Potência aparente total medida: " + df.format(varRandonSomaKw));
					System.out.println("Fator de potência baixo: " + df.format(varFP_baixo));
					System.out.println("Potência reativa total medida: " + df.format(varKvarFpBaixo) + " kVAr");
					System.out.println("Potência ativa total medida: " + df.format(varKwFpBaixo) + " kW");
					System.out.println("**************************************************");
					acumuladoKva += varRandonSomaKw;
					
					acumuladoKvarFpAlto += varKvarFpAlto;
					acumuladoKwFpAlto += varKwFpAlto;
					
					acumuladoKvarFpBaixo += varKvarFpBaixo;
					acumuladoKwFpBaixo += varKwFpBaixo;
										
					--varDiasConsumo;

					try {
						Thread.sleep(1500);
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
				System.out.println("");
				System.out.println("***************SIMULAÇÃO FINALIZADA***************");
				System.out.println("Total energia consumida acumulada :" + acumuladoKva + " kW/h");
				System.out.println("Custo total da energia consumida: R$ " + df.format(varKwh * acumuladoKva));
				System.out.println("**************************************************");
				System.out.println("*******RESULTADO DO SIMULADO COM FP >= 0.92*******");
				System.out.println("Acumulado potência reativa consumida FP >= 0.92: " + df.format(acumuladoKvarFpAlto) + " KVAr");
				System.out.println("Acumulado potência ativa consumida FP >= 0.92: " + df.format(acumuladoKwFpAlto) + " kW");
				System.out.println("Custo da potência reativa com FP >= 0.92: R$ " + df.format(varKwh * acumuladoKvarFpAlto));
				System.out.println("Custo da potência ativa com FP >= 0.92: R$ " + df.format(varKwh * acumuladoKwFpAlto));
				System.out.println("**************************************************");
				System.out.println("*******RESULTADO DO SIMULADO COM FP < 0.92********");
				System.out.println("Acumulado potência reativa consumida FP abaixo de 0.92: " + df.format(acumuladoKvarFpBaixo) + " KVAr");
				System.out.println("Acumulado potência ativa consumida FP abaixo de 0.92: " + df.format(acumuladoKwFpBaixo) + " kW");
				System.out.println("Custo da potência reativa com FP < 0.92: R$ " + df.format(varKwh * acumuladoKvarFpBaixo));
				System.out.println("Custo da potência ativa com FP < 0.92: R$ " + df.format(varKwh * acumuladoKwFpBaixo));
				System.out.println("");
				System.out.println("Pressione Enter para continuar.");
				sc.nextLine();
			}
//*******************************************************************************************************************************							
		} while (opcao != 0);

		sc.close();// FECHANDO OBJETO SCANNER
	}
}
