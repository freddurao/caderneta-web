package com.dao;

import java.util.List;

import javax.persistence.Query;

import com.dao.generic.GenericDAO;
import com.model.Aluno;
import com.model.Aula;
import com.model.Turma;

public class AlunoDAO  extends GenericDAO<Aluno>  {

	public AlunoDAO() {
		super(Aluno.class);
		// TODO Auto-generated constructor stub
	}
	
	
	
	 public  List<Aluno>  findAlunoByTurma(Turma turma){
			List<Aluno> alunos = null;
			
			beginTransaction();
			StringBuilder sql = new StringBuilder();
			sql.append(" select a from Aluno a ")
		     .append(" inner join fetch a.turmas t ")
			.append("where t.id =:turma");
			
			Query query = super.em.createQuery(sql.toString());
			
			query.setParameter("turma", turma.getId());
			alunos = (List<Aluno>)query.getResultList();
			
			closeTransaction();
			return alunos;
		}
	 

}
