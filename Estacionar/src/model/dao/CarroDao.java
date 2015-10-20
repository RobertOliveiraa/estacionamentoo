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
import model.connection.ConnectionFactory;

/**
 *
 * @author RobertOliveira
 */
public class CarroDao {
    Connection con= ConnectionFactory.getConnection();
    Statement stm;
    PreparedStatement pstm;
    ResultSet rs;
    String sql;
    Carro carro=new Carro();
    List<Carro> lista= new ArrayList<>();

    public void salvarCarro(Carro carro){
        try{
            stm=con.createStatement();
            sql="INSERT INTO CARRO VALUES"
                    +"(NULL,'"
                    +carro.getCarplaca()+"','"
                    +carro.getCarmarca()+"','"
                    +carro.getCarmodelo()+"','"
                    +carro.getCarcor()+"')";
            stm.execute(sql);
            JOptionPane.showMessageDialog(null, "Dados Salvos");
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Erro de sql"+erro);
        }
    }

    public Carro buscarPorCod(int cod){
        try{
            sql="SELECT * FROM CARRO WHERE AUTCOD=?";
            pstm=con.prepareStatement(sql);
            pstm.setInt(1, cod);
            pstm.executeQuery(sql);
            if(rs.next()){
               carro.setCarcod(rs.getInt("carcod"));
               carro.setCarplaca(rs.getString("carplaca"));
               carro.setCarmarca(rs.getString("carmarca"));
               carro.setCarmodelo(rs.getString("carmodelo"));
               carro.setCarcor(rs.getString("carcor"));
               
            }
            
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Carro não Encontrado"+erro);
        }
        return carro;
    }
    
    public void alterarAuto(){
        try{
            sql="UPDATE CARRO SET CARPLACA=?,CARMARCA=?,CARMODELO=?,CARCOR=? WHERE CARCOD=?";
            pstm=con.prepareStatement(sql);
            pstm.setInt(1, carro.getCarcod());
            pstm.setString(2, carro.getCarplaca());
            pstm.setString(3, carro.getCarmarca());
            pstm.setString(3, carro.getCarmodelo());
            pstm.setString(3, carro.getCarcor());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Alteração Realizada");
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Erro de sql"+erro);
        }
    }
    
    public List<Carro> listarCliente(){
        try{
            sql="select carcod,carplaca from carro order by carplaca";
            pstm=con.prepareStatement(sql);
            rs=pstm.executeQuery(sql);
            while(rs.next()){
                Carro carro= new Carro();
                carro.setCarcod(rs.getInt(1));
                carro.setCarplaca(rs.getString(2));
                lista.add(carro);
            }
        }catch(Exception erro){
            
        }
        return lista;
    }

    public ArrayList<Carro> listar(){
        ArrayList<Carro> listas= new ArrayList<>();
        try{
            sql="select * from carro";
            pstm=con.prepareStatement(sql);
            rs=pstm.executeQuery();
            while(rs.next()){
                Carro car= new Carro();
                car.setCarcod(rs.getInt(1));
                car.setCarplaca(rs.getString(2));
                listas.add(car);
            }
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Erro de Rs "+erro);
        }
        return listas;
    }
    
    
}
