package game;
// Simon Ung 101032525
// Chi Calvin Nguyen 101203877
class Weapon {
    
    // Class fields
    private String weaponName; 
    private int range;
    private int damage;
    private double weight;
    private double cost;

    /*
        Constructor
    */
    public Weapon(String n, int rang, int dam, double w, double c)
    {
        weaponName = n;
        damage = dam;
        range = rang;
        weight = w;
        cost = c;
    }

    /*
        GETTERS
    */
    public String getWeaponName(){
        return weaponName;
    }

    public int getRange(){
        return range;
    }

    public int getDamage(){
        return damage;
    }

    public double getWeight(){
        return weight;
    }

    public double getCost(){
        return cost;
    }
}

