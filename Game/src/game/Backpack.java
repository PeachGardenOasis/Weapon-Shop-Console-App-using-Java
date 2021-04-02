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


    
}
