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
import javax.swing.JOptionPane;
import model.bean.Reserva;
import model.connection.ConnectionFactory;

/**
 *
 * @author RobertOliveira
 */
public class ReservaDao {
    
    Connection con=ConnectionFactory.getConnection();
    Statement stm;
    PreparedStatement pstm;
    ResultSet rs;
    String sql;
    
    public void salvarReserva(Reserva reserva){
        try{
            sql="insert into reserva (rescarcod,resvagcod,resvalor,resdthrent,resdthrsai,resdthrdur,respagamento,restroco,resestatus) values(?,?,?,?,?,?,?,?,?)";
            pstm=con.prepareStatement(sql);
            pstm.setObject(1, reserva.getCarro());
            pstm.setObject(2, reserva.getCliente());
            pstm.setDouble(3, reserva.getResvalor());
            pstm.setString(4, reserva.getResdthrent());
            pstm.setString(5, reserva.getResdthrsai());
            pstm.setString(6, reserva.getResdthrdur());
            pstm.setDouble(7, reserva.getRespagamento());
            pstm.setDouble(8, reserva.getRestroco());
            pstm.setString(9, reserva.getResestatus());
            
            pstm.execute();
            
            
            JOptionPane.showMessageDialog(null, "Dados salvos Com Sucesso");
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Dados nao Salvo\n"+erro.getMessage());
        }
    }
    
}
