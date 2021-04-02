package game;
// Simon Ung 101032525
// Chi Calvin Nguyen 101203877

// need to work on 2) delete weapon ,4) view backpack, 5)view player

public class Backpack {

    private int numItems;
    private int maxItems;
    private double currWeight;
    private double maxWeight;
    
    private Weapon[] weaponTable;
    private int tableSize;
    private double loadFactor;

    public Backpack() {
        weaponTable = new Weapon[80];
        maxItems = 80;  // max # of weapons is 80
        Weapon temp = new Weapon("EMPTY", -1, -1, -1, -1);
        for (int x = 0; x < tableSize; x++) {
            weaponTable[x] = temp;
        }
        loadFactor = 0.70;
        numItems = 0;

    }


    private int quadHashFunction(Weapon weapon) {
        int value = 0;
        for (int x = 0; x < weapon.weaponName.length(); x++) {
            value += (weapon.weaponName.charAt(x) - 'a' + 1);
        }
        for (int y = 0; y < weapon.weaponName.length(); y++) {
            value += (weapon.weaponName.charAt(y) - 'a' + 2);
        }
        value += weapon.range + weapon.damage + weapon.weight + weapon.cost;

        return value % tableSize;
    }

    
    public boolean add(Weapon weapon, int quantity){
        if(numItems/tableSize < loadFactor){
            int loc = quadHashFunction(weapon);
            int count = 1;
            int start = loc;
            while(weaponTable[loc].weaponName.compareTo("EMPTY") != 0 && weaponTable[loc].range != -1 
                    && weaponTable[loc].damage != -1 && weaponTable[loc].weight != -1 && weaponTable[loc].cost != -1){
                loc = (start + (count * count)) % tableSize;
                count++;
            }
            weaponTable[loc] = weapon;
            return true;
        }
        return false;
    }
    
    
    public boolean delete(Weapon weapon){ //delete weapon
       int loc = quadHashFunction(weapon);
       int count = 1;
       int start = loc;
        while (weaponTable[loc].weaponName.compareTo(weapon.weaponName) != 0) {
            loc = (start + (count * count)) % tableSize;
            count++;
        }
        if (weaponTable[loc].weaponName.compareTo("EMPTY") != 0 && weaponTable[loc].range != -1) {
            weaponTable[loc].weaponName = "DELETED";
            weaponTable[loc].range = -1;
            weaponTable[loc].damage = -1;
            weaponTable[loc].weight = -1;
            weaponTable[loc].cost = -1;
            numItems--;
            return true;
        }
        return false;
    }
}
