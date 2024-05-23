package poke.app.service;

import com.google.gson.Gson;
import poke.app.entity.Pokemon;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class PokemonService {

    private static Pokemon llamadasAPI(String nombre){
        nombre = nombre.toLowerCase();
        final Gson gson = new Gson();

        try {
            URL pokeAPI = new URL("https://pokeapi.co/api/v2/pokemon/" + nombre);
            BufferedReader in = new BufferedReader(new InputStreamReader(pokeAPI.openStream(), StandardCharsets.UTF_8));
            Pokemon p = gson.fromJson(in, Pokemon.class);
            return p;
        }catch (FileNotFoundException e){
            System.out.println("Pokemon no encontrado");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static String urlSpritePokemon(String nombre){
        Pokemon p = llamadasAPI(nombre);
        //Sprites pequeñitos
        //String sprite = p.sprites.versions.generationVIII.icons.frontDefault;
        //Sprites más grandecitos
        //String sprite = p.sprites.frontDefault;
        //Sprites animados
        String sprite = p.sprites.other.showdown.frontDefault;
        return sprite;
    }
}
