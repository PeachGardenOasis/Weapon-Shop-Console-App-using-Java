package game;
// Simon Ung 101032525
// Chi Calvin Nguyen 101203877

public class HashFunctionMethods {
    
    // Class fields
    private final int tableSize;    // Used to loop within the array size
    
    /*
        Constructor
    */
    public HashFunctionMethods(int size){
        tableSize = size;
    }
    
    /*
        hashFunction2() method gives a value to an int based on the string given
            Gives up on design complexity of the hash function
            In return makes it so delete & search uses the hash function
                since delete & search are only given strings
    */
    private int hashFunction2(String w){
        int value = 0, weight = 1;
        
        for (int i = 0; i < w.length(); i++){
            value += (w.charAt(i)-'a'+1)*weight;
            weight++;
        }
        
        value *= weight;
        return value % tableSize;
    }
    
    /*
        addShop() method adds a shopItem to the shopItem[] table
        IF the new item must not match the name of the collision use quadratic probing
        IF the new item matches the name of the collison add stock to the current item
    */
    public void addShop(ShopItem[] table, Weapon item, int quantity){
        
        // Hash Function Location
        int count = 1;
        int startLoc = hashFunction2(item.getWeaponName());
        
        if (startLoc < 0){
            return;
        }
        
        int loc = startLoc;
        
        // Quadratic probing, finds empty location or location of matching item
        while (table[loc] != null && table[loc].item.getWeaponName().compareTo(item.getWeaponName()) != 0){  
            loc = (startLoc + (count * count) % tableSize);
            count++;
        }
        
        // Checks if item at location has matching name, adds stock if true
        if (table[loc] != null && table[loc].item.getWeaponName().compareTo(item.getWeaponName()) == 0){
            table[loc].numberInStock = table[loc].numberInStock + quantity;
            return;
        }
        
        table[loc] = new ShopItem(item,quantity);
    }
    
    /*
        getShop() method uses the String key to find a Shopitem object and return it
        Uses quadratic probing to resolve any collisions that do not match weapon name
    */
    public ShopItem getShop(ShopItem[] table, String key){
        
        int count = 1;
        int startLoc = hashFunction2(key); // gets location in table based on key
        int loc = startLoc;

        if (startLoc < 0){
            return null;
        }
        
        // Exits when it finds an empty location or the matching item
        while (table[loc] != null && table[loc].item.getWeaponName().compareTo(key) != 0){
            loc = (startLoc + (count * count) % tableSize);
            count++;
        }

        // If the location's element matches the item, return the item
        if (table[loc] != null && table[loc].item.getWeaponName().compareTo(key) == 0){
            return table[loc];
        }

        return null;
    }
    
    /*
        deleteShop() method uses the String key to find a Shopitem object and delete it
        Uses quadratic probing to resolve any collisions that do not match weapon name
    */
    public boolean deleteShop(ShopItem[] table, String key){
        
        int count = 1;
        int startLoc = hashFunction2(key);
        int loc = startLoc;
        
        if (startLoc < 0){
            return false;
        }
        
        // Exits when it finds an empty location or the matching item
        while(table[loc] != null && table[loc].item.getWeaponName().compareTo(key) != 0){
            loc = (startLoc + (count * count) % tableSize);
            count++;
        }
        
        // If the location's element matches the item, delete the item
        if (table[loc] != null && table[loc].item.getWeaponName().compareTo(key) == 0){
            table[loc] = null;
            return true;
        }

        return false;
    }
    
    /*
        addBackpack() method adds a weapon to the backpack hash table
        Uses seperate chaining to resolve any collisions
    */
    public void addBackpack(LinkedList[] table, Weapon item){
        int loc = hashFunction2(item.getWeaponName());
        
        if (loc < 0) {
            return;
        }
        
        // If location is null (no weapon/linkedlist) add linkedlist + weapon
        if (table[loc] == null){
            LinkedList temp = new LinkedList();
            table[loc] = temp;
            table[loc].addFront(item);
        }
        // If location is not null (weapon/linkedlist exists) add to end of linked list
        else {
            table[loc].addLast(item);
        }
    }
}