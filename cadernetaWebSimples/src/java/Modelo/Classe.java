/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author jorgepereira
 */
public class Classe implements Serializable {

    public Classe(ArrayList<Chamada> chamadas) {
        this.chamadas = chamadas;
    }

    public Classe() {
        this.chamadas = new ArrayList();
    }
    
    
    
    ArrayList<Chamada> chamadas;

    public ArrayList<Chamada> getChamadas() {
        return chamadas;
    }

    public void setChamadas(ArrayList<Chamada> chamadas) {
        this.chamadas = chamadas;
    }
    
    
    
}
