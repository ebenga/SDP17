/* The main driver for the game
 * For loaded games, will prompt for the load through Screen.java
 * for new games:
 * initialize spaces
 * initialize players
 * starts dragon
 * goes through player configuration (choosing color, etc?)
 * starts game
 * Will house functions to:
 * 	recieve input from Screen.java
 * 	run combat sequences
 * 	etc

Example code:
while(!gameOver){
  //run a players turn
  //at the end of each players turn, save game state
  // move dragon
  nextTurn()
}

//X is given from UI when player selects place to move to
public void moveTo(Space X){
  currentPlayer.currentSpace = X;
  action(currentPlayer)
}

private void action(Player A){
  //handles the action of what happens on the space depending on the space type
  switch(currentPlayer.currentSpace.type):
  case bazaar:
  case fields:
  case desert:
  ...
}

public void nextTurn(){
  currentPlayer = currentPlayer.next;
  Castle.rotate();
}
 */
