package game;
// Simon Ung 101032525
// Chi Calvin Nguyen 101203877

public class ArrayManager {

    int maxItems;    
    int numItems;     
    ShopItem[] table; 

    public ArrayManager() {
        maxItems = 80;
        numItems = 0;
        table = new ShopItem[maxItems];
        loadFactor = 0.75;
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

        return value % maxItems;
    }

    
    public boolean add(Weapon weapon, int quantity){
        if(numItems/table < loadFactor){
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
    
//    public void put(Weapon item, int quantity) { //adds weapon
//        if (numItems < maxItems) {
//            table[numItems] = new ShopItem(item, quantity);
//            numItems++;
//        }
//
//    }
//    public void deleteKey(String key) { // delete key of weapon
//        root = deleteRec(root, key);
//    }


public ShopItem get(String key) {
        int location = 0; //gets location in table based on key

        while (location < numItems && key.compareTo(table[location].item.weaponName) != 0) {  // not empty and not item
            location++;
        }
        if (location < numItems) {
            return table[location];
        }
        return null;
    }

    public void printTable() {
        int count = 0;
        for (int x = 0; x < numItems; x++) {
            System.out.println("Name: " + table[x].item.weaponName + "   Damage:" + table[x].item.damage + "    Cost:" + table[x].item.cost + "     Quantity in stock:" + table[x].numberInStock);
        }
    }
}
