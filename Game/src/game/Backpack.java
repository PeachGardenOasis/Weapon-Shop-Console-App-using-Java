package game;
// Simon Ung 101032525
// Chi Calvin Nguyen 101203877
public class Backpack {

    private int numItems;
    private int maxItems;
    private double currWeight;
    private double maxWeight;
    //use a hash table implemented as separate chaining to hold the items (weapons) bought.
    private LinkedList[] table; 
    
    
    private double loadFactor;

    public Backpack(int size, double lf) {
        numItems = 0;
        maxItems = size;
        currWeight = 0;
        maxWeight = 90;
        loadFactor = lf;
        table = new LinkedList[maxItems];
        

    }

    
    
}
