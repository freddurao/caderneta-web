package com.mbean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.facade.ProfessorFacade;
import com.model.Professor;

@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4093940071602942945L;
	private boolean loggedIn; //Armazena o usuário logado private Usuario usuarioLogado;
	private String login;
	private String senha;
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}    
	
	
	public String autentica(){
		String retorno ="/login.xhtml?faces-redirect=true";
		if(login!=null && senha!=null){
			Professor professor = new Professor();
			professor.setSiap(login);
			professor.setSenha(senha);
			ProfessorFacade professorFacade = new ProfessorFacade();
			professor = professorFacade.login(professor);
			if(professor!=null && professor.getId()!=null){

	            HttpSession session = (HttpSession) getFacesContext().getExternalContext().getSession(false);
	            
	            session.setAttribute("professorSession",  professor);
				loggedIn = true;
				retorno = "/teacher/index.xhtml?faces-redirect=true";
			}else{
				 
				 retorno ="/login.xhtml?faces-redirect=true";   
				 loggedIn = false;
			}
			
			
			
		}
		
		return retorno;
	}
	
	public String sair(){
		loggedIn = false;
		return "/login.xhtml?faces-redirect=true";
	}
	

    public HttpServletRequest getRequestSession() {  
        return (HttpServletRequest) getFacesContext().getExternalContext().getRequest();  
    }
    
     public FacesContext getFacesContext() {  
        return FacesContext.getCurrentInstance();  
    }
	
}
