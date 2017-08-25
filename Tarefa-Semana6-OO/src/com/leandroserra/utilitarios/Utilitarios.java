package com.leandroserra.utilitarios;

public class Utilitarios {

	public static boolean simDesejaInserirPalavrasNoBanco(String str) {

		if (str.equalsIgnoreCase("sim") || str.equals("1"))
			return true;
		else
			return false;

	}
	
	public static boolean palavrasComplexas(String str) {

		return str.equalsIgnoreCase("C");
		
	}
	
	public static boolean palavrasSimples(String str) {

		return str.equalsIgnoreCase("S");
		
	}
}
