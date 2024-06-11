package poke.app.entity;

import java.util.List;

public class PokemonSpecies {
    public int id;
    public String name;
    public int base_happiness;
    public int capture_rate;
    public boolean is_legendary;
    public List<FlavorTextEntry> flavor_text_entries;
    int[] pokemonJefesIDs = {
            248, // Tyranitar (Gen 2)
            254, // Sceptile (Gen 3)
            260, // Swampert (Gen 3)
            373, // Salamence (Gen 3)
            376, // Metagross (Gen 3)
            448, // Lucario (Gen 4)
            450, // Hippowdon (Gen 4)
            464, // Rhyperior (Gen 4)
            497, // Serperior (Gen 5)
            503, // Samurott (Gen 5)
            530, // Excadrill (Gen 5)
            635, // Hydreigon (Gen 5)
            660, // Diggersby (Gen 6)
            681, // Aegislash (Gen 6)
            706, // Goodra (Gen 6)
            784, // Kommo-o (Gen 7)
            797, // Celesteela (Gen 7)
            806, // Blacephalon (Gen 7)
            850, // Centiskorch (Gen 8)
            860, // Grimmsnarl (Gen 8)
            887, // Dragapult (Gen 8)
            905  // Enamorus (Gen 8)

    };
    int[] primeraEtapaIDs = {
            19, // Rattata
            21, // Spearow
            27, // Sandshrew
            29, // Nidoran♀
            32, // Nidoran♂
            41, // Zubat
            46, // Paras
            48, // Venonat
            50, // Diglett
            52, // Meowth
            54, // Psyduck
            56, // Mankey
            58, // Growlithe
            60, // Poliwag
            63, // Abra
            66, // Machop
            69, // Bellsprout
            72, // Tentacool
            74, // Geodude
            77, // Ponyta
            79, // Slowpoke
            81, // Magnemite
            83, // Farfetch'd
            86, // Seel
            90, // Shellder
            92, // Gastly
            96, // Drowzee
            98, // Krabby
            100, // Voltorb
            102, // Exeggcute
            104, // Cubone
            108, // Lickitung
            109, // Koffing
            111, // Rhyhorn
            113, // Chansey
            114, // Tangela
            115, // Kangaskhan
            116, // Horsea
            118, // Goldeen
            120, // Staryu
            123, // Scyther
            124, // Jynx
            125, // Electabuzz
            126, // Magmar
            127, // Pinsir
            128, // Tauros
            129, // Magikarp
            131, // Lapras
            132, // Ditto
            133, // Eevee
            137, // Porygon
            138, // Omanyte
            140, // Kabuto
            142, // Aerodactyl
            143, // Snorlax
            147  // Dratini
    };

    int[] minionIDs = {
            175, // Togepi (Gen 2)
            176, // Togetic (Gen 2)
            183, // Marill (Gen 2)
            184, // Azumarill (Gen 2)
            198, // Murkrow (Gen 2)
            208, // Steelix (Gen 2)
            236, // Tyrogue (Gen 2)
            239, // Elekid (Gen 2)
            240, // Magby (Gen 2)
            280, // Ralts (Gen 3)
            281, // Kirlia (Gen 3)
            290, // Nincada (Gen 3)
            292, // Ninjask (Gen 3)
            322, // Numel (Gen 3)
            324, // Camerupt (Gen 3)
            328, // Trapinch (Gen 3)
            329, // Vibrava (Gen 3)
            355, // Duskull (Gen 3)
            356, // Dusclops (Gen 3)
            361, // Snorunt (Gen 3)
            362, // Glalie (Gen 3)
            371, // Bagon (Gen 3)
            372, // Shelgon (Gen 3)
            399, // Bidoof (Gen 4)
            400, // Bibarel (Gen 4)
            433, // Chingling (Gen 4)
            438, // Bonsly (Gen 4)
            439, // Mime Jr. (Gen 4)
            447, // Riolu (Gen 4)
            458, // Mantyke (Gen 4)
            519, // Pidove (Gen 5)
            520, // Tranquill (Gen 5)
            532, // Timburr (Gen 5)
            533, // Gurdurr (Gen 5)
            622, // Golett (Gen 5)
            623, // Golurk (Gen 5)
            677, // Espurr (Gen 6)
            678, // Meowstic (Gen 6)
            704, // Goomy (Gen 6)
            705, // Sliggoo (Gen 6)
            742, // Cutiefly (Gen 7)
            743, // Ribombee (Gen 7)
            859, // Impidimp (Gen 8)
            860, // Morgrem (Gen 8)
            872, // Snom (Gen 8)
            873  // Frosmoth (Gen 8)
    };


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
