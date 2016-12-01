
public interface ItemInterface {
	/*
	 * Potions
	 * magical items
	 * weapons
	 * armor
	 */
	
	/**
	 * 
	 * @return the type of this item (potion, magical items, weapons, armor)
	 */
	public String getType();
	
	/**
	 * Set type of item
	 * @return none
	 */
	public void setType(String t);
	
	/**
	 * 
	 * @return string representing the effect this item has (increasing HP,CP
	 */
	public String getEffect();
	
}
