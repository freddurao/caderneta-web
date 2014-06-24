package com.mbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;

import com.facade.AulaFacade;
import com.model.Aluno;
import com.model.Aula;


@ViewScoped
@ManagedBean(name="testeBean")
public class TesteBean implements Serializable {

	private List<Aluno> alunos;
	

    private ScheduleModel eventModel;
	/**
	 * 
	 */
	private static final long serialVersionUID = 895445293216959017L;
	
	private List<String> dias;
	
	private Date horaInicial;
	
	private Date horaFinal;

	@PostConstruct
	public void init(){

		//aulaface.save(new Aula());
		  eventModel = new DefaultScheduleModel();
	      eventModel.addEvent(new DefaultScheduleEvent(" Aula ", previousDay8Pm(), previousDay11Pm()));
		  alunos = new ArrayList<Aluno>();
		for (int i = 0; i < 10; i++) {
			
			Aluno aluno = new Aluno();
			
			aluno.setNome("Aluno "+ i);
			aluno.setMatricula( "2312312"+1);
			alunos.add(aluno);
		}
	}

	public String goSchedule(){
	 return "schedule.xhtml?faces-redirect=true";
	}
	
	
	
	
	@SuppressWarnings("deprecation")
	public void agendar(ActionEvent e){

		
		//Temporario
		Calendar horaAula = new GregorianCalendar();
		Calendar fimSemestre = new GregorianCalendar();
		Integer cargaHoraria = 4080;// 68 h em min
		
		 int valorDeTeste = 120;// selecionado no cambo de horas adicionas 2 horas
		 
       
		fimSemestre.set(Calendar.DAY_OF_MONTH, 15);  
		fimSemestre.set(Calendar.MONTH, 11); // Mes começa em 0 e vai até 11   
		fimSemestre.set(Calendar.YEAR, 2014);  
		horaAula.set(Calendar.HOUR_OF_DAY, horaInicial.getHours());
		horaAula.set(Calendar.MINUTE, horaInicial.getMinutes());
		horaAula.set(Calendar.SECOND, 00);
        System.out.println(" data " + horaAula.getTime());  
        System.out.println(" data fim " + fimSemestre.getTime());  
        
        
        while (horaAula.getTime().before(fimSemestre.getTime())){  
      	  Integer  dia = horaAula.get(Calendar.DAY_OF_WEEK);
            if(dias.contains(dia.toString()) && valorDeTeste<=4080){
          	      
		        	  System.out.println(" Data " + horaAula.getTime()+ " Carga "+valorDeTeste); 
		        	  valorDeTeste += 120;
		             
            }
            
            horaAula.set(Calendar.DAY_OF_MONTH, horaAula.get(Calendar.DAY_OF_MONTH) +1 );
      }  
        
        
        
        
	}
	
	public void onEventSelect(SelectEvent selectEvent) {
     
    }

	
	  private Date previousDay8Pm() {
	        Calendar t = (Calendar) today().clone();
	        t.set(Calendar.AM_PM, Calendar.PM);
	        t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
	        t.set(Calendar.HOUR, 8);
	         
	        return t.getTime();
	  }

	  private Date previousDay11Pm() {
	        Calendar t = (Calendar) today().clone();
	        t.set(Calendar.AM_PM, Calendar.PM);
	        t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
	        t.set(Calendar.HOUR, 8);
	         
	        return t.getTime();
	    }
	
	private Calendar today() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);
 
        return calendar;
    }
	

	public List<Aluno> getAlunos() {
		return alunos;
	}


	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public ScheduleModel getEventModel() {
		return eventModel;
	}

	public void setEventModel(ScheduleModel eventModel) {
		this.eventModel = eventModel;
	}

	public List<String> getDias() {
		return dias;
	}

	public void setDias(List<String> dias) {
		this.dias = dias;
	}

	public Date getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(Date horaInicial) {
		this.horaInicial = horaInicial;
	}

	public Date getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(Date horaFinal) {
		this.horaFinal = horaFinal;
	}
	
}
