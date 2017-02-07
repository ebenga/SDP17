/* Used to instantiate an enemy
* should use current space and player hp/cp to generate appropriate enemy
*/
public class Enemy{
	
	private int CP;
	private int HP;
	private String Icon;
	private String Type;
	
	public Enemy(String type, int h, int c, String icon){
		HP = h;
		CP = c;
		Icon = icon;
		Type = type;
	}
	
	public String getIcon(){
		return Icon;
	}
	
	public boolean isDead(){
		return HP <= 0;
	}
	
	public String getType(){
		return Type;
	}
	
	public void subtractHP(int h){
		HP -= h;
	}
	
	public int getCP(){
		return CP;
	}
	
	public int getHP(){
		return HP;
	}
	
}