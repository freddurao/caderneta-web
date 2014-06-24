package com.mbean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import com.model.Aula;

public class Teste {
	
	
	public static void main(String[] args) {
	   List<String> dias  = new ArrayList<String>();
	   dias.add("2");
	   dias.add("4");
	   int valorDeTeste = 120;
	  
		Calendar data = new GregorianCalendar();
 
	        Calendar dataFim = new GregorianCalendar(); 
	        dataFim.set(Calendar.DAY_OF_MONTH, 15);  
	        dataFim.set(Calendar.MONTH, 11); // Mes começa em 0 e vai até 11   
	        dataFim.set(Calendar.YEAR, 2014);  
	        System.out.println(" data " + data.getTime());  
	        System.out.println(" data fim " + dataFim.getTime());  
	          
	        
	     
	
		    Integer cargaHoraria = 4080;
	        while (data.getTime().before(dataFim.getTime())){  
	        	  Integer  dia = data.get(Calendar.DAY_OF_WEEK);
	              if(dias.contains(dia.toString()) && valorDeTeste<=4080){
	            	      
			        	  System.out.println(" Data " + data.getTime()+ " Carga "+valorDeTeste); 
			        	  valorDeTeste += 120;
			             
	              }
	              
	              data.set(Calendar.DAY_OF_MONTH, data.get(Calendar.DAY_OF_MONTH) +1 );
	        }  

	
	}	
}
