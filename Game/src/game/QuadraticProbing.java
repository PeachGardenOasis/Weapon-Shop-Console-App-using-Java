package game;
// Simon Ung 101032525
// Chi Calvin Nguyen 101203877

public class QuadraticProbing {
    private final int tableSize;
    public QuadraticProbing(int ts){
        tableSize= ts;
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