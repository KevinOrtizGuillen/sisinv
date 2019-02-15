/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.mMarca;

/**
 *
 * @author Ortiz
 */
public class cMarca {
    cConexion con=new cConexion();
    Connection cn;
    public int totaldeResgistros=0;
    String sql="";
    String res="";
    public DefaultTableModel buscarMarca(mMarca dato){
       DefaultTableModel modelo;
       String titulos[]={"id_marc","nombr_marc","detal_marc"};
       String registro[]=new String[titulos.length];
       modelo=new DefaultTableModel(null,titulos);
       try {
          sql="execute BUSCAR_MARCA ?";//DNI,NOMBRE
          cn=con.Conectar();
          PreparedStatement pst=cn.prepareStatement(sql);
          pst.setString(1,dato.getNombr_marca());          
          ResultSet rs=pst.executeQuery(); 
          while(rs.next()){ 
            registro[0]=rs.getString("id_marca");
            registro[1]=rs.getString("nombr_marca");
            registro[2]=rs.getString("detal_marca");            
            totaldeResgistros++;
            modelo.addRow(registro);
          }
          cn=con.Desconectar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
       return modelo;
    }
    public String NuevoMarca(mMarca dato){
      try {
          sql="execute NUEVA_MARCA ?,?";
          cn=con.Conectar();
          PreparedStatement pst=cn.prepareStatement(sql);
          pst.setString(1,dato.getNombr_marca());
          pst.setString(2, dato.getDetal_marca());          
          ResultSet rs=pst.executeQuery(); 
          while(rs.next()){ 
            res=rs.getString(1);
          }
          cn=con.Desconectar();                        
      } catch (Exception e) {
         JOptionPane.showMessageDialog(null, e);
      }  
  return res;
  }
public String EditarMarca(mMarca dato){
    try{
     sql="execute EDITAR_MARCA ?,?,?";//DNI,NOMBRE
          cn=con.Conectar();
          PreparedStatement pst=cn.prepareStatement(sql);
          pst.setInt(1,dato.getId_marca());
          pst.setString(2,dato.getNombr_marca());
          pst.setString(3, dato.getDetal_marca());          
          ResultSet rs=pst.executeQuery(); 
          while(rs.next()){ 
            res=rs.getString(1);
          }
          cn=con.Desconectar();        
    }catch(Exception e){
       JOptionPane.showMessageDialog(null, e);
    }
    return res;
}
 public String eliminarMarca(mMarca dato){
     try {
         sql="execute ELIMINAR_MARCA ?";
          cn=con.Conectar();
          PreparedStatement pst=cn.prepareStatement(sql);
          pst.setInt(1,dato.getId_marca());                   
          ResultSet rs=pst.executeQuery(); 
          while(rs.next()){ 
            res=rs.getString(1);
          }
          cn=con.Desconectar();      
     } catch (Exception e) {
         JOptionPane.showMessageDialog(null, e);
     }
     return res;
 }
}
