package com.dao;
import com.dao.generic.*;
import com.model.Aula;
public class AulaDAO extends GenericDAO<Aula>  {
 
   

	private static final long serialVersionUID = 1L;
 
   
	 public AulaDAO() {
			super(Aula.class);
			// TODO Auto-generated constructor stub
	}
	 
	 @Override
	public void save(Aula entity) {
		// TODO Auto-generated method stub
		super.save(entity);
	}
  
}
