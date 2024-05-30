package poke.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class RandomStarter {
    private List<Starter> starterPokemons = new ArrayList<>();

    class Starter {
        String name;
        String type;

        Starter(String name, String type) {
            this.name = name;
            this.type = type;
        }
    }

    private void addStarters() {
        // Gen 1
        starterPokemons.add(new Starter("bulbasaur", "grass"));
        starterPokemons.add(new Starter("charmander", "fire"));
        starterPokemons.add(new Starter("squirtle", "water"));
        // Gen 2
        starterPokemons.add(new Starter("chikorita", "grass"));
        starterPokemons.add(new Starter("cyndaquil", "fire"));
        starterPokemons.add(new Starter("totodile", "water"));
        // Gen 3
        starterPokemons.add(new Starter("treecko", "grass"));
        starterPokemons.add(new Starter("torchic", "fire"));
        starterPokemons.add(new Starter("mudkip", "water"));
        // Gen 4
        starterPokemons.add(new Starter("turtwig", "grass"));
        starterPokemons.add(new Starter("chimchar", "fire"));
        starterPokemons.add(new Starter("piplup", "water"));
        // Gen 5
        starterPokemons.add(new Starter("snivy", "grass"));
        starterPokemons.add(new Starter("tepig", "fire"));
        starterPokemons.add(new Starter("oshawott", "water"));
        // Gen 6
        starterPokemons.add(new Starter("chespin", "grass"));
        starterPokemons.add(new Starter("fennekin", "fire"));
        starterPokemons.add(new Starter("froakie", "water"));
        // Gen 7
        starterPokemons.add(new Starter("rowlet", "grass"));
        starterPokemons.add(new Starter("litten", "fire"));
        starterPokemons.add(new Starter("popplio", "water"));
        // Gen 8
        starterPokemons.add(new Starter("grookey", "grass"));
        starterPokemons.add(new Starter("scorbunny", "fire"));
        starterPokemons.add(new Starter("sobble", "water"));
        // Gen 9
        starterPokemons.add(new Starter("sprigatito", "grass"));
        starterPokemons.add(new Starter("fuecoco", "fire"));
        starterPokemons.add(new Starter("quaxly", "water"));
    }

    public String getStarters(String desiredType){
        addStarters();
        desiredType = desiredType.toLowerCase();
        Random rand = new Random();

        for(Starter starter : starterPokemons) {
            int pokemon = rand.nextInt(starterPokemons.size());
            if (starterPokemons.get(pokemon).type.equals(desiredType)) {
                return  starterPokemons.get(pokemon).name;
            }
        }
        return null;
    }
}
