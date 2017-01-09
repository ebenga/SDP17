
public interface SpaceInterface {

	/**
	 * 
	 * @return all neighboring spaces on the board
	 * 
	 */
	public Space[] getNeighbors(); 
	public void setNeighbors(Space[] s); 
	
	/**
	 * 
	 * @return all players that are on this space
	 */
	public Player[] getPlayers();
	public void setPlayers(Player[] p);
	
	/**
	 * 
	 * @return true iff this is an active space. Else, space is inactive
	 */
	public boolean isActive(); 
	public void setActive(boolean a); 
	
	
}
