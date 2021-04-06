package game;
// Simon Ung 101032525
// Chi Calvin Nguyen 101203877
class Player {
    
    // Class fields
    private String name;    // Player's name
    private double money;   // Amount of money player has
    private Backpack bp;    // Backpack object

    /*
        Constructor
    */
    public Player(String n, double m)
    {
        name = n;
        money = m;
        bp = new Backpack(38, 0.8);
    }

    /*
        buy() method passes the weapon & calls the bp.buy() method
    */
    public void buy(Weapon w)
    {       
        bp.buy(w);
        System.out.println(w.getWeaponName()+" bought...");
        System.out.println(bp.getnumItems());
    }
    
    /*
        withdraw() method subtracts cost from player's money when purchase succeeds
    */
    public void withdraw(double amt)
    {
        money = money - amt;
    }

    /*
        getName() method returns the players name
    */
    public String getName(){
        return name;
    }

    /*
        getMoney() method returns int of the players money
    */
    public double getMoney(){
        return money;
    }

    /*
        inventoryFull() method returns boolean if the backpack is full
            TRUE if full
            FALSE if not full
    */
    public boolean inventoryFull()
    {
        return (bp.getnumItems() == 30) ;
    }

    /*
        fundsCheck() method 
        checks if the cost of the item is more than what the player has
    */
    public boolean fundsCheck(double cost){
        return ((money - cost) >= 0);
    }

    /*
        weightCheck() method
        checks if the wieght of the item is more than what the player can carry
    */
    public boolean weightCheck(double weight){
        return (bp.weightCheck(weight));
    }

    /*
        printCharacter() method
        Prints all information of the player character
    */
    public void printCharacter()
    {
        System.out.println(" Name:"+name+"\n Money:"+money);
        printBackpack();
    }

    /*
        printBackpack() method
        Prints all weapons in the backpack
    */
    public void printBackpack()
    {
        System.out.println(" " + name + ", you own " + bp.getnumItems() + " Weapons:");
        System.out.println(bp.printBackpack());
        System.out.println();
    }
}

