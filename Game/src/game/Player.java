package game;
// Simon Ung 101032525
// Chi Calvin Nguyen 101203877
class Player
    {
        public String name;
        public double money;
        public Backpack bp;

        public Player(String n, double m)
        {
            name = n;
            money = m;
            bp = new Backpack(38, 0.8);
        }

        // MODIFIED: Uses backpack add method
        public void buy(Weapon w)
        {       
            bp.buy(w);
            System.out.println(w.weaponName+" bought...");
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
        
        public boolean overWeight(double weight){
            return (bp.weightCheck(weight));
        }

        public void printCharacter()
        {
            System.out.println(" Name:"+name+"\n Money:"+money);
            printBackpack();
        }

        // TO EDIT: get string from backpack object & print
        public void printBackpack()
        {
            System.out.println(" " + name + ", you own " + bp.getnumItems() + " Weapons:");
            /*
             System.out.println(" "+name+", you own "+numItems+" Weapons:");
            for (int x = 0; x < bp.getnumItems(); x++)
            {
                 System.out.println(" "+backpack[x].weaponName);
            }
            System.out.println();
            */
        }
    }

