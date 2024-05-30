package poke.app.ui;

import org.hibernate.annotations.Cache;
import org.springframework.stereotype.Component;
import poke.app.controller.LoginController;
import poke.app.entity.Login;
import poke.app.localData.User;
import poke.app.repository.LoginRepository;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

@Component
public class LoginUI extends JFrame {
    private final LoginController loginController;
    private final LoginRepository loginRepository;


    private JPanel panelLogin;
    private JTextField usernameField;
    private JTextField passwordField;
    private JButton loginButton;
    private JButton registroButton;
    private JButton recuperarContraseñaButton;
    private JLabel Banner;

    public LoginUI(LoginController loginController, LoginRepository loginRepository) {
        this.loginController = loginController;
        this.loginRepository = loginRepository;

        SeleccionUI seleccionUI = new SeleccionUI(loginController, loginRepository);
        //setLayout(null);
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 900);
        panelLogin = new JPanel();
        panelLogin.setLayout(null);
        panelLogin.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panelLogin);
        setLocationRelativeTo(null);
        Banner = new JLabel();
        Banner.setIcon(new ImageIcon(getClass().getResource("/img/Poke-Clicker.png")));
        Banner.setBounds(0, -150, 800, 900);
        panelLogin.add(Banner);
        setBackground(Color.black);

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
            if(loginController.recuperarContraseña(usernameField.getText(),passwordField.getText())){
                JOptionPane.showMessageDialog(null,"Contraseña cambiada correctamente");
            }else{
                JOptionPane.showMessageDialog(null,"El usuario "+usernameField.getText()+" no existe");
            }
        });


        loginButton = new JButton("Login");
        loginButton.setBounds(200, 600, 120, 25);
        panelLogin.add(loginButton);
        loginButton.addActionListener(e -> {
            // Lógica de inicio de sesión
            String nombreUser = usernameField.getText();
            User.username = nombreUser;
            if(loginController.login(nombreUser, passwordField.getText())) {
                if(loginController.isConfigured(nombreUser)){
                    //seleccionUI.setName(nombreUser);
                    JOptionPane.showMessageDialog(null,"Bienvenido "+usernameField.getText());
                    Menu menu = new Menu(loginController,loginRepository);
                    menu.main(this);
                }else{
                    //seleccionUI.setName(nombreUser);
                    JOptionPane.showMessageDialog(null,"Bienvenido "+usernameField.getText()+" necesitamos que configures tu usuario.");
                    //SeleccionUI seleccionUI = new SeleccionUI(loginController,loginRepository);
                    seleccionUI.main(this);
                }
            }else{
                JOptionPane.showMessageDialog(null,"No se ha podido iniciar sesión con el usuario");
            }
        });

        registroButton = new JButton("Registro");
        registroButton.setBounds(400, 600, 120, 25);
        panelLogin.add(registroButton);
        registroButton.addActionListener(e -> {
            // Lógica de registro
            if(loginController.registro(usernameField.getText(), passwordField.getText())) {
                loginRepository.save(new Login(usernameField.getText(),passwordField.getText()));
                JOptionPane.showMessageDialog(null,"Registrando usuario "+usernameField.getText());
            }else{
                JOptionPane.showMessageDialog(null,String.format("El usuario %s ya existe",usernameField.getText()));
            }
        });
    }
}
