package com.leandroserra.console;

import java.io.IOException;
import java.util.Scanner;

import com.leandroserra.fabrica.FabricaMecanicaDoJogo;
import com.leandroserra.fases.Fase;
import com.leandroserra.regra.de.negocio.ArquivoDePalavras;
import com.leandroserra.regra.de.negocio.IMecanicaDoJogo;
import com.leandroserra.utilitarios.Utilitarios;

public class Principal {

	public static void main(String[] args) throws java.nio.file.NoSuchFileException, IOException {

		Scanner s = new Scanner(System.in);
		System.out.println("JOGO DAS PALAVRAS EMBARALHADAS!\n");

		System.out.println("*******************************************");
		System.out.println("*           **  ********   **             *");
		System.out.println("*           **     **     *****           *");
		System.out.println("*           **     **     ** **           *");
		System.out.println("*******************************************");

		System.out.println("Deseja inserir palavras no banco de dados?");
		System.out.println("1-Sim 2-Não");

		String str = s.nextLine();
		if (Utilitarios.simDesejaInserirPalavrasNoBanco(str)) {
			System.out.println("Para palavras Complexas digite > C ou 2 para sair.");
			if (Utilitarios.palavrasComplexas(s.nextLine()))
				ArquivoDePalavras.criarArquivoDePalavras('C');
			System.out.println("Para palavras Simples   digite > S ou 2 para sair.");
			if (Utilitarios.palavrasSimples(s.nextLine()))
				ArquivoDePalavras.criarArquivoDePalavras('C');

		}
		FabricaMecanicaDoJogo fabricaMecanicaDoJogo = new FabricaMecanicaDoJogo();
		IMecanicaDoJogo MecanicaDoJogo = fabricaMecanicaDoJogo.embaralhadorAutomatico();

		System.out.println("\n" + MecanicaDoJogo.getObjetivo() + "\n");
		System.out.println("\n MODO DE JOGAR => " + MecanicaDoJogo.getModoDoJogo() + "\n");
		System.out.println(MecanicaDoJogo.getLogicaDoJogo());
		System.out.println("\n NÍVEL DE DIFICULDADE: " + MecanicaDoJogo.getNivelDificuldade());
		System.out.println("\n QUANTIDADE DE ERROS PERMITIDOS NESTE NÍVEL: " +MecanicaDoJogo.getQtdPermitidaDeErros());

		boolean isPalavraCerta = false;
		double pontuacao = 0;
		for (int i = 0; i < 4; i++) {
			int fase = i;
			int acertos = 0;
			int erros = 0;
			//pontuacao += Fase.bonificacao(fase);
			if (fase == 3)
				System.out.println("Concentre-se está é a última fase!");

			for (int j = 0; j < 20; j++) {
				String palavra = MecanicaDoJogo.getPalavraNoJogo();
				String pCorreta = MecanicaDoJogo.getPalavraCorreta();
				System.out.println("_____________________________________________________\n");
				System.out.println("Gabarito:=====>" + pCorreta);
				System.out.println("_____________________________________________________");
				System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				System.out.println("\nQUE PALAVRA É ESTA EMBARALHADA? " + palavra );
				System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");				
				str = s.nextLine();
				isPalavraCerta = MecanicaDoJogo.getIsAssertivo(str);
				if (isPalavraCerta) {
					acertos++;
					pontuacao += MecanicaDoJogo.getPontuacao();
					System.out.println("\n################################################");						
					System.out.println("\nOk, esta você acertou! " + MecanicaDoJogo.getPontuacao() + " pts");						
					System.out.println("\nPONTUAÇÃO: " + pontuacao + " pontos!");
					System.out.println("\n################################################");							

					if (fase == 0) {
						if ((acertos == 2)) {
							pontuacao *= Fase.bonificacao(fase);
							j = 20;
							System.out.println("\n==========================================================");		
							System.out.println("\nParabéns primeira fase concluída!");
							System.out.println(
									"\nVocê está indo bem!"
									+"\nComo bônus seus pontos serão multiplicados por " + Fase.bonificacao(fase));
							System.out.println("\nSUA PONTUAÇÃO NA 1 ª FASE " + pontuacao + " PONTOS\n");
							System.out.println("\n===========================================================");							

						}
					}
					if (fase == 1) {
						if ((acertos == 2)) {
							pontuacao *= Fase.bonificacao(fase);
							j = 20;							
							System.out.println("\n============================================================");	
							System.out.println("\nParabéns segunda fase concluída!");
							System.out.println(
									"\nVocê está indo bem!"
									+"\nComo bônus seus pontos serão multiplicados por " + Fase.bonificacao(fase));
							System.out.println("\nSUA PONTUAÇÃO NA 2 ª FASE " + pontuacao + " PONTOS\n");
							System.out.println("\n============================================================");	
						}
					}
					if (fase == 2) {
						if ((acertos == 2)) {
							pontuacao *= Fase.bonificacao(fase);
							j = 20;							
							System.out.println("\n==============================================================");	
							System.out.println("\nParabéns terceira fase concluída!");
							System.out.println(
									"\nVocê está indo bem!"
									+"\nComo bônus seus pontos serão multiplicados por " + Fase.bonificacao(fase));
							System.out.println("\nSUA PONTUAÇÃO NA 3 ª FASE " + pontuacao + " PONTOS\n");
							System.out.println("\n==============================================================");	
						}
					}
					if (fase == 3) {
						if ((acertos == 2)) {
							pontuacao *= Fase.bonificacao(fase);
							j = 20;
							i = 5;
							System.out.println("\n===============================================================");	
							System.out.println("\nParabéns!!!!"
									+ "\nVOCÊ É UM VENCEDOR!!!!!!!");
							System.out.println(
									"\nComo bônus seus pontos serão multiplicados por " + Fase.bonificacao(fase));
							System.out.println("\nSUA PONTUAÇÃO FINAL " + pontuacao + " PONTOS\n");
							System.out.println("\n===============================================================");	

						}
					}
					MecanicaDoJogo.statusDoJogo();
				
				} else if (!isPalavraCerta) {
					erros++;
					System.out.println("\n#################################################");	
					System.out.println("\nInfelizmente, essa palavra você errou.");
					System.out.println("\n#################################################");	
				}
				if (erros == MecanicaDoJogo.getQtdPermitidaDeErros()) {
					System.out.println("\nFIM DE JOGO, VOCÊ ATINGIU UM TOTAL DE ERROS PERMITIDO!");
					System.out.println("\nTOTAL DE ERROS:"+erros + " palavras erradas!");			
					j = 20;
					i = 5;
				}
				if (!MecanicaDoJogo.isFimDeJogo()) {
					if (erros==0){ 
						System.out.println("\nFIM DE JOGO, Parabéns você é um campão invicto!");
					}else{
						System.out.println("\nFIM DE JOGO!");
						System.out.println("\nTOTAL DE ERROS:"+erros + " palavras erradas!");								
					}
	
					j = 20;
					i = 5;	
				}
			}
		}
		s.close();
		System.out.println("\n\n\n");
		System.out.println("*************************************************");
		System.out.println(" PONTUAÇÃO FINAL ====>  "+ pontuacao+" pontos    ");
		System.out.println("*************************************************");	
	}

}
