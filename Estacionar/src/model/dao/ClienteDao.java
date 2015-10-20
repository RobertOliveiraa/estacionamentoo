/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
    PreparedStatement pstm;
    ResultSet rs;
    String sql;
    List<Cliente> lista=new ArrayList<>();
    Cliente cli=new Cliente();
    
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
       
       public Cliente buscarPorCod(int cod){
        
        try{
            
            sql="select * from cliente where clicod=?";
            pstm=con.prepareStatement(sql);
            pstm.setInt(1, cod);
            rs=pstm.executeQuery();
            if(rs.next()){
                cli.setClicod(rs.getInt("clicod"));
                cli.setClinome(rs.getString("clinome"));
                cli.setClicpf(rs.getString("clicpf"));
                cli.setClitelefone(rs.getString("clitel"));
                
            }
            
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Nao encontrado" + erro);
        }
        
        return cli;
        
    }
    
    public void alterarCliente(Cliente cli){
        
        try{
            
            sql="update cliente set clinome=?,clicpf=?,clitel=?  where clicod=?";
            pstm=con.prepareStatement(sql);
            pstm.setString(1, cli.getClinome());
            pstm.setString(2, cli.getClicpf());
            pstm.setString(3, cli.getClitelefone());
            pstm.setInt(4, cli.getClicod());
            
            pstm.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Alterado");
            
            
            
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Alterar"+erro.getMessage());
        }
    }
           
 
} 
