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
    private QuadraticProbing qp;

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
    
    public double getcurrWeight(){
        return currWeight;
    }
    
    // TO DO: ADD BUY METHOD
    public boolean buy(Weapon w){
        
        // Checks the amount of items in the bag & the weight
        if ((numItems/maxItems) < loadFactor && ((maxWeight - currWeight) - w.weight) >= 0){
            int loc = qp.quadhashFunction2(w.weaponName);
            
            if (table[loc] == null){
                LinkedList temp = new LinkedList();
                table[loc] = temp;
                table[loc].addFront(w);
            }
            else {
                table[loc].addLast(w);
            }
            currWeight = currWeight + w.weight;
            numItems++;
            return true;
        }
        else {
            return false;
        }
    }
}
