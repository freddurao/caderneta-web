/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.util.ArrayList;

/**
 *
 * @author jorgepereira
 */
public class Chamada {
    ArrayList<Presenca> presenca;
    Aluno aluno;

    public Chamada() {
        this.presenca = new ArrayList<Presenca>();
    }

    public Chamada(int numPresencas) {
        this.presenca = new ArrayList<Presenca>(numPresencas);
        for(int i = 0; i < numPresencas; i++){
            this.presenca.add(new Presenca(i, i, false));
        }
        
    }
    
    
    
    

    public ArrayList<Presenca> getPresenca() {
        return presenca;
    }

    public void setPresenca(ArrayList<Presenca> presenca) {
        this.presenca = presenca;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    
    
    
}
