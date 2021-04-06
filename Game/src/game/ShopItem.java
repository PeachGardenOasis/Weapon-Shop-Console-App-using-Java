package game;
// Simon Ung 101032525
// Chi Calvin Nguyen 101203877
public class ShopItem {

    // Class fields
    Weapon item;            // Weapon object
    int numberInStock;      // stock of the weapon object

    /*
        Constructor
    */
    public ShopItem(Weapon w, int nInStock) {
        item = w;
        numberInStock = nInStock;
    }
    
    @Override
    public String toString() {
        return ("Name: " + item.getWeaponName() + "   Damage:" + item.getDamage() + "    Cost:" + item.getCost() + "     Quantity in stock:" + numberInStock);
    }
}
