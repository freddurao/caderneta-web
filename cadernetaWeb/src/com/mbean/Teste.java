package com.mbean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.model.Aula;

public class Teste {
	
	
	public static void main(String[] args) {
      List<Aula> aulas = new ArrayList<Aula>();
		
      Date data = new Date();
      data.setMonth(1);
      Aula aula = new Aula();
	  aula.setDataHoraInicio(data);
      aulas.add(aula);
      int d = data.getDate();
      for (int i = 1; i < 5; i++) {
    	  
    	  
    	  data = new Date();
    	 
    		  data.setMonth(1);
    	  
		aula = new Aula();
		
		d = d+7;
		
	 	data.setDate(d);
		aula.setDataHoraInicio(data);
		
		aulas.add(aula);
	 }
      
      
      for (Aula a : aulas) {
		System.out.println(a.getDataHoraInicio());
	  }
	}
	
	
}
