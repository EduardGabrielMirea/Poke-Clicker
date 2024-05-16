package poke.app.ui;

import org.hibernate.annotations.Cache;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
@Component
public class LoginUI extends JFrame {
    private JPanel panelLogin;
    private JTextField usernameField;
    private JTextField passwordField;
    private JButton loginButton;
    private JButton registroButton;
    private JButton recuperarContraseñaButton;
    private JLabel Banner;

    public LoginUI() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 700);
        panelLogin = new JPanel();
        panelLogin.setLayout(null);
        panelLogin.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panelLogin);

        Banner = new JLabel();
        Banner.setIcon(new ImageIcon(getClass().getResource("/img/Poke-Clicker.png")));
        Banner.setBounds(0, -150, 700, 700);
        panelLogin.add(Banner);


        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(170, 400, 80, 20);
        panelLogin.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(250, 400, 200, 20);
        panelLogin.add(usernameField);
        usernameField.setColumns(10);


        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(170, 450, 80, 20);
        panelLogin.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(250, 450, 200, 20);
        panelLogin.add(passwordField);
        passwordField.setColumns(10);


        recuperarContraseñaButton = new JButton("Recuperar Contraseña");
        recuperarContraseñaButton.setBounds(200, 480, 280, 25);
        panelLogin.add(recuperarContraseñaButton);
        recuperarContraseñaButton.addActionListener(e -> {
            // Lógica de recuperación de contraseña
        });


        loginButton = new JButton("Login");
        loginButton.setBounds(200, 600, 120, 25);
        panelLogin.add(loginButton);
        loginButton.addActionListener(e -> {
            // Lógica de inicio de sesión
        });

        registroButton = new JButton("Registro");
        registroButton.setBounds(400, 600, 120, 25);
        panelLogin.add(registroButton);
        registroButton.addActionListener(e -> {
            // Lógica de registro
        });

    }
}
