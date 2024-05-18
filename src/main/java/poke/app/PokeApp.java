package poke.app;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import poke.app.ui.LoginUI;
import poke.app.ui.PantallaPrincipal;

import java.awt.*;

@SpringBootApplication(scanBasePackages = {"poke.app"})
public class PokeApp {

    public static int pantalla = 0;

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new SpringApplicationBuilder(PokeApp.class)
                        .headless(false)
                        .web(WebApplicationType.NONE)
                        .run(args);

        EventQueue.invokeLater(() -> {
            // Obtenemos los objetos form a través de Spring
            LoginUI loginUI = context.getBean(LoginUI.class);
            //PantallaPrincipal pantallaPrincipal = context.getBean(PantallaPrincipal.class);

            //Selector de pantalla
            switch (pantalla){
                case 0:
                    loginUI.setVisible(true);
                    break;
                case 1:
                    //pantallaPrincipal.setVisible(true);
                    break;
                default:
                    break;
            }
        });
    }

}
