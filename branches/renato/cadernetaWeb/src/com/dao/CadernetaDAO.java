package com.dao;

import com.dao.generic.GenericDAO;
import com.model.Caderneta;

public class CadernetaDAO extends GenericDAO<Caderneta>  {

	public CadernetaDAO() {
		super(Caderneta.class);
		// TODO Auto-generated constructor stub
	}

	
	public void save(Caderneta entity) {
		// TODO Auto-generated method stub
		beginTransaction();
		super.save(entity);
		commitAndCloseTransaction();
	}
	 
}
