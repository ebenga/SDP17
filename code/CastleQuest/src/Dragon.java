
public class Dragon{

	private Space space;
	private int gold = 300;
	private MagicItem magic;
	
	public void setSpace(Space s){
		space = s;
	}
	
	public Space getSpace(){
		return space;
	}

	public int getGold() {
		return gold;
	}

	public void addGold(int g) {
		// TODO Auto-generated method stub
		gold += g;
	}

}
