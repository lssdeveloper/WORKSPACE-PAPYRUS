package com.leandroserra.modelo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EmbaralhadorAleatorio implements IEmbaralhador {

	@Override
	public String embaralhadorDePalavra(String palavra) {
		List<String> lstPalavra = Arrays.asList(palavra.trim().split(""));
		Collections.shuffle(lstPalavra);
		StringBuilder sb = new StringBuilder();
		for(String s : lstPalavra) sb.append(s);
		return sb.toString();
	}

	@Override
	public int nivelDeDificuldade() {
		return 10;
	}
}


