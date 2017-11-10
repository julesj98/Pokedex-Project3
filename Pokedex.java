import java.util.Arrays;

public class Pokedex {
    private String[] pokedex;
    private int[] evolver;    //Array used to differentiate b/w evolved & un-evolved Pokemon
    private int numPokemon;
    private int maxDex;

    public Pokedex(int maxDex){
        this.maxDex = maxDex;
        pokedex = new String[this.maxDex];
        evolver = new int[this.maxDex];
    }

    public String[] listPokemon(){
        return pokedex;
    }

    public boolean addPokemon(String species){
        for (int i = 0; i < pokedex.length; i++){
            if(species.equalsIgnoreCase(pokedex[i])){
                return false;
            }
        }
        Pokemon newPoke = new Pokemon(species);
        pokedex[numPokemon] = newPoke.getSpecies();
        numPokemon++;
        return true;
    }

    public int[] checkStats(String species){
        int[] pokeStats = null;
        int[] emptyArray = new int[1];
        int i = 0;
        boolean pokeLoop = false;
        while (i < pokedex.length && !pokeLoop && pokedex[i] != null) {

            // Stats calculation for un-evolved Pokemon
            if (species.equalsIgnoreCase(pokedex[i]) && evolver[i] != 1) {
                pokeStats = new int[3];
                Pokemon poke = new Pokemon(species);
                poke.setSpecies(species);
                int attack = poke.getAttack();
                pokeStats[0] = attack;
                int defense = poke.getDefense();
                pokeStats[1] = defense;
                int speed = poke.getSpeed();
                pokeStats[2] = speed;
                pokeLoop = true;
            }

            //Stats calculation for evolved Pokemon
            else if(species.equalsIgnoreCase(pokedex[i]) && evolver[i] == 1){
                pokeStats = new int[3];
                Pokemon poke = new Pokemon(species);
                poke.setSpecies(species);
                poke.evolve();
                int attack = poke.getAttack();
                pokeStats[0] = attack;
                int defense = poke.getDefense();
                pokeStats[1] = defense;
                int speed = poke.getSpeed();
                pokeStats[2] = speed;
                pokeLoop = true;
            }
            i++;
        }
        if (!pokeLoop){
            return emptyArray;
        }
        return pokeStats;
    }

    public void sortPokedex(){
        int i = 0;
        while (pokedex[i] != null){
            i++;
        }
      Arrays.sort(pokedex, 0, i);
    }

    public boolean evolvePokemon (String species){
        int i = 0;
        int evolve = 0;
        while (i < pokedex.length && pokedex[i] != null && evolve == 0){
           if (!species.equalsIgnoreCase(pokedex[i])){
               i++;
           }
           else {
               evolver[i] = 1;
               evolve = 1;
           }
        }
        if (evolve == 0){
            return false;
        }
        return true;
    }
}
