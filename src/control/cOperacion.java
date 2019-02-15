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
import modelo.mOperacion;

/**
 *
 * @author Ortiz
 */
public class cOperacion {
    cConexion con=new cConexion();
    Connection cn;
    public int totaldeResgistros=0;
    String sql="";
    String res="";
    public DefaultTableModel buscarOperacion(mOperacion dato){
        DefaultTableModel modelo;
        String[] titulos={"id_oper","nombre_oper","desc_oper"};
        String[] registro=new String[titulos.length];
        modelo =new DefaultTableModel(null,titulos);
        try {
            sql="EXEC BUSCAR_OPERACION ?";
            cn=con.Conectar();
            PreparedStatement pst=cn.prepareStatement(sql);
            pst.setString(1,dato.getNombre());
            ResultSet rs=pst.executeQuery();
           while(rs.next()){
               registro[0]=rs.getString("id_oper");
               registro[1]=rs.getString("nombre_ope");
               registro[2]=rs.getString("desc_oper");
               totaldeResgistros++;
               modelo.addRow(registro);
           }
           cn=con.Desconectar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return modelo;        
    }
    public String CrearOperacion(mOperacion dato){ 
        try {
            sql="EXEC NUEVA_OPERACION ?,?";
            cn=con.Conectar();
            PreparedStatement pst=cn.prepareStatement(sql);
            pst.setString(1,dato.getNombre());
            pst.setString(2, dato.getDescripcion());
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
    public String EditarOperacion(mOperacion dato){
    try {
            sql="EXEC EDITAR_OPERACION ?,?,?";
            cn=con.Conectar();
            PreparedStatement pst=cn.prepareStatement(sql);
            pst.setInt(1,dato.getId());
            pst.setString(2,dato.getNombre());
            pst.setString(3, dato.getDescripcion());
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
    public String EliminarOperacion(mOperacion dato){
    try {
            sql="EXEC ELIMINAR_OPERACION ?";
            cn=con.Conectar();
            PreparedStatement pst=cn.prepareStatement(sql);
            pst.setInt(1,dato.getId());            
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
