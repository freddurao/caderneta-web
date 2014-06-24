package com.mbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.facade.TurmaFacade;
import com.model.Turma;

@ViewScoped
@ManagedBean(name="agendaMBean")
public class AgendaMBean {
	
	
	private TurmaFacade turmaFacade;
	
	private List<Turma> turmas;
	
	private Turma turma;
	
	public AgendaMBean(){
		if(turmaFacade==null){
			turmaFacade = new TurmaFacade();
		}
		
		
	}
	
	@PostConstruct
	public void init(){
		
		if(turmas==null){
			turmas = turmaFacade.getTurmas();
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

}
