package entidades;
// Generated 04-mar-2013 11:00:55 by Hibernate Tools 3.2.1.GA



/**
 * Contadores generated by hbm2java
 */
public class Contadores  implements java.io.Serializable {


     private Integer idcontadores;
     private String tabla;
     private Integer valor;

    public Contadores() {
    }

    public Contadores(String tabla, Integer valor) {
       this.tabla = tabla;
       this.valor = valor;
    }
   
    public Integer getIdcontadores() {
        return this.idcontadores;
    }
    
    public void setIdcontadores(Integer idcontadores) {
        this.idcontadores = idcontadores;
    }
    public String getTabla() {
        return this.tabla;
    }
    
    public void setTabla(String tabla) {
        this.tabla = tabla;
    }
    public Integer getValor() {
        return this.valor;
    }
    
    public void setValor(Integer valor) {
        this.valor = valor;
    }




}


