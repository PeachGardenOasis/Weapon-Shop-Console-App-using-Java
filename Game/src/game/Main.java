package game;
// Simon Ung 101032525
// Chi Calvin Nguyen 101203877
import java.util.Scanner;

public class Main {

    public static int getInteger(Scanner sc,String message){
            System.out.print(message);
            while (!sc.hasNextInt()) 
            {
                sc.nextLine(); //clear the invalid input ...
                System.out.print(message);
            }
            return sc.nextInt();
        }
        
        public static double getDouble(Scanner sc,String message){
            System.out.print(message);
            while (!sc.hasNextDouble()) 
            {
                sc.nextLine(); //clear the invalid input ...
                System.out.print(message);
            }
            return sc.nextDouble();
        }
        // validate 0-10
        public static int validateRangeInput(Scanner sc, String message, int lower, int upper) {
        System.out.print(message);
        while (!sc.hasNextInt()) {
            sc.nextLine(); //clear the invalid input ...
            System.out.print(message);
        }
        int choice = sc.nextInt();
        while (true) {
            if (lower <= choice && upper >= choice) {
                return choice;
            } else {
                System.out.println("Range value is invalid.");
                return validateRangeInput(sc, message, lower, upper);
            }
        }
    }

    
        public static void addWeapons(ArrayManager h,Scanner sc)
        {
            System.out.println("***********WELCOME TO THE WEAPON ADDING MENU*********");
            String weaponName; int weaponRange; int weaponDamage; double weaponWeight; double weaponCost;
            int quantity;
            System.out.print("Please enter the NAME of the Weapon ('end' to quit):");
            weaponName=sc.next();
            while (weaponName.compareTo("end") != 0)
            {
                weaponRange= getInteger(sc,"Please enter the Range of the Weapon (0-10):"); 
                weaponDamage=getInteger(sc,"Please enter the Damage of the Weapon:"); 
                weaponWeight= getDouble(sc,"Please enter the Weight of the Weapon (in pounds):");
                weaponCost=getDouble(sc,"Please enter the Cost of the Weapon:");
                Weapon w = new Weapon(weaponName, weaponRange, weaponDamage, weaponWeight, weaponCost);
                quantity=getInteger(sc,"Please enter the quantity in stock:"); 
                h.put(w,quantity);
                System.out.print("Please enter the NAME of another Weapon ('end' to quit):");
                weaponName = sc.next().toLowerCase();;
            }
        }

        public static void deleteWeaponMenu(ArrayManager ht){
            System.out.println("***********WELCOME TO THE WEAPON DELETE MENU*********");
            ht.printTable("delete");
            System.out.println("Please select a weapon to delete('end' to quit):");
        }
        
        public static void deleteWeapon(ArrayManager ht, Scanner sc){
            
            String choice;
            deleteWeaponMenu(ht);
            choice = sc.next();
            while (choice.compareTo("end") != 0){
                if(ht.delete(choice)){
                    System.out.println(choice + " successfully deleted");
                }
                else {
                    System.out.println("Failed to delete: " + choice);
                }
                deleteWeaponMenu(ht);
                choice = sc.next();
            }
            System.out.println("");
        }

        public static void showRoomMenu(ArrayManager ht,Player p){
            System.out.println("WELCOME TO THE SHOWROOM!!!!");
            ht.printTable("buy");
            System.out.println("You have "+p.money+" money.");
            System.out.println("Please select a weapon to buy('end' to quit):");
        }
        
        public static void showRoom(ArrayManager ht, Player p,Scanner sc)
        {
            String choice;
            showRoomMenu(ht,p);
            choice=sc.next();
            while (choice.compareTo("end") != 0 && !p.inventoryFull() && p.overWeight() == true)
            {
                ShopItem si = ht.get(choice);
                if (si != null)
                {

                        p.buy(si.item);
                        p.withdraw(si.item.cost);
                        si.numberInStock--;
 
                }
                else
                {
                    System.out.println(" ** "+choice+" not found!! **" );
                }
                showRoomMenu(ht,p);
                choice = sc.next();
            }
            System.out.println("");
        }
        
        public static void displayMenu() {
        System.out.println("1) Add Items to the shop");
        System.out.println("2) Delete Items from the shop ");
        System.out.println("3) Buy from the Shop");
        System.out.println("4) View backpack");
        System.out.println("5) View Player");
        System.out.println("6) Exit");
    }
        public static void getDecision(ArrayManager ht, Player pl, Scanner sc) {
        String choice = "";
        while (!choice.equals("6")) {
            displayMenu();
            choice = sc.next();
            sc.nextLine();
            switch (choice) {
                case "1":
                    addWeapons(ht, sc);
                    break;
                case "2":
                    deleteWeapon(ht, sc);
                    break;
                case "3":
                    showRoom(ht, pl, sc);
                    break;
                case "4":
                    pl.printBackpack();
                    break;
                case "5":
                    pl.printCharacter();
                    break;
                case "6":
                    break;
                default:
                    System.out.println("Print a valid number");
                    break;
            }
        }
    }
    
        public static void main(String[] args)
        {
            Scanner sc = new Scanner(System.in);
            String pname;
            System.out.println("Please enter Player name:");
            pname=sc.next();
            Player pl= new Player(pname,45);
            ArrayManager ht= new ArrayManager(101,0.8);
            getDecision(ht,pl,sc);
        }
}
