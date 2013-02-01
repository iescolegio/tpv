/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tpv;


import formularios.MenuTpv;
import formularios.frmFamilias;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
//import java.util.Iterator;
//import java.util.List;
//import org.hibernate.Query;
//import org.hibernate.Session;

/**
 *
 * @author mgacosta
 */
public class Tpv {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try
	{
	    JFrame.setDefaultLookAndFeelDecorated(true);
	    JDialog.setDefaultLookAndFeelDecorated(true);
            //UIManager.setLookAndFeel("com.apple.laf.AquaLookAndFeel");
           // UIManager.setLookAndFeel("com.sun.java.swing.plaf.mac.MacLookAndFeel");
	    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
	}
	catch (Exception e)
	{
	    e.printStackTrace();
	}
        
        
    
    
    MenuTpv f= new MenuTpv();
    f.setVisible(true);
    /*Esto es nuevo*/
    
    
    
//    entidades.Contadores Contador=  Operaciones.ObtenerContador("Familias");
//     int ID =Contador.getIdcontadores();
//     Integer Valor =Contador.getValor();
//      
//      if (Contador.getIdcontadores()==0){
//          Operaciones.InsertarContador("Familias",1);
//      }
//      else{ 
//          Operaciones.ActualizarContador(Contador.getIdcontadores(),"Familias",Contador.getValor()+1);
//      }    
//    
    
    
    
    // Operaciones.BorrarFamilia(2);
   // Operaciones.InsertarFamilia(3, "asasdfdfsd", "aasdsdfasd");
    
    
    
    
//      entidades.Contadores  contador = new entidades.Contadores();
//       contador.setIdcontadores(3);
//       contador.setTabla("prueba8888");
//       contador.setValor(2);
//            
//       Session s= utilidades.HibernateUtil.getSessionFactory().getCurrentSession();
//             s.beginTransaction();
//             
//Query query = s.createQuery("from Contadores where Tabla = :tabla ");
//query.setParameter("tabla", "prueba8888");
//
//Iterator iter = query.iterate();
//
//while (iter.hasNext()){
//   entidades.Contadores contador1 = (entidades.Contadores) iter.next();  // fetch the object
//   System.out.println(contador1.getTabla());
//}
// 
 //Entidades.Alumnos alumnos = (Entidades.Alumnos) iter.next();
   //System.out.println(alumnos.getNombre());
 
   //  Contadores  contador = new Contadores();
  

     // Contadores.

//Query query = s.createQuery("from Stock where stockCode = :code ");
//query.setParameter("code", "7277");
//List Contadores = query.list();
//
//
//Query query = s.createQuery("from Stock where stockCode = '7277' ");
//List Contadores = query.list();
       
      // System.out.println( Operaciones.ObtenerContador("prueba8888"));
       
       
     //  System.out.println( Operaciones.ObtenerContador("prueba8888"));
       
       
       
     //  s.beginTransaction();
       // s.save(contador);
        
      // s.update(contador);
      // s.getTransaction().commit();
        
   
    
    }
    
}

