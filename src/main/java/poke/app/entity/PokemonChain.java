package poke.app.entity;

import java.util.ArrayList;

public class PokemonChain {
    public Chain chain;

    public class Chain{
        public boolean is_baby;
        public Species species;
        public ArrayList<EvolvesTo> evolves_to;

        public class EvolvesTo{
            public boolean is_baby;
            public Species species;
            public ArrayList<Object> evolves_to;
        }

        public class Species{
            public String name;
            public String url;
        }
    }


}
