/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import javax.swing.JComboBox;
import model.bean.Reserva;
import model.bean.Cliente;

/**
 *
 * @author RobertOliveira
 */
public class Servicos {
    Reserva reser=new Reserva();
    
//    public void preencherComboCliente(JComboBox comboCliente){
//        
//        ClienteDao clidao=new ClienteDao();
//        List<Cliente> listagem= clidao.listarClientes();
//        
//        for(Cliente c: listagem){
//            
//            comboCliente.addItem(c);
//            
//        }
//        
//        
//    }
    
//    public void preencherComboReserva(JComboBox comboReserva){
//         
//        
//        
//        ReservaDao autodao=new ReservaDao();
//        List<Reserva> listagem=autodao.listarReserva();
//        
//        for(Reserva a: listagem){
//            comboReserva.addItem(a);
//            
//        }
//        }
    public void preencherComboReserva(JComboBox comboReserva){
         
        
        
        ReservaDao reserdao=new ReservaDao();
        List<Reserva> listagem=reserdao.listarReserva();
        
        for(Reserva r: listagem){
            comboReserva.addItem(r);
            
        }
        }
    
}
