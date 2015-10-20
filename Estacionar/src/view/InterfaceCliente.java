/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.bean.Cliente;
import model.dao.ClienteDao;

/**
 *
 * @author RobertOliveira
 */
public class InterfaceCliente implements ActionListener {
  
    ClienteDao clienteDao=new ClienteDao();
    Cliente cliente=new Cliente();
    
    
    
    JFrame tela = new JFrame();//componente principal para criacao da tela
    JPanel painel = new JPanel();//campos de delimitacao da tela
    JButton botaosalvar = new JButton("Salvar");
    JButton botaolimpar = new JButton("Limpar");
    JButton botaosair = new JButton("Sair");
    
    JLabel labelnome= new JLabel("NOME: ");
    JTextField txtnome= new JTextField();
    JLabel labelcpf= new JLabel("CPF: ");
    JTextField txtcpf= new JTextField();
    JLabel labeltelefone = new JLabel("TELEFONE: ");
    JTextField txttelefone= new JTextField();
 
    JTextField txtsalvar= new JTextField();
    JTextField txtlimpar= new JTextField();
    JTextField txtsair= new JTextField();
    
    public void criarTela() {
        
        // configuraçao da Frame(Tela)
                       //(horizontal,vertical,largura,altura)
        tela.setBounds(250, 200, 500, 800);
        tela.setVisible(true);
        tela.setTitle("Cadastro Cliente");
        tela.add(painel);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//finaliza o processo do frame
        tela.setResizable(true);//desativar o maximizar
        
        painel.setLayout(null);
        painel.setBackground(Color.LIGHT_GRAY);
        
        painel.setBounds(0,0,500,800);
        
        //configuracao do painel
        painel.setLayout(null);
        painel.add(labelnome);
        painel.add(txtnome);
        painel.add(labelcpf);
        painel.add(txtcpf);
        painel.add(labeltelefone);
        painel.add(txttelefone);
        
        painel.add(botaosalvar);
        painel.add(botaolimpar);
        painel.add(botaosair);
  
        
        
        
        labelnome.setBounds(30, 30,100, 30);//X=vai para direita e y=descer
        txtnome.setBounds(30,60, 440, 30);
        
        labelcpf.setBounds(30, 90,100, 30);
        txtcpf.setBounds(30,120, 440, 30);
        
        labeltelefone.setBounds(30, 150,100, 30);
        txttelefone.setBounds(30,180, 440, 30);   
        
        //criando botoes
        botaosalvar.setBounds(30, 410, 100, 30); 
        botaolimpar.setBounds(140, 410, 100, 30);
        botaosair.setBounds(250, 410, 100, 30);
        
        botaosalvar.addActionListener(this);
        
        }
        
    

       public static void main(String[]Args){
        InterfaceCliente tela= new InterfaceCliente();
        tela.criarTela();
        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource().equals(botaosalvar)){
           cliente.setClinome(txtnome.getText());
           cliente.setClicpf(txtcpf.getText());
           cliente.setClitelefone(txttelefone.getText());
           clienteDao.salvarCliente(cliente);

            
        }
        
    }
            
    
    
    
}
