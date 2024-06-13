package poke.app.ui;

import org.springframework.stereotype.Component;
import poke.app.localData.Window;
import poke.app.service.UIService;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;


@Component
public class TiendaUI {
    private JPanel panelPrincipal;
    private JTabbedPane Tienda;
    private JPanel mejoras;
    private JPanel pokemon;
    private JScrollBar scrollBar1;
    private JPanel derecha;
    private JPanel abajo;
    private JPanel arriba;
   // private JButton p1;
    private JLabel p1;
    private JButton p2;
    private JButton p3;
    private JButton p4;
    private JButton p5;
    private JButton p6;


    public TiendaUI() throws IOException {
        //Mostrar Pokemons
       // UIService.mostrarImagenEnBotonByIdStatico(1,p1);
        //UIService.resizeImgInButton(37,p2);
        //UIService.resizeImgInButton(68,p3);
        //UIService.resizeImgInButton(132,p4);
        //UIService.resizeImgInButton(29,p5);
        //UIService.resizeImgInButton(12,p6);
        UIService.ImagenEnJlabelByIdStatico(135,p1);



        //UIService.most(12,p1);
        p1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("Hola");
            }
        });
        p2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        p3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        p4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        p5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        p6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }

    public void ventanaTienda() {
        JFrame frame = Window.frame;
        frame.setContentPane(panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
