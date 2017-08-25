package com.leandroserra.fabrica;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.leandroserra.regra.de.negocio.IMecanicaDoJogo;
import com.leandroserra.regra.de.negocio.MecanicaDoJogoNivelHard;
import com.leandroserra.regra.de.negocio.MecanicaDoJogoNivelEasy;

public class FabricaMecanicaDoJogo {
	private List<IMecanicaDoJogo> lstMecanicaDoJogo;

	public FabricaMecanicaDoJogo() {
		lstMecanicaDoJogo = new ArrayList<IMecanicaDoJogo>();
		lstMecanicaDoJogo.add(new MecanicaDoJogoNivelHard());
		lstMecanicaDoJogo.add(new MecanicaDoJogoNivelEasy());

	} 
	public IMecanicaDoJogo embaralhadorAutomatico(){
		return lstMecanicaDoJogo.get(new Random().nextInt(lstMecanicaDoJogo.size()));
	}
	
}
