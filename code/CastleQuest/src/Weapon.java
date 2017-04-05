
public class Weapon implements java.io.Serializable{

	private String type;
	private int effect;
	
	public Weapon(String typ){
		type = typ;
		switch(typ){
			case "Iron Sword":
				effect = 10;
				break;
			case "Steel Sword":
				effect = 20;
				break;
			case "Obsidian Sword":
				effect = 30;
				break;
		}
	}
	public String getType() {
		return type;
	}

	public int getEffect() {
		return effect;
	}

}
