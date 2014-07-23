package com.facade;

import com.dao.CadernetaDAO;
import com.model.Caderneta;

public class CadernetaFacade {

	private CadernetaDAO cadernetaDAO;
	
	
	public CadernetaFacade() {
		// TODO Auto-generated constructor stub
		
		cadernetaDAO = new CadernetaDAO();
	}
	
	
	
	public void  save (Caderneta caderneta){
		
		cadernetaDAO.save(caderneta);
		
	}

}
