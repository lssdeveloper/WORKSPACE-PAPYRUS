package com.leandroserra.regra.de.negocio;

public class MecanicaDoJogoNivelHard extends MecanicaDoJogo {


	@Override
	public int getTotalDePalavras() {
		
		return 12;
	}
	public MecanicaDoJogoNivelHard() {
		setQtdPermitidaDeErros(3);
	}
	@Override
	public int getQtdPermitidaDeErros() {

		return super.getQtdPermitidaDeErros();
	}
	@Override
	public boolean getIsAssertivo(String palavra) {
		if(palavraNoJogo.equalsIgnoreCase(palavra)){ 
			this.getSomaPontuacao();
			this.isAssertivo = true;
			this.countDePalavras();
		}
		else{
			this.isAssertivo = false;
		}
		this.statusDoJogo();
		return this.isAssertivo;
	}
	
	@Override
	public void statusDoJogo(){
		if (this.getCountPalavras() >= this.getTotalDePalavras())	
			this.isFimDoJogo = true;
		else
			this.isFimDoJogo = false;
	}	

	@Override
	public String getLogicaDoJogo() {
		
		return  "SE DIVIRTA ADIVINHANDO "
				+"PALAVRAS COMPLEXAS EMBARALHADAS.";
	}
	
	@Override
	public void getReset(){
		this.isAssertivo = false;
		this.isNovaTentativa = true;
	}

	@Override
	public String getModoDoJogo() {
		
		return "HARD";
	}

	@Override
	public String getNivelDificuldade() {
		
		return "10";
	}

	

}
