package game;
// Simon Ung 101032525
// Chi Calvin Nguyen 101203877

public class Backpack {

    // Class fields
    private int numItems;               // Number of items in backpack
    private int maxItems;               // Maximum size of the array
    private double currWeight;          // The current weight of the backpack
    private double maxWeight;           // The maximum weight of the backpack
    private LinkedList[] table;         // The array to store weapons (hash table itself)
    private double loadFactor;          // The load factor of the hash table
    private HashFunctionMethods hfm;    // The hash function & methods

    /*
        Constructor
    */
    public Backpack(int size, double lf) {
        numItems = 0;
        maxItems = size;
        currWeight = 0;
        maxWeight = 90;
        loadFactor = lf;
        table = new LinkedList[maxItems];
        hfm = new HashFunctionMethods(maxItems);
    }
    
    /*
        Returns the current number of items in the backpack
    */
    public int getnumItems(){
        return numItems;
    }
    
    /*
        Returns a boolean
            Returns TRUE if new weapon's weight + current does not exceed maximum
            Returns FALSE if new weapon's weight + current does exceed maximum
    */
    public boolean weightCheck(double weight){
        if (((maxWeight - currWeight) - weight) >= 0){
            return true;
        } 
        return false;
    }

    /*
        buy() method, takes the weapon object from the shop and adds it to hash table
            Passes weapon + table to hfm.addBackpack()
                Purpose is to keep hash function itself private
    */
    public void buy(Weapon w){
        
        // Checks the amount of items in the bag
       if ((numItems/maxItems) < loadFactor){
            hfm.addBackpack(table, w);
            currWeight += w.getWeight();
            numItems++;
        }
    }
    
    /*
        printBackpack(), Returns string of all the weapon objects in the backpack
        Traverses the array (hash table), and linkedlists within each element of the array
    */
    public String printBackpack(){
        String s = "";
        
        // Traverses array
        for (int x = 0; x < maxItems; x++){
            
            // Traverses Linked List if element is not null (LinkedList exists)
            if (table[x] != null){
                Node currNode = table[x].head;
                while (currNode != null){
                    s += (" " + currNode.data.getWeaponName());
                    s += ("\n");
                    currNode = currNode.next;
                }
            }
        }
        
        // Returns string of all weapons
        return s;
    }
}
