package game;
// Simon Ung 101032525
// Chi Calvin Nguyen 101203877
class Player
    {
        public String name;
        public double money;
        public Backpack bp;
        
        public Weapon[] backpack;   // TO EDIT
        public int numItems;        // TO EDIT

        public Player(String n, double m)
        {
            name = n;
            money = m;
            numItems = 0;
            backpack = new Weapon[10];
            bp = new Backpack(38, 0.8);
        }

        // TO DO: MODIFY METHOD TO USE proper backpack & modify backpack to add to linked list
        public void buy(Weapon w)
        {
            bp.buy(w);
            System.out.println(w.weaponName+" bought...");
            
            
            backpack[numItems] = w;
            numItems++;
            System.out.println(bp.getnumItems());
        }
        public void withdraw(double amt)
        {
            money = money - amt;
        }

        public boolean inventoryFull()
        {
            return (bp.getnumItems() == 30) ;
        }
        
        public boolean overWeight(){
            return (bp.getcurrWeight() < 90);
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

