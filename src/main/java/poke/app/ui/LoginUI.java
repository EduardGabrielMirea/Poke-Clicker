package poke.app.ui;

import org.springframework.stereotype.Component;
import poke.app.controller.LoginController;
import poke.app.repository.LoginRepository;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
@Component
public class LoginUI extends JFrame{
    private JPanel login;
    private JPanel banner;
    private JPanel credenciales;
    private JPanel botonera;
    private JLabel lblUser;
    private JLabel lblPsswd;
    private JTextField textField1;
    private JTextField textField2;
    private JButton btnLogin;
    private JButton btnRegistro;
    private JButton btnRecPsswd;


    // Reference to the LoginController instance
    private LoginController loginController;
    private LoginRepository loginRepository;



    public LoginUI() {

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnRecPsswd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("LoginUI");
        frame.setContentPane(new LoginUI().login); // Pass instances
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
