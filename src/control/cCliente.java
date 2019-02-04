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
import modelo.mCliente;


/**
 *
 * @author Ortiz
 */
public class cCliente {
    cConexion con=new cConexion();
    Connection cn;
    public int totaldeResgistros=0;
    String sql="";
    String res="";
    //
    public DefaultTableModel buscaCliente(mCliente dato){
    DefaultTableModel modelo;    
    String[] titulos={"id_clien","dni_clien","nombr_clien","apell_pater_clien","apell_mater_clien","email_clien","telef_clien","fecha_clien"};
    String[] registro=new String[titulos.length];
    modelo=new DefaultTableModel(null,titulos);
      try {
          sql="execute BUSCAR_CLIENTE ?,?";//DNI,NOMBRE
          cn=con.Conectar();
          PreparedStatement pst=cn.prepareStatement(sql);
          pst.setString(1,dato.getDni_clien());
          pst.setString(2, dato.getNombr_clien());
          ResultSet rs=pst.executeQuery(); 
          while(rs.next()){ 
            registro[0]=rs.getString("id_clien");
            registro[1]=rs.getString("dni_clien");
            registro[2]=rs.getString("nombr_clien");
            registro[3]=rs.getString("apell_pater_clien");
            registro[4]=rs.getString("apell_mater_clien");
            registro[5]=rs.getString("email_clien");
            registro[6]=rs.getString("telef_clien");            
            registro[7]=rs.getString("fecha_nacim");
            totaldeResgistros++;
            modelo.addRow(registro);
          }
          cn=con.Desconectar();        
                
      } catch (Exception e) {
         JOptionPane.showMessageDialog(null, e);
      }  
  return modelo;
  }
 public String NuevoCliente(mCliente dato){
      try {
          sql="execute NUEVO_CLIENTE ?,?,?,?,?,?,?";//DNI,NOMBRE
          cn=con.Conectar();
          PreparedStatement pst=cn.prepareStatement(sql);
          pst.setString(1,dato.getDni_clien());
          pst.setString(2, dato.getNombr_clien());
          pst.setString(3,dato.getApell_pater_clien());
          pst.setString(4,dato.getApell_mater_clien());
          pst.setString(5, dato.getEmail_clien());
          pst.setString(6, dato.getTelef_clien());
          pst.setString(7, dato.getFecha_nacim());          
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
 public String EditarCliente(mCliente dato){
    try{
     sql="execute EDITAR_CLIENTE ?,?,?,?,?,?,?,?";//DNI,NOMBRE
          cn=con.Conectar();
          PreparedStatement pst=cn.prepareStatement(sql);
          pst.setInt(1,dato.getId_client());
          pst.setString(2,dato.getDni_clien());
          pst.setString(3, dato.getNombr_clien());
          pst.setString(4,dato.getApell_pater_clien());
          pst.setString(5,dato.getApell_mater_clien());
          pst.setString(6, dato.getEmail_clien());
          pst.setString(7, dato.getTelef_clien());
          pst.setString(8, dato.getFecha_nacim());          
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
 public String eliminarCliente(mCliente dato){
     try {
         sql="execute ELIMINAR_CLIENTE ?";//DNI,NOMBRE
          cn=con.Conectar();
          PreparedStatement pst=cn.prepareStatement(sql);
          pst.setInt(1,dato.getId_client());                   
          ResultSet rs=pst.executeQuery(); 
          while(rs.next()){ 
            res=rs.getString(1);
          }
          cn=con.Desconectar();      
     } catch (Exception e) {
     }
     return res;
 }
}