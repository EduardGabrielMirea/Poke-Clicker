package poke.app.service;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class UIService extends JFrame {
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

    public static void asignarTextoAlabel(String texto,JLabel label){
        label.setText(texto);
    }

    public static void asignarTextoAJTextArea(String texto,JTextArea textArea){
        textArea.setText(texto);
        textArea.setEditable(false);
        textArea.setLineWrap(false);
    }
}
