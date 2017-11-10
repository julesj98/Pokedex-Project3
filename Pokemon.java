public class Pokemon {
    private int attack;
    private int defense;
    private int speed;
    private String species;

    public Pokemon(String species){
        this.species = species;
        attack = species.length() * 4 + 2;
        defense = species.length() * 2 + 7;
        speed = species.length() * 3 + 5;
    }
    public int getAttack(){
        return attack;
    }
    public void setAttack(int newAttack){
        attack = newAttack;
    }
    public int getDefense(){
        return defense;
    }
    public void setDefense(int newDefense){
        defense = newDefense;
    }
    public int getSpeed(){
        return speed;
    }
    public void setSpeed(int newSpeed){
        speed = newSpeed;
    }
    public String getSpecies(){
        return species;
    }
    public void setSpecies(String newSpecies){
        species = newSpecies;
    }
    public void evolve(){
        speed = 2 * speed;
        attack = 3 * attack;
        defense = 5 * defense;
    }
}
