
public class Dragon implements java.io.Serializable{

	private Space space;
	private int ID = 0;
	private int gold = 300;
	private MagicItem magic = new MagicItem("Mantle of Perception");
	
	public int getId(){
		return ID;
	}
	
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
		gold += g;
	}
	
	public void AddMagic(MagicItem m){
		magic = m;
	}
	
	public MagicItem getMagicItem(){
		return magic;
	}

}
