package poke.app.ui;

import org.springframework.stereotype.Component;
import poke.app.config.AppConfig;
import poke.app.controller.EquipoController;
import poke.app.controller.LoginController;
import poke.app.entity.Login;
import poke.app.localData.User;
import poke.app.repository.EquipoRepository;
import poke.app.repository.LoginRepository;
import poke.app.service.AppService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static poke.app.localData.Window.frame;

@Component
public class LoginUI {
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
    private EquipoController equipoController;
    private EquipoRepository equipoRepository;
    private AppConfig appConfig;

    public LoginUI(AppService appService) {
        this.appConfig = appService.getAppConfig();
        this.loginRepository  = appService.getLoginRepository();
        this.equipoController = appService.getEquipoController();
        this.equipoRepository = appService.getEquipoRepository();
        this.loginController = appService.getLoginController();

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreUser = textField1.getText();
                User.username = nombreUser;
                if(loginController.login(nombreUser, textField2.getText())) {
                    if(loginController.isConfigured(nombreUser)){
                        //seleccionUI.setName(nombreUser);
                        JOptionPane.showMessageDialog(null,"Bienvenido "+textField1.getText());
                        MenuUI menuUI = new MenuUI(appService);
                        menuUI.initUI(frame);
                    }else{
                        //seleccionUI.setName(nombreUser);
                        JOptionPane.showMessageDialog(null,"Bienvenido "+textField1.getText()+" necesitamos que configures tu usuario.");
                        //SeleccionUI seleccionUI = new SeleccionUI(loginController,loginRepository);
                        //seleccionUI.initUI(appService);
                        SeleccionUI seleccionUI1 = new SeleccionUI(appService);
                        seleccionUI1.initUI(frame);
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"No se ha podido iniciar sesión con el usuario");
                }
            }
        });
        btnRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica de registro
                if(loginController.registro(textField1.getText(), textField2.getText())) {
                    loginRepository.save(new Login(textField1.getText(),textField2.getText()));
                    JOptionPane.showMessageDialog(null,"Registrando usuario "+textField1.getText());
                }else{
                    JOptionPane.showMessageDialog(null,String.format("El usuario %s ya existe",textField1.getText()));
                }
            }
        });
        btnRecPsswd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica de recuperación de contraseña
                if(loginController.recuperarContraseña(textField1.getText(),textField2.getText())){
                    JOptionPane.showMessageDialog(null,"Contraseña cambiada correctamente");
                }else{
                    JOptionPane.showMessageDialog(null,"El usuario "+textField1.getText()+" no existe");
                }
            }
        });
    }


    public void initUI(JFrame frame) {
        frame.setContentPane(login); // Pass instances
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
