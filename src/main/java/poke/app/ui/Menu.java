package poke.app.ui;

import poke.app.controller.LoginController;
import poke.app.controller.MenuController;
import poke.app.localData.User;
import poke.app.repository.LoginRepository;

import javax.swing.*;
import javax.swing.text.html.ImageView;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Menu {
    private final LoginController loginController;
    private final LoginRepository loginRepository;
    private JPanel menu;
    private JPanel header;
    private JPanel foot;
    private JPanel izquierdo;
    private JPanel derecho;
    private JPanel p1;
    private JPanel p2;
    private JPanel p3;
    private JPanel p4;
    private JPanel p5;
    private JPanel p6;
    private JPanel texto;
    private JPanel player;
    private JLabel titulo;
    private JLabel Foto;
    private JLabel Nombre;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    private JButton b5;
    private JButton b6;
    private JButton entrenar;
    private JButton luchar;
    private MenuController menuController;


    public Menu(LoginController loginController, LoginRepository loginRepository)
    {
        this.loginController = loginController;
        this.loginRepository = loginRepository;
        this.menuController = new MenuController();


        Nombre.setText(User.username.toUpperCase());
        if (loginController.getPersonaGenero(User.username)==1)
        {
           menuController.setImageLocal("src/main/resources/img/icons/redPlayer.png",Foto);




        } else if (loginController.getPersonaGenero(User.username)==2)
        {

            menuController.setImageLocal("src/main/resources/img/icons/leafPlayer.png",Foto);

        }

    }



    public void main(JFrame frame) {
        frame.setContentPane(new Menu(loginController, loginRepository).menu);
        frame.setSize(800, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);



    }

}
