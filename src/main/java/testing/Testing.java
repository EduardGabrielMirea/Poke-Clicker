package testing;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Pokemon {
    String name;
    String type;

    Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
    }
}

public class Testing {

    public String randomStarter(String desiredType) {
        List<Pokemon> starterPokemons = new ArrayList<>();
        // Gen 1
        starterPokemons.add(new Pokemon("bulbasaur", "grass"));
        starterPokemons.add(new Pokemon("charmander", "fire"));
        starterPokemons.add(new Pokemon("squirtle", "water"));
        // Gen 2
        starterPokemons.add(new Pokemon("chikorita", "grass"));
        starterPokemons.add(new Pokemon("cyndaquil", "fire"));
        starterPokemons.add(new Pokemon("totodile", "water"));
        // Gen 3
        starterPokemons.add(new Pokemon("treecko", "grass"));
        starterPokemons.add(new Pokemon("torchic", "fire"));
        starterPokemons.add(new Pokemon("mudkip", "water"));
        // Gen 4
        starterPokemons.add(new Pokemon("turtwig", "grass"));
        starterPokemons.add(new Pokemon("chimchar", "fire"));
        starterPokemons.add(new Pokemon("piplup", "water"));
        // Gen 5
        starterPokemons.add(new Pokemon("snivy", "grass"));
        starterPokemons.add(new Pokemon("tepig", "fire"));
        starterPokemons.add(new Pokemon("oshawott", "water"));
        // Gen 6
        starterPokemons.add(new Pokemon("chespin", "grass"));
        starterPokemons.add(new Pokemon("fennekin", "fire"));
        starterPokemons.add(new Pokemon("froakie", "water"));
        // Gen 7
        starterPokemons.add(new Pokemon("rowlet", "grass"));
        starterPokemons.add(new Pokemon("litten", "fire"));
        starterPokemons.add(new Pokemon("popplio", "water"));
        // Gen 8
        starterPokemons.add(new Pokemon("grookey", "grass"));
        starterPokemons.add(new Pokemon("scorbunny", "fire"));
        starterPokemons.add(new Pokemon("sobble", "water"));
        // Gen 9
        starterPokemons.add(new Pokemon("sprigatito", "grass"));
        starterPokemons.add(new Pokemon("fuecoco", "fire"));
        starterPokemons.add(new Pokemon("quaxly", "water"));

        desiredType = desiredType.toLowerCase();
        Random rand = new Random();
        int pokemon = rand.nextInt(starterPokemons.size());
        if (starterPokemons.get(pokemon).type.equals(desiredType)) {
            return  starterPokemons.get(pokemon).name;
        }
            return null;
        }



    }