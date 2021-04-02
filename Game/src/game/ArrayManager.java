package game;
// Simon Ung 101032525
// Chi Calvin Nguyen 101203877

public class ArrayManager {
    
        int maxItems;    // records the max size of the table
        int numItems;       // records number of items in the list
        ShopItem[] table; //hashtable itself
        public double loadFactor;
        
        public ArrayManager(int size, double loadFactor)
        {
            maxItems = size;
            numItems = 0;
            table = new ShopItem[maxItems];
            this.loadFactor=loadFactor;
        }
        
        public void put(Weapon item,int quantity)
        {
            if (numItems<maxItems){             
                table[numItems] = new ShopItem(item,quantity);
                numItems++;
            }

        }
        //quadratic probing hash function
        public int hashFunction(Weapon wp) {
        int value = 0, weight = 1;
        for (int i = 0; i < wp.weaponName.length(); i++) {
            value += (wp.weaponName.charAt(i) - 'a' + 1) * weight;
            weight++;
        }
        value += wp.cost + wp.damage + wp.range + wp.weight; 
        return value % tableSize;
    }


        public ShopItem get(String key)
        {
            int location = 0; //gets location in table based on key
            
            while (location <numItems && key.compareTo(table[location].item.weaponName) != 0)
            {  // not empty and not item
                location++;
            }
            if (location<numItems){
                return table[location];
            }
            return null;
        }

        public void printTable()
        {
            int count = 0;
            for (int x = 0; x < numItems; x++)
            {
                    System.out.println("Name: " +table[x].item.weaponName+"   Damage:"+table[x].item.damage+"    Cost:"+table[x].item.cost+"     Quantity in stock:"+table[x].numberInStock);
            }
        }
}

