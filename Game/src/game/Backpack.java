package game;
// Simon Ung 101032525
// Chi Calvin Nguyen 101203877
public class Backpack { 
// aggregation with player - backpack can exist with player class or decide not to
// aggregation with weapon - weapon can exist with backpack class or decide not to

    public int numItems;
    public int maxItems;
    public double currWeight;
    public double maxWeight;

    public Backpack(int numItems, int maxItems, double currWeight,double maxWeight) {
        numItems = this.numItems;
        maxItems = this.maxItems;
        currWeight = this.currWeight;
        maxWeight = this.maxWeight;
    }
}
