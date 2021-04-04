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
            }
        }

        // MODIFIED: Checks if item exists in array using hash function and returns it
        public ShopItem get(String key)
        {
            ShopItem toReturn = qp.get(table, key);
            return toReturn;
        }
        
        // ADDED: DELETE FUNCTION, TO DO: DELETE MENU
        public boolean delete(String key){
            
            boolean toReturn = qp.delete(table, key);
            numItems--;
            return toReturn;
        }

        // MODIFIED: Changes output depending if delete or buy 
        // DELETE WILL SHOW ITEMS WITH 0 STOCK
        public void printTable(String s)
        {
            int count = 0;
            for (int x = 0; x < maxItems; x++)
            {   
                if(s.compareTo("delete") == 0){
                    if(table[x] != null){
                        System.out.println("Name: " +table[x].item.weaponName+"   Damage:"+table[x].item.damage+"    Cost:"+table[x].item.cost+"     Quantity in stock:"+table[x].numberInStock);
                    }
                }
                if(s.compareTo("buy") == 0){
                    // Lists all weapons in the shop that are in stock (greater than 0)
                    if(table[x] != null && table[x].numberInStock > 0){
                        System.out.println("Name: " +table[x].item.weaponName+"   Damage:"+table[x].item.damage+"    Cost:"+table[x].item.cost+"     Quantity in stock:"+table[x].numberInStock);
                    }
                }
            }
        }
}

