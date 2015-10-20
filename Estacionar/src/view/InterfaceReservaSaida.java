/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.bean.Carro;
import model.bean.Cliente;
import model.bean.Reserva;
import model.bean.Vaga;
import model.dao.ReservaDao;
import model.dao.Servicos;

/**
 *
 * @author RobertOliveira
 */
public class InterfaceReservaSaida implements ActionListener{
    Reserva reserva=new Reserva();
    ReservaDao reservadao=new ReservaDao();
    Carro carro=new Carro();
    Vaga vaga=new Vaga();
    Servicos serv=new Servicos();
    
    String tes;
    String tes2;
    
    JFrame tela = new JFrame();//componente principal para criacao da tela
    JPanel painel = new JPanel();//campos de delimitacao da tela
    JButton botaosalvar = new JButton("Salvar");
    JButton botaolimpar = new JButton("Limpar");
    JButton botaosair = new JButton("Sair");
    //JButton botaoentrada = new JButton("Entrada");
    JButton botaosaida = new JButton("Saida");
    JButton botaocalculo = new JButton("Calcular");
    
    JComboBox<Reserva> jcreserva = new JComboBox<>();
    //JComboBox<Vaga> jcvaga = new JComboBox<>();
    
    JLabel labelcarro= new JLabel("RESERVA: ");
    //JTextField txtchassi= new JTextField();
    //JLabel labelvaga = new JLabel("VAGA: ");
    //JTextField txtplaca= new JTextField();
    JLabel labelvalor= new JLabel("TOTAL: ");
    JTextField txtvalor= new JTextField();
    JLabel labelhrentrada = new JLabel("ENTRADA HR: ");
    JTextField txthrentrada= new JTextField();
    JLabel labelhrsaida = new JLabel("SAIDA HR: ");
    JTextField txthrsaida= new JTextField();
    JLabel labelhrduracao = new JLabel("DURACAO HR: ");
    JTextField txthrduracao= new JTextField();
    JLabel labelpagamento = new JLabel("PAGAMENTO: ");
    JTextField txtpagamento= new JTextField();
    JLabel labeltroco = new JLabel("TROCO: ");
    JTextField txttroco= new JTextField();
    JLabel labelstatus = new JLabel("STATUS: ");
    JTextField txtstatus= new JTextField();
    
    
 
    
    //TextArea areaObs= new TextArea("",1,1, TextArea.SCROLLBARS_VERTICAL_ONLY);
    //JScrollPane scrolObs= new JScrollPane(areaObs);
    
    public void criarTela(){
    
        tela.setBounds(250, 200, 500, 650);
        tela.setVisible(true);
        tela.setTitle("RESERVA SAIDA");
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
        //painel.add(labelvaga);
        //painel.add(txtplaca);
        painel.add(labelvalor);
        painel.add(txtvalor);
        painel.add(labelhrentrada);
        painel.add(txthrentrada);
        painel.add(labelhrsaida);
        painel.add(txthrsaida);
        painel.add(labelhrduracao);
        painel.add(txthrduracao);
        painel.add(labelpagamento);
        painel.add(txtpagamento);
        painel.add(labeltroco);
        painel.add(txttroco);
        painel.add(labelstatus);
        painel.add(txtstatus);
        painel.add(jcreserva);
        //painel.add(jcvaga);
        
        painel.add(botaosalvar);
        painel.add(botaolimpar);
        painel.add(botaosair);
        //painel.add(botaoentrada);
        painel.add(botaosaida);
        painel.add(botaocalculo);
        
        //painel.add(scrolObs);
        //painel.add(labelareaObs);
        
        
        
        labelcarro.setBounds(30, 30,100, 30);//X=vai para direita e y=descer
        jcreserva.setBounds(30,60, 440, 30);
        
        //labelvaga.setBounds(30, 90,100, 30);
        //jcvaga.setBounds(30,120, 440, 30);
        
        labelhrentrada.setBounds(30, 110,100, 30);
        txthrentrada.setBounds(30,140, 440, 30);
        txthrentrada.setEditable(false);
        
        labelhrsaida.setBounds(30, 170,100, 30);
        txthrsaida.setBounds(30,200, 340, 30);
        txthrsaida.setEditable(false);
        
        labelhrduracao.setBounds(30, 230,100, 30);
        txthrduracao.setBounds(30,260, 440, 30);
        
        labelvalor.setBounds(30, 290,100, 30);
        txtvalor.setBounds(30,310, 440, 30);
        
        labelpagamento.setBounds(30, 340,120, 30);
        txtpagamento.setBounds(30,370, 340, 30);
        
        labeltroco.setBounds(30, 400,100, 30);
        txttroco.setBounds(30,430, 440, 30);
        
        labelstatus.setBounds(30, 460,100, 30);
        txtstatus.setBounds(30,490, 440, 30);
        
        //criando obersavacao
        
        
        //scrolObs.setBounds(30, 330, 280,100);
        //labelareaObs.setBounds(30, 300, 100, 30);
        
        
        //criando botoes
        botaosalvar.setBounds(30, 540, 100, 30); 
        botaolimpar.setBounds(140, 540, 100, 30);
        botaosair.setBounds(250, 540, 100, 30);
        //botaoentrada.setBounds(370, 240, 100, 30);
        botaosaida.setBounds(370, 200, 100, 30);
        botaocalculo.setBounds(370, 370, 100, 30);
        
        botaosalvar.addActionListener(this);
        //botaoentrada.addActionListener(this);
        botaosaida.addActionListener(this);
        botaocalculo.addActionListener(this);
        
        serv.preencherComboReserva(jcreserva);
        
        
        jcreserva.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e)
    {
        reserva=(Reserva) jcreserva.getSelectedItem();
        txthrentrada.setText(reserva.getResdthrent());
        txtstatus.setText(reserva.getResestatus());
        
            //aluguel.setCliente(new Cliente());
            //aluguel.setCliente(cli);
        System.out.println(jcreserva);
    }
});
    
        
    }
    
    public void iniciarcronometro2(){
        Timer timer = null;
        
        final SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        final SimpleDateFormat formathr = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        
        txthrsaida.setText(format.format(new Date().getTime()));
        
        //reserva.setResdthrsai(format.format(new Date().getTime()));
        tes=txthrentrada.getText();
        
        tes2=formathr.format(new Date().getTime());
        
        //System.out.println(tes2);
        
//        
    }
    public void iniciarcronometro3() throws ParseException{
        Timer timer = null;
        
        final SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        
        //tes3=format.format(new Date().getTime());
        
        //System.out.println(tes3);
        Date ent=null;
        Date sai=null;
        Date sai2=null;
        
        final SimpleDateFormat dfEntrada = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");    
        ent = dfEntrada.parse(tes);  
          
        final SimpleDateFormat dfSaida = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");    
        sai = dfSaida.parse(tes2);
        
//        final SimpleDateFormat dfteste = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");    
//        sai2 = dfteste.parse(hms);
        
        long min = sai.getTime() - ent.getTime(); 
        
        System.out.println(min);
        
        //long min2=min/900000;
          
        float resultado = (float) ((min / 1000));
        //float result = (int) ((min2/1000)/60);
        
        
        int segundos = (int) resultado; 
        int segundo = segundos % 60; 
        int minutos = segundos / 60; 
        int minuto = minutos % 60; 
        int hora = minutos / 60; 
        String hms = String.format ("%02d:%02d:%02d", hora, minuto, segundo); 
        
        final SimpleDateFormat dfteste = new SimpleDateFormat("HH:mm:ss");    
        sai2 = dfteste.parse(hms);
        long min2=sai2.getTime();
        //min2=min2/900000;
        System.out.println (hms); // deve mostrar "01:16:07"
        
        double result=(float) (((hora*60.0)+minuto+(segundo/60))*0.067);
        
        DecimalFormat df = new DecimalFormat("#.00");
        df.format(result);
        
        //resultado=String.valueOf(format.format(new Date().getTime()));
        
        
        txthrduracao.setText(String.valueOf(hms));
        int ponto = String.valueOf(result).indexOf('.');
        txtvalor.setText(String.valueOf(result).substring(0, ponto + 3));
        System.out.println(min2);
        System.out.println(result);
        
        //reserva.setResdthrdur(String.valueOf(resultado));
          
        //System.out.println("Diferença: " + resultado + " minuto(s)");
        //System.out.println("Total: " + resutl + " real");
        
      
    }
    
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
        InterfaceReservaSaida tela= new InterfaceReservaSaida();
        tela.criarTela();
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource().equals(botaosalvar)){
            
            reserva=(Reserva) jcreserva.getSelectedItem();
            reserva.setCarro(new Carro());
            reserva.setCarro(carro);
            
            reserva.setResdthrent(txthrentrada.getText());
            reserva.setResdthrdur(txthrduracao.getText());
            reserva.setResdthrsai(txthrsaida.getText());
            reserva.setResestatus(txtstatus.getText());
            reserva.setRespagamento(Double.parseDouble(txtpagamento.getText()));
            reserva.setRestroco(Double.parseDouble(txtvalor.getText()));
            reserva.setResvalor(Double.parseDouble(txtvalor.getText()));
            
            reservadao.UpdateReserva(reserva);
            
//            automovel.setAutchassi(txtchassi.getText());
//            automovel.setAutplaca(txtplaca.getText());
//            automovel.setAutmarca(txtvalor.getText());
//            automovel.setAutmodelo(txthrentrada.getText());
//            automovel.setAutvldiaria(Double.parseDouble(txthrsaida.getText()));
//            automovelDao.salvarAutomovel(automovel);
            
            //JOptionPane.showMessageDialog(null,"Parabens voce conseguiu!!");
            
        }else if(evento.getSource().equals(botaosaida)){
            iniciarcronometro2();
            
            try {
                iniciarcronometro3();
            } catch (ParseException ex) {
                //Logger.getLogger(InterfaceReserva.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else if(evento.getSource().equals(botaocalculo)){
            
            reserva.setRespagamento(Double.parseDouble(txtpagamento.getText()));
            reserva.setResvalor(Double.parseDouble(txtvalor.getText()));
            //txttroco.setText(String.valueOf(reservadao.calcularTotal(reserva.getResvalor(), reserva.getRespagamento())));
            txttroco.setText(String.valueOf(reservadao.calcularTotal(reserva.getResvalor(),reserva.getRespagamento())));
        }
        
    }
}
