package com.leandroserra.regra.de.negocio;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import com.leandroserra.modelo.IEmbaralhador;

public class BancoDePalavras implements IBancoDePalavras {
	private static List<String> lstPalavras;
	private static String palavra;


	public BancoDePalavras(boolean isSimples) {
		try {
			if (isSimples){
				lstPalavras = ArquivoDePalavras.retornarPalavra("bancoDePalavrasSIMPLES.txt");			
			}else{
				lstPalavras = ArquivoDePalavras.retornarPalavra("bancoDePalavrasCOMPLEXAS.txt");			
			}


		} catch (java.nio.file.NoSuchFileException e) {
			System.out.println("Erro ao acessar arquivo com banco de palavras não existe!");
		} catch (java.nio.file.FileSystemException e) {
			System.out.println("Arquivo não encontrado, classe geral para exceções do sistema de arquivos!");
		} catch (IOException e) {

		}
	}

	@Override
	public String selecionarPalavraComRandom() {
		int index = new Random().nextInt(lstPalavras.size());
		palavra = lstPalavras.get(index);
		lstPalavras.remove(index);
		return palavra;
	}

	@Override
	public String selecionaPalavraFixa() {
		int index = 0;
		palavra = lstPalavras.get(index);
		lstPalavras.remove(index);
		return palavra;
	}

}
