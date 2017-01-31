
public class Board {

	private Space p1; //space where p1 is
	private Space p2; //space where p2 is
	private Space p3; //space where p3 is
	private Space p4; //space where p4 is
	private Space d; //space where d is
	
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
		spaces[45] = new Space(45,"Forest","/resources/forest.png"); 
		spaces[49] = new Space(49,"Forest","/resources/forest.png"); 
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
		spaces[46] = new Space(46,"Swamp","/resources/swamp.png");
		spaces[50] = new Space(50,"Swamp","/resources/swamp.png");
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
		spaces[28].setCount(spaces[28]);
		
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
		
		//TODO 36 --> 67
		
	}
	
	
	
	public void initialize(int numPlayers, Player play1, Player play2, Player play3, Player play4){
		
	}
	

}
