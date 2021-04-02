package game;
// Simon Ung 101032525
// Chi Calvin Nguyen 101203877
public class Weapon {

    public String weaponName;
    public int range;
    public int damage;
    public double weight;
    public double cost;

    public Weapon(String weaponName,int range, int damage, double weight, double cost) {
        this.weaponName = weaponName;
        this.range = range;
        this.damage = damage;
        this.weight = weight;
        this.cost = cost;
    }
}
