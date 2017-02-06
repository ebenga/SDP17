/* Space class
 * spaces have types and pointers to neighbors
 * Spaces can also house traps or keys
 * keys are player dependent, so only the player who needs this key could get it
 */

public class Space {

	private int id;
	private Space innerNeighbor;
	private Space outerNeighbor;
	private Space clockNeighbor;
	private Space countNeighbor;
	private Trap trap;
	private String type;
	private String icon;
	private boolean trappable;
	
	public Space(int Id, String typ, String ico){
		id = Id;
		type = typ;
		icon = ico;
		
		if(type=="Forest"||type=="Swamp"||type=="Desert"){
			trappable = true;
		}
		else {
			trappable = false;
		}
	}
	
	//s.outer(this)? replicate for two-way relationship?
	public void setInner(Space s){
		innerNeighbor = s;
	}
	public Space getInner(){
		return innerNeighbor;
	}
	
	public void setOuter(Space s){
		outerNeighbor = s;
	}
	public Space getOuter(){
		return outerNeighbor;
	}
	
	public void setClock(Space s){
		clockNeighbor = s;
	}
	public Space getClock(){
		return clockNeighbor;
	}
	
	public void setCount(Space s){
		countNeighbor = s;
	}
	public Space getCount(){
		return countNeighbor;
	}

	public void setType(String t){
		type = t;
	}
	public String getType(){
		return type;
	}

	public void setIcon(String t){
		icon = t;
	}
	public String getIcon(){
		return icon;
	}

	public boolean isTrapped(){
		return trap != null;
	}
	
	public void setTrap(Trap t){
		trap = t;
	}
	public Trap getTrap(){
		return trap;
	}
	
	public boolean isKingdom(){
		return (type=="Lassallax"||type=="Derelin"||type=="WybengaLand"||type=="Mangia");
	}
	
	public boolean isTrappable(){
		return trappable;
	}
	
}
