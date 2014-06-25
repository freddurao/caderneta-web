package com.facade;

import java.io.Serializable;

import com.dao.SemestreDAO;
import com.model.Semestre;

public class SemestreFacade implements Serializable{

	
    
	private SemestreDAO semestreDAO;
	
     public SemestreFacade() {
		// TODO Auto-generated method stub
    	 
    	 if(semestreDAO==null){
    		 semestreDAO = new SemestreDAO();
    	 }

	}
     
    
     public Semestre getSemestreAtual(){
    	 return semestreDAO.getSemestreAtual();
     }
}
