package entidades;
// Generated 04-mar-2013 11:00:55 by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Tickets generated by hbm2java
 */
public class Tickets  implements java.io.Serializable {


     private int idTickets;
     private String numero;
     private Date fecha;
     private Integer cerrado;
     private Integer pagado;
     private Date fechaMod;
     private String usuarioMod;

    public Tickets() {
    }

	
    public Tickets(int idTickets) {
        this.idTickets = idTickets;
    }
    public Tickets(int idTickets, String numero, Date fecha, Integer cerrado, Integer pagado, Date fechaMod, String usuarioMod) {
       this.idTickets = idTickets;
       this.numero = numero;
       this.fecha = fecha;
       this.cerrado = cerrado;
       this.pagado = pagado;
       this.fechaMod = fechaMod;
       this.usuarioMod = usuarioMod;
    }
   
    public int getIdTickets() {
        return this.idTickets;
    }
    
    public void setIdTickets(int idTickets) {
        this.idTickets = idTickets;
    }
    public String getNumero() {
        return this.numero;
    }
    
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Integer getCerrado() {
        return this.cerrado;
    }
    
    public void setCerrado(Integer cerrado) {
        this.cerrado = cerrado;
    }
    public Integer getPagado() {
        return this.pagado;
    }
    
    public void setPagado(Integer pagado) {
        this.pagado = pagado;
    }
    public Date getFechaMod() {
        return this.fechaMod;
    }
    
    public void setFechaMod(Date fechaMod) {
        this.fechaMod = fechaMod;
    }
    public String getUsuarioMod() {
        return this.usuarioMod;
    }
    
    public void setUsuarioMod(String usuarioMod) {
        this.usuarioMod = usuarioMod;
    }




}


