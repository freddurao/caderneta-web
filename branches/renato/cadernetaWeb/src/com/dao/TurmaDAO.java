package com.dao;

import java.util.List;

import javax.persistence.Query;

import com.dao.generic.GenericDAO;
import com.model.Professor;
import com.model.Turma;

public class TurmaDAO extends GenericDAO<Turma>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2516004190796232507L;

	public TurmaDAO() {
		super(Turma.class);
		// TODO Auto-generated constructor stub
	}
	
	public  List<Turma>  getTurmas(){
		List<Turma> turmas = null;
		
		beginTransaction();
		StringBuilder sql = new StringBuilder();
		sql.append(" select t from Turma t ")
		.append("where t.fimDeVigencia is null");
		
		Query query = super.em.createQuery(sql.toString());
		turmas = (List<Turma>)query.getResultList();
		
		closeTransaction();
		return turmas;
	}
	
	public  List<Turma>  findTurmaByProfessor(Professor professor){
		List<Turma> turmas = null;
		
		beginTransaction();
		StringBuilder sql = new StringBuilder();
		sql.append(" select t from Turma t ")
		.append("where t.fimDeVigencia is null and t.professor =:professor");
		
		Query query = super.em.createQuery(sql.toString());
		
		query.setParameter("professor", professor);
		turmas = (List<Turma>)query.getResultList();
		
		closeTransaction();
		return turmas;
	}
	
	
	

}
