package poke.app.controller;

import org.springframework.stereotype.Component;
import poke.app.localData.User;
import poke.app.service.AppService;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

@Component
public class MenuController {

    public void setImageURL(String imagen, JLabel label){
        try {
            URL url= new URL(imagen);
            BufferedImage image = ImageIO.read(url);
            label.setIcon(new ImageIcon(image));

        }catch (MalformedURLException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



    public void setImageLocal(String imagen, JLabel label){

        try {
            File file= new File(imagen);
            BufferedImage image = ImageIO.read(file);
            label.setIcon(new ImageIcon(image));
        }catch (MalformedURLException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void elegirGenero(User username, AppService appService, JLabel Foto){
        if (appService.getLoginController().getPersonaGenero(User.username)==1)
        {
          appService.getMenuController().setImageLocal("src/main/resources/img/icons/redPlayer.png",Foto);
        } else if (appService.getLoginController().getPersonaGenero(User.username)==2)
        {
            appService.getMenuController().setImageLocal("src/main/resources/img/icons/leafPlayer.png",Foto);
        }
    }

}
