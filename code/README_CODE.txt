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
