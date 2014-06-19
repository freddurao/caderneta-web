package com.dao;

import com.facade.AulaFacade;
import com.model.Aula;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			AulaFacade aulaFacade = new AulaFacade();
			
			Aula aula = new Aula();
			//aula.setDescricao("teste");
			aulaFacade.save(aula);
	}

}
