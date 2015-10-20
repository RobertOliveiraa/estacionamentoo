/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.connection;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author RobertOliveira
 */
public class ConnectionFactory {
    
    public static Connection getConnection() {
        Connection con=null;
        ResultSet rs;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url="jdbc:mysql://localhost:8889/parking";
            String usuario="root";
            String senha="root";
            con=DriverManager.getConnection(url,usuario,senha);
            JOptionPane.showMessageDialog(null, "Conectado");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException | HeadlessException erro) {
            JOptionPane.showMessageDialog(null, "ERRO DE JDBC"+erro.getMessage());
        }
        return con;
    }
    
}
