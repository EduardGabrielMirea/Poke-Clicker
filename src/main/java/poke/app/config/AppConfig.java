package poke.app.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import poke.app.localData.Window;
import poke.app.ui.LoginUI;

import javax.swing.JFrame;
import poke.app.service.AppService;
import poke.app.ui.SeleccionUI;


@Configuration
public class AppConfig {

    @Bean
    @Primary
    public JFrame jFrame(JFrame jFrame) {
        return jFrame;
    }



/*
    @Bean
    public LoginUI loginUI(AppService appService) {
        LoginUI loginUI = appService.getAppConfig().loginUI(appService);
        loginUI.setLoginController(appService.getLoginController());
        loginUI.setLoginRepository(appService.getLoginRepository());
        loginUI.setEquipoController(appService.getEquipoController());
        loginUI.setEquipoRepository(appService.getEquipoRepository());
        loginUI.setAppConfig(this);
        loginUI.initUI(jFrame(Window.frame)); // Inicializar la interfaz
        return loginUI;
    }

    @Bean
    public SeleccionUI seleccionUI(AppService appService) {
        SeleccionUI seleccionUI = appService.getAppConfig().seleccionUI(appService);
        seleccionUI.setLoginController(appService.getLoginController());
        seleccionUI.setLoginRepository(appService.getLoginRepository());
        seleccionUI.setEquipoController(appService.getEquipoController());
        seleccionUI.setEquipoRepository(appService.getEquipoRepository());
        seleccionUI.setAppConfig(this);
        seleccionUI.initUI(Window.frame); // Inicializar la interfaz
        return seleccionUI;
    }

 */
}
