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
import model.bean.Carro;
import model.bean.Vaga;
import model.connection.ConnectionFactory;

/**
 *
 * @author RobertOliveira
 */
public class VagaDao {
    
    //Vaga vaga=new Vaga();
    
    Connection con= ConnectionFactory.getConnection();
    Statement stm;
    PreparedStatement pstm;
    ResultSet rs;
    String sql;
    List<Vaga> lista= new ArrayList<>();
    
    public List<Vaga> listarVaga(){
        try{
            sql="select vagcod,vagqtde from vaga";
            pstm=con.prepareStatement(sql);
            rs=pstm.executeQuery(sql);
            while(rs.next()){
                Vaga vaga=new Vaga();
                vaga.setVagcod(rs.getInt(1));
                vaga.setVagqtde(rs.getInt(2));
                lista.add(vaga);
            }
        }catch(Exception erro){
            
        }
        return lista;
    }
    
    
}
