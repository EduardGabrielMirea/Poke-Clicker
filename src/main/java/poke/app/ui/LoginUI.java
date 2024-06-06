package poke.app.ui;

import org.springframework.stereotype.Component;
import poke.app.config.AppConfig;
import poke.app.controller.EquipoController;
import poke.app.controller.LoginController;
import poke.app.entity.Login;
import poke.app.localData.User;
import poke.app.localData.Window;
import poke.app.repository.EquipoRepository;
import poke.app.repository.LoginRepository;
import poke.app.service.AppService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

@Component
public class LoginUI{

    private final LoginController loginController;
    private final LoginRepository loginRepository;
    private final EquipoController equipoController;
    private final EquipoRepository equipoRepository;
    private final AppConfig appConfig;




    private JPanel loginMain;
    private JTextField usernameField;
    private JTextField passwordField;
    private JButton loginButton;
    private JButton registroButton;
    private JButton recuperarContraseñaButton;
    private JLabel titulo;
    private JPanel panelTitulo;
    private JPanel panelBotones;
    private JPanel panelDatos;
    private JLabel user;
    private JLabel password;




    public LoginUI(AppService appService) {
        this.loginController = appService.getLoginController();
        this.loginRepository = appService.getLoginRepository();
        this.equipoController = appService.getEquipoController();
        this.equipoRepository = appService.getEquipoRepository();
        this.appConfig = appService.getAppConfig();


        JFrame frame = new Window();
        SeleccionUI seleccionUI = new SeleccionUI(appService);


        frame.setTitle("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 800, 900);
        loginMain = new JPanel();
        loginMain.setLayout(null);
        loginMain.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(loginMain);
        frame.setLocationRelativeTo(null);
        titulo = new JLabel();
        titulo.setIcon(new ImageIcon(getClass().getResource("/img/Poke-Clicker.png")));
        titulo.setBounds(0, -150, 800, 900);
        loginMain.add(titulo);
        frame.setBackground(Color.black);
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(170, 400, 80, 20);
        loginMain.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(250, 400, 200, 20);
        loginMain.add(usernameField);
        usernameField.setColumns(10);


        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(170, 450, 80, 20);
        loginMain.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(250, 450, 200, 20);
        loginMain.add(passwordField);
        passwordField.setColumns(10);


        recuperarContraseñaButton = new JButton("Recuperar Contraseña");
        recuperarContraseñaButton.setBounds(200, 480, 280, 25);
        loginMain.add(recuperarContraseñaButton);
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
        loginMain.add(loginButton);
        loginButton.addActionListener(e -> {
            // Lógica de inicio de sesión
            String nombreUser = usernameField.getText();
            User.username = nombreUser;
            if(loginController.login(nombreUser, passwordField.getText())) {
                if(loginController.isConfigured(nombreUser)){

                    JOptionPane.showMessageDialog(null,"Bienvenido "+usernameField.getText());
                    MenuUI menuUI = new MenuUI(appService);
                    menuUI.main(frame);
                }else{

                    JOptionPane.showMessageDialog(null,"Bienvenido "+usernameField.getText()+" necesitamos que configures tu usuario.");
                    SeleccionUI seleccionUI1 = new SeleccionUI(appService);
                    seleccionUI1.main(frame);
                }
            }else{
                JOptionPane.showMessageDialog(null,"No se ha podido iniciar sesión con el usuario");
            }
        });

        registroButton = new JButton("Registro");
        registroButton.setBounds(400, 600, 120, 25);
        loginMain.add(registroButton);
        registroButton.addActionListener(e -> {
            // Lógica de registro
            if(loginController.registro(usernameField.getText(), passwordField.getText())) {
                loginRepository.save(new Login(usernameField.getText(),passwordField.getText()));
                JOptionPane.showMessageDialog(null,"Registrando usuario "+usernameField.getText());
            }else{
                JOptionPane.showMessageDialog(null,String.format("El usuario %s ya existe",usernameField.getText()));
            }
        });
        //frame.setVisible(true);
    }


}
