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
import model.bean.Carro;
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
    
    List<Reserva> lista=new ArrayList<>();
    Reserva reser=new Reserva();
    
    public double calcularTotal(double totalest, double pagamento){
        double total=0;
        total=pagamento-totalest;
        return total;
    }
    
    
    public void salvarReserva(Reserva reserva){
        try{
            sql="insert into reserva (rescarcod,resvagcod,resdthrent,resestatus) values(?,?,?,?)";
            pstm=con.prepareStatement(sql);
            pstm.setObject(1, reserva.getCarro().getCarcod());
            pstm.setObject(2, reserva.getVaga().getVagcod());
            pstm.setString(3, reserva.getResdthrent());
            pstm.setString(4, reserva.getResestatus());
            
            pstm.execute();
            
            
            JOptionPane.showMessageDialog(null, "Dados salvos Com Sucesso");
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Dados nao Salvo\n"+erro.getMessage());
        }
    }
    
    public void UpdateReserva(Reserva reserva){
        try{
            sql="update reserva set resvalor=?,resdthrsai=?,resdthrdur=?,respagamento=?,restroco=?,resestatus=? where rescod=?";
            pstm=con.prepareStatement(sql);
            pstm.setDouble(1, reserva.getResvalor());
            pstm.setString(2, reserva.getResdthrsai());
            pstm.setString(3, reserva.getResdthrdur());
            pstm.setDouble(4, reserva.getRespagamento());
            pstm.setDouble(5, reserva.getRestroco());
            pstm.setString(6, reserva.getResestatus());
            pstm.setInt(7, reserva.getRescod());
            
            
            pstm.execute();
            
            
            JOptionPane.showMessageDialog(null, "Dados salvos Com Sucesso");
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Dados nao Salvo\n"+erro.getMessage());
        }
    }
    public List<Reserva> listarReserva(){
                
        
        try{
            
//            sql="select * from automovel where autcod=?";
//            pstm=con.prepareStatement(sql);
//            pstm.setInt(1, cod);
//            rs=pstm.executeQuery();
//            if(rs.next()){
//                reser.setRescod(rs.getInt("rescod"));
//                reser.setResdthrent(rs.getString("resdthrent"));
//                reser.setResdthrsai(rs.getString("resdthrsai"));
//                reser.setResdthrdur(rs.getString("resdthrdur"));
//                reser.setResvalor(rs.getDouble("resvalor"));
//                reser.setRespagamento(rs.getDouble("respagamento"));
//                reser.setRestroco(rs.getDouble("restroco"));
                
                //lista.add(reser);
                
            //}
            
            stm=con.createStatement();
            sql="select rescod,resdthrent,resestatus from reserva";
            rs=stm.executeQuery(sql);
            
            while(rs.next()){
                
                Reserva reser=new Reserva();
                //Carro car=new Carro();
                reser.setRescod(rs.getInt(1));
                reser.setResdthrent(rs.getString(2));
                reser.setResestatus(rs.getString(3));
                //car.setCarcod(rs.getInt(2));
                //car.setCarpla(rs.getString(3));
                //reser.setCarro(car);
                
                
                
                lista.add(reser);
                
                
            }
            
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, erro);
        }
        
        return lista;
    }
    
}
