
public interface EnemyInterface {

	/*
	 * Enemies should be initialized when a player enters a combat situation
	 * they should take in the player so that they can be created with stats
	 * Comparable to the player
	 * Things enemies have: 
	 * Type
	 * HP
	 * CP
	 * Gold
	 * Item Loot (optional)
	 */
	
	/**
	 * 
	 * @return the type of this enemy (bandits, raiders, bear, other monster)
	 */
	public String getType();
	
	/**
	 * Set type of enemy
	 * @return none
	 */
	public void setType(String t);
	
	/**
	 * 
	 * @return the number of health points this enemy has
	 */
	public int getHealthPoints();
	
	/**
	 * set the enemy's health points
	 * @return nothing
	 */
	public void setHealthPoints(int h);
	
	/**
	 * 
	 * @return the number of health points this enemy has
	 */
	public int getCombatPower();
	
	/**
	 * set the enemy's combat power
	 * @return nothing
	 */
	public void setCombatPower(int c);

	/**
	 * 
	 * @return the number of Gold the enemy gives on death
	 */
	public int getGold();
	
	/**
	 * set the enemy's Gold amount
	 * @return nothing
	 */
	public void setGold(int g);
	
	/**
	 * 
	 * @return either null or an item that an enemy returns on death
	 */
	public Item getLoot();
	
	/**
	 * set the enemy's loot
	 * @return nothing
	 */
	public void setLoot(Item l);
	
}

