package com.mbean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.facade.AulaFacade;
import com.facade.SemestreFacade;
import com.facade.TurmaFacade;
import com.model.Aula;
import com.model.Professor;
import com.model.Semestre;
import com.model.Status;
import com.model.Turma;
import com.util.Constantes;

@ViewScoped
@ManagedBean(name="agendaMBean")
public class AgendaMBean implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4666915617412736740L;

	private TurmaFacade turmaFacade;
	
	private AulaFacade aulaFacade;
	
	private SemestreFacade semestreFacade;
	
	private List<Turma> turmas;
	
	private Turma turma;
	private Semestre semestre;
	
	private List<String> dias;
	private Date horario;
	
	private Integer duracaoAula;
	
	public AgendaMBean(){
		if(turmaFacade==null){
			turmaFacade = new TurmaFacade();
		}
		
		if(semestreFacade==null){
			semestreFacade = new SemestreFacade();
		}
		
		
		if(aulaFacade==null){
			aulaFacade = new AulaFacade();
		}
		
	}
	
	@PostConstruct
	public void init(){
		HttpSession session = (HttpSession) getFacesContext().getExternalContext().getSession(false);
         
	    Professor professor =  (Professor) session.getAttribute("professorSession");

		if(turmas==null&& professor!=null){
			turmas = turmaFacade.findTurmaByProfessor(professor);
		}
		
	}

	
	@SuppressWarnings("deprecation")
	public void agendar(ActionEvent e){
		
		Calendar dataFimSemestre = turma.getSemestre().getDataFim();
	
		Integer cargaHoraria = turma.getDisciplina().getCargaHoraria().getQuantidade();
	
		
		Calendar horarioInicial = turma.getSemestre().getDataInicio();
		horarioInicial.set(Calendar.HOUR_OF_DAY, horario.getHours());
		horarioInicial.set(Calendar.MINUTE, horario.getMinutes());
		horarioInicial.set(Calendar.SECOND, 00);
		
		Calendar horarioFinal = (Calendar) horarioInicial.clone();
	    horarioFinal.add(Calendar.MINUTE, duracaoAula);
	    
	    int total = duracaoAula;
        
         
        while (horarioInicial.getTime().before(dataFimSemestre.getTime())){  
      	  Integer  dia = horarioInicial.get(Calendar.DAY_OF_WEEK);
            if(dias.contains(dia.toString()) && total<=cargaHoraria){
          	      
		        	  System.out.println(" Data " + horarioInicial.getTime()+ " Carga "+total); 
		        	  Aula aula = new Aula();
		        	  aula.setDataHoraInicio(horarioInicial);
		        	  aula.setDataHoraFim(horarioFinal);
		        	  Status status = new Status();
		        	  status.setId(Constantes.STATUS_AULA_CONFIRMADA);
		        	  aula.setStatus(status);
		        	  aula.setTurma(turma);
		        	  aulaFacade.save(aula);
		        	  total += duracaoAula;
		              
            }
            
            horarioInicial.set(Calendar.DAY_OF_MONTH, horarioInicial.get(Calendar.DAY_OF_MONTH) +1 );
      }  
        
        
        
        
	}
	
	
	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public List<String> getDias() {
		return dias;
	}

	public void setDias(List<String> dias) {
		this.dias = dias;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public SemestreFacade getSemestreFacade() {
		return semestreFacade;
	}

	public void setSemestreFacade(SemestreFacade semestreFacade) {
		this.semestreFacade = semestreFacade;
	}

	public Integer getDuracaoAula() {
		return duracaoAula;
	}

	public void setDuracaoAula(Integer duracaoAula) {
		this.duracaoAula = duracaoAula;
	}
	

	public HttpServletRequest getRequestSession() {  
        return (HttpServletRequest) getFacesContext().getExternalContext().getRequest();  
    }
    
     public FacesContext getFacesContext() {  
        return FacesContext.getCurrentInstance();  
    }

	
	
	
}
