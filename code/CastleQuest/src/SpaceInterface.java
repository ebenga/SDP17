
public interface SpaceInterface {

	/**
	 * 
	 * @return all neighboring spaces on the board
	 * do we need this??
	 */
	public Space[] getNeighbors(); 
	
	/**
	 * 
	 * @return all players that are on this space
	 */
	public Player[] getPlayers();
	
	/**
	 * 
	 * @return true iff this is an active space. Else, space is inactive
	 */
	public boolean isActive(); 
	
	
}
