package com.dao;
import java.util.List;

import javax.persistence.Query;

import com.dao.generic.*;
import com.model.Aula;
import com.model.Professor;
import com.model.Turma;
public class AulaDAO extends GenericDAO<Aula>  {
 
   

	private static final long serialVersionUID = 1L;
 
   
	 public AulaDAO() {
			super(Aula.class);
			// TODO Auto-generated constructor stub
	}
	 
	 @Override
	public void save(Aula entity) {
		// TODO Auto-generated method stub
		beginTransaction();
		super.save(entity);
		commitAndCloseTransaction();
	}
	 
	 
	 
	 public  List<Aula>  findAulaByTurma(Turma turma){
			List<Aula> aulas = null;
			
			beginTransaction();
			StringBuilder sql = new StringBuilder();
			sql.append(" select a from Aula a ")
			.append("where a.turma =:turma");
			
			Query query = super.em.createQuery(sql.toString());
			
			query.setParameter("turma", turma);
			aulas = (List<Aula>)query.getResultList();
			
			closeTransaction();
			return aulas;
		}
  
}
