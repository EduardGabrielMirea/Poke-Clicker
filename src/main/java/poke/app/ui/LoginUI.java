package poke.app.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import javax.imageio.ImageIO;
import org.springframework.stereotype.Component;

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
        setSize(1280, 720); // Tamaño inicial
        setLocationRelativeTo(null); // Centrar en la pantalla
        panelLogin = new JPanel() {
            private Image backgroundImage;

            {
                try {
                    backgroundImage = ImageIO.read(getClass().getResource("/img/Poke-Clicker.png"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, getWidth()/4, 0, getWidth()/2, getHeight()/2, this);
                }
                int panelWidth = getWidth();
                int panelHeight = getHeight();

                Banner.setBounds(0, -150, panelWidth, panelHeight);

                int labelWidth = 80;
                int labelHeight = 20;
                int fieldWidth = 200;
                int fieldHeight = 20;
                int buttonWidth = 120;
                int buttonHeight = 25;

                int usernameLabelX = (panelWidth - labelWidth - fieldWidth) / 2;
                int usernameLabelY = panelHeight / 2 + 50;
                usernameField.setBounds(usernameLabelX + labelWidth, usernameLabelY, fieldWidth, fieldHeight);

                int passwordLabelX = (panelWidth - labelWidth - fieldWidth) / 2;
                int passwordLabelY = usernameLabelY + 50;
                passwordField.setBounds(passwordLabelX + labelWidth, passwordLabelY, fieldWidth, fieldHeight);

                recuperarContraseñaButton.setBounds((panelWidth - buttonWidth) / 2, passwordLabelY + 30, buttonWidth, buttonHeight);
                loginButton.setBounds((panelWidth - buttonWidth) / 2 - 120, passwordLabelY + 100, buttonWidth, buttonHeight);
                registroButton.setBounds((panelWidth - buttonWidth) / 2 + 120, passwordLabelY + 100, buttonWidth, buttonHeight);
            }
        };
        panelLogin.setLayout(null);
        panelLogin.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panelLogin);

        Banner = new JLabel();
        Banner.setBounds(0, 0, 700, 700);
        panelLogin.add(Banner);

        JLabel usernameLabel = new JLabel("Username:");
        panelLogin.add(usernameLabel);

        usernameField = new JTextField();
        panelLogin.add(usernameField);
        usernameField.setColumns(10);

        JLabel passwordLabel = new JLabel("Password:");
        panelLogin.add(passwordLabel);

        passwordField = new JPasswordField();
        panelLogin.add(passwordField);
        passwordField.setColumns(10);

        recuperarContraseñaButton = new JButton("Recuperar Contraseña");
        panelLogin.add(recuperarContraseñaButton);

        loginButton = new JButton("Login");
        panelLogin.add(loginButton);

        registroButton = new JButton("Registro");
        panelLogin.add(registroButton);
    }
}
