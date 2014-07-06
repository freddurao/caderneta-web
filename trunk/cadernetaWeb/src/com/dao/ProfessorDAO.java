package com.dao;

import java.util.HashMap;
import java.util.Map;

import com.dao.generic.GenericDAO;
import com.model.Professor;

public class ProfessorDAO extends GenericDAO<Professor>  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2541373197861371325L;

	public ProfessorDAO() {
		super(Professor.class);
		// TODO Auto-generated constructor stub
	}

	public Professor login (Professor professor){
		beginTransaction();
		Map<String, Object> parameters = new HashMap<String, Object>();
	    parameters.put("siap", professor.getSiap());
	    parameters.put("senha", professor.getSenha());
	    
	    StringBuilder sb = new StringBuilder();
	    
	    sb.append("select p from professor p where.siap :=siap and p.senha :=senha ");
	    
		Professor result =  super.findOneResult(sb.toString(), parameters);
		closeTransaction();
		
		return result;
	}
	

}
