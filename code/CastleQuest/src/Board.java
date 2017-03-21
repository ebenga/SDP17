import java.util.Random;

public class Board implements java.io.Serializable {

	public Player p1; //space where p1 is
	public Player p2; //space where p2 is
	public Player p3; //space where p3 is
	public Player p4; //space where p4 is
	public Dragon d; //space where d is
	public Player currentPlayer;
	public int numPlayer;
	public boolean dragonLives;
	
	
	//======================== ALL GAME SPACES =========================
	private Space[] spaces = new Space[68];
	public Board(){
		//CASTLE
		spaces[0] = new Space(0,"Throne Room","/resources/throne.png");
		spaces[1] = new Space(1,"Royal Staircase","/resources/staircase.png"); 
		spaces[2] = new Space(2,"Courtyard","/resources/courtyard.png"); 
		spaces[3] = new Space(3,"Castle Gates","/resources/gates.png"); 
		//FOREST
		spaces[4] = new Space(4,"Forest","/resources/forest.png"); 
		spaces[6] = new Space(6,"Forest","/resources/forest.png"); 
		spaces[8] = new Space(8,"Forest","/resources/forest.png"); 
		spaces[10] = new Space(10,"Forest","/resources/forest.png"); 
		spaces[12] = new Space(12,"Forest","/resources/forest.png"); 
		spaces[14] = new Space(14,"Forest","/resources/forest.png"); 
		spaces[16] = new Space(16,"Forest","/resources/forest.png"); 
		spaces[18] = new Space(18,"Forest","/resources/forest.png"); 
		spaces[21] = new Space(21,"Forest","/resources/forest.png"); 
		spaces[23] = new Space(23,"Forest","/resources/forest.png"); 
		spaces[25] = new Space(25,"Forest","/resources/forest.png"); 
		spaces[27] = new Space(27,"Forest","/resources/forest.png"); 
		spaces[29] = new Space(29,"Forest","/resources/forest.png"); 
		spaces[31] = new Space(31,"Forest","/resources/forest.png"); 
		spaces[33] = new Space(33,"Forest","/resources/forest.png"); 
		spaces[35] = new Space(35,"Forest","/resources/forest.png"); 
		spaces[38] = new Space(38,"Forest","/resources/forest.png"); 
		spaces[42] = new Space(42,"Forest","/resources/forest.png"); 
		spaces[46] = new Space(46,"Forest","/resources/forest.png"); 
		spaces[50] = new Space(50,"Forest","/resources/forest.png"); 
		spaces[53] = new Space(53,"Forest","/resources/forest.png"); 
		spaces[55] = new Space(55,"Forest","/resources/forest.png"); 
		spaces[57] = new Space(57,"Forest","/resources/forest.png"); 
		spaces[59] = new Space(59,"Forest","/resources/forest.png"); 
		spaces[61] = new Space(61,"Forest","/resources/forest.png"); 
		spaces[63] = new Space(63,"Forest","/resources/forest.png"); 
		spaces[65] = new Space(65,"Forest","/resources/forest.png"); 
		spaces[67] = new Space(67,"Forest","/resources/forest.png"); 
		//DESERT
		spaces[5] = new Space(5,"Desert","/resources/desert.png"); 
		spaces[9] = new Space(9,"Desert","/resources/desert.png"); 
		spaces[13] = new Space(13,"Desert","/resources/desert.png"); 
		spaces[17] = new Space(17,"Desert","/resources/desert.png"); 
		spaces[36] = new Space(36,"Desert","/resources/desert.png"); 
		spaces[39] = new Space(39,"Desert","/resources/desert.png"); 
		spaces[40] = new Space(40,"Desert","/resources/desert.png"); 
		spaces[43] = new Space(43,"Desert","/resources/desert.png"); 
		spaces[44] = new Space(44,"Desert","/resources/desert.png"); 
		spaces[47] = new Space(47,"Desert","/resources/desert.png"); 
		spaces[48] = new Space(48,"Desert","/resources/desert.png"); 
		spaces[51] = new Space(51,"Desert","/resources/desert.png"); 
		//SWAMP
		spaces[7] = new Space(7,"Swamp","/resources/swamp.png");
		spaces[11] = new Space(11,"Swamp","/resources/swamp.png");
		spaces[15] = new Space(15,"Swamp","/resources/swamp.png");
		spaces[19] = new Space(19,"Swamp","/resources/swamp.png");
		spaces[37] = new Space(37,"Swamp","/resources/swamp.png");
		spaces[41] = new Space(41,"Swamp","/resources/swamp.png");
		spaces[45] = new Space(45,"Swamp","/resources/swamp.png");
		spaces[49] = new Space(49,"Swamp","/resources/swamp.png");
		//BAZAAR
		spaces[20] = new Space(20,"Bazaar","/resources/bazaar.png");
		spaces[24] = new Space(24,"Bazaar","/resources/bazaar.png");
		spaces[28] = new Space(28,"Bazaar","/resources/bazaar.png");
		spaces[32] = new Space(32,"Bazaar","/resources/bazaar.png");
		//CAVES
		spaces[22] = new Space(22,"Caves","/resources/cave.png");
		spaces[26] = new Space(26,"Caves","/resources/cave.png");
		spaces[30] = new Space(30,"Caves","/resources/cave.png");
		spaces[34] = new Space(34,"Caves","/resources/cave.png");
		//RUINS
		spaces[52] = new Space(52,"Ruins","/resources/ruins.png");
		spaces[56] = new Space(56,"Ruins","/resources/ruins.png");
		spaces[60] = new Space(60,"Ruins","/resources/ruins.png");
		spaces[64] = new Space(64,"Ruins","/resources/ruins.png");
		//KINGDOMS
		spaces[54] = new Space(54,"Lassallax","/resources/kingdom.png");
		spaces[58] = new Space(58,"Mangia","/resources/kingdom.png");
		spaces[62] = new Space(62,"WybengaLand","/resources/kingdom.png");
		spaces[66] = new Space(66,"Derelin","/resources/kingdom.png");
		
		//======================= NEIGHBOR SETUPS ===========================
		
		spaces[0].setOuter(spaces[1]);
		
		spaces[1].setInner(spaces[0]);
		spaces[1].setOuter(spaces[2]);
		
		spaces[2].setInner(spaces[1]);
		spaces[2].setOuter(spaces[3]);
		
		spaces[3].setInner(spaces[2]);
		
		spaces[4].setInner(spaces[3]);
		spaces[4].setOuter(spaces[20]);
		spaces[4].setClock(spaces[19]);
		spaces[4].setCount(spaces[5]);
		
		spaces[5].setInner(spaces[3]);
		spaces[5].setOuter(spaces[21]);
		spaces[5].setClock(spaces[4]);
		spaces[5].setCount(spaces[6]);
		
		spaces[6].setInner(spaces[3]);
		spaces[6].setOuter(spaces[22]);
		spaces[6].setClock(spaces[5]);
		spaces[6].setCount(spaces[7]);
		
		spaces[7].setInner(spaces[3]);
		spaces[7].setOuter(spaces[23]);
		spaces[7].setClock(spaces[6]);
		spaces[7].setCount(spaces[8]);
		
		spaces[8].setInner(spaces[3]);
		spaces[8].setOuter(spaces[24]);
		spaces[8].setClock(spaces[7]);
		spaces[8].setCount(spaces[9]);
		
		spaces[9].setInner(spaces[3]);
		spaces[9].setOuter(spaces[25]);
		spaces[9].setClock(spaces[8]);
		spaces[9].setCount(spaces[10]);
		
		spaces[10].setInner(spaces[3]);
		spaces[10].setOuter(spaces[26]);
		spaces[10].setClock(spaces[9]);
		spaces[10].setCount(spaces[11]);
		
		spaces[11].setInner(spaces[3]);
		spaces[11].setOuter(spaces[27]);
		spaces[11].setClock(spaces[10]);
		spaces[11].setCount(spaces[12]);
		
		spaces[12].setInner(spaces[3]);
		spaces[12].setOuter(spaces[28]);
		spaces[12].setClock(spaces[11]);
		spaces[12].setCount(spaces[13]);
		
		spaces[13].setInner(spaces[3]);
		spaces[13].setOuter(spaces[29]);
		spaces[13].setClock(spaces[12]);
		spaces[13].setCount(spaces[14]);
		
		spaces[14].setInner(spaces[3]);
		spaces[14].setOuter(spaces[30]);
		spaces[14].setClock(spaces[13]);
		spaces[14].setCount(spaces[15]);
		
		spaces[15].setInner(spaces[3]);
		spaces[15].setOuter(spaces[31]);
		spaces[15].setClock(spaces[14]);
		spaces[15].setCount(spaces[16]);
		
		spaces[16].setInner(spaces[3]);
		spaces[16].setOuter(spaces[32]);
		spaces[16].setClock(spaces[15]);
		spaces[16].setCount(spaces[17]);
		
		spaces[17].setInner(spaces[3]);
		spaces[17].setOuter(spaces[33]);
		spaces[17].setClock(spaces[16]);
		spaces[17].setCount(spaces[18]);
		
		spaces[18].setInner(spaces[3]);
		spaces[18].setOuter(spaces[34]);
		spaces[18].setClock(spaces[17]);
		spaces[18].setCount(spaces[19]);
		
		spaces[19].setInner(spaces[3]);
		spaces[19].setOuter(spaces[35]);
		spaces[19].setClock(spaces[18]);
		spaces[19].setCount(spaces[4]);
		
		spaces[20].setInner(spaces[4]);
		spaces[20].setOuter(spaces[36]);
		spaces[20].setClock(spaces[35]);
		spaces[20].setCount(spaces[21]);
		
		spaces[21].setInner(spaces[5]);
		spaces[21].setOuter(spaces[37]);
		spaces[21].setClock(spaces[20]);
		spaces[21].setCount(spaces[22]);
		
		spaces[22].setInner(spaces[6]);
		spaces[22].setOuter(spaces[38]);
		spaces[22].setClock(spaces[21]);
		spaces[22].setCount(spaces[23]);
		
		spaces[23].setInner(spaces[7]);
		spaces[23].setOuter(spaces[39]);
		spaces[23].setClock(spaces[22]);
		spaces[23].setCount(spaces[24]);
		
		spaces[24].setInner(spaces[8]);
		spaces[24].setOuter(spaces[40]);
		spaces[24].setClock(spaces[23]);
		spaces[24].setCount(spaces[25]);
		
		spaces[25].setInner(spaces[9]);
		spaces[25].setOuter(spaces[41]);
		spaces[25].setClock(spaces[24]);
		spaces[25].setCount(spaces[26]);
		
		spaces[26].setInner(spaces[10]);
		spaces[26].setOuter(spaces[42]);
		spaces[26].setClock(spaces[25]);
		spaces[26].setCount(spaces[27]);
		
		spaces[27].setInner(spaces[11]);
		spaces[27].setOuter(spaces[43]);
		spaces[27].setClock(spaces[26]);
		spaces[27].setCount(spaces[28]);
		
		spaces[28].setInner(spaces[12]);
		spaces[28].setOuter(spaces[44]);
		spaces[28].setClock(spaces[27]);
		spaces[28].setCount(spaces[29]);
		
		spaces[29].setInner(spaces[13]);
		spaces[29].setOuter(spaces[45]);
		spaces[29].setClock(spaces[28]);
		spaces[29].setCount(spaces[30]);
		
		spaces[30].setInner(spaces[14]);
		spaces[30].setOuter(spaces[46]);
		spaces[30].setClock(spaces[29]);
		spaces[30].setCount(spaces[31]);
		
		spaces[31].setInner(spaces[15]);
		spaces[31].setOuter(spaces[47]);
		spaces[31].setClock(spaces[30]);
		spaces[31].setCount(spaces[32]);
		
		spaces[32].setInner(spaces[16]);
		spaces[32].setOuter(spaces[48]);
		spaces[32].setClock(spaces[31]);
		spaces[32].setCount(spaces[33]);
		
		spaces[33].setInner(spaces[17]);
		spaces[33].setOuter(spaces[49]);
		spaces[33].setClock(spaces[32]);
		spaces[33].setCount(spaces[34]);
		
		spaces[34].setInner(spaces[18]);
		spaces[34].setOuter(spaces[50]);
		spaces[34].setClock(spaces[33]);
		spaces[34].setCount(spaces[35]);
		
		spaces[35].setInner(spaces[19]);
		spaces[35].setOuter(spaces[51]);
		spaces[35].setClock(spaces[34]);
		spaces[35].setCount(spaces[20]);
		
		spaces[36].setInner(spaces[20]);
		spaces[36].setOuter(spaces[52]);
		spaces[36].setClock(spaces[51]);
		spaces[36].setCount(spaces[37]);
		
		spaces[37].setInner(spaces[21]);
		spaces[37].setOuter(spaces[53]);
		spaces[37].setClock(spaces[36]);
		spaces[37].setCount(spaces[38]);
		
		spaces[38].setInner(spaces[22]);
		spaces[38].setOuter(spaces[54]);
		spaces[38].setClock(spaces[37]);
		spaces[38].setCount(spaces[39]);
		
		spaces[39].setInner(spaces[23]);
		spaces[39].setOuter(spaces[55]);
		spaces[39].setClock(spaces[38]);
		spaces[39].setCount(spaces[40]);
		
		spaces[40].setInner(spaces[24]);
		spaces[40].setOuter(spaces[56]);
		spaces[40].setClock(spaces[39]);
		spaces[40].setCount(spaces[41]);
		
		spaces[41].setInner(spaces[25]);
		spaces[41].setOuter(spaces[57]);
		spaces[41].setClock(spaces[40]);
		spaces[41].setCount(spaces[42]);
		
		spaces[42].setInner(spaces[26]);
		spaces[42].setOuter(spaces[58]);
		spaces[42].setClock(spaces[41]);
		spaces[42].setCount(spaces[43]);
		
		spaces[43].setInner(spaces[27]);
		spaces[43].setOuter(spaces[59]);
		spaces[43].setClock(spaces[42]);
		spaces[43].setCount(spaces[44]);
		
		spaces[44].setInner(spaces[28]);
		spaces[44].setOuter(spaces[60]);
		spaces[44].setClock(spaces[43]);
		spaces[44].setCount(spaces[45]);
		
		spaces[45].setInner(spaces[29]);
		spaces[45].setOuter(spaces[61]);
		spaces[45].setClock(spaces[44]);
		spaces[45].setCount(spaces[46]);
		
		spaces[46].setInner(spaces[30]);
		spaces[46].setOuter(spaces[62]);
		spaces[46].setClock(spaces[45]);
		spaces[46].setCount(spaces[47]);
		
		spaces[47].setInner(spaces[31]);
		spaces[47].setOuter(spaces[63]);
		spaces[47].setClock(spaces[46]);
		spaces[47].setCount(spaces[48]);
		
		spaces[48].setInner(spaces[32]);
		spaces[48].setOuter(spaces[64]);
		spaces[48].setClock(spaces[47]);
		spaces[48].setCount(spaces[49]);
		
		spaces[49].setInner(spaces[33]);
		spaces[49].setOuter(spaces[65]);
		spaces[49].setClock(spaces[48]);
		spaces[49].setCount(spaces[50]);
		
		spaces[50].setInner(spaces[34]);
		spaces[50].setOuter(spaces[66]);
		spaces[50].setClock(spaces[49]);
		spaces[50].setCount(spaces[51]);
		
		spaces[51].setInner(spaces[35]);
		spaces[51].setOuter(spaces[67]);
		spaces[51].setClock(spaces[50]);
		spaces[51].setCount(spaces[36]);
		
		spaces[52].setInner(spaces[36]);
		spaces[52].setOuter(null);
		spaces[52].setClock(spaces[67]);
		spaces[52].setCount(spaces[53]);
		
		spaces[53].setInner(spaces[37]);
		spaces[53].setOuter(null);
		spaces[53].setClock(spaces[52]);
		spaces[53].setCount(spaces[54]);
		
		spaces[54].setInner(spaces[38]);
		spaces[54].setOuter(null);
		spaces[54].setClock(spaces[53]);
		spaces[54].setCount(spaces[55]);
		
		spaces[55].setInner(spaces[39]);
		spaces[55].setOuter(null);
		spaces[55].setClock(spaces[54]);
		spaces[55].setCount(spaces[56]);
		
		spaces[56].setInner(spaces[40]);
		spaces[56].setOuter(null);
		spaces[56].setClock(spaces[55]);
		spaces[56].setCount(spaces[57]);
		
		spaces[57].setInner(spaces[41]);
		spaces[57].setOuter(null);
		spaces[57].setClock(spaces[56]);
		spaces[57].setCount(spaces[58]);
		
		spaces[58].setInner(spaces[42]);
		spaces[58].setOuter(null);
		spaces[58].setClock(spaces[57]);
		spaces[58].setCount(spaces[59]);
		
		spaces[59].setInner(spaces[43]);
		spaces[59].setOuter(null);
		spaces[59].setClock(spaces[58]);
		spaces[59].setCount(spaces[60]);
		
		spaces[60].setInner(spaces[44]);
		spaces[60].setOuter(null);
		spaces[60].setClock(spaces[59]);
		spaces[60].setCount(spaces[61]);
		
		spaces[61].setInner(spaces[45]);
		spaces[61].setOuter(null);
		spaces[61].setClock(spaces[60]);
		spaces[61].setCount(spaces[62]);
		
		spaces[62].setInner(spaces[46]);
		spaces[62].setOuter(null);
		spaces[62].setClock(spaces[61]);
		spaces[62].setCount(spaces[63]);
		
		spaces[63].setInner(spaces[47]);
		spaces[63].setOuter(null);
		spaces[63].setClock(spaces[62]);
		spaces[63].setCount(spaces[64]);
		
		spaces[64].setInner(spaces[48]);
		spaces[64].setOuter(null);
		spaces[64].setClock(spaces[63]);
		spaces[64].setCount(spaces[65]);
		
		spaces[65].setInner(spaces[49]);
		spaces[65].setOuter(null);
		spaces[65].setClock(spaces[64]);
		spaces[65].setCount(spaces[66]);
		
		spaces[66].setInner(spaces[50]);
		spaces[66].setOuter(null);
		spaces[66].setClock(spaces[65]);
		spaces[66].setCount(spaces[67]);
		
		spaces[67].setInner(spaces[51]);
		spaces[67].setOuter(null);
		spaces[67].setClock(spaces[66]);
		spaces[67].setCount(spaces[52]);
		
	}
	
	public void initialize(int numPlayers, Player play1, Player play2, Player play3, Player play4, Dragon dragon){
		p1 = play1;
		p2 = play2;
		p3 = play3;
		p4 = play4;
		d = dragon;
		numPlayer = numPlayers;
		switch(numPlayers){
			case 1: 
				play1.setSpace(spaces[54]);
				play1.setHomeSpace(spaces[54]);
				play2.setSpace(new Space(100,"null","null"));
				play3.setSpace(new Space(101,"null","null"));
				play4.setSpace(new Space(102,"null","null"));
				break;
			case 2:
				play1.setSpace(spaces[54]);
				play1.setHomeSpace(spaces[54]);
				play2.setSpace(spaces[66]);
				play2.setHomeSpace(spaces[66]);
				play3.setSpace(new Space(101,"null","null"));
				play4.setSpace(new Space(102,"null","null"));
				break;
			case 3:
				play1.setSpace(spaces[54]);
				play1.setHomeSpace(spaces[54]);
				play2.setSpace(spaces[66]);
				play2.setHomeSpace(spaces[66]);
				play3.setSpace(spaces[62]);
				play3.setHomeSpace(spaces[62]);
				play4.setSpace(new Space(102,"null","null"));
				break;
			case 4:
				play1.setSpace(spaces[54]);
				play1.setHomeSpace(spaces[54]);
				play2.setSpace(spaces[66]);
				play2.setHomeSpace(spaces[66]);
				play3.setSpace(spaces[62]);
				play3.setHomeSpace(spaces[62]);
				play4.setSpace(spaces[58]);
				play4.setHomeSpace(spaces[58]);
				break;
		}
		dragon.setSpace(spaces[rando(4,51)]);
		
		//TODO communicate with benga's board? might have to do that in the setSpace() method for players
	}
	
	public int rando(int min, int max){
		//generate random number between min and max (inclusive)
		Random ran = new Random();
		int r = ran.nextInt(max-min+1) + min;
		return r;
	}
	
	public Space getKingdom(String king){
		switch(king){
			case "Lassallax":
				return spaces[54];
			case "Derelin":
				return spaces[66];
			case "WybengaLand":
				return spaces[62];
			case "Mangia":
				return spaces[58];
		}
		return spaces[4];
	}
	

}
