
public class Armor {

	private String type;
	private int effect;
	
	public Armor(String typ){
		type = typ;
		switch(typ){
			case "Leather Armor":
				effect = 20;
				break;
			case "Chainmail Armor":
				effect = 40;
				break;
			case "Plate Armor":
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
