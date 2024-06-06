package poke.app.ui;

import org.springframework.stereotype.Component;
import poke.app.controller.LoginController;
import poke.app.entity.Login;
import poke.app.localData.User;
import poke.app.localData.Window;
import poke.app.repository.LoginRepository;
import poke.app.service.AppService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Component
public class InicioSesionUI {
    private JButton recoverPass;
    private JButton registro;
    private JButton login;
    private JTextField nameField;
    private JPasswordField passField;
    private JPanel inicioSesion;
    private JPanel paneLogo;
    private JPanel paneDatos;
    private JPanel paneBotones;
    private JLabel logo;
    private JLabel lbName;
    private JLabel lbPass;

    private final LoginController loginController;
    private final LoginRepository loginRepository;
    private final JFrame frame = Window.frame;

    public InicioSesionUI(AppService appService) {
        this.loginController = appService.getLoginController();
        this.loginRepository = appService.getLoginRepository();

        nameField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        passField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        recoverPass.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                // Lógica de recuperación de contraseña
                if(loginController.recuperarContraseña(nameField.getText(),passField.getText())){
                    JOptionPane.showMessageDialog(null,"Contraseña cambiada correctamente");
                }else{
                    JOptionPane.showMessageDialog(null,"El usuario "+nameField.getText()+" no existe");
                }
            }
        });
        registro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(loginController.registro(nameField.getText(), passField.getText())) {
                    loginRepository.save(new Login(nameField.getText(),passField.getText()));
                    JOptionPane.showMessageDialog(null,"Registrando usuario "+nameField.getText());
                }else{
                    JOptionPane.showMessageDialog(null,String.format("El usuario %s ya existe",nameField.getText()));
                }
            }
        });
        login.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String nombreUser = nameField.getText();
                User.username = nombreUser;
                if(loginController.login(nombreUser, passField.getText())) {
                    if(loginController.isConfigured(nombreUser)){

                        JOptionPane.showMessageDialog(null,"Bienvenido "+nameField.getText());
                        MenuUI menuUI = new MenuUI(appService);
                        menuUI.main(Window.frame);
                    }else{

                        JOptionPane.showMessageDialog(null,"Bienvenido "+nameField.getText()+" necesitamos que configures tu usuario.");
                        SeleccionUI seleccionUI1 = new SeleccionUI(appService);
                        seleccionUI1.main(Window.frame);
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"No se ha podido iniciar sesión con el usuario");
                }
            }
        });
    }

    public void main() {
        //JFrame frame = new JFrame("InicioSesionUI");
        //Window.frame = frame;
        //frame.setContentPane(new InicioSesionUI(inicioSesion).inicioSesion);
        frame.setContentPane(inicioSesion);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setVisible(true);
    }
}


