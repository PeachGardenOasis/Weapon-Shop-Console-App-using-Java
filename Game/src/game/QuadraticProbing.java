package game;
// Simon Ung 101032525
// Chi Calvin Nguyen 101203877

public class QuadraticProbing {
    private final int tableSize;
    private final double loadFactor;
    
    public QuadraticProbing(){
        tableSize = 100; // Table Size of 100, max weapons = 80
        loadFactor = 0.8; // Load Factor 0.8
    }
    
    public int quadhashFunction(Weapon w) {
        int value=0,weight=1;
        for(int i=0;i<w.weaponName.length();i++){
            value+=(w.weaponName.charAt(i)-'a'+1)*weight;
            weight++;
        }
        value += w.damage + w.range + w.weight + w.cost; // wasnt searching properly with this
        return value % tableSize;
    }
}