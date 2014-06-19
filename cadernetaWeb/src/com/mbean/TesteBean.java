package com.mbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;

import com.model.Aluno;


@ViewScoped
@ManagedBean(name="testeBean")
public class TesteBean implements Serializable {

	private List<Aluno> alunos;
	

    private ScheduleModel eventModel;
	/**
	 * 
	 */
	private static final long serialVersionUID = 895445293216959017L;

	@PostConstruct
	public void init(){
		
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
	
}
