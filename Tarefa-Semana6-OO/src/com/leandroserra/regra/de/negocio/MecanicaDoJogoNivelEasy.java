package com.leandroserra.regra.de.negocio;

public class MecanicaDoJogoNivelEasy extends MecanicaDoJogo{
	
	

	@Override
	public int getTotalDePalavras() {

		return 8;
	}

	public MecanicaDoJogoNivelEasy() {
		setQtdPermitidaDeErros(5);
	}
	
	@Override
	public int getQtdPermitidaDeErros() {

		return super.getQtdPermitidaDeErros();
	}
	
	@Override
	public String getLogicaDoJogo() {
		return  "SE DIVIRTA ADIVINHANDO "
						+"PALAVRAS SIMPLES EMBARALHADAS.";
	
	}

	@Override
	public String getModoDoJogo() {
		return "EASY";
	}

	@Override
	public String getNivelDificuldade() {
		
		return "3";
	}


	

	

}
