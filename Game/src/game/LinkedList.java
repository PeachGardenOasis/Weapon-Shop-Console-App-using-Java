package game;
// Simon Ung 101032525
// Chi Calvin Nguyen 101203877

public class LinkedList {

    // Class fields
    public Node head;
    public int numItems;

    /*
        Construcor
    */
    public LinkedList() {
        head = null;
    }

    /*
        Adds node to the front of the linked list
    */
    public void addFront(Weapon data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        numItems++;
    }

    /*
        Adds node to the end of the linked list
    */
    public void addLast(Weapon data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            numItems++;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        numItems++;
        curr.next = newNode;
    }
}
