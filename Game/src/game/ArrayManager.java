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

        // MODIFIED: Checks if item exists in array using hash function and returns it
        public ShopItem get(String key)
        {
            ShopItem toReturn = qp.get(table, key);
            return toReturn;
            
            /* LEGACY
            // Lowers complexity of hash function for faster get method
            int count = 1;
            int startLoc = qp.quadhashFunction2(key); // gets location in table based on key
            int loc = startLoc;
            
            // Exits when it finds an empty location or the matching item
            while (table[loc] != null && table[loc].item.weaponName.compareTo(key) != 0){
                loc = (startLoc + (count * count) % maxItems);
                count++;
            }
            
            // If the location's element matches the item, return the item
            if (table[loc] != null && table[loc].item.weaponName.compareTo(key) == 0){
                return table[loc];
            }
            
            return null;
            */
        }
        
        // TO DO: DELETE FUNCTION
        public void delete(String key){
            
        }

        public void printTable()
        {
            int count = 0;
            for (int x = 0; x < maxItems; x++)
            {   
                // Lists all weapons in the shop that are in stock (greater than 0)
                if(table[x] != null && table[x].numberInStock > 0){
                    System.out.println("Name: " +table[x].item.weaponName+"   Damage:"+table[x].item.damage+"    Cost:"+table[x].item.cost+"     Quantity in stock:"+table[x].numberInStock);
                }
            }
        }
}

