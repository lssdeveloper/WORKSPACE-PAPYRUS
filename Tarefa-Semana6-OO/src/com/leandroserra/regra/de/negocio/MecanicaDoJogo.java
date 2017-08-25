package com.leandroserra.regra.de.negocio;

import com.leandroserra.fabrica.FabricaEmbaralhadores;
import com.leandroserra.modelo.IEmbaralhador;

public abstract class MecanicaDoJogo implements IMecanicaDoJogo {

	protected IEmbaralhador embaralhador = null;
	private IBancoDePalavras bancoDePalavras = null;
	protected String palavraNoJogo = "";
	protected String palavraCorreta = "";

	protected boolean isFimDoJogo = false;
	protected boolean isNovaTentativa = false;
	protected boolean isAssertivo = false;

	private double pontuacao = 0;
	
	private int qtdPermitidaDeErros;

	private int totalDePalavras = 10;
	private int countPalavras = 0;
	public boolean isSimples = true;
	
	

	public String getPalavraCorreta() {
		return palavraCorreta;
	}

	public void setPalavraCorreta(String palavraCorreta) {
		this.palavraCorreta = palavraCorreta;
	}

	public MecanicaDoJogo() {
		embaralhador = new FabricaEmbaralhadores().embaralhadorAutomatico();
		if (embaralhador.nivelDeDificuldade() == 10)
			this.isSimples = true;
		if (embaralhador.nivelDeDificuldade() == 3)
			this.isSimples = false;

		bancoDePalavras = new BancoDePalavras(this.isSimples);
	}

	public void countDePalavras() {
		this.countPalavras++;
	}

	public void getSomaPontuacao() {
		pontuacao += this.embaralhador.nivelDeDificuldade() * 100;
	}

	public int getCountPalavras() {
		return this.countPalavras++;
	}
	@Override
	public void statusDoJogo() {
		if (this.getCountPalavras() >= this.getTotalDePalavras())
			this.isFimDoJogo = true;
		else
			this.isFimDoJogo = false;
	}

	public int getTotalDePalavras() {
		return totalDePalavras;
	}

	@Override
	public boolean isFimDeJogo() {
		return !isFimDoJogo;
	}

	@Override
	public boolean getIsAssertivo(String palavra) {
		if (palavraNoJogo.equalsIgnoreCase(palavra)) {
			this.getSomaPontuacao();
			this.isAssertivo = true;
			this.countDePalavras();
		} else {
			this.isAssertivo = false;
		}
		this.statusDoJogo();
		return this.isAssertivo;
	}

	@Override
	public double getPontuacao() {
		return pontuacao;
	}

	@Override
	public String getPalavraNoJogo() {
		this.getReset();
		setPalavraCorreta(bancoDePalavras.selecionarPalavraComRandom());
		palavraNoJogo = getPalavraCorreta();
		return embaralhador.embaralhadorDePalavra(palavraNoJogo);
	}

	@Override
	public void getReset() {
		this.isAssertivo = false;
	}

	@Override
	public boolean getIsNovaTentativa() {

		return isNovaTentativa;
	}

	@Override
	public String getObjetivo() {

		return "ADVINHE A PALAVRA EMBARALHADA!";
	}

	public int getQtdPermitidaDeErros() {
		return qtdPermitidaDeErros;
	}

	public void setQtdPermitidaDeErros(int qtdPermitidaDeErros) {
		this.qtdPermitidaDeErros = qtdPermitidaDeErros;
	}

}
