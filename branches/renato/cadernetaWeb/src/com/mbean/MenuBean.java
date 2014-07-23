package com.mbean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;


@ViewScoped
@ManagedBean(name="menuBean")
public class MenuBean implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 895445293216959017L;

	public String goSchedule(){
	 return "schedule.xhtml?faces-redirect=true";
	}
	
	
	public void onEventSelect(SelectEvent selectEvent) {
     
    }
}
