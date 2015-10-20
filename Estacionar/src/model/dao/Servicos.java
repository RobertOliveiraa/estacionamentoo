/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import javax.swing.JComboBox;
import model.bean.Carro;
import model.bean.Reserva;
import model.bean.Cliente;
import model.bean.Vaga;

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
    
    public void preencherComboCarro(JComboBox comboCarro){
         
        
        
        CarroDao carrodao=new CarroDao();
        List<Carro> listagem=carrodao.listarCliente();
        
        for(Carro c: listagem){
            comboCarro.addItem(c);
            
        }
        }
    public void preencherComboVaga(JComboBox comboVaga){
         
        
        
        VagaDao vagadao=new VagaDao();
        List<Vaga> listagem=vagadao.listarVaga();
        
        for(Vaga v: listagem){
            comboVaga.addItem(v);
            
        }
        }
    public void preencherComboReserva(JComboBox comboReserva){
         
        
        
        ReservaDao reserdao=new ReservaDao();
        List<Reserva> listagem=reserdao.listarReserva();
        
        for(Reserva r: listagem){
            comboReserva.addItem(r);
            
        }
        }
    
}
