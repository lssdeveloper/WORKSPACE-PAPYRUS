package com.leandroserra.fabrica;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.leandroserra.modelo.EmbaralhadorAleatorio;
import com.leandroserra.modelo.EmbaralhadorInverso;
import com.leandroserra.modelo.IEmbaralhador;

public class FabricaEmbaralhadores {
	private List<IEmbaralhador> lstEmbaralhadores;


	public FabricaEmbaralhadores() {
		lstEmbaralhadores = new ArrayList<IEmbaralhador>();
		lstEmbaralhadores.add(new EmbaralhadorInverso());
		lstEmbaralhadores.add(new EmbaralhadorAleatorio());
	} 
	
	public IEmbaralhador embaralhadorAutomatico(){
		return lstEmbaralhadores.get(new Random().nextInt(lstEmbaralhadores.size()));
	}
	
}
