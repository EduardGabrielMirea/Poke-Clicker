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

    /*public int id;
    public Root root;

    public class Chain{
        public boolean is_baby;
        public PokemonSpecies species;
        public Object evolution_details;
        public ArrayList<EvolvesTo> evolves_to;
    }

    public class EvolutionDetail{
        public Object item;
        public Trigger trigger;
        public Object gender;
        public Object held_item;
        public Object known_move;
        public Object known_move_type;
        public Object location;
        public int min_level;
        public Object min_happiness;
        public Object min_beauty;
        public Object min_affection;
        public boolean needs_overworld_rain;
        public Object party_species;
        public Object party_type;
        public Object relative_physical_stats;
        public String time_of_day;
        public Object trade_species;
        public boolean turn_upside_down;
    }

    public static class EvolvesTo{
        public boolean is_baby;
        public PokemonSpecies species;
        public ArrayList<EvolutionDetail> evolution_details;
        public ArrayList<Object> evolves_to;
    }

    public class Root{
        public int id;
        public Object baby_trigger_item;
        public Chain chain;
    }

    public class Trigger{
        public String name;
        public String url;
    }*/
}
