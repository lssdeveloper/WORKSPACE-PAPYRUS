package com.leandroserra.regra.de.negocio;

public interface IMecanicaDoJogo {

	boolean isFimDeJogo();
	boolean getIsAssertivo(String palavra);
	double getPontuacao();
	boolean getIsNovaTentativa();
	String getPalavraNoJogo();
	String getPalavraCorreta();
	String getLogicaDoJogo();
	String getObjetivo();
	String getModoDoJogo();
	String getNivelDificuldade();
	void getReset();
	void getSomaPontuacao();
	int getQtdPermitidaDeErros();
	int getTotalDePalavras();
	void statusDoJogo();
}
