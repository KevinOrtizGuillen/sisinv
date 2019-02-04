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
import modelo.mUsuario;

/**
 *
 * @author Ortiz
 */
public class cUsuario {
 cConexion con=new cConexion();
    Connection cn;
    public int totaldeResgistros=0;
    String sql="";
 public DefaultTableModel login(mUsuario dato){
    DefaultTableModel modelo;    
    String[] titulos={"id_usuar","dni_usuar","nombre_usuar","apell_pater_usuar","apell_mater_usuar","email_usuar","telef_usuar","tipo_usuar","desc_usuar","estad_usuar","usua_usuar","id_tiend"};
    String[] registro=new String[12];
    modelo=new DefaultTableModel(null,titulos);
      try {
          sql="execute LOGUEAR_USUARIO ?,?";
          cn=con.Conectar();
          PreparedStatement pst=cn.prepareStatement(sql);
          pst.setString(1,dato.getUsua_usuar());
          pst.setString(2,dato.getPin_usuar());
          ResultSet rs=pst.executeQuery();          
          while(rs.next()){ 
            registro[0]=rs.getString("id_usuar");
            registro[1]=rs.getString("dni_usuar");
            registro[2]=rs.getString("nombr_usuar");
            registro[3]=rs.getString("apell_pater_usuar");
            registro[4]=rs.getString("apell_mater_usuar");
            registro[5]=rs.getString("email_usuar");
            registro[6]=rs.getString("telef_usuar");
            registro[7]=rs.getString("tipo_usuar");
            registro[8]=rs.getString("desc_usuar");
            registro[9]=rs.getString("estad_usuar");
            registro[10]=rs.getString("usua_usuar");
            registro[11]=rs.getString("id_tiend");
            totaldeResgistros++;
            modelo.addRow(registro);
          }
          cn=con.Desconectar();          
      } catch (Exception e) {
          JOptionPane.showMessageDialog(null, e);
      }  
  return modelo;
  }
}
