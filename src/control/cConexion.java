/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Ortiz
 */
public class cConexion {
    public Connection Conectar(){
    Connection cn=null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String conectionURL="jdbc:sqlserver://localhost:1433;databaseName=SISINV1;user=kev;password=123";
            cn=DriverManager.getConnection(conectionURL);
            return cn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
            return cn;
        }
    }
    //
    public Connection Desconectar(){
        Connection cn=null;
        cn=null;
            if(cn!=null){
                JOptionPane.showMessageDialog(null,"no se pudo desconectarse de la base de datos ");
            }
        return cn;
    }
}
