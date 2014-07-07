package com.facade;

import java.io.Serializable;
import java.util.List;

import com.dao.AlunoDAO;
import com.dao.AulaDAO;
import com.model.Aluno;
import com.model.Turma;

public class AlunoFacade implements Serializable{
	
    private static final long serialVersionUID = 1L;
    
    private AlunoDAO alunoDAO = null;
    
    public AlunoFacade(){
    	if(alunoDAO == null)
    		alunoDAO = new AlunoDAO();
    }
    
    
    public  List<Aluno>  findAlunoByTurma(Turma turma){
       return	alunoDAO.findAlunoByTurma(turma);
    }

}
