package game;
// Simon Ung 101032525
// Chi Calvin Nguyen 101203877
class Weapon
    {
        private String weaponName; 
        private int range;
        private int damage;
        private double weight;
        private double cost;

        public Weapon(String n, int rang, int dam, double w, double c)
        {
            weaponName = n;
            damage = dam;
            range = rang;
            weight = w;
            cost = c;
        }
        
        public String getWeaponName(){
            return weaponName;
        }
        
        public int getRange(){
            return range;
        }
        
        public int getDamage(){
            return damage;
        }
        
        public double getWeight(){
            return weight;
        }
        
        public double getCost(){
            return cost;
        }
    }

