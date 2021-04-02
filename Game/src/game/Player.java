package game;
// Simon Ung 101032525
// Chi Calvin Nguyen 101203877
public class Player {

    public String name;
    public Backpack backpack;
    public int numItems;
    public int money; // int instead of double because UML says so

    public Player(String n, int m) {
        name = n;
        money = m;
        numItems = 0;
        backpack = new Backpack();
        
       
    }

      public void buy(Weapon w)
        {
            System.out.println(w.weaponName+" bought...");
            backpack[numItems] = w;
            numItems++;
            System.out.println(numItems);
        }
        public void withdraw(double amt)
        {
            money = money - amt;
        }

        public boolean inventoryFull()
        {
            return (numItems == 10) ;
        }

        public void printCharacter()
        {
            System.out.println(" Name:"+name+"\n Money:"+money);
            printBackpack();
        }

        public void printBackpack()
        {
            System.out.println(" "+name+", you own "+numItems+" Weapons:");
            for (int x = 0; x < numItems; x++)
            {
                System.out.println(" "+backpack[x].weaponName);
            }
            System.out.println();
        }
    }
