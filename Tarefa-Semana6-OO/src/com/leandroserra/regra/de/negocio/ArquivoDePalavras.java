package com.leandroserra.regra.de.negocio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;



public class ArquivoDePalavras {


	public static List<String> retornarPalavra(String arquivo) throws IOException{
		return Files.readAllLines(Paths.get(Paths.get("").toAbsolutePath()+"/fontes/"+arquivo),
				Charset.availableCharsets().get(Charset.availableCharsets().firstKey()));		
	}
	

	
	public static void criarArquivoDePalavras(char tipoDePalavra){
		String nomeFile = null, palavra = null;		
		Scanner input = new Scanner(System.in);
		
		if (tipoDePalavra == 'C'){
			palavra = "COMPLEXAS";
			nomeFile = "bancoDePalavrasCOMPLEXAS.txt";			
		}else if (tipoDePalavra == 'S'){ 
			palavra = "SIMPLES";
			nomeFile = "bancoDePalavrasSIMPLES.txt";			
		}
	

		File file = new File(Paths.get(Paths.get("").toAbsolutePath() + "/fontes/" + nomeFile).toString());
		try {

			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			System.out.println("BANCO DE PALAVRAS "+ palavra +"\n\n");
			
			while (true) {
				System.out.printf("Informe uma palavra para gravação e FIM para encerrar!\n");
				palavra = input.nextLine();
				if (palavra.equalsIgnoreCase("FIM"))
					break;
				bw.write(palavra);
				bw.newLine();
			}


			bw.close();
			fw.close();

		} catch (IOException e) {
			System.out.println("Error ao gravar arquivo!");
		}
	}

	
}
