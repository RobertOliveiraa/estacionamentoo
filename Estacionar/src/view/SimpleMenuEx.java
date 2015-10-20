/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author RobertOliveira
 */
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class SimpleMenuEx extends JFrame {
    
   

    public SimpleMenuEx() {

        initUI();
        
    }

    private void initUI() {
        
        createMenuBar();

        setTitle("Simple menu");
        setSize(800, 600);
        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //getContentPane().setBackground(Color.WHITE);
        //getContentPane().add(new ImageIcon("sample.jpeg"));
        
        
    }

    private void createMenuBar() {

        
        //setBackground(Color.yellow);
        JMenuBar menubar = new JMenuBar();
        ImageIcon icon = new ImageIcon("inserir.png");
        ImageIcon iconcli = new ImageIcon("cliente.png");
        ImageIcon iconcar = new ImageIcon("carro.png");
        ImageIcon iconent = new ImageIcon("cima.png");
        ImageIcon iconsai = new ImageIcon("baixo.png");
        ImageIcon iconrel= new ImageIcon("pdf.png");
        
        //icon.getIconHeight(height);
         Image img = icon.getImage() ;
         Image newimg = img.getScaledInstance( 20, 20,  java.awt.Image.SCALE_SMOOTH ) ;  
         icon = new ImageIcon( newimg );
         Image imgcli = iconcli.getImage() ;
         Image newimgcli = imgcli.getScaledInstance( 25, 25,  java.awt.Image.SCALE_SMOOTH ) ;  
         iconcli = new ImageIcon( newimgcli );
         Image imgcar = iconcar.getImage() ;
         Image newimgcar = imgcar.getScaledInstance( 25, 25,  java.awt.Image.SCALE_SMOOTH ) ;  
         iconcar = new ImageIcon( newimgcar );
         Image imgent = iconent.getImage() ;
         Image newimgent = imgent.getScaledInstance( 25, 25,  java.awt.Image.SCALE_SMOOTH ) ;  
         iconent = new ImageIcon( newimgent );
         Image imgsai = iconsai.getImage() ;
         Image newimgsai = imgsai.getScaledInstance( 25, 25,  java.awt.Image.SCALE_SMOOTH ) ;  
         iconsai = new ImageIcon( newimgsai );
         Image imgrel = iconrel.getImage() ;
         Image newimgrel = imgrel.getScaledInstance( 25, 25,  java.awt.Image.SCALE_SMOOTH ) ;  
         iconrel = new ImageIcon( newimgrel );

        JMenu filecliente = new JMenu("Cliente");
        filecliente.setIcon(iconcli);
        JMenu filecarro = new JMenu("Carro");
        filecarro.setIcon(iconcar);
        JMenu fileentrada = new JMenu("Entrada");
        fileentrada.setIcon(iconent);
        JMenu filesaida = new JMenu("Saida");
        filesaida.setIcon(iconsai);
         JMenu fileRelatorio = new JMenu("Relatorio");
        fileRelatorio.setIcon(iconrel);
        filecliente.setMnemonic(KeyEvent.VK_F);
        filecarro.setMnemonic(KeyEvent.VK_F);
        fileentrada.setMnemonic(KeyEvent.VK_F);
        filesaida.setMnemonic(KeyEvent.VK_F);
        fileRelatorio.setMnemonic(KeyEvent.VK_F);
        
        JMenuItem eMenuInserirCliente = new JMenuItem("  Inserir", icon);
        eMenuInserirCliente.setMnemonic(KeyEvent.VK_E);
        JMenuItem eMenuInserirCarro = new JMenuItem("  Inserir", icon);
        eMenuInserirCarro.setMnemonic(KeyEvent.VK_E);
        JMenuItem eMenuInserirEntrada = new JMenuItem("  Inserir", icon);
        eMenuInserirEntrada.setMnemonic(KeyEvent.VK_E);
        JMenuItem eMenuInserirSaida = new JMenuItem("  Inserir", icon);
        eMenuInserirSaida.setMnemonic(KeyEvent.VK_E);
        //eMenuItem.setToolTipText("Exit application");
        eMenuInserirCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                InterfaceCliente cliente=new InterfaceCliente();
                cliente.criarTela();
            }
        });
        eMenuInserirCarro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                InterfaceCarro carro=new InterfaceCarro();
                //carro.criarTela();
            }
        });
        eMenuInserirEntrada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                InterfaceReserva reserva=new InterfaceReserva();
                reserva.criarTela();
            }
        });
        eMenuInserirSaida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                InterfaceReservaSaida reservaSaida=new InterfaceReservaSaida();
                reservaSaida.criarTela();
            }
        });

        filecliente.add(eMenuInserirCliente);
        filecarro.add(eMenuInserirCarro);
        fileentrada.add(eMenuInserirEntrada);
        filesaida.add(eMenuInserirSaida);
        
        menubar.add(filecliente);
        menubar.add(filecarro);
        menubar.add(fileentrada);
        menubar.add(filesaida);
        menubar.add(fileRelatorio);

        setJMenuBar(menubar);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                SimpleMenuEx ex = new SimpleMenuEx();
                ex.setVisible(true);
            }
        });
    }

}
