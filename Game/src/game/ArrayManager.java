package game;
// Simon Ung 101032525
// Chi Calvin Nguyen 101203877

public class ArrayManager {
        
        // Class Fields
        private int maxItems;               // records the max size of the table
        private int numItems;               // records number of items in the list
        private ShopItem[] table;           // hashtable itself
        private double loadFactor;          // load factor of hash table
        private HashFunctionMethods hfm;    // hash function & methods
        
        /*
            Constructor
        */
        public ArrayManager(int size, double loadFactor)
        {
            maxItems = size;
            numItems = 0;
            table = new ShopItem[maxItems];
            this.loadFactor = loadFactor;
            hfm = new HashFunctionMethods(maxItems);
        }
        
        /*
            put() method adds weapon object to the hash table
                if numItems is less than the loadFactor of maxItems
            Passes the weapon, hash table, & quantity to hfm.addShop()
                Purpose is to keep the hash function itself private
        */
        public void put(Weapon item,int quantity)
        {
            if ((numItems/maxItems) < loadFactor){
                
                hfm.addShop(table, item, quantity);
                numItems++;
            }
        }

        /*
            get() method uses a string and returns the ShopItem if found
            Passes the string & table to hfm.getShop()
                Purpose is to keep the hash function itself private
        */
        public ShopItem get(String key)
        {
            ShopItem toReturn = hfm.getShop(table, key);
            return toReturn;
        }
        
        /*
            delete() method uses a string and deletes the ShopItem if found
            Passes the string & table to hfm.deleteShop()
                Purpose is to keep the hash function itself private
        */
        public boolean delete(String key){
            
            boolean toReturn = hfm.deleteShop(table, key);
            numItems--;
            return toReturn;
        }

        /*
            printTable() method receives a string
                If the string is "buy" then it prints items IN STOCK
                If the string is "delete" then it prints ALL items
        */
        public void printTable(String s)
        {
            int count = 0;
            for (int x = 0; x < maxItems; x++)
            {   
                if(s.compareTo("delete") == 0){
                    if(table[x] != null){
                        System.out.println("Name: " +table[x].item.getWeaponName()+"   Damage:"+table[x].item.getDamage()+"    Cost:"+table[x].item.getCost()+"     Quantity in stock:"+table[x].numberInStock);
                    }
                }
                if(s.compareTo("buy") == 0){
                    // Lists all weapons in the shop that are in stock (greater than 0)
                    if(table[x] != null && table[x].numberInStock > 0){
                        System.out.println("Name: " +table[x].item.getWeaponName()+"   Damage:"+table[x].item.getDamage()+"    Cost:"+table[x].item.getCost()+"     Quantity in stock:"+table[x].numberInStock);
                    }
                }
            }
        }
}

