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

    //private static final int FRAME_RATE = 60; // 60 FPS
    //private static final int FRAME_DELAY = 1000 / FRAME_RATE;
    //private static long frameCount = 0;
    //private static long lastTime = System.currentTimeMillis();
    //private static int currentFPS = 0;

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
            UIService.musicInLoop();

            /* HILOS

            Thread thread = new Thread(() ->
            {
                System.out.println("hilo ejecutado por"+Thread.currentThread().getName());


            });
            thread.start();

             */


            // Iniciamos el bucle de actualización
            //startUpdateLoop(loginUI);
        });
    }

    /*private static void startUpdateLoop(LoginUI loginUI) {
        Timer timer = new Timer(FRAME_DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes actualizar la UI o realizar las acciones necesarias
                update(loginUI);
            }
        });
        timer.start();
    }

    private static void update(LoginUI loginUI) {
        // Incrementa el contador de frames
        frameCount++;

        // Calcula el tiempo transcurrido
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - lastTime;

        // Si ha pasado un segundo, calcula los FPS
        if (elapsedTime >= 1000) {
            currentFPS = (int) frameCount;
            frameCount = 0;
            lastTime = currentTime;



        }
    }*/

}
