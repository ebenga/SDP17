/*Contains the inventory of the player as well as the player stats
 * will house functions for checking inventory, adding/removing items from inventory
 * adding/removing from inventory should refresh HP/CP
 * pointer to next player in order
 * adding/removing health in combat
 * where the player is
 * LED color, player looks, other customizations
 */
public class Player {

	private Player next;
	private boolean finalPlayer = false;
	private String homeKingdom;
	private int gold = 100;
	private int HP = 100;
	private int effectiveHP = HP;
	private int CP = 20;
	private int Food = 5;
	private boolean Lost = false;
	private boolean Slowed = false;
	private boolean Diseased = false;
	private boolean Robbed = false;
	private boolean Starving = false;
	private boolean[] Keys = {false,false,false};
	private Potion potion;
	private Trap trap;
	private Armor armor;
	private Weapon weapon;
	private MagicItem magicItem;
	private Space currentSpace;
	private int Drounds = 0;
	private int Rrounds = 0;
	private int Srounds = 0;
	private int Lrounds = 0;
	private int rate = 1;
	
	public String getHomeKingdom(){
		return homeKingdom;
	}
	public void setHomeKingdom(String s){
		homeKingdom = s;
	}
	
	public void makeFinalPlayer(){
		finalPlayer = true;
	}
	public boolean isFinalPlayer(){
		return finalPlayer;
	}
	
	public void setNextPlayer(Player p){
		next = p;
	}
	public Player nextPlayer() {
		//returns the next player
		Drounds++;
		Rrounds++;
		Srounds++;
		Lrounds++;
		return next;
	}
	
	public int getHealthPoints() {
		// returns health points
		return HP;
	}
	public void setHealthPoints(int h) {
		// sets the player's hp
		HP = h;
	}

	public int getCombatPower() {
		// returns cp
		return CP;
	}
	public void setCombatPower(int c) {
		// sets cp
		CP = c;
	}
	
	public int getGold() {
		return gold;
	}
	public void setGold(int g) {
		gold = g;
	}

	public int getFood() {
		return Food;
	}
	public void setFood(int f) {
		Food = f;
	}
	public void Eat(){
		Food -= rate;
	}

	public boolean[] getKeys() {
		//{courage, wisdom, strength}
		return Keys;
	}
	public void setKeyofCourage(boolean state) {
		Keys[0] = state;
	}
	public void setKeyofWisdom(boolean state) {
		Keys[1] = state;
	}
	public void setKeyofStrength(boolean state) {
		Keys[2] = state;
	}

	public boolean isStarving() {
		if(Food<=0){
			setStarving(true);
			HP -= 5;
		}
		return Starving;
	}
	public void setStarving(boolean state) {
			Starving = state;
	}

	public boolean isDiseased() {
		if(Drounds > 3){
			setDiseased(false);
		}
		return Diseased;
	}
	public void setDiseased(boolean state) {
		if((!state)&&Diseased){
			//were diseased, now not
			HP = HP*2;
		} else if(state&&(!Diseased)){
			//weren't diseased, now are
			HP = HP/2;
			Drounds = 0;
		}
		Diseased = state;
	}

	public boolean isSlowed() {
		if(Srounds > 2){
			setSlowed(false);
		} 
		if(magicItem != null && magicItem.getType() == "Climbing Gear"){
			setSlowed(false);
		}
		return Slowed;
	}
	public void setSlowed(boolean state) {
		if(state){
			rate = 2;
			Srounds = 0;
		} else {
			rate = 1;
		}
		Slowed = state;
	}

	public boolean isLost() {
		if(Lrounds > 3){
			setLost(false);
		}
		return Lost;
	}
	public void setLost(boolean state) {
		if(state){
			Lrounds = 0;
		}
		Lost = state;
	}

	public Space getSpace() {
		return currentSpace;
	}
	public void setSpace(Space s) {
		currentSpace = s;
	}

	public boolean isRobbed() {
		if(Rrounds>2){
			setRobbed(false);
		}
		return Robbed;
	}
	public void setRobbed(boolean state) {
		if(state){
			//we are being robbed
			gold = gold - gold/10;
			Rrounds = 0;
		}
		Robbed = state;
	}

	public boolean hasTrap(){
		return trap!=null;
	}
	public Trap getTrap() {
		return trap;
	}
	public void setTrap(Trap t) {
		trap = t;
	}
	public void useTrap(){
		currentSpace.setTrap(trap);
		trap = null; //removes trap from inventory
	}
	
	public void trapped(String t){
		//plagued rats, theif, caltrops, roadblock
		switch(t){
			case "Plagued Rats":
				//diseased == 1/2 health 
				setDiseased(true);
				break;
			case "Thief":
				//steal 1/2 of gold is gone
				if(magicItem != null && magicItem.getType() == "Mantle of Perception"){
					setRobbed(false);
				} else {
					setRobbed(true);
				}
				break;
			case "Caltrops":
				//consume twice the food
				setSlowed(true);
				break;
			case "Roadblock":
				// become lost
				setLost(true);
				break;
		}
	}

	public boolean hasArmor(){
		return armor != null;
	}
	public void setArmor(Armor a) {
		// TODO add to cp?
		armor = a;
	}
	public Armor getArmor() {
		return armor;
	}

	public boolean hasWeapon(){
		return weapon != null;
	}
	public void setWeapon(Weapon w) {
		// TODO update weapon effects
		weapon = w;
	}
	public Weapon getWeapon() {
		return weapon;
	}

	public boolean hasPotion(){
		return potion!=null;
	}
	public void setPotion(Potion p) {
		potion = p;
	}
	public Potion getPotion() {
		return potion;
	}	
	public void usePotion(){
		//TODO: use potion to effect HP, CP, or diseased status
		potion = null; //remove potion from inventory after use
	}
	
	public boolean hasMagicItem(){
		return magicItem != null;
	}
	public void setMagicItem(MagicItem i) {
		//TODO: add effects?
		magicItem = i;
	}
	public MagicItem getMagicItem() {
		return magicItem;
	}

}
