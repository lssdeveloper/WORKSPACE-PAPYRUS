package com.leandroserra.fases;

public class Fase{

	public static int bonificacao(int fase){
		
		int bonus = 0;
		
		switch (fase) {
		case 0:
			bonus = 10;
			break;
		
		case 1:
			bonus = 2;
			break;
		case 2:
			bonus = 3;
			break;
		case 3:
			bonus = 4;
			break;

		}
		return bonus;
	}

}
