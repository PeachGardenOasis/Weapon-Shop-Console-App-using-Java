package game;
// Simon Ung 101032525
// Chi Calvin Nguyen 101203877

public class QuadraticProbing {
    private final int tableSize;
    
    public QuadraticProbing(int size){
        tableSize = size;
    }
    
    public int quadhashFunction(Weapon w) {
        int value=0,weight=1;
        for(int i=0;i<w.weaponName.length();i++){
            value+=(w.weaponName.charAt(i)-'a'+1)*weight;
            weight++;
        }
        value += w.damage + w.range + w.weight + w.cost; // wasnt searching properly with this
        return value % tableSize;
    }
    
    public void add(ShopItem[] table, Weapon item, int quantity){
        int count = 1;
        int startLoc = quadhashFunction(item);
        int loc = startLoc;
        
        while (table[loc] != null && table[loc].item.weaponName.compareTo(item.weaponName) != 0){  
            loc = (startLoc + (count * count) % tableSize);
            count++;
        }
        
        if (table[loc] != null && table[loc].item.weaponName.compareTo(item.weaponName) == 0){
            table[loc].numberInStock = table[loc].numberInStock + quantity;
            return;
        }
        
        table[loc] = new ShopItem(item,quantity);
        return;
    }
}