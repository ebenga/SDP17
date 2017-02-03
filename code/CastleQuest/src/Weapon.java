
public class Weapon {

	private String type;
	private int effect;
	
	public Weapon(String typ){
		type = typ;
		switch(typ){
			case "Iron Sword":
				effect = 20;
				break;
			case "Steel Sword":
				effect = 40;
				break;
			case "Obsidian Sword":
				effect = 60;
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
