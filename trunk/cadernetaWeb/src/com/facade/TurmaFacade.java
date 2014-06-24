package com.facade;

import java.io.Serializable;
import java.util.List;

import com.dao.TurmaDAO;
import com.model.Turma;

public class TurmaFacade implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1462271520426765371L;
    
	private TurmaDAO turmaDAO;
	
     public TurmaFacade() {
		// TODO Auto-generated method stub
    	 
    	 if(turmaDAO==null){
    		 turmaDAO = new TurmaDAO();
    	 }

	}
     
    
     public List<Turma> getTurmas(){
    	 return turmaDAO.getTurmas();
     }
}
