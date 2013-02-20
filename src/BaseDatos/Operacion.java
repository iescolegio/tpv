/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import entidades.Contadores;
import java.util.Iterator;
import java.util.List;
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
