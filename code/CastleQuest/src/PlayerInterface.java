
public interface PlayerInterface {
	
	/**
	 * 
	 * @return the number of health points this player has
	 */
	public int getHealthPoints();
	
	/**
	 * 
	 * @return the combat power of this player
	 */
	public int getCombatPower();
	
	/**
	 * 
	 * @return the amount of gold this player has
	 */
	public int getGold(); 
	
	/**
	 * 
	 * @return the amount of food this player has
	 */
	public int getFood(); 
	
	/**
	 * 
	 * @return a length 3 array with booleans signifying which Keys the player has. [KeyofCourage, KeyofWisdom, KeyofStrength]
	 * True if the player has that key, false if the player does not have that key
	 */
	public boolean[] getKeys(); 
	
	/**
	 * 
	 * @return true iff the player has 0 food
	 */
	public boolean isStarving(); 
	
	/**
	 * 
	 * @return true iff the player is diseased
	 */
	public boolean isDiseased(); 
	
	/**
	 * 
	 * @return
	 */
	public boolean isSlowed();
	
	/**
	 * 
	 * @return
	 */
	public boolean isLost(); 
	
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
	
}
