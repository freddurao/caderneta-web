/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeansGerenciaveis;

import Modelo.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

/**
 *
 * @author jorgepereira
 */
@ManagedBean
@ViewScoped
public class CadernetaBean implements Serializable {

    /**
     * Creates a new instance of CadernetaBean
     */
    public CadernetaBean() {
        this.classe = new Classe();
        System.out.println("Carga/3 : " + cargaHoraria / 3);
        this.novaChamada = new Chamada(35);

        this.novoAluno = new Aluno("210105066", "Jorge Fernando Silva Pereira Filho", 51);

        this.novaChamada.setAluno(novoAluno);

        this.classe.getChamadas().add(novaChamada);
        novaChamada = new Chamada(35);
        this.novoAluno = new Aluno();

        //this.createDynamicColumns();
    }

    ArrayList<Integer> arrayNumeroDeAulas;
    Aluno novoAluno;
    String universidade = "UFBA - Universidade Federal da Bahia - Sistema Acadêmico";
    String textoRegistroPresenca = "R00232 - Registro de Presença";
    String departamento = "Departamento - MAT05 - Ciência da Computação";
    String textoDisciplina = "MATC84 - LABORATÓRIO DE PROGRAMAÇÃO WEB";
    String periodoLetivo = "2014-1";
    String turma = "000100(P01)";
    String registroTexto = "R00232 - Registro de Presença";
    int cargaHoraria = 51;

    Classe classe;
    Chamada novaChamada;

    public void setUniversidade(String universidade) {
        this.universidade = universidade;
    }

    public void setTextoRegistroPresenca(String textoRegistroPresenca) {
        this.textoRegistroPresenca = textoRegistroPresenca;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setTextoDisciplina(String textoDisciplina) {
        this.textoDisciplina = textoDisciplina;
    }

    public void setPeriodoLetivo(String periodoLetivo) {
        this.periodoLetivo = periodoLetivo;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public void addNovoAluno() {
        this.novaChamada = new Chamada(35);
        this.novaChamada.setAluno(novoAluno);
        this.classe.getChamadas().add(novaChamada);
        novaChamada = new Chamada();
        this.novoAluno = new Aluno();
        //this.createDynamicColumns();
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Chamada getNovaChamada() {
        return novaChamada;
    }

    public void setNovaChamada(Chamada novaChamada) {
        this.novaChamada = novaChamada;
    }

    public Aluno getNovoAluno() {
        return novoAluno;
    }

    public String getUniversidade() {
        return universidade;
    }

    public String getTextoRegistroPresenca() {
        return textoRegistroPresenca;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getTextoDisciplina() {
        return textoDisciplina;
    }

    public String getPeriodoLetivo() {
        return periodoLetivo;
    }

    public String getTurma() {
        return turma;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setNovoAluno(Aluno novoAluno) {
        this.novoAluno = novoAluno;
    }

    /*
     private List<ColumnModel> columns;
     public List<ColumnModel> getColumns() {
     return columns;
     }
     public void setColumns(List<ColumnModel> columns) {
     this.columns = columns;
     }
     public void updateColumns() {
     //reset table state
     UIComponent table = FacesContext.getCurrentInstance().getViewRoot().findComponent(":form:cars");
     table.setValueExpression("sortBy", null);
     //update columns
     createDynamicColumns();
     }
     private void createDynamicColumns() {
     columns = new ArrayList<ColumnModel>();
     for (Chamada colunas : classe.getChamadas()) {
     Iterator<Presenca> it = colunas.getPresenca().iterator();
     System.out.println("Quantidade de Presenças: "+ colunas.getPresenca().size());
     while(it.hasNext()) {
     columns.add(new ColumnModel("Teste","Teste2" ));
     }
     }
     }
     */
    /*static public class ColumnModel implements Serializable {
     private String header;
     private String presente;
     public ColumnModel(String header, String presente) {
     this.header = header;
     this.presente = presente;
     }
     public String getHeader() {
     return header;
     }
     public void setHeader(String header) {
     this.header = header;
     }
     public String getPresente() {
     return presente;
     }
     public void setPresente(String presente) {
     this.presente = presente;
     }
     public String retorno(){
     return "teste";
     }
     }*/
    public ArrayList<Integer> getArrayNumeroDeAulas() {
        if (arrayNumeroDeAulas == null) {
            arrayNumeroDeAulas = new ArrayList<Integer>(35);
            for (int i = 0; i < 35; i++) {
                
                arrayNumeroDeAulas.add(i + 1);

            }

        }

        return arrayNumeroDeAulas;
    }

    public void setArrayNumeroDeAulas(ArrayList<Integer> arrayNumeroDeAulas) {
        this.arrayNumeroDeAulas = arrayNumeroDeAulas;
    }

    public String getRegistroTexto() {
        return registroTexto;
    }

    public void setRegistroTexto(String registroTexto) {
        this.registroTexto = registroTexto;
    }
    
    

}
