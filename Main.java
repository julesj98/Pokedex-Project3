import java.util.*;
public class Main {
    public static void main(String[] args) {

        //Some important variables
        Scanner scnr = new Scanner(System.in);
        int[] stats;
        boolean start = true;
        int maxDex = 0;
        int numPokemon = 0;

        //
        //Start of Program
        //
        System.out.println("Welcome to your new PokeDex!");
        while (start) {
            try {
                System.out.print("How many Pokemon are in your region: ");
                maxDex = scnr.nextInt();
                start = false;
            }
            catch (InputMismatchException a) {
                System.out.println("");
                System.out.println("Please enter a valid integer");
                System.out.println("");
                scnr.nextLine();
            }
        }
        Pokedex pocket = new Pokedex(maxDex);
        String[] list = pocket.listPokemon();

        System.out.println("");
        System.out.println("Your new Pokedex can hold " + maxDex + " Pokemon." +
                " Let's start using it!");
        System.out.println("");
        int userInput = 0;
        String poke = "";
        boolean dexTime = true;

        //Let's Catch 'em all!
        while (dexTime) {
            try {
                System.out.print("1. List Pokemon\n2. Add Pokemon\n3. Check" +
                        " a Pokemon's Stats\n4. Evolve Pokemon\n5. Sort Pokemon\n6. Exit\n");
                System.out.println("");
                System.out.print("What would you like to do? ");
                userInput = scnr.nextInt();

                //List Pokemon
                if (userInput == 1){
                   if (numPokemon == 0){
                        System.out.println("");
                        System.out.println("Add a pokemon to your Pokedex first!");
                        System.out.println("");
                   }
                   else {
                       int i = 0;
                       while (i < numPokemon) {
                           System.out.println((i + 1) + ". " + list[i]);
                           i++;
                       }
                       System.out.println("");
                   }
                }

                //Add Pokemon
                else if (userInput == 2) {
                    System.out.println("");
                    System.out.print("Please enter the Pokemon's Species: ");
                    poke = scnr.next();
                    if (numPokemon == maxDex){
                        System.out.println("Max");
                    }
                    else if (!pocket.addPokemon(poke)){
                        System.out.println("Duplicate");
                    }
                    else {
                        pocket.addPokemon(poke);
                        numPokemon++;
                    }
                    System.out.println("");
                }

                //Check a Pokemon's Stats
                else if (userInput == 3) {
                    System.out.println("");
                    System.out.print("Please enter the Pokemon of interest: ");
                    poke = scnr.next();
                    if (numPokemon == 0) {
                        System.out.println("");
                        System.out.println("Add a pokemon to your Pokedex first!");
                        System.out.println("");
                    }
                    else {
                        int i = 0;
                        stats = pocket.checkStats(poke);
                        boolean checkStats = true;
                        while (i < numPokemon && checkStats) {
                            if (poke.equalsIgnoreCase(list[i])) {
                                System.out.println("\nThe stats for " + list[i] + " are:");
                                System.out.println("Attack: " + stats[0] + "\nDefense: " + stats[1] +
                                        "\nSpeed: " + stats[2] + "\n");
                                checkStats = false;
                            }
                            else {
                                i++;
                            }
                        }
                        if (checkStats){
                            System.out.println("Missing\n");
                        }
                    }
                }

                //Evolve Pokemon
                else if(userInput == 4) {
                    if(numPokemon == 0){
                        System.out.println("");
                        System.out.println("Add a pokemon to your Pokedex first!");
                        System.out.println("");
                    }
                    else {
                        System.out.print("\nEnter the Pokemon of interest: ");
                        poke = scnr.next();
                        if (!pocket.evolvePokemon(poke)) {
                            System.out.println("Missing\n");
                        }
                        else if (pocket.evolvePokemon(poke)) {
                            System.out.println(poke + " has evolved!\n");
                        }
                    }
                }

                //Sort Pokemon
                else if(userInput == 5){
                    if (numPokemon == 0) {
                        System.out.println("");
                        System.out.println("Add a pokemon to your Pokedex first!");
                        System.out.println("");
                    }
                    else {
                        pocket.sortPokedex();
                        list = pocket.listPokemon();
                        System.out.println("");
                    }
                }

                //Exit
                else if(userInput == 6){
                    System.exit(0);
                }

                //Invalid int error print statement
                else if(userInput < 1 || userInput > 6){
                    System.out.println("\nThat is not a valid choice. Try again.\n");
                }
            }

            //InputMismatchException
            catch (InputMismatchException a) {
                System.out.println("");
                System.out.println("That is not a valid choice. Try again.\n");
                scnr.nextLine();
            }
        }
    }
}


