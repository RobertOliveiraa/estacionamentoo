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
public class InterfaceAlterarCliente implements ActionListener {
  
    ClienteDao clienteDao=new ClienteDao();
    Cliente cliente=new Cliente();
    
    
    
    JFrame tela = new JFrame();//componente principal para criacao da tela
    JPanel painel = new JPanel();//campos de delimitacao da tela
    JButton botaosalvar = new JButton("Alterar");
    JButton botaolimpar = new JButton("Limpar");
    JButton botaosair = new JButton("Sair");
    JButton botaobuscar = new JButton("Buscas");
    
    
    JLabel labelcodigo= new JLabel("CODIGO: ");
    JTextField txtcodigo= new JTextField();
    
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
        tela.setBounds(250, 200, 500, 400);
        tela.setVisible(true);
        tela.setTitle("ALTERAR CLIENTE");
        tela.add(painel);
        //tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//finaliza o processo do frame
        tela.setResizable(true);//desativar o maximizar
        
        painel.setLayout(null);
        painel.setBackground(Color.LIGHT_GRAY);
        
        painel.setBounds(0,0,500,800);
        
        //configuracao do painel
        painel.setLayout(null);
        painel.add(labelcodigo);
        painel.add(txtcodigo);
        painel.add(labelnome);
        painel.add(txtnome);
        painel.add(labelcpf);
        painel.add(txtcpf);
        painel.add(labeltelefone);
        painel.add(txttelefone);
        
        painel.add(botaosalvar);
        painel.add(botaolimpar);
        painel.add(botaosair);
        painel.add(botaobuscar);
  
        
        
        labelcodigo.setBounds(30, 30,100, 30);//X=vai para direita e y=descer
        txtcodigo.setBounds(30,60, 340, 30);
        
        labelnome.setBounds(30, 90,100, 30);//X=vai para direita e y=descer
        txtnome.setBounds(30,120, 440, 30);
        
        labelcpf.setBounds(30, 150,100, 30);
        txtcpf.setBounds(30,180, 440, 30);
        
        labeltelefone.setBounds(30, 210,100, 30);
        txttelefone.setBounds(30,240, 440, 30);   
        
        //criando botoes
        botaosalvar.setBounds(30, 290, 100, 30); 
        botaolimpar.setBounds(140, 290, 100, 30);
        botaosair.setBounds(250, 290, 100, 30);
        botaobuscar.setBounds(370, 60, 100, 30);
        
        botaosalvar.addActionListener(this);
        botaosair.addActionListener(this);
        botaobuscar.addActionListener(this);
        botaolimpar.addActionListener(this);
        
        
        }
    
    public void limparTela(){
        txtcodigo.setText("");
        txtnome.setText("");
        txtcpf.setText("");
        txttelefone.setText("");
        
    }
        
    

       public static void main(String[]Args){
        InterfaceAlterarCliente tela= new InterfaceAlterarCliente();
        tela.criarTela();
        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource().equals(botaosalvar)){
           cliente.setClicod(Integer.parseInt(txtcodigo.getText()));
            cliente.setClinome(txtnome.getText());
            cliente.setClicpf(txtcpf.getText());
            cliente.setClitelefone(txttelefone.getText());
            clienteDao.alterarCliente(cliente);
            limparTela();

            
        }else if(evento.getSource().equals(botaosair)){
            System.exit(0);
        }else if(evento.getSource().equals(botaobuscar)){
            
            cliente=clienteDao.buscarPorCod(Integer.parseInt(txtcodigo.getText()));
            txtnome.setText(cliente.getClinome());
            txtcpf.setText(cliente.getClicpf());
            txttelefone.setText(cliente.getClitelefone());
            
        }else if(evento.getSource().equals(botaolimpar)){
            
        }
        
    }
            
    
    
    
}
