package game;
// Simon Ung 101032525
// Chi Calvin Nguyen 101203877

public class QuadraticProbing {
    private final int tableSize;
    
    public QuadraticProbing(int size){
        tableSize = size;
    }
    
    // Gives up on design of hash function to make search/get more simple
    private int quadhashFunction2(String w){
        int value = 0, weight = 1;
        
        for (int i = 0; i < w.length(); i++){
            value += (w.charAt(i)-'a'+1)*weight;
            weight++;
        }
        
        value *= weight;
        return value % tableSize;
    }
    
    // Uses quadratic probing
    public void addShop(ShopItem[] table, Weapon item, int quantity){
        
        // Hash Function Location
        int count = 1;
        int startLoc = quadhashFunction2(item.getWeaponName());
        
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
    
    public ShopItem getShop(ShopItem[] table, String key){
        
        int count = 1;
        int startLoc = quadhashFunction2(key); // gets location in table based on key
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
    
    public boolean deleteShop(ShopItem[] table, String key){
        
        int count = 1;
        int startLoc = quadhashFunction2(key);
        int loc = startLoc;
        
        if (startLoc < 0){
            return false;
        }
        
        while(table[loc] != null && table[loc].item.getWeaponName().compareTo(key) != 0){
            loc = (startLoc + (count * count) % tableSize);
            count++;
        }
        
        if (table[loc] != null && table[loc].item.getWeaponName().compareTo(key) == 0){
            table[loc] = null;
            return true;
        }

        return false;
    }
    
    // Uses seperate chaining
    public void addBackpack(LinkedList[] table, Weapon item){
        int loc = quadhashFunction2(item.getWeaponName());
        
        if (loc < 0) {
            return;
        }
        
        if (table[loc] == null){
            LinkedList temp = new LinkedList();
            table[loc] = temp;
            table[loc].addFront(item);
        }
        else {
            table[loc].addLast(item);
        }
    }
}