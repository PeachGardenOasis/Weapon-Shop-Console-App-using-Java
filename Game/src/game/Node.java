package game;
// Simon Ung 101032525
// Chi Calvin Nguyen 101203877

public class Node {

    // Class fields
    public Weapon data;
    public Node next;

    /*
        Constructor
    */
    public Node(Weapon data) {
        this.data = data;
        next = null;
    }
}
