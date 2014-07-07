package com.facade;

import java.io.Serializable;
import java.util.List;

import com.dao.AulaDAO;
import com.model.Aula;
import com.model.Turma;

public class AulaFacade implements Serializable{
	
    private static final long serialVersionUID = 1L;
    
    private AulaDAO aulaDAO = null;
    
    public AulaFacade(){
    	if(aulaDAO == null)
    		aulaDAO = new AulaDAO();
    }
    
    public void save (Aula aula){
    	aulaDAO.save(aula);
    }
    
    public  List<Aula>  findAulaByTurma(Turma turma){
    	return aulaDAO.findAulaByTurma(turma);
    }
}
