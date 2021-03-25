package game;
// Simon Ung 101032525
// Chi Calvin Nguyen 101203877

public class Backpack {
// Aggregation. the dependent object remains in the scope of a relationship even when the source object is destroyed.
// aggregation with player - backpack can exist with player class or without but player needs backpack to function
// aggregation with weapon - weapon can exist with backpack class or without but backpack needs weapon to function

    public int numItems;
    public int maxItems;
    public double currWeight;
    public double maxWeight;
    public String[] table;
    public int tableSize;
    

    public Backpack() {
        numItems = this.numItems;
        maxItems = this.maxItems;
        currWeight = 0;
        maxWeight = 80;
        table = new String[80];
        tableSize= 80;

        numItems=0;

    }
    
    public boolean add(Weapon k){
        
    }



}
