package game;
// Simon Ung 101032525
// Chi Calvin Nguyen 101203877

public class Backpack {

    private int numItems;
    private int maxItems;
    private double currWeight;
    private double maxWeight;
    //use a hash table implemented as separate chaining to hold the items (weapons) bought.
    private LinkedList[] table;     // The array to store weapons
    private double loadFactor;
    private QuadraticProbing qp;    // The hash function & methods

    public Backpack(int size, double lf) {
        numItems = 0;
        maxItems = size;
        currWeight = 0;
        maxWeight = 90;
        loadFactor = lf;
        table = new LinkedList[maxItems];
        qp = new QuadraticProbing(maxItems);
    }
    
    public int getnumItems(){
        return numItems;
    }
    
    public boolean weightCheck(double weight){
        if (((maxWeight - currWeight) - weight) >= 0){
            return true;
        } 
        return false;
    }
    
    // TO DO: ADD BUY METHOD
    

    public void buy(Weapon w){
        
        // Checks the amount of items in the bag
       if ((numItems/maxItems) < loadFactor){
            qp.addBackpack(table, w);
            currWeight += w.getWeight();
            numItems++;
        }
    }
}
