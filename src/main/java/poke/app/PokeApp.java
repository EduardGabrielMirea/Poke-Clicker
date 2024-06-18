package poke.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import poke.app.service.AppService;
import poke.app.service.UIService;
import poke.app.ui.InicioSesionUI;
import java.awt.*;

@SpringBootApplication(scanBasePackages = {"poke.app"})

public class PokeApp {

    @Autowired
    private AppService appService;

    public static void main(String[] args) {

        ConfigurableApplicationContext context =
                new SpringApplicationBuilder(PokeApp.class)
                        .headless(false)
                        .web(WebApplicationType.NONE)
                        .run(args);

        EventQueue.invokeLater(() -> {
            // Obtenemos los objetos form a través de Spring
            //Inicio de Sesión UI
            InicioSesionUI inicioSesionUI = context.getBean(InicioSesionUI.class);
            inicioSesionUI.main();
            UIService.musicInLoop("src/main/resources/audio/PokemonRoute201.wav");
        });
    }

}
