
public interface PlayerInterface {
	
	/**
	 * 
	 * @return the number of health points this player has
	 */
	public int getHealthPoints();
	
	/**
	 * 
	 * @param add the number of HPs to add to this players HPs
	 * @return the total number of HPs this player now has
	 */
	public int setHealthPoints(int add); 
	
	/**
	 * 
	 * @return the combat power of this player
	 */
	public int getCombatPower();
	
	/**
	 * 
	 * @param add the number of points to add to this players CPs
	 * @return the total number of CPs this play now has
	 */
	public int setCombatPower(int add); 
	
	/**
	 * 
	 * @return the amount of gold this player has
	 */
	public int getGold(); 
	
	/**
	 * 
	 * @param add the number of gold to add to this player
	 * @return the total gold this player now has
	 */
	public int setGold(int add); 
	
	/**
	 * 
	 * @return the amount of food this player has
	 */
	public int getFood(); 
	
	/**
	 * 
	 * @param add
	 * @return
	 */
	public int setFood(int add); 
	
	/**
	 * 
	 * @return a length 3 array with booleans signifying which Keys the player has. [KeyofCourage, KeyofWisdom, KeyofStrength]
	 * True if the player has that key, false if the player does not have that key
	 */
	public boolean[] getKeys(); 
	
	/**
	 * Adds the key of courage to this players set of keys
	 * Note: Players never 'loose' keys so we don't need to handle 'deleteKey'
	 * @return the length 3 key array after the new key has been added
	 */
	public boolean[] setKeyofCourage();
	
	/**
	 * Adds the key of wisdom to this players set of keys
	 * @return the length 3 key array after the new key has been added
	 */
	public boolean[] setKeyofWisdom();
	
	/**
	 * Adds the key of strength to this players set of keys
	 * @return the length 3 key array after the new key has been added
	 */
	public boolean[] setKeyofStrength();
	
	/**
	 * 
	 * @return true iff the player has 0 food
	 */
	public boolean isStarving(); 
	
	/**
	 * 
	 * @param state is true if the player will be set to starving, false if setting to not starving
	 */
	public void setStarving(boolean state); 
	
	/**
	 * 
	 * @return true iff the player is diseased
	 */
	public boolean isDiseased(); 
	
	/**
	 * 
	 * @param state is true if the player will be set to diseased, false if setting to not diseased
	 */
	public void setDiseased(boolean state); 
	
	/**
	 * 
	 * @return
	 */
	public boolean isSlowed();
	
	/**
	 * 
	 * @param state is true if the player will be set to slowed, false if setting to not slowed
	 */
	public void setSlowed(boolean state); 
	
	/**
	 * 
	 * @return
	 */
	public boolean isLost(); 
	
	public void setLost(boolean state); 
	
	/**
	 * 
	 * @return the Space that the player is currently on
	 */
	public Space getSpace(); 
	
	/**
	 * 
	 * @param s the space the player will move to
	 * @return the space the player moved to? or nothing? or the previous space? 
	 */
	public Space move(Space s);
	
	/**
	 * 
	 * @return true if the player is robbed
	 */
	public boolean isRobbed(); 
	
	/**
	 * 
	 * @param state true if setting to robbed. false if setting to not robbed
	 */
	public void setRobbed(boolean state); 
	
	/**
	 * 
	 * @return a Trap object if the player has a trap, or null if they don't
	 */
	public Trap getTrap();
	
	/**
	 * A player can only hold 1 trap at a time. If a player come across a new trap but already has one, they get to choose which to keep.
	 * @param t the trap the player picked up
	 */
	public void setTrap(Trap t); 
	
	/**
	 * 
	 * @return an @Armor object
	 */
	public Armor getArmor(); 
	
	/**
	 * 
	 * @param a length 3 array of strings for [Helm, Chest, Grieves]
	 */
	public void setArmor(String[] a); 
	
	/**
	 * 
	 * @return a Weapon object
	 */
	public Weapon getWeapon(); 
	
	public void setWeapon(String w); 
	
	public Potion getPotion(); 
	
	public void setPotion(String p); 
	
	public MagicItem getMagicItem(); 
	
	public void setMagicItem(String i); 
	
}
