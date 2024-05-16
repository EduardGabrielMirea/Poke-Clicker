package poke.app.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class LoginUI extends JFrame {
    private JPanel panelLogin;
    private JTextField textField1;
    private JTextField textField2;
    private JButton loginButton;
    private JButton registroButton;
    private JButton recuperarContraseñaButton;

    public LoginUI() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        panelLogin = new JPanel();
        panelLogin.setLayout(null);
        panelLogin.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panelLogin);
        panelLogin.setBounds(0, 0, 450, 300);
        panelLogin.setLayout(null);
        textField1 = new JTextField();
        textField1.setBounds(80, 80, 80, 20);
        panelLogin.add(textField1);
        textField1.setColumns(10);
        textField2 = new JTextField();
        textField2.setBounds(80, 120, 80, 20);
        panelLogin.add(textField2);
        textField2.setColumns(10);
        loginButton = new JButton("Login");
        loginButton.setBounds(80, 160, 80, 20);
        panelLogin.add(loginButton);
        loginButton.addActionListener(e -> {});
        registroButton = new JButton("Registro");
        registroButton.setBounds(80, 200, 80, 20);
        panelLogin.add(registroButton);
        registroButton.addActionListener(e -> {});

    }
}
