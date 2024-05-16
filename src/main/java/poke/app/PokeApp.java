package poke.app;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import poke.app.ui.LoginUI;

import java.awt.*;

@SpringBootApplication
public class PokeApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context  =
                new SpringApplicationBuilder(PokeApp.class)
                        .headless(false)
                        .web(WebApplicationType.NONE)
                        .run(args);
       /** EventQueue.invokeLater(()->{
            //obtenemos el objeto form a través de Spring
            EntityGUI entityUI = context.getBean(EntityGUI.class);
            entityUI.setVisible(true);
        });
        */
    }
}
