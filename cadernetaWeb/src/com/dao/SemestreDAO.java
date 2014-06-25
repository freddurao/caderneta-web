package com.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;







import javax.persistence.Query;

import com.dao.generic.GenericDAO;
import com.model.Semestre;
import com.model.Turma;

public class SemestreDAO extends GenericDAO<Semestre>{



	public SemestreDAO() {
		super(Semestre.class);
		// TODO Auto-generated constructor stub
	}
	
	public Semestre  getSemestreAtual(){
		Semestre semestre = null;
		
		beginTransaction();
		StringBuilder sql = new StringBuilder();
		sql.append(" select s from Semestre s ")
		.append("where s.dataInicio <= " +today().getTime()+" and s.dataFim >= "+today().getTime() );
		
		Query query = super.em.createQuery(sql.toString());
		semestre = (Semestre)query.getSingleResult();
		
		closeTransaction();
		return semestre;
	}
	
	
	private Calendar today() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);
 
        return calendar;
    }
	

}
