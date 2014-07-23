/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

/**
 *
 * @author jorgepereira
 */
public class Aluno {
    String matricula;
    String nome;
    int codDisciplina;

    

    public Aluno(String matricula, String nome, int codDisciplina) {
        this.matricula = matricula;
        this.nome = nome;
        this.codDisciplina = codDisciplina;
    }

    public Aluno() {
    }
    
    

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodDisciplina() {
        return codDisciplina;
    }

    public void setCodDisciplina(int codDisciplina) {
        this.codDisciplina = codDisciplina;
    }

  
    
    
    
}
