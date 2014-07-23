package com.facade;

import java.io.Serializable;

import com.dao.ProfessorDAO;
import com.model.Professor;

public class ProfessorFacade implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1629211318255712667L;
	
	private ProfessorDAO  professorDAO;

	public ProfessorDAO getProfessorDAO() {
		return professorDAO;
	}

	public ProfessorFacade() {
		// TODO Auto-generated method stub
    	 
    	 if(professorDAO==null){
    		 professorDAO = new ProfessorDAO();
    	 }

	}
	
	
	public Professor login (Professor professor){
		return professorDAO.login(professor);
	}
}
