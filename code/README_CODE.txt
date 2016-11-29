MainGame.java contains the Main function and initializes and runs the game.

Code Process:
- Use Screen.java to attain how many players are playing / if we are loading a game
Loading:
  ~ Read in stored files and start game
New Game:
- initialize spaces and their values / key locations [likely to be 'hard-coded']
- Initialize players and their starting inventories
- Use Screen.java to get player configurations for LED color and other customizations
- Place players at their starting locations
- Enter FSM for gameplay

Finishing:
When a player wins, they will have the option of adding their high scores to a local leaderboard
Score categories:
Highest HP/CP, Most Gold, Least number of turns

Sarah Notes:
player constructor takes in a string which is the name of that players kingdom (there are only 4 choices). Then it sets that players ‘space’ value to that kingdoms start space

When you add a player to the board (board.initPlayer()) the board must put that player on the starting space. use player.getKingdom() to find out which player it is so you know which of the 4 starting spaces to put them on.
