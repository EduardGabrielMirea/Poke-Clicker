package poke.app.entity;

import java.util.ArrayList;
import java.util.List;

public class PokemonSpecies {
    public int id;
    public String name;
    public String url;
    public int base_happiness;
    public int capture_rate;
    public boolean is_legendary;
    public List<FlavorTextEntry> flavor_text_entries;

    public static class FlavorTextEntry {
        public String flavor_text;
        public Language language;
        public Version version;

        public static class Language {
            public String name;
            public String url;
        }

        public static class Version {
            public String name;
            public String url;
        }
    }
}
