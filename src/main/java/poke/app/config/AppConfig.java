package poke.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.JFrame;

@Configuration
public class AppConfig {

    @Bean
    public JFrame jFrame() {
        return new JFrame("Poke-Clicker");
    }
}
