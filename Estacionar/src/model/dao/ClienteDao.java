/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Cliente;
import model.connection.ConnectionFactory;

/**
 *
 * @author RobertOliveira
 */
public class ClienteDao {
    Connection con=ConnectionFactory.getConnection();
    Statement stm;
    ResultSet rs;
    String sql;
    List<Cliente> lista=new ArrayList<>();
    
       public void salvarCliente(Cliente cliente){
        try{
            stm=con.createStatement();
            sql="INSERT INTO CLIENTE VALUES"
                    + "(NULL,'"+cliente.getClinome()+"',"+cliente.getClicpf()+"'"+cliente.getClitelefone()+"')";
            stm.execute(sql);
            JOptionPane.showMessageDialog(null, "Cliente Cadastrado com Sucesso.");
    }catch(Exception erro){
        JOptionPane.showMessageDialog(null, "Erro de sql"+erro);
    }
    
}
       
       public List<Cliente> listarClientes(){
        try{
            
            stm=con.createStatement();
            sql="SELECT clicod,clinome from cliente order by clinome";
            rs=stm.executeQuery(sql);
            while(rs.next()){
                Cliente cli=new Cliente();
                cli.setClicod(rs.getInt(1));
                cli.setClinome(rs.getString(2));
                lista.add(cli);
                
            }
            
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, erro);
        }
        
        return lista;
    }
           
 
} 
