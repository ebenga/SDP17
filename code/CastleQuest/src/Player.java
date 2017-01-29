/*Contains the inventory of the player as well as the player stats
 * will house functions for checking inventory, adding/removing items from inventory
 * adding/removing from inventory should refresh HP/CP
 * pointer to next player in order
 * adding/removing health in combat
 * where the player is
 * LED color, player looks, other customizations
 */
public class Player implements PlayerInterface {

	private Player next;
	private boolean finalPlayer = false;
	private String homeKingdom;
	private int gold = 100;
	private int HP = 100;
	private int CP = 20;
	private int Food = 5;
	private boolean Lost = false;
	private boolean Slowed = false;
	private boolean Diseased = false;
	private boolean Robbed = false;
	private boolean Starving = false;
	private boolean[] Keys = {false,false,false};
	
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
		return next;
	}
	
	@Override
	public int getHealthPoints() {
		// TODO Auto-generated method stub
		return HP;
	}

	@Override
	public int setHealthPoints(int h) {
		// TODO Auto-generated method stub
		HP = h;
		return 0;
	}

	@Override
	public int getCombatPower() {
		// TODO Auto-generated method stub
		return CP;
	}

	@Override
	public int setCombatPower(int c) {
		// TODO Auto-generated method stub
		CP = c;
		return 0;
	}

	@Override
	public int getGold() {
		// TODO Auto-generated method stub
		return gold;
	}

	@Override
	public int setGold(int g) {
		// TODO Auto-generated method stub
		gold = g;
		return 0;
	}

	@Override
	public int getFood() {
		// TODO Auto-generated method stub
		return Food;
	}

	@Override
	public int setFood(int f) {
		// TODO Auto-generated method stub
		Food = f;
		return 0;
	}

	@Override
	public boolean[] getKeys() {
		// TODO Auto-generated method stub
		//{courage, wisdom, strength}
		return Keys;
	}

	@Override
	public void setKeyofCourage(boolean state) {
		// TODO Auto-generated method stub
		Keys[0] = state;
	}

	@Override
	public void setKeyofWisdom(boolean state) {
		// TODO Auto-generated method stub
		Keys[1] = state;
	}

	@Override
	public void setKeyofStrength(boolean state) {
		// TODO Auto-generated method stub
		Keys[2] = state;
	}

	@Override
	public boolean isStarving() {
		// TODO Auto-generated method stub
		return Starving;
	}

	@Override
	public void setStarving(boolean state) {
		// TODO Auto-generated method stub
			Starving = state;
	}

	@Override
	public boolean isDiseased() {
		// TODO Auto-generated method stub
		return Diseased;
	}

	@Override
	public void setDiseased(boolean state) {
		// TODO Auto-generated method stub
		Diseased = state;
	}

	@Override
	public boolean isSlowed() {
		// TODO Auto-generated method stub
		return Slowed;
	}

	@Override
	public void setSlowed(boolean state) {
		// TODO Auto-generated method stub
		Slowed = state;
	}

	@Override
	public boolean isLost() {
		// TODO Auto-generated method stub
		return Lost;
	}

	@Override
	public void setLost(boolean state) {
		// TODO Auto-generated method stub
			Lost = state;
	}

	@Override
	public Space getSpace() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Space move(Space s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isRobbed() {
		// TODO Auto-generated method stub
		return Robbed;
	}

	@Override
	public void setRobbed(boolean state) {
		// TODO Auto-generated method stub
		Robbed = state;
	}

	@Override
	public Trap getTrap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTrap(Trap t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setArmor(String[] a) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public Armor getArmor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setWeapon(String w) {
		// TODO Auto-generated method stub

	}

	@Override
	public Weapon getWeapon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPotion(String p) {
		// TODO Auto-generated method stub

	}

	@Override
	public Potion getPotion() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void setMagicItem(String i) {
		// TODO Auto-generated method stub

	}

	@Override
	public MagicItem getMagicItem() {
		// TODO Auto-generated method stub
		return null;
	}

}
