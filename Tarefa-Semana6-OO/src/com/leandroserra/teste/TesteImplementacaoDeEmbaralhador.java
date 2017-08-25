package com.leandroserra.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.leandroserra.fabrica.FabricaMecanicaDoJogo;
import com.leandroserra.modelo.EmbaralhadorAleatorio;
import com.leandroserra.modelo.EmbaralhadorInverso;
import com.leandroserra.regra.de.negocio.BancoDePalavras;
import com.leandroserra.regra.de.negocio.IMecanicaDoJogo;



public class TesteImplementacaoDeEmbaralhador {
	EmbaralhadorAleatorio ea;
	EmbaralhadorInverso ei;
	BancoDePalavras bpSimples, bpComplexas;
	String palavraSimples, palavraComplexa;
	String palavraSimplesInvertida, palavraComplexaInvertida;
	boolean isPalavraCerta = false;
	String pCorreta;
	IMecanicaDoJogo MecanicaDoJogo;
	int totalDePalavras;
	int countPalavras;
	int erros;
	
	@Before
	public void iniciar(){
		FabricaMecanicaDoJogo fabricaMecanicaDoJogo = new FabricaMecanicaDoJogo();
		MecanicaDoJogo = fabricaMecanicaDoJogo.embaralhadorAutomatico();
		pCorreta = MecanicaDoJogo.getPalavraCorreta();
		erros = MecanicaDoJogo.getQtdPermitidaDeErros();
		ea = new EmbaralhadorAleatorio();
		ei = new EmbaralhadorInverso();
		bpSimples = new BancoDePalavras(true);
		palavraSimples = bpSimples.selecionarPalavraComRandom();
		palavraSimplesInvertida = ei.embaralhadorDePalavra(palavraSimples);
		
		bpComplexas = new BancoDePalavras(false);
		palavraComplexa = bpSimples.selecionarPalavraComRandom();
		palavraComplexaInvertida = ei.embaralhadorDePalavra(palavraComplexa);
	}
	
	@Test
	public void embaralhadorAleatorioSimples() {
		assertNotEquals(palavraSimples, ea.embaralhadorDePalavra(palavraSimples));
		System.out.println(palavraSimples);
	}
	@Test
	public void isPalavraCerta() {
		isPalavraCerta = MecanicaDoJogo.getIsAssertivo(pCorreta);
		assertTrue(isPalavraCerta);
	}
	@Test
	public void isPalavraErrada() {
		isPalavraCerta = MecanicaDoJogo.getIsAssertivo(pCorreta);
		assertFalse(!isPalavraCerta);
	}	
	@Test
	public void embaralhadorInversaoSimples() {
		assertEquals(palavraSimplesInvertida, ei.embaralhadorDePalavra(palavraSimples));
		System.out.println(palavraSimplesInvertida);
		System.out.println(palavraSimples);
	}
	@Test
	public void embaralhadorAleatorioComplexa() {
		assertNotEquals(palavraComplexa, ea.embaralhadorDePalavra(palavraComplexa));
		System.out.println(palavraComplexa);
	}
	@Test
	public void embaralhadorInversaoComplexa() {
		assertEquals(palavraComplexaInvertida, ei.embaralhadorDePalavra(palavraComplexa));
		System.out.println(palavraComplexaInvertida);
		System.out.println(palavraComplexa);
	}	
	@Test
	public void NotIsFimDoJogo() {
		MecanicaDoJogo.statusDoJogo();
		assertTrue(MecanicaDoJogo.isFimDeJogo());
	}
	@Test
	public void QtdPermitidaDeErros() {
		assertEquals(erros, MecanicaDoJogo.getQtdPermitidaDeErros());
	}
	@Test
	public void qtdPermitidaDeErrosAcertouTodas() {
		erros = 0;
		assertNotEquals(erros, MecanicaDoJogo.getQtdPermitidaDeErros());
	}	

}
