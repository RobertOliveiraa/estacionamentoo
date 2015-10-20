/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import model.bean.Carro;
import model.bean.Reserva;
import model.bean.Vaga;
import model.dao.ReservaDao;

/**
 *
 * @author RobertOliveira
 */
public class InterfaceReserva implements ActionListener{
    
    Reserva reserva=new Reserva();
    ReservaDao reservadao=new ReservaDao();
    Carro carro=new Carro();
    Vaga vaga=new Vaga();
    String tes;
    String tes2;
    
    JFrame tela = new JFrame();//componente principal para criacao da tela
    JPanel painel = new JPanel();//campos de delimitacao da tela
    JButton botaosalvar = new JButton("Salvar");
    JButton botaolimpar = new JButton("Limpar");
    JButton botaosair = new JButton("Sair");
    JButton botaoentrada = new JButton("Entrada");
    //JButton botaosaida = new JButton("Saida");
    //JButton botaocalculo = new JButton("Calcular");
    
    JComboBox<Carro> jccarro = new JComboBox<>();
    JComboBox<Vaga> jcvaga = new JComboBox<>();
    
    JLabel labelcarro= new JLabel("CARRO: ");
    //JTextField txtchassi= new JTextField();
    JLabel labelvaga = new JLabel("VAGA: ");
    //JTextField txtplaca= new JTextField();
    //JLabel labelvalor= new JLabel("TOTAL: ");
    //JTextField txtvalor= new JTextField();
    JLabel labelhrentrada = new JLabel("ENTRADA HR: ");
    JTextField txthrentrada= new JTextField();
    //JLabel labelhrsaida = new JLabel("SAIDA HR: ");
    //JTextField txthrsaida= new JTextField();
    //JLabel labelhrduracao = new JLabel("DURACAO HR: ");
    //JTextField txthrduracao= new JTextField();
    //JLabel labelpagamento = new JLabel("TOTAL A PAGAR: ");
    //JTextField txtpagamento= new JTextField();
    //JLabel labeltroco = new JLabel("TROCO: ");
    //JTextField txttroco= new JTextField();
    JLabel labelstatus = new JLabel("STATUS: ");
    JTextField txtstatus= new JTextField();
    
    
 
    
    //TextArea areaObs= new TextArea("",1,1, TextArea.SCROLLBARS_VERTICAL_ONLY);
    //JScrollPane scrolObs= new JScrollPane(areaObs);
    
    public void criarTela(){
    
        tela.setBounds(250, 200, 500, 650);
        tela.setVisible(true);
        tela.setTitle("RESERVA ENTRADA");
        tela.add(painel);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//finaliza o processo do frame
        tela.setResizable(true);//desativar o maximizar
        
        painel.setLayout(null);
        painel.setBackground(Color.LIGHT_GRAY);
        
        painel.setBounds(0,0,500,800);
        
        //configuracao do painel
        painel.setLayout(null);
        painel.add(labelcarro);
        //painel.add(txtchassi);
        painel.add(labelvaga);
        //painel.add(txtplaca);
        //painel.add(labelvalor);
        //painel.add(txtvalor);
        painel.add(labelhrentrada);
        painel.add(txthrentrada);
//        painel.add(labelhrsaida);
//        painel.add(txthrsaida);
//        painel.add(labelhrduracao);
//        painel.add(txthrduracao);
//        painel.add(labelpagamento);
//        painel.add(txtpagamento);
//        painel.add(labeltroco);
//        painel.add(txttroco);
        painel.add(labelstatus);
        painel.add(txtstatus);
        painel.add(jccarro);
        painel.add(jcvaga);
        
        painel.add(botaosalvar);
        painel.add(botaolimpar);
        painel.add(botaosair);
        painel.add(botaoentrada);
        //painel.add(botaosaida);
        //painel.add(botaocalculo);
        
        //painel.add(scrolObs);
        //painel.add(labelareaObs);
        
        
        
        labelcarro.setBounds(30, 30,100, 30);//X=vai para direita e y=descer
        jccarro.setBounds(30,60, 440, 30);
        
        labelvaga.setBounds(30, 90,100, 30);
        jcvaga.setBounds(30,120, 440, 30);
        
        //labelvalor.setBounds(30, 150,100, 30);
        //txtvalor.setBounds(30,180, 440, 30);
        
        labelhrentrada.setBounds(30, 170,100, 30);
        txthrentrada.setBounds(30,200, 340, 30);
        
//        labelhrsaida.setBounds(30, 270,100, 30);
//        txthrsaida.setBounds(30,300, 340, 30);
//        
//        labelhrduracao.setBounds(30, 330,100, 30);
//        txthrduracao.setBounds(30,360, 440, 30);
//        
//        labelpagamento.setBounds(30, 390,120, 30);
//        txtpagamento.setBounds(30,410, 340, 30);
//        
//        labeltroco.setBounds(30, 440,100, 30);
//        txttroco.setBounds(30,470, 440, 30);
        
        labelstatus.setBounds(30, 230,100, 30);
        txtstatus.setBounds(30,260, 440, 30);
        
        //criando obersavacao
        
        
        //scrolObs.setBounds(30, 330, 280,100);
        //labelareaObs.setBounds(30, 300, 100, 30);
        
        
        //criando botoes
        botaosalvar.setBounds(30, 310, 100, 30); 
        botaolimpar.setBounds(140, 310, 100, 30);
        botaosair.setBounds(250, 310, 100, 30);
        botaoentrada.setBounds(370, 200, 100, 30);
//        botaosaida.setBounds(370, 300, 100, 30);
//        botaocalculo.setBounds(370, 410, 100, 30);
        
        botaosalvar.addActionListener(this);
        botaoentrada.addActionListener(this);
        //botaosaida.addActionListener(this);
        
    }
    
    public void iniciarcronometro(){
        Timer timer = null;
        
        final SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy HH:mm:ss");
        final SimpleDateFormat formathr = new SimpleDateFormat("HH:mm");
        
        txthrentrada.setText(format.format(new Date().getTime()));
        
        tes=(formathr.format(new Date().getTime()));
        
        //System.out.println(tes);
        
    }
    
//    public void iniciarcronometro2(){
//        Timer timer = null;
//        
//        final SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy HH:mm:ss");
//        final SimpleDateFormat formathr = new SimpleDateFormat("HH:mm");
//        
//        txthrsaida.setText(format.format(new Date().getTime()));
//        
//        //reserva.setResdthrsai(format.format(new Date().getTime()));
//        
//        tes2=formathr.format(new Date().getTime());
//        
//        //System.out.println(tes2);
//        
////        
//    }
//    public void iniciarcronometro3() throws ParseException{
//        Timer timer = null;
//        
//        final SimpleDateFormat format = new SimpleDateFormat("HH:mm");
//        
//        //tes3=format.format(new Date().getTime());
//        
//        //System.out.println(tes3);
//        Date ent=null;
//        Date sai=null;
//        
//        final SimpleDateFormat dfEntrada = new SimpleDateFormat("HH:mm");    
//        ent = dfEntrada.parse(tes);  
//          
//        final SimpleDateFormat dfSaida = new SimpleDateFormat("HH:mm");    
//        sai = dfSaida.parse(tes2);
//        
//        long min = sai.getTime() - ent.getTime(); 
//        
//        long min2=(long) (min*0.067);
//          
//        float resultado = (int) ((min / 1000)/60);
//        float resutl = (int) ((min2/1000)/60);
//        
//        //resultado=String.valueOf(format.format(new Date().getTime()));
//        
//        
//        txthrduracao.setText(String.valueOf(resultado));
//        txtvalor.setText(String.valueOf(resutl));
//        
//        //reserva.setResdthrdur(String.valueOf(resultado));
//          
//        //System.out.println("Diferença: " + resultado + " minuto(s)");
//        //System.out.println("Total: " + resutl + " real");
//        
//      
//    }
    
//    public boolean validarCmpos(){
//        if((txtchassi.getText().length()==0||(txtplaca.getText().length()==0||(txtvalor.getText().length()==0||(txthrentrada.getText().length()==0))))){
//            return true;
//            
//        }else{
//            
//            return false;
//                    
//                    
//        }
//        
//               
//    }
    
    public static void main(String[]Args){
        InterfaceReserva tela= new InterfaceReserva();
        tela.criarTela();
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource().equals(botaosalvar)){
            
//            automovel.setAutchassi(txtchassi.getText());
//            automovel.setAutplaca(txtplaca.getText());
//            automovel.setAutmarca(txtvalor.getText());
//            automovel.setAutmodelo(txthrentrada.getText());
//            automovel.setAutvldiaria(Double.parseDouble(txthrsaida.getText()));
//            automovelDao.salvarAutomovel(automovel);
            
            //JOptionPane.showMessageDialog(null,"Parabens voce conseguiu!!");
            
        }else if(evento.getSource().equals(botaoentrada)){
            //txthrentrada.setText(reserva.getResdthrent());
            iniciarcronometro();
        }
        
    }
    
}
