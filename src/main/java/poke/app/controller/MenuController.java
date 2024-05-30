package poke.app.controller;

import org.aspectj.asm.IProgramElement;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class MenuController extends JFrame
{


    public void setImageURL(String imagen, JLabel label){

        try {
            URL url= new URL(imagen);
            BufferedImage image = ImageIO.read(url);
            label.setIcon(new ImageIcon(image));
            System.out.println("llega");

        }catch (MalformedURLException e) {

            System.out.println("No llega");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



    public void setImageLocal(String imagen, JLabel label){

        try {
            File file= new File(imagen);
            BufferedImage image = ImageIO.read(file);
            label.setIcon(new ImageIcon(image));
            System.out.println("llega");

        }catch (MalformedURLException e) {

            System.out.println("No llega");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
