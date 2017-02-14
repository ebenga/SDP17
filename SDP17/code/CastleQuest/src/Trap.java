
public class Trap implements java.io.Serializable{

	
	//plagued rats, theif, caltrops, roadblock
	private String type;
	private String desc;
	
	public Trap(String t){
		type = t;
		switch(t){
		case "Plagued Rats":
			desc = "You open a box and come upon plagued rats! You burnt the box, but you might be diseased!";
			break;
		case "Thief":
			desc = "That traveling magician was quick with his hands! Uh oh.... you might have been Robbed!";
			break;
		case "Caltrops":
			desc = "Someone left caltrops in the road! Traveling might be harder and you may be Slowed";
			break;
		case "Roadblock":
			desc = "Someone blocked the path ahead, time for a 'shortcut.' Oops! You're Lost!";
			break;
		}
	}
	
	public String getType() {
		return type;
	}
	public String getDesc(){
		return desc;
	}

}
