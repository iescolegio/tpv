/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import entidades.Contadores;
import entidades.Familias;
import entidades.Tickets;
import entidades.Lineasticket;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
//import java.util.HashSet;
////import java.util.Iterator;
//import java.util.List;
//import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author mgacosta
 */
public class Operacion {
    
    public Operacion(){
        
    }
    
    
    
    public String ObtenerNumeroTicket(){
        entidades.Contadores Contador=  ObtenerContador("Numeroticket");
    
          if (Contador.getValor()==0){
              InsertarContador("Numeroticket",1);
          }
          else{ 
              ActualizarContador(Contador.getIdcontadores(),"Numeroticket",Contador.getValor()+1);
          } 
          return Contador.getValor().toString();
    }
            
    
    
     /*
     **********************************************************************
     Funciones para trabajar con la tabla Linea Tickets* 
     **********************************************************************
     */
    
    public void InsertarLineaTickets(String Numero,String Concepto,
                                int Cantidad,double Precio,double Importe,
                                double Iva,int Descuento,int NLinea){
        
        Lineasticket  lineasticket = new Lineasticket();
       
        entidades.Contadores Contador=  ObtenerContador("Lineasticket");
    
          if (Contador.getValor()==0){
              InsertarContador("Lineasticket",1);
          }
          else{ 
              ActualizarContador(Contador.getIdcontadores(),"Lineasticket",Contador.getValor()+1);
          }   
        
        lineasticket.setIdTicket(Contador.getValor()+1);
        lineasticket.setNumeroTicket(Numero);
        lineasticket.setConcepto(Concepto);
        lineasticket.setCantidad(Cantidad);
        lineasticket.setConcepto(Concepto);
        lineasticket.setImporte(Importe);
        lineasticket.setPrecio(Precio);
        lineasticket.setIva(Iva);
        lineasticket.setDescuento(Descuento);
        lineasticket.setNlinea(NLinea);
                
        
        lineasticket.setUsuarioMod("prueba");
       
        Session s= utilidades.HibernateUtil.getSessionFactory().getCurrentSession();
        
        s.beginTransaction();
        s.save(lineasticket);
        s.getTransaction().commit();
       
       
    }
    
     public Lineasticket ObtenerIdLineaTicketPorNumero(String Numero,Integer Linea){
        Session s= utilidades.HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query query = s.createQuery("from Lineasticket Where NumeroTicket = :Numero and NLinea = :Linea ");
        query.setParameter("Numero", Numero);
        query.setParameter("Linea", Linea);
                 
        Iterator iter = query.iterate();
        Lineasticket Lineastickets;
      
        while (iter.hasNext()){
           Lineastickets = (Lineasticket) iter.next();  // fetch the object
           return Lineastickets; 
        }
        
        s.getTransaction().commit();
        return null;
      
        
    }
    
     public void BorrarLineaTickets(int ID){
        
        entidades.Lineasticket  Lineasticket = new entidades.Lineasticket();
        Lineasticket.setIdTicket(ID);
     
        Session s= utilidades.HibernateUtil.getSessionFactory().getCurrentSession();
        
        s.beginTransaction();
        s.delete(Lineasticket);
        s.getTransaction().commit();
       
    }
    
    
      
    public void ActualizarLineaTickets(int ID,String NumeroTicket,Date FechaTicket,int Pagado, int Cerrado){
       
        entidades.Tickets  tickets = new entidades.Tickets();
    
        tickets.setIdTickets(ID);
        tickets.setNumero(NumeroTicket);
        tickets.setFecha(FechaTicket);
        tickets.setCerrado(Cerrado);
        tickets.setPagado(Pagado);
                
        
        tickets.setUsuarioMod("prueba");
       
        Session s= utilidades.HibernateUtil.getSessionFactory().getCurrentSession();
        
        s.beginTransaction();
        s.update(tickets);
        s.getTransaction().commit();
        
        
        
    }
    
    
    
   
    
    
    
     /*
     **********************************************************************
     Funciones para trabajar con la tabla Tickets* 
     **********************************************************************
     */
    
    public String InsertarTickets(Date FechaTicket,int Pagado, int Cerrado){
        String NumeroTicket="";
        entidades.Tickets  tickets = new entidades.Tickets();
       
        entidades.Contadores Contador=  ObtenerContador("Tickets");
        entidades.Contadores ContadorNumeroTicket=  ObtenerContador("NumeroTickets");
  
          if (Contador.getValor()==0){
              InsertarContador("Tickets",1);
          }
          else{ 
              ActualizarContador(Contador.getIdcontadores(),"Tickets",Contador.getValor()+1);
          }   
          
         if (ContadorNumeroTicket.getValor()==0){
              InsertarContador("NumeroTickets",1);
          }
          else{ 
              ActualizarContador(ContadorNumeroTicket.getIdcontadores(),"NumeroTickets",ContadorNumeroTicket.getValor()+1);
          }  
          
          
        NumeroTicket=String.valueOf(ContadorNumeroTicket.getValor()+1);
        
        tickets.setIdTickets(Contador.getValor()+1);
        tickets.setNumero(NumeroTicket);
        tickets.setFecha(FechaTicket);
        tickets.setCerrado(Cerrado);
        tickets.setPagado(Pagado);
                
        
        tickets.setUsuarioMod("prueba");
       
        Session s= utilidades.HibernateUtil.getSessionFactory().getCurrentSession();
        
        s.beginTransaction();
        s.save(tickets);
        s.getTransaction().commit();
       
        return NumeroTicket;
    }
    
     
      
    public void ActualizarTickets(int ID,String NumeroTicket,Date FechaTicket,int Pagado, int Cerrado){
       
        entidades.Tickets  tickets = new entidades.Tickets();
    
        tickets.setIdTickets(ID);
        tickets.setNumero(NumeroTicket);
        tickets.setFecha(FechaTicket);
        tickets.setCerrado(Cerrado);
        tickets.setPagado(Pagado);
                
        
        tickets.setUsuarioMod("prueba");
       
        Session s= utilidades.HibernateUtil.getSessionFactory().getCurrentSession();
        
        s.beginTransaction();
        s.update(tickets);
        s.getTransaction().commit();
        
        
        
    }
    
    
    
    public Tickets ObtenerIdTicketPorNumero(String Numero){
        Session s= utilidades.HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query query = s.createQuery("from Tickets where Numero = :Numero ");
        query.setParameter("Numero", Numero);
                 
        Iterator iter = query.iterate();
        Tickets tickets;//=new Familias();
      
        while (iter.hasNext()){
           tickets = (entidades.Tickets) iter.next();  // fetch the object
           return tickets; 
        }
        
        s.getTransaction().commit();
        return null;
      
        
    }
    
    
    /*
     **********************************************************************
     Funciones para trabajar con la tabla familias* 
     **********************************************************************
     */
    
    public void InsertarFamilia(String Codigo,String Descripcion){
        
        entidades.Familias  familia = new entidades.Familias();
       
        entidades.Contadores Contador=  ObtenerContador("Familias");
  
          if (Contador.getValor()==0){
              InsertarContador("Familias",1);
          }
          else{ 
              ActualizarContador(Contador.getIdcontadores(),"Familias",Contador.getValor()+1);
          }    
     
        familia.setIdfamilias(Contador.getValor()+1);
        familia.setCodigo(Codigo);
        familia.setDescripcion(Descripcion);
        familia.setUsuarioMod("prueba");
       
        Session s= utilidades.HibernateUtil.getSessionFactory().getCurrentSession();
        
        s.beginTransaction();
        s.save(familia);
        s.getTransaction().commit();
       
    }
         
     public void ActualizarFamilia(int ID,String Codigo,String Descripcion){
        
        entidades.Familias  familia = new entidades.Familias();
        familia.setIdfamilias(ID);
        familia.setCodigo(Codigo);
        familia.setDescripcion(Descripcion);
        familia.setUsuarioMod("prueba");
       
        Session s= utilidades.HibernateUtil.getSessionFactory().getCurrentSession();
        
        s.beginTransaction();
        s.update(familia);
        s.getTransaction().commit();
   }
    
       public void BorrarFamilia(int ID){
        
        entidades.Familias  familia = new entidades.Familias();
        familia.setIdfamilias(ID);
     
        Session s= utilidades.HibernateUtil.getSessionFactory().getCurrentSession();
        
        s.beginTransaction();
        s.delete(familia);
        s.getTransaction().commit();
       
    }
    
    public List  ObtenerFamilias(){
      //  list <ArrayList>(Familias);
       Session s= utilidades.HibernateUtil.getSessionFactory().getCurrentSession();
       s.beginTransaction();
       Query query = s.createQuery("from Familias order by Codigo");
       List ListaFamilias = query.list();
       s.getTransaction().commit();
      
        return (ListaFamilias);
        
    }
    
  public List  ObtenerFamiliasID(String ID){
      //  list <ArrayList>(Familias);
       Session s= utilidades.HibernateUtil.getSessionFactory().getCurrentSession();
       s.beginTransaction();
             
        Query query = s.createQuery("from Familias Where Idfamilias=:ID");
        query.setParameter("ID", ID);
        List ListaFamilias = query.list();
    
        s.getTransaction().commit();
           
        return (ListaFamilias);
        
    }
   
   public Familias ObtenerIdFamiliaPorCodigo(String Codigo){
        Session s= utilidades.HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query query = s.createQuery("from Familias where Codigo = :Codigo ");
        query.setParameter("Codigo", Codigo);
                 
        Iterator iter = query.iterate();
        Familias familia;//=new Familias();
      
        while (iter.hasNext()){
           familia = (entidades.Familias) iter.next();  // fetch the object
           return familia; 
        }
        
        s.getTransaction().commit();
        return null;
      
        
    }

  
  
   /*
     **********************************************************************
     Funciones para trabajar con la tabla Articulos* 
     **********************************************************************
     */
    
    public void InsertarArticulos(String Codigo,String Descripcion,double Precio,Integer IdFamilia){
        
        entidades.Articulos  Articulos = new entidades.Articulos();
       
        entidades.Contadores Contador=  ObtenerContador("Articulos");
  
          if (Contador.getValor()==0){
              InsertarContador("Articulos",1);
          }
          else{ 
              ActualizarContador(Contador.getIdcontadores(),"Articulos",Contador.getValor()+1);
          }    
     
        Articulos.setIdarticulos(Contador.getValor()+1);
        Articulos.setCodigo(Codigo);
        Articulos.setDescripcion(Descripcion);
        Articulos.setPrecio(Precio);
        Articulos.setIdfamilias(IdFamilia);
        Articulos.setUsuarioMod("moises");
       
        Session s= utilidades.HibernateUtil.getSessionFactory().getCurrentSession();
        
        s.beginTransaction();
        s.save(Articulos);
        s.getTransaction().commit();
       
    }
         
     public void ActualizarArticulos(int ID,String Codigo,String Descripcion,double Precio,Integer IdFamilia){
        
        entidades.Articulos  Articulos = new entidades.Articulos();
        Articulos.setIdarticulos(ID);
        Articulos.setCodigo(Codigo);
        Articulos.setDescripcion(Descripcion);
        Articulos.setPrecio(Precio);
        Articulos.setIdfamilias(IdFamilia);
        Articulos.setUsuarioMod("moises");
       
        Session s= utilidades.HibernateUtil.getSessionFactory().getCurrentSession();
        
        s.beginTransaction();
        s.update(Articulos);
        s.getTransaction().commit();
   }
    
     
       public void BorrarArticulos(int ID){
        
        entidades.Articulos  Articulos = new entidades.Articulos();
        Articulos.setIdarticulos(ID);
     
        Session s= utilidades.HibernateUtil.getSessionFactory().getCurrentSession();
        
        s.beginTransaction();
        s.delete(Articulos);
        s.getTransaction().commit();
       
    }
       
  public int  BorrarArticulosFamilia(int ID){
      
       Session s= utilidades.HibernateUtil.getSessionFactory().getCurrentSession();
       s.beginTransaction();
     
       Query query = s.createQuery("delete Articulos Where IDfamilias=:IDFamilia");
       query.setParameter("IDFamilia", ID);
       int result = query.executeUpdate();
     
        s.getTransaction().commit();
        return (result);   
    }
               
    public List  ObtenerArticulos(){
      //  list <ArrayList>(Familias);
       Session s= utilidades.HibernateUtil.getSessionFactory().getCurrentSession();
       s.beginTransaction();
       Query query = s.createQuery("from Articulos");
       List ListaArticulos = query.list();
       s.getTransaction().commit();
      
        return (ListaArticulos);
        
    }
    
   public List  ObtenerArticulosFamilia(String ID){
      //  list <ArrayList>(Familias);
       Session s= utilidades.HibernateUtil.getSessionFactory().getCurrentSession();
       s.beginTransaction();
       Query query = s.createQuery("from Articulos Where IDfamilias=:IDFamilia");
       query.setParameter("IDFamilia", ID);
       List ListaArticulos = query.list();
       s.getTransaction().commit();
        return (ListaArticulos);   
    }
   
  public List  ObtenerArticulosID(String ID){
      //  list <ArrayList>(Familias);
       Session s= utilidades.HibernateUtil.getSessionFactory().getCurrentSession();
       s.beginTransaction();
             
        Query query = s.createQuery("from Articulos Where Idarticulos=:ID");
        query.setParameter("ID", ID);
        List ListaArticulos = query.list();
    
        s.getTransaction().commit();
           
        return (ListaArticulos);
        
    }
   
  
  
       
       
     /*
     **********************************************************************
     Funciones para trabajar con la tabla Contador* 
     **********************************************************************
     */
     public void ActualizarContador(int ID,String Tabla,int Valor ){
        
        entidades.Contadores  Contador = new entidades.Contadores();
        
        Contador.setIdcontadores(ID);
        Contador.setTabla(Tabla);
        Contador.setValor(Valor);
               
        Session s= utilidades.HibernateUtil.getSessionFactory().getCurrentSession();
        
        s.beginTransaction();
        s.update(Contador);
        s.getTransaction().commit();
   }
    
    
     public void InsertarContador(String Tabla,int Valor){
        
        entidades.Contadores  contador = new entidades.Contadores();
       
        contador.setTabla(Tabla);
        contador.setValor(Valor);
             
        Session s= utilidades.HibernateUtil.getSessionFactory().getCurrentSession();
        
        s.beginTransaction();
        s.save(contador);
        s.getTransaction().commit();
       
    }
    
     public void BorrarContador(int ID){
        
        entidades.Contadores  contador = new entidades.Contadores();
       
        contador.setIdcontadores(ID);
      
             
        Session s= utilidades.HibernateUtil.getSessionFactory().getCurrentSession();
        
        s.beginTransaction();
        s.delete(contador);
        s.getTransaction().commit();
       
    }
    public Contadores ObtenerContador(String Tabla){
        Session s= utilidades.HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query query = s.createQuery("from Contadores where Tabla = :tabla ");
        query.setParameter("tabla", Tabla);
        int  Valor=0;
        int ID=0;
          
        Iterator iter = query.iterate();
        Contadores contador1=new Contadores();
       // int Valor=0 ;
        while (iter.hasNext()){
           contador1 = (entidades.Contadores) iter.next();  // fetch the object
         Valor=contador1.getValor();
         ID=contador1.getIdcontadores();
        }
        Contadores contador2=new Contadores();
      
        contador2.setIdcontadores(ID);
        contador2.setValor(Valor);
      
        s.getTransaction().commit();
      // System.out.println( contador1.getValor());  
        return (contador2);
    
    }
            
    
    
}
