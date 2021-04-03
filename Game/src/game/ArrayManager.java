package game;
// Simon Ung 101032525
// Chi Calvin Nguyen 101203877

public class ArrayManager {
    
        int maxItems;                   // records the max size of the table
        int numItems;                   // records number of items in the list
        ShopItem[] table;               // hashtable itself
        public double loadFactor;       // load factor of hash table
        private QuadraticProbing qp;    // hash function
        
        public ArrayManager(int size, double loadFactor)
        {
            maxItems = size;
            numItems = 0;
            table = new ShopItem[maxItems];
            this.loadFactor = loadFactor;
            qp = new QuadraticProbing(maxItems);
        }
        
        // MODIFIED: Hash Function, Check for existing items & Quadratic Probing
        public void put(Weapon item,int quantity)
        {
            if ((numItems/maxItems) < loadFactor){
                
                qp.add(table, item, quantity);
                numItems++;
                
                /* LEGACY
                // Hash Function Location
                int count = 1;
                int startLoc = qp.quadhashFunction(item);
                int loc = startLoc;
                
                // Quadratic probing, finds empty location or location of matching item
                while (table[loc] != null && table[loc].item.weaponName.compareTo(item.weaponName) != 0){  
                    loc = (startLoc + (count * count) % maxItems);
                    count++;
                }
                
                // Checks if item at location has matching name, adds stock if true
                if (table[loc] != null && table[loc].item.weaponName.compareTo(item.weaponName) == 0){
                    table[loc].numberInStock = table[loc].numberInStock + quantity;
                    return;
                }
                
                table[loc] = new ShopItem(item,quantity);
                numItems++;
                return;
                */
            }

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
            for (int x = 0; x < maxItems; x++)
            {
                if(table[x] != null){
                    System.out.println("Name: " +table[x].item.weaponName+"   Damage:"+table[x].item.damage+"    Cost:"+table[x].item.cost+"     Quantity in stock:"+table[x].numberInStock);
                }
            }
        }
}

