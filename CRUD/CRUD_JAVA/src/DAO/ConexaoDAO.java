
package DAO;

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLException;       

public class ConexaoDAO {
    
    public Connection conectaBD(){
        Connection conexao = null;
        
        try {
            String url = "jdbc:mysql://localhost:3306//bancoteste?user=root&password=123";
            conexao = DriverManager.getConnection(url); 
            
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "conexaoDAO" + error.getMessage());
        }
        return conexao;
    }
}
