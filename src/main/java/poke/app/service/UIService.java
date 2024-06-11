package poke.app.service;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.*;

import static poke.app.service.PokemonService.urlSpritePokemonByIDStatico;

public class UIService extends JFrame {
    public static void mostrarImagenEnLabelById(int id,JLabel label){
        try {
            // Cargar la imagen desde la URL
            if (id == 0) {
                ImageIcon icon = new ImageIcon("src/main/resources/img/defaultPokeball.png");
                label.setIcon(icon);

            } else {
                URL url = new URL(PokemonService.urlSpritePokemonByID(id));
                ImageIcon icon = new ImageIcon(url);
                //label.setIcon(icon);
                label.setIcon(icon);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void mostrarImagenEnBoton(String nombrePokemon,JButton boton){
        try {
            // Cargar la imagen desde la URL
            URL url = new URL(PokemonService.urlSpritePokemon(nombrePokemon));
            ImageIcon icon = new ImageIcon(url);
            boton.setIcon(icon);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void mostrarImagenEnBotonById(int id,JButton boton){
        try {
            // Cargar la imagen desde la URL
            if (id == 0)
            {
                ImageIcon icon = new ImageIcon("src/main/resources/img/defaultPokeball.png");
                boton.setIcon(icon);

            }
            else
            {
                URL url = new URL(PokemonService.urlSpritePokemonByID(id));
                ImageIcon icon = new ImageIcon(url);
                boton.setIcon(icon);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void mostrarImagenEnBotonByIdStatico(int id,JButton boton){
        try {
            // Cargar la imagen desde la URL
            if (id == 0)
            {
                ImageIcon icon = new ImageIcon("src/main/resources/img/defaultPokeball.png");
                boton.setIcon(icon);

            }
            else
            {
                URL url = new URL(urlSpritePokemonByIDStatico(id));
                ImageIcon icon = new ImageIcon(url);
                boton.setIcon(icon);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void resizeImgInButton(int idPokemon,JButton boton){
        // Load the original image
        ImageIcon originalIcon = new ImageIcon(urlSpritePokemonByIDStatico(idPokemon));
        Image originalImage = originalIcon.getImage();

        // Resize the image
        int newWidth = 100; // Desired width
        int newHeight = 100; // Desired height
        Image resizedImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

        // Create an ImageIcon from the resized image
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        // Set the resized icon on the button
        boton.setIcon(resizedIcon);
    }

    public static void asignarTextoAlabel(String texto,JLabel label){
        label.setText(texto);
    }

    public static void asignarTextoAJTextArea(String texto,JTextArea textArea){
        textArea.setText(texto);
        textArea.setEditable(false);
        textArea.setLineWrap(false);
    }

    public static void musicInLoop(){
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/resources/audio/PokemonRoute201.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.out.println("Error al reproducir el sonido.");
        }
    }
}
