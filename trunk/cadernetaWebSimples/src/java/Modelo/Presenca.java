/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.io.Serializable;

/**
 *
 * @author jorgepereira
 */
public class Presenca implements Serializable {
    
    public int dia;
    public int mes;
    public boolean presenca;

    public Presenca() {
        this.presenca = false;
    }

    public Presenca(int dia, int mes, boolean presenca) {
        this.dia = dia;
        this.mes = mes;
        this.presenca = presenca;
    }
    
    

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public boolean isPresenca() {
        return presenca;
    }

    public void setPresenca(boolean presenca) {
        this.presenca = presenca;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }
    
    
    
}
