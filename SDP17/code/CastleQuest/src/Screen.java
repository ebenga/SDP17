import java.awt.EventQueue;

import java.io.*;
import sun.audio.*;
import sun.audio.AudioPlayer;

import java.util.*;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.Timer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;


public class Screen {

	private Board gameBoard;
	private JFrame frame;
	private JPanel startPanel;
	private JPanel playerStartPanel;
	private JPanel settingsPanel;
	private JPanel inventoryPanel;
	private JPanel movePanel;
	private JPanel combatPanel;
	private JPanel bazaarPanel;
	private JPanel ruinPanel;
	private JPanel cavePanel;
	private JPanel rotatePanel;
	private JPanel dragonPanel;
	public int numPlayers = 1;
	public Player playerOne;
	public Player playerTwo;
	public Player playerThree;
	public Player playerFour;
	public Player currentPlayer;
	public Dragon dragon = new Dragon();
	public boolean dragonLives = true;
	private JButton btnSettings;
	private JLabel lblcurrentPlayer;
	private JButton btnInventory;
	private JButton btnMove;
	private JLabel lblGold;
	private JLabel lblHP;
	private JLabel lblCP;
	private JLabel lblFood;
	private JLabel lblStatus;
	private JTextPane statusPane;
	private JTextPane keyPane;
	private JTextPane magicPane;
	private JLabel lblcurrentWeapon;
	private JLabel lblcurrentArmor;
	private JLabel lblWeapon;
	private JButton btnPotion;
	private JButton btnTrap;
	private JButton button;
	private JLabel lblRight;
	private JLabel lblUp;
	private JLabel lblLeft;
	private JLabel lblDown;
	private JLabel lblCharactersLeft;
	private JLabel lblCharactersRight;
	private JLabel lblMove;
	private JButton btnStay;
	private JLabel lblStay;
	private JLabel lblRotate;
	private JLabel lblRotateArrow;
	private JButton btnReady;
	private JLabel lblTurnOver;
	private JButton btnDown;
	private JButton btnLeft;
	private JButton btnRight;
	private JButton btnUp;
	private JPanel trapPanel;
	private JLabel lblTraptype;
	private JTextPane lblTrapEffect;
	private JLabel lblYouHaveFound;
	private JLabel lblYouHaveFound_1;
	private JButton btnNW;
	private JButton btnBI;
	private JLabel label_2;
	private JPanel keyPanel;
	private JButton btnOK;
	private JLabel lblKeyname;
	private JTextPane txtpnDesc;
	private JButton btnBuy3;
	private JButton btnBuy2;
	private JButton btnBuy1;
	private JButton btnBuyFood;
	private JLabel lblBGold;
	private JLabel lblItem1;
	private JLabel lblItem2;
	private JLabel lblItem3;
	private JLabel lblBuyFood;
	private JButton btnBarter;
	private String[] itemArray = {
			"Health Potion","Battle Elixir","Cure Disease",
			"Plagued Rats","Thief","Caltrops","Roadblock"
			};
	private String[] itemEffects = {
			"+20HP","+20CP","",
			"Trap","Trap","Trap","Trap"
			};
	private String[] itemCosts = {
			"50","50","75",
			"70","60","50","70",
			"100","100"
			};
	private boolean canBarter = false;
	private JLabel lblItem1Effect;
	private JLabel lblItem2Effect;
	private JLabel lblItem3Effect;
	private JButton btnDReady;
	private JTextPane lblDragonPosition;
	private String[] fightSounds = {
			"/resources/battle1.wav","/resources/battle2.wav",
			"/resources/battle3.wav","/resources/battle4.wav"
	};
	
	private String[] standardEnemies = {
			"Bandits","Raiders","Brigands"
	};
	private String[] standardEnemiesIcon = {
			"/resources/bandits.png","/resources/raiders.png",
			"/resources/brigands.png"
	};
	
	private String[] epicEnemies = {
			"Bear","Basilisk","Giant Snake"
	};
	private String[] epicEnemiesIcon = {
			"/resources/bear.png","/resources/basilisk.png",
			"/resources/giantsnake.png"
	};
	
	private String[] royalEnemies = {
			"Skeleton Guards","King's Elites","The Evil King"
	}; 
	private String[] royalEnemiesIcon = {
			"/resources/skeletonguards.png","/resources/kingselites.png",
			"/resources/theevilking.png"
	};//courtyard, staircase, throneroom
	
	private JLabel lblFighting;
	private JLabel lblPlayerIcon;
	private JLabel lblVs;
	private JLabel lblEnemyIcon;
	private JLabel lblYou;
	private JLabel lblThem;
	private JLabel lblSwing;
	private JLabel lblDamage;
	private JLabel lblPlayerCP;
	private JLabel lblEnemyCP;
	private JLabel lblPlayerHP;
	private JLabel lblEnemyHP;
	private Enemy currentEnemy;
	private JButton btnContinue;
	private String tier = "standard";
	
	private String[] potions = {
			"Health Potion","Battle Elixir","Cure Disease"
	};
	private String[] traps = {
			"Plagued Rats","Thief","Caltrops","Roadblock"
	};
	private String[] magicItems = {
			"Mangel-Slayer","Mantle of Perception","Climbing Gear"
	};
	
	private JPanel lootPanel;
	private JLabel lblLootName;
	private JButton btnAccept;
	private JLabel lblLootFound;
	private JButton btnDecline;
	private JTextPane lblLootValue;
	private JPanel victoryPanel;
	private JLabel lblVictor;
	private JLabel label_1;
	private JButton btnGameWon;
	private JLabel lblGameOver;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Screen window = new Screen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Screen() {
		currentPlayer = new Player();
		gameBoard = new Board();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 340, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		//================= START PAGE ===========================
		
		startPanel = new JPanel();
		startPanel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(startPanel, "name_257946467045291");
		startPanel.setLayout(null);
		
		JLabel titleLabel = new JLabel("CASTLE QUEST");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Cambria", Font.BOLD, 30));
		titleLabel.setBounds(18, 64, 304, 94);
		startPanel.add(titleLabel);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					//TODO Loading
				Board gboard = null;
			      try {
			    	 File cwdFile = new File (".");
				     String cwd = cwdFile.getAbsolutePath();
				     File f = new File(cwd+"gboard.ser");
			         FileInputStream fileIn = new FileInputStream(f);
			         ObjectInputStream in = new ObjectInputStream(fileIn);
			         gboard = (Board) in.readObject();
			         in.close();
			         fileIn.close();
			         gameBoard = gboard;
			         currentPlayer = gameBoard.currentPlayer;
			         playerOne = gameBoard.p1;
			         playerTwo = gameBoard.p2;
			         playerThree = gameBoard.p3;
			         playerFour = gameBoard.p4;
			         dragon = gameBoard.d;
			         numPlayers = gameBoard.numPlayer;
			         dragonLives = gameBoard.dragonLives;
			         repopulate();
			         startPanel.setVisible(false);
			         playerStartPanel.setVisible(true);
			         
			      }catch(IOException i) {
			         i.printStackTrace();
			         btnLoad.setText("Error");
			         return;
			      }catch(ClassNotFoundException c) {
			         System.out.println("Board class not found");
			         btnLoad.setText("Error");
			         c.printStackTrace();
			         return;
				}
			      System.out.println("Play1.getFood: " + gboard.p1.getFood());
			}
		});
		btnLoad.setBackground(new Color(128, 128, 128));
		btnLoad.setFont(new Font("Cambria", Font.BOLD, 16));
		btnLoad.setBounds(204, 11, 110, 25);
		startPanel.add(btnLoad);
		
		JLabel lblNewLabel = new JLabel("Number of Players:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 16));
		lblNewLabel.setBounds(44, 148, 251, 25);
		startPanel.add(lblNewLabel);
		
		JButton btnOnePlayer = new JButton("ONE");
		btnOnePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				play("/resources/blip.wav");
				numPlayers = 1;
				startPanel.setVisible(false);
				boarder();
				playerStartPanel.setVisible(true);
			}
		});
		btnOnePlayer.setFont(new Font("Cambria", Font.BOLD, 16));
		btnOnePlayer.setBackground(Color.WHITE);
		btnOnePlayer.setBounds(110, 184, 119, 40);
		startPanel.add(btnOnePlayer);
		
		JButton btnTwoPlayer = new JButton("TWO");
		btnTwoPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				play("/resources/blip.wav");
				numPlayers = 2;
				startPanel.setVisible(false);
				boarder();
				playerStartPanel.setVisible(true);
			}
		});
		btnTwoPlayer.setFont(new Font("Cambria", Font.BOLD, 16));
		btnTwoPlayer.setBackground(Color.WHITE);
		btnTwoPlayer.setBounds(110, 242, 119, 40);
		startPanel.add(btnTwoPlayer);
		
		JButton btnThreePlayer = new JButton("THREE");
		btnThreePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				play("/resources/blip.wav");
				numPlayers = 3;
				startPanel.setVisible(false);
				boarder();
				playerStartPanel.setVisible(true);
			}
		});
		btnThreePlayer.setFont(new Font("Cambria", Font.BOLD, 16));
		btnThreePlayer.setBackground(Color.WHITE);
		btnThreePlayer.setBounds(109, 304, 121, 40);
		startPanel.add(btnThreePlayer);
		
		JButton btnFourPlayer = new JButton("FOUR");
		btnFourPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				play("/resources/blip.wav");
				numPlayers = 4;
				startPanel.setVisible(false);
				boarder();
				playerStartPanel.setVisible(true);
			}
		});
		btnFourPlayer.setFont(new Font("Cambria", Font.BOLD, 16));
		btnFourPlayer.setBackground(Color.WHITE);
		btnFourPlayer.setBounds(109, 361, 121, 40);
		startPanel.add(btnFourPlayer);
		
		//====================== PLAYER START PAGE =========================
		
		playerStartPanel = new JPanel();
		playerStartPanel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(playerStartPanel, "name_257948874350106");
		playerStartPanel.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.WHITE);
		separator.setForeground(Color.BLACK);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(120, 273, 1, 150);
		playerStartPanel.add(separator);
		
		btnSettings = new JButton("Settings");
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerStartPanel.setVisible(false);
				play("/resources/blip.wav");
				settingsPanel.setVisible(true);
			}
		});
		btnSettings.setFont(new Font("Cambria", Font.BOLD, 16));
		btnSettings.setBackground(Color.GRAY);
		btnSettings.setBounds(200, 10, 134, 29);
		playerStartPanel.add(btnSettings);

		lblcurrentPlayer = new JLabel("Knight of " + currentPlayer.getHomeKingdom());
		lblcurrentPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		lblcurrentPlayer.setFont(new Font("Cambria", Font.BOLD, 19));
		lblcurrentPlayer.setBounds(10, 47, 304, 47);
		playerStartPanel.add(lblcurrentPlayer);
		
		btnInventory = new JButton("Inventory");
		btnInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				playerStartPanel.setVisible(false);
				repopulate();
				if(currentPlayer.isLost()){
					play("/resources/bazaarCloses.wav");
					rotatePanel.setVisible(true);
				}
				else{
					play("/resources/blip.wav");
					inventoryPanel.setVisible(true);
				}
			}
		});
		btnInventory.setBackground(Color.WHITE);
		btnInventory.setFont(new Font("Cambria", Font.BOLD, 16));
		btnInventory.setBounds(25, 105, 125, 47);
		playerStartPanel.add(btnInventory);
		
		btnMove = new JButton("Move");
		btnMove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				playerStartPanel.setVisible(false);
				repopulate();
				if(currentPlayer.isLost()){
					play("/resources/bazaarCloses.wav");
					rotatePanel.setVisible(true);
				}
				else{
					play("/resources/blip.wav");
					movePanel.setVisible(true);
				}
			}
		});
		btnMove.setBackground(Color.WHITE);
		btnMove.setFont(new Font("Cambria", Font.BOLD, 16));
		btnMove.setBounds(160, 105, 125, 47);
		playerStartPanel.add(btnMove);
		
		lblGold = new JLabel("Gold:");
		lblGold.setForeground(Color.BLACK);
		lblGold.setHorizontalAlignment(SwingConstants.LEFT);
		lblGold.setFont(new Font("Cambria", Font.BOLD, 16));
		lblGold.setBounds(10, 273, 104, 25);
		playerStartPanel.add(lblGold);
		
		lblHP = new JLabel("HP:");
		lblHP.setForeground(Color.RED);
		lblHP.setHorizontalAlignment(SwingConstants.LEFT);
		lblHP.setFont(new Font("Cambria", Font.BOLD, 16));
		lblHP.setBounds(10, 309, 104, 25);
		playerStartPanel.add(lblHP);
		
		lblCP = new JLabel("CP:");
		lblCP.setForeground(Color.BLUE);
		lblCP.setHorizontalAlignment(SwingConstants.LEFT);
		lblCP.setFont(new Font("Cambria", Font.BOLD, 16));
		lblCP.setBounds(10, 345, 104, 25);
		playerStartPanel.add(lblCP);
		
		lblFood = new JLabel("Food:");
		lblFood.setForeground(Color.GREEN);
		lblFood.setHorizontalAlignment(SwingConstants.LEFT);
		lblFood.setFont(new Font("Cambria", Font.BOLD, 16));
		lblFood.setBounds(10, 381, 104, 25);
		playerStartPanel.add(lblFood);
		
		lblStatus = new JLabel("Status");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setFont(new Font("Cambria", Font.BOLD, 18));
		lblStatus.setBounds(63, 208, 179, 38);
		playerStartPanel.add(lblStatus);
		
		statusPane = new JTextPane();
		statusPane.setEditable(false);
		statusPane.setForeground(Color.RED);
		statusPane.setFont(new Font("Cambria", Font.BOLD, 16));
		statusPane.setBackground(Color.LIGHT_GRAY);
		statusPane.setBounds(143, 273, 171, 150);
		playerStartPanel.add(statusPane);
		
		//==================== INVENTORY PAGE =============================
		
		inventoryPanel = new JPanel();
		inventoryPanel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(inventoryPanel, "name_257953235220668");
		inventoryPanel.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inventoryPanel.setVisible(false);
				play("/resources/blip.wav");
				repopulate();
				playerStartPanel.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Cambria", Font.BOLD, 16));
		btnBack.setBackground(Color.GRAY);
		btnBack.setBounds(10, 11, 110, 25);
		inventoryPanel.add(btnBack);
		
		JLabel lblInventory = new JLabel("Inventory");
		lblInventory.setHorizontalAlignment(SwingConstants.CENTER);
		lblInventory.setFont(new Font("Cambria", Font.BOLD, 22));
		lblInventory.setBounds(54, 47, 214, 47);
		inventoryPanel.add(lblInventory);
		
		JLabel lblKeys = new JLabel("Keys");
		lblKeys.setHorizontalAlignment(SwingConstants.CENTER);
		lblKeys.setFont(new Font("Cambria", Font.BOLD, 17));
		lblKeys.setBounds(195, 90, 103, 42);
		inventoryPanel.add(lblKeys);
		
		keyPane = new JTextPane();
		keyPane.setEditable(false);
		keyPane.setText("null");
		keyPane.setFont(new Font("Cambria", Font.BOLD, 14));
		keyPane.setBackground(Color.LIGHT_GRAY);
		keyPane.setBounds(172, 132, 142, 128);
		inventoryPanel.add(keyPane);
		
		JLabel lblArmor = new JLabel("Armor");
		lblArmor.setHorizontalAlignment(SwingConstants.CENTER);
		lblArmor.setFont(new Font("Cambria", Font.BOLD, 17));
		lblArmor.setBounds(10, 90, 103, 42);
		inventoryPanel.add(lblArmor);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.BLACK);
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(168, 110, 1, 175);
		inventoryPanel.add(separator_1);
		
		JLabel lblItems = new JLabel("Items");
		lblItems.setHorizontalAlignment(SwingConstants.CENTER);
		lblItems.setFont(new Font("Cambria", Font.BOLD, 17));
		lblItems.setBounds(31, 249, 103, 42);
		inventoryPanel.add(lblItems);
		
		JLabel lblMagicalItems = new JLabel("Magical Item");
		lblMagicalItems.setHorizontalAlignment(SwingConstants.CENTER);
		lblMagicalItems.setFont(new Font("Cambria", Font.BOLD, 17));
		lblMagicalItems.setBounds(172, 255, 141, 42);
		inventoryPanel.add(lblMagicalItems);
		
		magicPane = new JTextPane();
		magicPane.setForeground(Color.BLACK);
		magicPane.setFont(new Font("Cambria", Font.BOLD, 14));
		magicPane.setEditable(false);
		magicPane.setBackground(Color.LIGHT_GRAY);
		magicPane.setBounds(172, 302, 142, 134);
		inventoryPanel.add(magicPane);
		
		lblcurrentWeapon = new JLabel("null");
		lblcurrentWeapon.setHorizontalAlignment(SwingConstants.LEFT);
		lblcurrentWeapon.setForeground(Color.BLUE);
		lblcurrentWeapon.setFont(new Font("Cambria", Font.BOLD, 14));
		lblcurrentWeapon.setBounds(10, 213, 152, 25);
		inventoryPanel.add(lblcurrentWeapon);
		
		lblcurrentArmor = new JLabel("null");
		lblcurrentArmor.setHorizontalAlignment(SwingConstants.LEFT);
		lblcurrentArmor.setForeground(Color.RED);
		lblcurrentArmor.setFont(new Font("Cambria", Font.BOLD, 14));
		lblcurrentArmor.setBounds(10, 132, 152, 25);
		inventoryPanel.add(lblcurrentArmor);
		
		lblWeapon = new JLabel("Weapon");
		lblWeapon.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeapon.setFont(new Font("Cambria", Font.BOLD, 17));
		lblWeapon.setBounds(10, 168, 103, 42);
		inventoryPanel.add(lblWeapon);
		
		btnPotion = new JButton("Null");
		btnPotion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(currentPlayer.hasPotion()){
					play("/resources/blip.wav");
					currentPlayer.usePotion();
					btnTrap.setText("Used");
					btnTrap.setBackground(Color.GRAY);
					repopulate();
				}
			}
		});
		btnPotion.setFont(new Font("Cambria", Font.BOLD, 14));
		btnPotion.setBackground(Color.GRAY);
		btnPotion.setBounds(10, 302, 152, 47);
		inventoryPanel.add(btnPotion);
		
		btnTrap = new JButton("null");
		btnTrap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(currentPlayer.hasTrap() && currentPlayer.getSpace().isTrappable()){
					currentPlayer.useTrap();
					repopulate();
					btnTrap.setText("Used! Move!");
					btnTrap.setBackground(Color.GRAY);
				}
			}
		});
		btnTrap.setFont(new Font("Cambria", Font.BOLD, 14));
		btnTrap.setBackground(Color.GRAY);
		btnTrap.setBounds(10, 370, 152, 47);
		inventoryPanel.add(btnTrap);
		
		//==================== MOVE SELECTION PAGE =========================
		
		movePanel = new JPanel();
		movePanel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(movePanel, "name_257955706103938");
		movePanel.setLayout(null);
		
		button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				play("/resources/blip.wav");
				movePanel.setVisible(false);
				playerStartPanel.setVisible(true);
			}
		});
		
		lblStay = new JLabel("Stay");
		lblStay.setHorizontalAlignment(SwingConstants.CENTER);
		lblStay.setFont(new Font("Cambria", Font.BOLD, 12));
		lblStay.setBounds(110, 249, 60, 34);
		movePanel.add(lblStay);
		button.setFont(new Font("Cambria", Font.BOLD, 16));
		button.setBackground(Color.GRAY);
		button.setBounds(10, 11, 110, 25);
		movePanel.add(button);
		
		lblRight = new JLabel("");
		lblRight.setVerticalAlignment(SwingConstants.BOTTOM);
		lblRight.setFont(new Font("Cambria", Font.BOLD, 16));
		lblRight.setIcon(new ImageIcon(Screen.class.getResource("/resources/rightArrow.png")));
		lblRight.setBounds(198, 208, 50, 50);
		movePanel.add(lblRight);
		
		lblUp = new JLabel("In");
		lblUp.setFont(new Font("Cambria", Font.BOLD, 12));
		lblUp.setIcon(new ImageIcon(Screen.class.getResource("/resources/upArrow.png")));
		lblUp.setBounds(133, 147, 90, 50);
		movePanel.add(lblUp);
		
		lblLeft = new JLabel("");
		lblLeft.setFont(new Font("Cambria", Font.BOLD, 16));
		lblLeft.setIcon(new ImageIcon(Screen.class.getResource("/resources/leftArrow.png")));
		lblLeft.setBounds(70, 208, 50, 50);
		movePanel.add(lblLeft);
		
		lblDown = new JLabel("Out");
		lblDown.setFont(new Font("Cambria", Font.BOLD, 12));
		lblDown.setIcon(new ImageIcon(Screen.class.getResource("/resources/downArrow.png")));
		lblDown.setBounds(133, 282, 90, 50);
		movePanel.add(lblDown);
		
		lblCharactersLeft = new JLabel("Clockwise");
		lblCharactersLeft.setHorizontalAlignment(SwingConstants.CENTER);
		lblCharactersLeft.setFont(new Font("Cambria", Font.BOLD, 12));
		lblCharactersLeft.setBounds(37, 185, 100, 34);
		movePanel.add(lblCharactersLeft);
		
		lblCharactersRight = new JLabel("Counter-Clockwise");
		lblCharactersRight.setHorizontalAlignment(SwingConstants.CENTER);
		lblCharactersRight.setFont(new Font("Cambria", Font.BOLD, 12));
		lblCharactersRight.setBounds(176, 185, 138, 34);
		movePanel.add(lblCharactersRight);
		
		lblMove = new JLabel("Move");
		lblMove.setHorizontalAlignment(SwingConstants.CENTER);
		lblMove.setFont(new Font("Cambria", Font.BOLD, 22));
		lblMove.setBounds(53, 47, 214, 47);
		movePanel.add(lblMove);
		
		btnStay = new JButton("");
		btnStay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				movePanel.setVisible(false);
				currentPlayer.Eat();
				//Swamp
				if(currentPlayer.getSpace().getType()=="Swamp" && rando(1,3)==2){
					currentPlayer.setDiseased(true);
				}
				//Desert
				if(currentPlayer.getSpace().getType()=="Desert" && rando(1,3)==2){
					currentPlayer.setSlowed(true);
				}
				//Bazaar
				if(currentPlayer.getSpace().getType() == "Bazaar"){
					openBazaar();
					return;
				}
				if(currentPlayer.getSpace().isTrapped()){
					play("/resources/trapSprung.wav");
					repopulate();
					trapPanel.setVisible(true);
				}
				else{
					play("/resources/turnOver.wav");
					rotatePanel.setVisible(true);
				}
			}
		});
		btnStay.setIcon(new ImageIcon(Screen.class.getResource("/resources/stay.png")));
		btnStay.setBounds(133, 208, 50, 50);
		movePanel.add(btnStay);
		
		
		//desert, swamp, forest, cave, ruins, bazaar
		btnDown = new JButton("");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				movePanel.setVisible(false);
				currentPlayer.Eat();
				Space s = currentPlayer.getSpace();
				currentPlayer.setSpace(currentPlayer.getSpace().getOuter());
				spaceHandler(s,currentPlayer.getSpace());
			}
		});
		btnDown.setIcon(null);
		btnDown.setBounds(133, 343, 50, 50);
		movePanel.add(btnDown);
		
		btnLeft = new JButton("");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				movePanel.setVisible(false);
				currentPlayer.Eat();
				Space s = currentPlayer.getSpace();
				currentPlayer.setSpace(currentPlayer.getSpace().getClock());
				spaceHandler(s,currentPlayer.getSpace());
			}
		});
		btnLeft.setIcon(null);
		btnLeft.setBounds(10, 208, 50, 50);
		movePanel.add(btnLeft);
		
		btnRight = new JButton("");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				movePanel.setVisible(false);
				currentPlayer.Eat();
				Space s = currentPlayer.getSpace();
				currentPlayer.setSpace(currentPlayer.getSpace().getCount());
				spaceHandler(s,currentPlayer.getSpace());
			}
		});
		btnRight.setIcon(null);
		btnRight.setBounds(258, 208, 50, 50);
		movePanel.add(btnRight);
		
		btnUp = new JButton("");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				movePanel.setVisible(false);
				currentPlayer.Eat();
				Space s = currentPlayer.getSpace();
				currentPlayer.setSpace(currentPlayer.getSpace().getInner());
				spaceHandler(s,currentPlayer.getSpace());
			}
		});
		btnUp.setIcon(null);
		btnUp.setBounds(133, 99, 50, 50);
		movePanel.add(btnUp);
		
		//==================== COMBAT PAGE =================================
		
		combatPanel = new JPanel();
		combatPanel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(combatPanel, "name_264104150585210");
		combatPanel.setLayout(null);
		
		lblPlayerIcon = new JLabel("");
		lblPlayerIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerIcon.setIcon(new ImageIcon(Screen.class.getResource("/resources/player.png")));
		lblPlayerIcon.setBounds(56, 171, 50, 50);
		combatPanel.add(lblPlayerIcon);
		
		lblFighting = new JLabel("Combat with The Evil King");
		lblFighting.setHorizontalAlignment(SwingConstants.CENTER);
		lblFighting.setFont(new Font("Cambria", Font.BOLD, 19));
		lblFighting.setBounds(10, 56, 304, 50);
		combatPanel.add(lblFighting);
		
		lblVs = new JLabel("VS.");
		lblVs.setHorizontalAlignment(SwingConstants.CENTER);
		lblVs.setFont(new Font("Cambria", Font.BOLD, 20));
		lblVs.setBounds(121, 171, 78, 50);
		combatPanel.add(lblVs);
		
		lblEnemyIcon = new JLabel("");
		lblEnemyIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnemyIcon.setBounds(209, 171, 50, 50);
		combatPanel.add(lblEnemyIcon);
		
		lblYou = new JLabel("YOU");
		lblYou.setHorizontalAlignment(SwingConstants.CENTER);
		lblYou.setFont(new Font("Cambria", Font.BOLD, 20));
		lblYou.setBounds(31, 131, 99, 40);
		combatPanel.add(lblYou);
		
		lblThem = new JLabel("THEM");
		lblThem.setHorizontalAlignment(SwingConstants.CENTER);
		lblThem.setFont(new Font("Cambria", Font.BOLD, 20));
		lblThem.setBounds(188, 131, 99, 40);
		combatPanel.add(lblThem);
		
		lblPlayerCP = new JLabel("CP: ");
		lblPlayerCP.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerCP.setFont(new Font("Cambria", Font.BOLD, 17));
		lblPlayerCP.setBounds(20, 232, 110, 27);
		combatPanel.add(lblPlayerCP);
		
		lblEnemyCP = new JLabel("CP: ");
		lblEnemyCP.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnemyCP.setFont(new Font("Cambria", Font.BOLD, 17));
		lblEnemyCP.setBounds(188, 232, 110, 27);
		combatPanel.add(lblEnemyCP);
		
		lblPlayerHP = new JLabel("HP: ");
		lblPlayerHP.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerHP.setFont(new Font("Cambria", Font.BOLD, 17));
		lblPlayerHP.setBounds(20, 270, 110, 27);
		combatPanel.add(lblPlayerHP);
		
		lblEnemyHP = new JLabel("HP: ");
		lblEnemyHP.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnemyHP.setFont(new Font("Cambria", Font.BOLD, 17));
		lblEnemyHP.setBounds(188, 270, 110, 27);
		combatPanel.add(lblEnemyHP);
		
		lblSwing = new JLabel("");
		lblSwing.setHorizontalAlignment(SwingConstants.CENTER);
		lblSwing.setBounds(132, 270, 60, 60);
		combatPanel.add(lblSwing);
		
		lblDamage = new JLabel("");
		lblDamage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDamage.setFont(new Font("Cambria", Font.BOLD, 18));
		lblDamage.setBounds(10, 331, 304, 50);
		combatPanel.add(lblDamage);
		
		btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				combatPanel.setVisible(false);
				if(!currentPlayer.isDead()){
					if(tier == "Throne Room"){
						victoryPanel.setVisible(true);
						play("/resources/finalvictory.wav");
						return;
					}
					if(rando(1,6) != 1){
						lootter(tier);
					} else {
						play("/resources/turnOver.wav");
						rotatePanel.setVisible(true);
					}
				} else {
					play("/resources/turnOver.wav");
					rotatePanel.setVisible(true);
				}
			}
		});
		btnContinue.setFont(new Font("Cambria", Font.BOLD, 16));
		btnContinue.setBackground(Color.WHITE);
		btnContinue.setBounds(99, 11, 126, 45);
		combatPanel.add(btnContinue);
		
		//==================== BAZZAR PAGE =================================
		
		bazaarPanel = new JPanel();
		bazaarPanel.setBackground(Color.PINK);
		frame.getContentPane().add(bazaarPanel, "name_264106582521953");
		bazaarPanel.setLayout(null);
		
		JButton btbDone = new JButton("Done");
		btbDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bazaarPanel.setVisible(false);
				play("/resources/turnOver.wav");
				rotatePanel.setVisible(true);
			}
		});
		btbDone.setFont(new Font("Cambria", Font.BOLD, 16));
		btbDone.setBackground(Color.WHITE);
		btbDone.setBounds(10, 11, 110, 25);
		bazaarPanel.add(btbDone);
		
		JLabel lblWelcomeToMy = new JLabel("Welcome to my Bazaar");
		lblWelcomeToMy.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToMy.setFont(new Font("Cambria", Font.BOLD, 22));
		lblWelcomeToMy.setBounds(15, 47, 294, 47);
		bazaarPanel.add(lblWelcomeToMy);
		
		btnBarter = new JButton("Barter");
		btnBarter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(canBarter){//success
					int p1 = Integer.parseInt(btnBuy1.getText());
					int p2 = Integer.parseInt(btnBuy2.getText());
					int p3 = Integer.parseInt(btnBuy3.getText());
					int p4 = Integer.parseInt(btnBuyFood.getText());
					p1 = p1 - p1/4;
					p2 = p2 - p2/4;
					p3 = p3 - p3/4;
					p4 = p4 - p4/4;
					btnBuy1.setText(String.valueOf(p1));
					btnBuy2.setText(String.valueOf(p2));
					btnBuy3.setText(String.valueOf(p3));
					btnBuyFood.setText(String.valueOf(p4));
					int b = rando(1,4);
					if(b!=2){
						canBarter = false;
					}
				} else {//fail
					bazaarPanel.setVisible(false);
					play("/resources/bazaarCloses.wav");
					rotatePanel.setVisible(true);
				}
			}
		});
		btnBarter.setFont(new Font("Cambria", Font.BOLD, 16));
		btnBarter.setBackground(Color.WHITE);
		btnBarter.setBounds(184, 99, 130, 41);
		bazaarPanel.add(btnBarter);
		
		btnBuy3 = new JButton("Buy");
		btnBuy3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				provider(lblItem3.getText(),Integer.parseInt(btnBuy3.getText()));
				btnBuy3.setBackground(Color.GRAY);
				btnBuy3.setEnabled(false);
			}
		});
		btnBuy3.setFont(new Font("Cambria", Font.BOLD, 16));
		btnBuy3.setBackground(Color.WHITE);
		btnBuy3.setBounds(225, 302, 84, 41);
		bazaarPanel.add(btnBuy3);
		
		btnBuy2 = new JButton("Buy");
		btnBuy2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				provider(lblItem2.getText(),Integer.parseInt(btnBuy2.getText()));
				btnBuy2.setBackground(Color.GRAY);
				btnBuy2.setEnabled(false);
			}
		});
		btnBuy2.setFont(new Font("Cambria", Font.BOLD, 16));
		btnBuy2.setBackground(Color.WHITE);
		btnBuy2.setBounds(225, 238, 84, 41);
		bazaarPanel.add(btnBuy2);
		
		btnBuy1 = new JButton("Buy");
		btnBuy1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				provider(lblItem1.getText(),Integer.parseInt(btnBuy1.getText()));
				btnBuy1.setBackground(Color.GRAY);
				btnBuy1.setEnabled(false);
			}
		});
		btnBuy1.setFont(new Font("Cambria", Font.BOLD, 16));
		btnBuy1.setBackground(Color.WHITE);
		btnBuy1.setBounds(225, 174, 84, 41);
		bazaarPanel.add(btnBuy1);
		
		btnBuyFood = new JButton("25");
		btnBuyFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(currentPlayer.getGold()>=25){
					currentPlayer.setFood(currentPlayer.getFood()+5);
					currentPlayer.setGold(currentPlayer.getGold()-25);
					play("/resources/blip.wav");
					repopulate();
				} else {
					play("/resources/turnOver.wav");
				}
			}
		});
		btnBuyFood.setFont(new Font("Cambria", Font.BOLD, 16));
		btnBuyFood.setBackground(Color.WHITE);
		btnBuyFood.setBounds(225, 363, 84, 41);
		bazaarPanel.add(btnBuyFood);
		
		lblBGold = new JLabel("Your Gold: ");
		lblBGold.setFont(new Font("Cambria", Font.BOLD, 16));
		lblBGold.setBounds(10, 105, 150, 34);
		bazaarPanel.add(lblBGold);
		
		lblItem1 = new JLabel("Item1");
		lblItem1.setFont(new Font("Cambria", Font.BOLD, 14));
		lblItem1.setBounds(10, 174, 130, 41);
		bazaarPanel.add(lblItem1);
		
		lblItem2 = new JLabel("Item2");
		lblItem2.setFont(new Font("Cambria", Font.BOLD, 14));
		lblItem2.setBounds(10, 238, 130, 41);
		bazaarPanel.add(lblItem2);
		
		lblItem3 = new JLabel("Item4");
		lblItem3.setFont(new Font("Cambria", Font.BOLD, 14));
		lblItem3.setBounds(10, 302, 130, 41);
		bazaarPanel.add(lblItem3);
		
		lblBuyFood = new JLabel("Food:");
		lblBuyFood.setFont(new Font("Cambria", Font.BOLD, 14));
		lblBuyFood.setBounds(10, 363, 110, 41);
		bazaarPanel.add(lblBuyFood);
		
		lblItem1Effect = new JLabel("+some");
		lblItem1Effect.setFont(new Font("Cambria", Font.BOLD, 14));
		lblItem1Effect.setBounds(150, 174, 68, 41);
		bazaarPanel.add(lblItem1Effect);
		
		lblItem2Effect = new JLabel("+some");
		lblItem2Effect.setFont(new Font("Cambria", Font.BOLD, 14));
		lblItem2Effect.setBounds(147, 238, 68, 41);
		bazaarPanel.add(lblItem2Effect);
		
		lblItem3Effect = new JLabel("+some");
		lblItem3Effect.setFont(new Font("Cambria", Font.BOLD, 14));
		lblItem3Effect.setBounds(150, 302, 68, 41);
		bazaarPanel.add(lblItem3Effect);
		
		JLabel lblFoodEffect = new JLabel("+5 Food");
		lblFoodEffect.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoodEffect.setFont(new Font("Cambria", Font.BOLD, 14));
		lblFoodEffect.setBounds(130, 363, 88, 41);
		bazaarPanel.add(lblFoodEffect);
		
		//==================== RUINS PAGE ==================================
		
		ruinPanel = new JPanel();
		ruinPanel.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(ruinPanel, "name_264108286407165");
		ruinPanel.setLayout(null);
		
		lblYouHaveFound_1 = new JLabel("You have found some ruins!");
		lblYouHaveFound_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblYouHaveFound_1.setForeground(Color.WHITE);
		lblYouHaveFound_1.setFont(new Font("Cambria", Font.BOLD, 22));
		lblYouHaveFound_1.setBounds(5, 69, 314, 59);
		ruinPanel.add(lblYouHaveFound_1);
		
		btnNW = new JButton("No Way!");
		btnNW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ruinPanel.setVisible(false);
				play("/resources/turnOver.wav");
				rotatePanel.setVisible(true);
			}
		});
		btnNW.setFont(new Font("Cambria", Font.BOLD, 16));
		btnNW.setBackground(Color.LIGHT_GRAY);
		btnNW.setBounds(20, 305, 132, 45);
		ruinPanel.add(btnNW);
		
		btnBI = new JButton("Bring It!");
		btnBI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ruinPanel.setVisible(false);
				int cran = rando(1,5);
				if(cran != 2){
					combat("epic");
					return;
				} else {
					lootter("epic");
				}
			}
		});
		btnBI.setFont(new Font("Cambria", Font.BOLD, 16));
		btnBI.setBackground(Color.LIGHT_GRAY);
		btnBI.setBounds(171, 305, 132, 45);
		ruinPanel.add(btnBI);
		
		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Screen.class.getResource("/resources/ruins.png")));
		label_2.setBounds(137, 139, 50, 50);
		ruinPanel.add(label_2);
		
		JTextPane txtpnWouldYouLike = new JTextPane();
		txtpnWouldYouLike.setFont(new Font("Cambria", Font.BOLD, 22));
		txtpnWouldYouLike.setForeground(Color.WHITE);
		txtpnWouldYouLike.setBackground(Color.DARK_GRAY);
		txtpnWouldYouLike.setText("Would you like to go inside?");
		txtpnWouldYouLike.setEditable(false);
		txtpnWouldYouLike.setBounds(12, 200, 299, 94);
		ruinPanel.add(txtpnWouldYouLike);
		
		//==================== CAVES PAGE ==================================
		
		cavePanel = new JPanel();
		cavePanel.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(cavePanel, "name_264109808785584");
		cavePanel.setLayout(null);
		
		lblYouHaveFound = new JLabel("You have found a cave!");
		lblYouHaveFound.setHorizontalAlignment(SwingConstants.CENTER);
		lblYouHaveFound.setForeground(Color.WHITE);
		lblYouHaveFound.setFont(new Font("Cambria", Font.BOLD, 24));
		lblYouHaveFound.setBounds(5, 54, 314, 59);
		cavePanel.add(lblYouHaveFound);
		
		JButton btnNoWay = new JButton("No Way!");
		btnNoWay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cavePanel.setVisible(false);
				play("/resources/turnOver.wav");
				rotatePanel.setVisible(true);
			}
		});
		btnNoWay.setFont(new Font("Cambria", Font.BOLD, 16));
		btnNoWay.setBackground(Color.LIGHT_GRAY);
		btnNoWay.setBounds(20, 305, 134, 45);
		cavePanel.add(btnNoWay);
		
		JButton btnBringIt = new JButton("Bring It!");
		btnBringIt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cavePanel.setVisible(false);
				int cran = rando(1,5);
				if(cran != 2){
					combat("epic");
					return;
				} else {
					lootter("epic");
				}
			}
		});
		btnBringIt.setFont(new Font("Cambria", Font.BOLD, 16));
		btnBringIt.setBackground(Color.LIGHT_GRAY);
		btnBringIt.setBounds(172, 305, 134, 45);
		cavePanel.add(btnBringIt);
		
		JLabel lblCaveIcon = new JLabel("");
		lblCaveIcon.setIcon(new ImageIcon(Screen.class.getResource("/resources/cave.png")));
		lblCaveIcon.setBounds(137, 140, 50, 50);
		cavePanel.add(lblCaveIcon);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("Would you like to go inside?");
		textPane.setForeground(Color.WHITE);
		textPane.setFont(new Font("Cambria", Font.BOLD, 22));
		textPane.setEditable(false);
		textPane.setBackground(Color.DARK_GRAY);
		textPane.setBounds(12, 201, 299, 94);
		cavePanel.add(textPane);
		
		//==================== ROTATE PAGE ==================================
		
		rotatePanel = new JPanel();
		rotatePanel.setBackground(Color.BLACK);
		frame.getContentPane().add(rotatePanel, "name_264249039774567");
		rotatePanel.setLayout(null);
		
		lblRotate = new JLabel("ROTATE TO NEXT PLAYER");
		lblRotate.setHorizontalAlignment(SwingConstants.CENTER);
		lblRotate.setForeground(Color.WHITE);
		lblRotate.setFont(new Font("Cambria", Font.BOLD, 22));
		lblRotate.setBounds(10, 116, 304, 51);
		rotatePanel.add(lblRotate);
		
		lblRotateArrow = new JLabel("");
		lblRotateArrow.setIcon(new ImageIcon(Screen.class.getResource("/resources/leftRotate.png")));
		lblRotateArrow.setBounds(33, 151, 255, 287);
		rotatePanel.add(lblRotateArrow);
		
		btnReady = new JButton("Ready");
		btnReady.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rotatePanel.setVisible(false);
				currentPlayer.endRound();
				if(currentPlayer.isFinalPlayer() && dragonLives){
					currentPlayer = currentPlayer.nextPlayer();
					dragonPanel.setVisible(true);
					dragonRunner();
					return;
				}
				currentPlayer = currentPlayer.nextPlayer();
				repopulate();
				play("/resources/blip.wav");
				playerStartPanel.setVisible(true);
			}
		});
		btnReady.setBackground(Color.LIGHT_GRAY);
		btnReady.setFont(new Font("Cambria", Font.BOLD, 16));
		btnReady.setBounds(106, 22, 101, 45);
		rotatePanel.add(btnReady);
		
		lblTurnOver = new JLabel("TURN OVER");
		lblTurnOver.setHorizontalAlignment(SwingConstants.CENTER);
		lblTurnOver.setForeground(Color.RED);
		lblTurnOver.setFont(new Font("Cambria", Font.BOLD, 22));
		lblTurnOver.setBounds(10, 53, 304, 82);
		rotatePanel.add(lblTurnOver);
		
		//==================== DRAGON PAGE ==================================
		
		dragonPanel = new JPanel();
		dragonPanel.setBackground(Color.RED);
		frame.getContentPane().add(dragonPanel, "name_264250839698398");
		dragonPanel.setLayout(null);
		
		JLabel lblDragonIcon = new JLabel("");
		lblDragonIcon.setIcon(new ImageIcon(Screen.class.getResource("/resources/dragon.png")));
		lblDragonIcon.setBounds(98, 177, 128, 128);
		dragonPanel.add(lblDragonIcon);
		
		btnDReady = new JButton("Lassallax Ready?");
		btnDReady.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dragonPanel.setVisible(false);
				repopulate();
				play("/resources/blip.wav");
				playerStartPanel.setVisible(true);
			}
		});
		btnDReady.setFont(new Font("Cambria", Font.BOLD, 16));
		btnDReady.setBackground(Color.LIGHT_GRAY);
		btnDReady.setBounds(69, 28, 186, 45);
		dragonPanel.add(btnDReady);
		
		JLabel lblDragonsTurn = new JLabel("MANGELOR'S TURN");
		lblDragonsTurn.setHorizontalAlignment(SwingConstants.CENTER);
		lblDragonsTurn.setForeground(Color.WHITE);
		lblDragonsTurn.setFont(new Font("Cambria", Font.BOLD, 22));
		lblDragonsTurn.setBounds(10, 94, 304, 51);
		dragonPanel.add(lblDragonsTurn);
		
		lblDragonPosition = new JTextPane();
		lblDragonPosition.setFont(new Font("Cambria", Font.BOLD, 20));
		lblDragonPosition.setForeground(Color.WHITE);
		lblDragonPosition.setBackground(Color.RED);
		lblDragonPosition.setEditable(false);
		lblDragonPosition.setBounds(10, 333, 304, 85);
		dragonPanel.add(lblDragonPosition);
		
		//===================== SETTINGS PAGE =============================
		
		settingsPanel = new JPanel();
		settingsPanel.setBackground(Color.BLACK);
		frame.getContentPane().add(settingsPanel, "name_257950747583981");
		settingsPanel.setLayout(null);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO saving
			     try {
			    	 File cwdFile = new File (".");
			    	 String cwd = cwdFile.getAbsolutePath();
			    	 File f = new File(cwd+"gboard.ser");
			    	 if (!f.exists()) {
							f.createNewFile();
					}
			         FileOutputStream fileOut = new FileOutputStream(f);
			         ObjectOutputStream out = new ObjectOutputStream(fileOut);
			         
			         gameBoard.currentPlayer = currentPlayer;
			         gameBoard.dragonLives = dragonLives;
			         
			         out.writeObject(gameBoard);
			         out.close();
			         fileOut.close();
			         btnSave.setText("Saved");
			         
			         System.out.println("Serialized data is saved in /resources/gboard.ser");
			      }catch(IOException  i) {
			         i.printStackTrace();
			         btnSave.setText("Error");
			      }
			}
		});
		btnSave.setFont(new Font("Dialog", Font.BOLD, 20));
		btnSave.setBackground(Color.WHITE);
		btnSave.setBounds(89, 128, 162, 66);
		settingsPanel.add(btnSave);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				settingsPanel.setVisible(false);
				currentPlayer = new Player();
				play("/resources/turnOver.wav");
				gameBoard = new Board();
				startPanel.setVisible(true);
			}
		});
		btnQuit.setFont(new Font("Dialog", Font.BOLD, 20));
		btnQuit.setBackground(Color.WHITE);
		btnQuit.setBounds(89, 265, 162, 66);
		settingsPanel.add(btnQuit);
		
		JButton btnBack_1 = new JButton("Back");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				settingsPanel.setVisible(false);
				play("/resources/blip.wav");
				playerStartPanel.setVisible(true);
			}
		});
		btnBack_1.setFont(new Font("Dialog", Font.BOLD, 16));
		btnBack_1.setBackground(Color.WHITE);
		btnBack_1.setBounds(6, 6, 124, 33);
		settingsPanel.add(btnBack_1);
		
		//====================== TRAP PAGE ==================================
		
		trapPanel = new JPanel();
		trapPanel.setLayout(null);
		trapPanel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(trapPanel, "name_634909162301115");
		
		JButton btnOkay = new JButton("OK");
		btnOkay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				trapPanel.setVisible(false);
				//Activate trap on player
				currentPlayer.trapped(currentPlayer.getSpace().getTrap().getType());
				currentPlayer.getSpace().setTrap(null);
				play("/resources/turnOver.wav");
				rotatePanel.setVisible(true);
			}
		});
		btnOkay.setFont(new Font("Cambria", Font.BOLD, 16));
		btnOkay.setBackground(Color.WHITE);
		btnOkay.setBounds(111, 335, 101, 45);
		trapPanel.add(btnOkay);
		
		lblTraptype = new JLabel("TrapType");
		lblTraptype.setForeground(Color.RED);
		lblTraptype.setHorizontalAlignment(SwingConstants.CENTER);
		lblTraptype.setFont(new Font("Cambria", Font.BOLD, 25));
		lblTraptype.setBounds(33, 36, 257, 77);
		trapPanel.add(lblTraptype);
		
		lblTrapEffect = new JTextPane();
		lblTrapEffect.setEditable(false);
		lblTrapEffect.setText("effect");
		lblTrapEffect.setFont(new Font("Cambria", Font.BOLD, 18));
		lblTrapEffect.setBackground(Color.LIGHT_GRAY);
		lblTrapEffect.setBounds(33, 124, 257, 202);
		trapPanel.add(lblTrapEffect);
		
		//============================= KEY PAGE =============================
		
		keyPanel = new JPanel();
		keyPanel.setLayout(null);
		keyPanel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(keyPanel, "name_710502356464675");
		
		btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				keyPanel.setVisible(false);
				play("/resources/turnOver.wav");
				rotatePanel.setVisible(true);
			}
		});
		btnOK.setFont(new Font("Cambria", Font.BOLD, 16));
		btnOK.setBackground(Color.WHITE);
		btnOK.setBounds(111, 335, 101, 45);
		keyPanel.add(btnOK);
		
		lblKeyname = new JLabel("KeyName");
		lblKeyname.setHorizontalAlignment(SwingConstants.CENTER);
		lblKeyname.setForeground(Color.BLUE);
		lblKeyname.setFont(new Font("Cambria", Font.BOLD, 25));
		lblKeyname.setBounds(33, 36, 257, 77);
		keyPanel.add(lblKeyname);
		
		txtpnDesc = new JTextPane();
		txtpnDesc.setText("Desc");
		txtpnDesc.setFont(new Font("Cambria", Font.BOLD, 18));
		txtpnDesc.setEditable(false);
		txtpnDesc.setBackground(Color.LIGHT_GRAY);
		txtpnDesc.setBounds(33, 124, 257, 202);
		keyPanel.add(txtpnDesc);
		
		//===============================  LOOT PAGE    ===============================
		
		lootPanel = new JPanel();
		lootPanel.setLayout(null);
		lootPanel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(lootPanel, "name_704231918780171");
		
		lblLootName = new JLabel("Item/Gold");
		lblLootName.setHorizontalAlignment(SwingConstants.CENTER);
		lblLootName.setFont(new Font("Cambria", Font.BOLD, 18));
		lblLootName.setBounds(10, 162, 304, 50);
		lootPanel.add(lblLootName);
		
		btnAccept = new JButton("Accept");
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lootPanel.setVisible(false);
				accept();
				play("/resources/turnOver.wav");
				rotatePanel.setVisible(true);
			}
		});
		btnAccept.setFont(new Font("Cambria", Font.BOLD, 16));
		btnAccept.setBackground(Color.WHITE);
		btnAccept.setBounds(24, 28, 126, 45);
		lootPanel.add(btnAccept);
		
		lblLootFound = new JLabel("YOU HAVE FOUND");
		lblLootFound.setHorizontalAlignment(SwingConstants.CENTER);
		lblLootFound.setFont(new Font("Cambria", Font.BOLD, 19));
		lblLootFound.setBounds(10, 84, 304, 50);
		lootPanel.add(lblLootFound);
		
		btnDecline = new JButton("Decline");
		btnDecline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lootPanel.setVisible(false);
				play("/resources/turnOver.wav");
				rotatePanel.setVisible(true);
			}
		});
		btnDecline.setFont(new Font("Cambria", Font.BOLD, 16));
		btnDecline.setBackground(Color.WHITE);
		btnDecline.setBounds(174, 28, 126, 45);
		lootPanel.add(btnDecline);
		
		lblLootValue = new JTextPane();
		lblLootValue.setFont(new Font("Cambria", Font.BOLD, 18));
		lblLootValue.setEditable(false);
		lblLootValue.setBackground(Color.LIGHT_GRAY);
		lblLootValue.setBounds(35, 223, 269, 213);
		lootPanel.add(lblLootValue);
		
		//===================== VICTORY PANEL ===============================
		
		victoryPanel = new JPanel();
		victoryPanel.setLayout(null);
		victoryPanel.setBackground(Color.WHITE);
		frame.getContentPane().add(victoryPanel, "name_22782025038433");
		
		lblVictor = new JLabel("YOU ARE VICTORIOUS");
		lblVictor.setHorizontalAlignment(SwingConstants.CENTER);
		lblVictor.setForeground(Color.BLACK);
		lblVictor.setFont(new Font("Dialog", Font.BOLD, 22));
		lblVictor.setBounds(10, 116, 304, 51);
		victoryPanel.add(lblVictor);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Screen.class.getResource("/resources/victory.png")));
		label_1.setBounds(33, 151, 255, 321);
		victoryPanel.add(label_1);
		
		btnGameWon = new JButton("Done");
		btnGameWon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				victoryPanel.setVisible(false);
				currentPlayer = new Player();
				gameBoard = new Board();
				startPanel.setVisible(true);
			}
		});
		btnGameWon.setFont(new Font("Dialog", Font.BOLD, 16));
		btnGameWon.setBackground(Color.LIGHT_GRAY);
		btnGameWon.setBounds(106, 22, 101, 45);
		victoryPanel.add(btnGameWon);
		
		lblGameOver = new JLabel("GAME OVER");
		lblGameOver.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameOver.setForeground(Color.RED);
		lblGameOver.setFont(new Font("Dialog", Font.BOLD, 22));
		lblGameOver.setBounds(10, 53, 304, 82);
		victoryPanel.add(lblGameOver);
		
		
	}
	
	public void boarder(){
		//set up # of players and put them in starting positions on board
		switch (numPlayers){
			case 1:
				playerOne = new Player();
				playerOne.setHomeKingdom("Lassallax");
				playerOne.setNextPlayer(playerOne);
				playerOne.makeFinalPlayer();
				gameBoard.initialize(1, playerOne, playerTwo, playerThree, playerFour, dragon);
				break;
			case 2:
				playerOne = new Player();
				playerOne.setHomeKingdom("Lassallax");
				playerTwo = new Player();
				playerTwo.setHomeKingdom("Derelin");
				playerOne.setNextPlayer(playerTwo);
				playerTwo.setNextPlayer(playerOne);
				playerTwo.makeFinalPlayer();
				gameBoard.initialize(2, playerOne, playerTwo, playerThree, playerFour, dragon);
				break;
			case 3:
				playerOne = new Player();
				playerOne.setHomeKingdom("Lassallax");
				playerTwo = new Player();
				playerTwo.setHomeKingdom("Derelin");
				playerThree = new Player();
				playerThree.setHomeKingdom("Wybengaland");
				playerOne.setNextPlayer(playerTwo);
				playerTwo.setNextPlayer(playerThree);
				playerThree.setNextPlayer(playerOne);
				playerThree.makeFinalPlayer();
				gameBoard.initialize(3, playerOne, playerTwo, playerThree, playerFour, dragon);
				break;
			case 4:
				playerOne = new Player();
				playerOne.setHomeKingdom("Lassallax");
				playerTwo = new Player();
				playerTwo.setHomeKingdom("Derelin");
				playerThree = new Player();
				playerThree.setHomeKingdom("Wybengaland");
				playerFour = new Player();
				playerFour.setHomeKingdom("Mangia");
				playerOne.setNextPlayer(playerTwo);
				playerTwo.setNextPlayer(playerThree);
				playerThree.setNextPlayer(playerFour);
				playerFour.setNextPlayer(playerOne);
				playerFour.makeFinalPlayer();
				gameBoard.initialize(4, playerOne, playerTwo, playerThree, playerFour, dragon);
				break;
		}
		currentPlayer = playerOne;
		repopulate();
	}
	
	//sets all the labels and text fields to the right value for the current player
	public void repopulate(){
		//==================== PLAYER START SCREEN ============================
		
		String stats = "";
		if(currentPlayer.isDiseased()){
			stats += "Diseased: 1/2 HP\n";
		}
		if(currentPlayer.isLost()){
			stats += "Lost: Turn Skipped\n";
		}
		if(currentPlayer.isRobbed()){
			stats += "You have been Robbed!\n";
		}
		if(currentPlayer.isSlowed()){
			stats += "Slowed: Consuming 2x Food\n";
		}
		if(currentPlayer.isStarving()){
			stats += "Starving: Losing HP\n";
		}
		if(currentPlayer.isDead()){
			stats += "You Died!\n";
		}
		if(stats.length()<3){
			stats = "No Negative Effects\n";
		}
		statusPane.setText(stats);
		lblcurrentPlayer.setText("Knight of " + currentPlayer.getHomeKingdom());
		lblGold.setText("Gold: "+currentPlayer.getGold());
		lblHP.setText("HP: " + currentPlayer.getHealthPoints());
		lblCP.setText("CP: " + currentPlayer.getCombatPower());
		lblFood.setText("Food: " + currentPlayer.getFood());
		
		//========================= INVENTORY SCREEN ======================================
		
		//KEYS
		//{courage, wisdom, strength}
		String keys = "";
		if(currentPlayer.getKeys()[0]){
			keys += "Key of Courage\n";
		}
		if(currentPlayer.getKeys()[1]){
			keys += "Key of Wisdom\n";
		}
		if(currentPlayer.getKeys()[2]){
			keys += "Key of Strength\n";
		}
		if(keys.length()<3){
			keys = "No Keys Yet!\n";
		}
		keyPane.setText(keys);
		
		//POTION
		if(currentPlayer.hasPotion()){
			btnPotion.setText(currentPlayer.getPotion().getType());
			btnPotion.setBackground(Color.WHITE);
		}
		else {
			btnPotion.setText("No Potions");
			btnTrap.setBackground(Color.GRAY);
		}
		//TRAPS
		if(currentPlayer.hasTrap()){
			btnTrap.setText(currentPlayer.getTrap().getType());
			btnTrap.setBackground(Color.WHITE);
		}
		else {
			btnTrap.setText("No Traps");
			btnTrap.setBackground(Color.GRAY);
		}
		
		//ARMOR
		if(currentPlayer.hasArmor()){
			lblcurrentArmor.setText(currentPlayer.getArmor().getType() + ": +" + currentPlayer.getArmor().getEffect() + "HP");
		} else {
			lblcurrentArmor.setText("No Armor: +0HP");
		}
		//WEAPON
		if(currentPlayer.hasWeapon()){
			lblcurrentWeapon.setText(currentPlayer.getWeapon().getType() + ": +" + currentPlayer.getWeapon().getEffect() + "CP");
		} else {
			lblcurrentWeapon.setText("No Weapon: +0CP");
		}
		//MAGICAL ITEM
		if(currentPlayer.hasMagicItem()){
			magicPane.setText(currentPlayer.getMagicItem().getType()+"\n -" + currentPlayer.getMagicItem().getEffect());
		} else {
			magicPane.setText("No Magical Items!");
		}
		
		
		//================================ ROTATE SCREEN ===========================================================
		//ARROW
		if(numPlayers > 1){
			if(currentPlayer.isFinalPlayer()){
				lblRotateArrow.setIcon(new ImageIcon(Screen.class.getResource("/resources/rightRotate.png")));
			} else {
				lblRotateArrow.setIcon(new ImageIcon(Screen.class.getResource("/resources/leftRotate.png")));
			}
			//label
			lblRotate.setText("ROTATE TO " + currentPlayer.nextPlayer().getHomeKingdom());
		} else {
			lblRotate.setText("WAITING FOR " + currentPlayer.nextPlayer().getHomeKingdom());
			lblRotateArrow.setIcon(new ImageIcon(Screen.class.getResource("/resources/black.png")));
		}
		lblTurnOver.setText("TURN OVER");
		
		//================================ MOVE SCREEN ===========================================================
		
		Space up = currentPlayer.getSpace().getInner();
		Space down = currentPlayer.getSpace().getOuter();
		Space right = currentPlayer.getSpace().getCount();
		Space left = currentPlayer.getSpace().getClock();
		
		//OUTTER OPTION
		if(down == null){
			btnDown.setIcon(null);
			btnDown.setEnabled(false);
			btnDown.setVisible(false);
			lblDown.setEnabled(false);
			lblDown.setVisible(false);
		} else {
			btnDown.setIcon(new ImageIcon(Screen.class.getResource(down.getIcon())));
			btnDown.setEnabled(true);
			btnDown.setVisible(true);
			lblDown.setEnabled(true);
			lblDown.setVisible(true);
		}
		
		//INNER OPTION
		if(up == null){
			btnUp.setIcon(null);
			btnUp.setEnabled(false);
			btnUp.setVisible(false);
			lblUp.setEnabled(false);
			lblUp.setVisible(false);
		} else {
			btnUp.setIcon(new ImageIcon(Screen.class.getResource(up.getIcon())));
			btnUp.setEnabled(true);
			btnUp.setVisible(true);
			lblUp.setEnabled(true);
			lblUp.setVisible(true);
		}
		
		//CLOCKWISE OPTION
		if(left == null){
			btnLeft.setIcon(null);
			btnLeft.setEnabled(false);
			btnLeft.setVisible(false);
			lblLeft.setEnabled(false);
			lblLeft.setVisible(false);
			lblCharactersLeft.setEnabled(false);
			lblCharactersLeft.setVisible(false);
		} else {
			btnLeft.setIcon(new ImageIcon(Screen.class.getResource(left.getIcon())));
			btnLeft.setEnabled(true);
			btnLeft.setVisible(true);
			lblLeft.setEnabled(true);
			lblLeft.setVisible(true);
			lblCharactersLeft.setEnabled(true);
			lblCharactersLeft.setVisible(true);
		}
		
		//COUNTER-CLOCKWISE OPTION
		if(right == null){
			btnRight.setIcon(null);
			btnRight.setEnabled(false);
			btnRight.setVisible(false);
			lblRight.setEnabled(false);
			lblRight.setVisible(false);
			lblCharactersRight.setEnabled(false);
			lblCharactersRight.setVisible(false);
		} else {
			btnRight.setIcon(new ImageIcon(Screen.class.getResource(right.getIcon())));
			btnRight.setEnabled(true);
			btnRight.setVisible(true);
			lblRight.setEnabled(true);
			lblRight.setVisible(true);
			lblCharactersRight.setEnabled(true);
			lblCharactersRight.setVisible(true);
		}
		//STAY
		btnStay.setIcon(new ImageIcon(Screen.class.getResource(currentPlayer.getSpace().getIcon())));
		
		//======================== TRAP SCREEN ====================================================
		
		if(currentPlayer.getSpace().isTrapped()){
			lblTrapEffect.setText(currentPlayer.getSpace().getTrap().getDesc());
			lblTraptype.setText(currentPlayer.getSpace().getTrap().getType());
		}
		
		//======================== Bazaar ==========================
		lblBGold.setText("Your Gold: "+currentPlayer.getGold());
		btnBuyFood.setText("25");
		
		////======================== Dragon SCREEN ====================================================
		lblDragonPosition.setText("Moving...");
		
		//============================= COMBAT SCREEN==================================
		lblPlayerCP.setText("CP: " + currentPlayer.getCombatPower());
		lblDamage.setText("");
		
		//============================= LOOT SCREEN ==========================
		lblLootValue.setText("");
	}
	
	public void spaceHandler(Space b,Space s){
		//performs actions based on which space a player just entered
		
		boolean[] k = currentPlayer.getKeys();
		//Enter new kingdom and get a key
		if(s.isKingdom() && !currentPlayer.hasVisited(s.getType())){
			currentPlayer.setVisited(s.getType());
			txtpnDesc.setText("Congratulations!\nThe people of " + s.getType() + " have granted you a key!");
			//courage wisdom strength
			if(!k[0]){
				currentPlayer.setKeyofCourage(true);
				lblKeyname.setText("Key of Courage");
				play("/resources/keyGained.wav");
				keyPanel.setVisible(true);
				return;
			} else if(!k[1]){
				currentPlayer.setKeyofWisdom(true);
				lblKeyname.setText("Key of Wisdom");
				play("/resources/keyGained.wav");
				keyPanel.setVisible(true);
				return;
			} else if(!k[2]){
				currentPlayer.setKeyofStrength(true);
				lblKeyname.setText("Key of Strength");
				play("/resources/keyGained.wav");
				keyPanel.setVisible(true);
				return;
			}
		}
		
		//trapped space
		if(s.isTrapped()){
			play("/resources/trapSprung.wav");
			repopulate();
			trapPanel.setVisible(true);
			return;
		}
		
		//ruins
		if(s.getType() == "Ruins"){
			play("/resources/dragonTurn.wav");
			ruinPanel.setVisible(true);
			return;
		}
		
		//caves
		if(s.getType() == "Caves"){
			play("/resources/dragonTurn.wav");
			cavePanel.setVisible(true);
			return;
		}
		
		//Bazaar
		if(s.getType() == "Bazaar"){
			openBazaar();
			return;
		}
		
		//Swamp
		if(s.getType()=="Swamp" && rando(1,3)==2){
			currentPlayer.setDiseased(true);
		}
		
		//Desert
		if(s.getType()=="Desert" && rando(1,3)==2){
			currentPlayer.setSlowed(true);
		}
		//Castle Gates
		if(s.getType()=="Castle Gates"){
			if(k[0]&&k[1]&&k[2]){
				//player has all the keys
				play("/resources/gateOpen.wav");
				lblTurnOver.setText("THE GATES HAVE OPENED");
				rotatePanel.setVisible(true);
				return;
			} else {
				play("/resources/gateShut.wav");
				currentPlayer.setSpace(b);
				lblTurnOver.setText("NOT ENOUGH KEYS");
				rotatePanel.setVisible(true);
				return;
			}
		}
		
		if(s.getType()=="Courtyard"){
			combat(s.getType());
			return;
		}
		if(s.getType()=="Royal Staircase"){
			combat(s.getType());
			return;
		}
		if(s.getType()=="Throne Room"){
			combat(s.getType());
			return;
		}
		
		//Combat
		int cran = rando(1,5);
		if(cran == 4){
			combat("standard");
			return;
		}
		
		//None of the above
		play("/resources/turnOver.wav");
		rotatePanel.setVisible(true);
	}
	
	public void combat(String typ){
		btnContinue.setVisible(false);
		currentPlayer.initEffectiveHP();
		currentEnemy = getEnemy(typ);
		play("/resources/combatStart.wav");
		populateCombat();
		combatPanel.setVisible(true);
		
		Timer t = new Timer(1000,null);
		t.addActionListener(new ActionListener(){
		     boolean playTurn = true;
		     public void actionPerformed(ActionEvent e){
		    	 play(fightSounds[rando(0,3)]);
		    	 if(playTurn){
		    		 lblSwing.setIcon(new ImageIcon(Screen.class.getResource("/resources/playerSwing.png")));
		    		 int damage = currentPlayer.getCombatPower()/2 + currentPlayer.getCombatPower()/rando(2,5);
		    		 lblDamage.setText("THEY TAKE " + damage + " DAMAGE");
		    		 currentEnemy.subtractHP(damage);
		    		 populateCombat();
		    	 } else {
		    		 lblSwing.setIcon(new ImageIcon(Screen.class.getResource("/resources/enemySwing.png")));
		    		 int damage = currentEnemy.getCP()/2 + currentEnemy.getCP()/rando(2,5);
		    		 lblDamage.setText("YOU TAKE " + damage + " DAMAGE");
		    		 currentPlayer.setEffectiveHP(currentPlayer.getEffectiveHP()-damage);
		    		 populateCombat();
		    	 }
		 		 if(currentPlayer.isDead() || currentEnemy.isDead()){
		 			 if(currentPlayer.isDead()){
		 				 if(rando(1,15) == 11){
			 				 play("/resources/death2.wav");
		 				 } else {
		 					 play("/resources/death.wav");
		 				 }
		 				 currentPlayer.death();
		 				lblDamage.setText("YOU HAVE DIED");
		 			 } else {
		 				play("/resources/battleWon.wav");
		 				lblDamage.setText("THEY HAVE DIED");
		 			 }
		 			btnContinue.setVisible(true);
		        	t.stop();
		         }
		         playTurn = !playTurn;
		     }
		});
		t.setRepeats(true);
		t.start();
	}
	
	public Enemy getEnemy(String typ){
		String enemies[];
		String icons[];
		tier = typ;
		int eCP;
		int eHP;
		if(typ == "Throne Room"){
			enemies = royalEnemies;
			icons = royalEnemiesIcon;
			eCP = 40;
			eHP = 250;
			Enemy e = new Enemy(enemies[2],eHP,eCP,icons[2]);
			return e;
		} else if(typ == "Royal Staircase"){
			enemies = royalEnemies;
			icons = royalEnemiesIcon;
			eCP = 35;
			eHP = 240;
			Enemy e = new Enemy(enemies[1],eHP,eCP,icons[1]);
			return e;
		} else if(typ == "Courtyard"){
			enemies = royalEnemies;
			icons = royalEnemiesIcon;
			eCP = 30;
			eHP = 230;
			Enemy e = new Enemy(enemies[0],eHP,eCP,icons[0]);
			return e;
		} else if(typ == "epic"){
			enemies = epicEnemies;
			icons = epicEnemiesIcon;
			int rs = rando(3,5);
			eCP = 6*rs;
			rs = rando(3,5);
			eHP = 40*rs;
		} else {
			enemies = standardEnemies;
			icons = standardEnemiesIcon;
			int rs = rando(2,6);
			eCP = 4*rs;
			rs = rando(3,6);
			eHP = 30*rs;
		}
		//choose enemy
		int re = rando(0,2);
		Enemy e = new Enemy(enemies[re],eHP,eCP,icons[re]);
		return e;
	}
	
	public void populateCombat(){
		//redisplay stats
		lblFighting.setText("Combat with " + currentEnemy.getType());
		lblEnemyIcon.setIcon(new ImageIcon(Screen.class.getResource(currentEnemy.getIcon())));
		lblPlayerCP.setText("CP: " + currentPlayer.getCombatPower());
		lblPlayerHP.setText("HP: " + currentPlayer.getEffectiveHP());
		lblEnemyCP.setText("CP: "+ currentEnemy.getCP());
		lblEnemyHP.setText("HP: " + currentEnemy.getHP());		
	}
	
	public void openBazaar(){
		stockShelves();
		int bart = rando(1,4);
		canBarter = false;
		if(bart==2){
			canBarter = true;
		}
		play("/resources/bazaarOpens.wav");
		bazaarPanel.setVisible(true);
	}
	
	//fulfills the sale of an item to a player from a bazaar
	public void provider(String thing, int cost){
		/*
		 * "Health Potion","Battle Elixir","Cure Disease",
			"Plagued Rats","Thief","Caltrops","Roadblock"
		 */
		if(currentPlayer.getGold()>=cost){
			switch(thing){
				case "Leather Armor":
					currentPlayer.setArmor(new Armor(thing));
					break;
				case "Chainmail Armor":
					currentPlayer.setArmor(new Armor(thing));
					break;
				case "Plate Armor":
					currentPlayer.setArmor(new Armor(thing));
					break;
				case "Iron Sword":
					currentPlayer.setWeapon(new Weapon(thing));
					break;
				case "Steel Sword":
					currentPlayer.setWeapon(new Weapon(thing));
					break;
				case "Obsidian Sword":
					currentPlayer.setWeapon(new Weapon(thing));
					break;
				case "Health Potion":
					currentPlayer.setPotion(new Potion(thing));
					break;
				case "Battle Elixir":
					currentPlayer.setPotion(new Potion(thing));
					break;
				case "Cure Disease":
					currentPlayer.setPotion(new Potion(thing));
					break;
				case "Plagued Rats":
					currentPlayer.setTrap(new Trap(thing));
					break;
				case "Thief":
					currentPlayer.setTrap(new Trap(thing));
					break;
				case "Caltrops":
					currentPlayer.setTrap(new Trap(thing));
					break;
				case "Roadblock":
					currentPlayer.setTrap(new Trap(thing));
					break;
			}
			currentPlayer.setGold(currentPlayer.getGold()-cost);
			play("/resources/blip.wav");
			repopulate();
		} else {
			play("/resources/turnOver.wav");
		}
		
		
	}
	
	public void stockShelves(){
		//itemCosts[]
		//btnBuy1...btnBuy3
		//lblItem1...lblItem3
		//		
		//ITEM ONE
		btnBuy3.setBackground(Color.WHITE);
		btnBuy3.setEnabled(true);
		btnBuy2.setBackground(Color.WHITE);
		btnBuy2.setEnabled(true);
		btnBuy1.setBackground(Color.WHITE);
		btnBuy1.setEnabled(true);
		
		if(!currentPlayer.hasArmor()){
			lblItem1.setText("Leather Armor");
			lblItem1Effect.setText("+20HP");
			btnBuy1.setText("100");
		} else if(currentPlayer.getArmor().getType() == "Leather Armor"){
			lblItem1.setText("Chainmail Armor");
			lblItem1Effect.setText("+40HP");
			btnBuy1.setText("100");
		} else if(currentPlayer.getArmor().getType() == "Chainmail Armor"){
			lblItem1.setText("Plate Armor");
			lblItem1Effect.setText("+60HP");
			btnBuy1.setText("100");
		} else {
			int r1 = rando(0,6);
			lblItem1.setText(itemArray[r1]);
			lblItem1Effect.setText(itemEffects[r1]);
			btnBuy1.setText(itemCosts[r1]);
		}
		//ITEM TWO
		if(!currentPlayer.hasWeapon()){
			lblItem2.setText("Iron Sword");
			lblItem2Effect.setText("+20CP");
			btnBuy2.setText("100");
		} else if(currentPlayer.getWeapon().getType() == "Iron Sword"){
			lblItem2.setText("Steel Sword");
			lblItem2Effect.setText("+40CP");
			btnBuy2.setText("100");
		} else if(currentPlayer.getWeapon().getType() == "Steel Sword"){
			lblItem2.setText("Obsidian Sword");
			lblItem2Effect.setText("+60CP");
			btnBuy2.setText("100");
		} else {
			int r2 = rando(0,6);
			lblItem2.setText(itemArray[r2]);
			lblItem2Effect.setText(itemEffects[r2]);
			btnBuy2.setText(itemCosts[r2]);
		}
		//ITEM THREE
		int r3 = rando(0,6);
		lblItem3.setText(itemArray[r3]);
		lblItem3Effect.setText(itemEffects[r3]);
		btnBuy3.setText(itemCosts[r3]);

	}
	
	public void dragonRunner(){
		btnDReady.setEnabled(false);
		btnDReady.setVisible(false);
		play("/resources/dragonTurn.wav");

		Timer t = new Timer(2000,null);
		t.addActionListener(new ActionListener(){
		     int i=0;
		     public void actionPerformed(ActionEvent e){
		         boolean Dwin = false;
		         boolean Pwin = false;
		 		 
		         if(playerOne.getSpace().getId() == dragon.getSpace().getId()){
		        	 //player wins
		        	 if(playerOne.hasMagicItem()&&playerOne.getMagicItem().getType()=="Mangel-Slayer"){
		        		 dragonLives =  false;
		        		 Pwin = true;
		        		 playerOne.setGold(playerOne.getGold()+dragon.getGold());
		        		 playerOne.setMagicItem(dragon.getMagicItem());
		        		 lblDragonPosition.setText("Dragon has been slain!");
		        	 } else { //dragon wins
		        		 Dwin = true;
			        	 dragon.addGold(playerOne.getGold());
			        	 if(playerOne.hasMagicItem()){
			        		 dragon.AddMagic(playerOne.getMagicItem());
			        	 }
			        	 playerOne.death();
			        	 lblDragonPosition.setText("Knight of Lassallax Incinerated!");
		        	 }
		         }
		         if(numPlayers > 1 && dragonLives && playerTwo.getSpace().getId() == dragon.getSpace().getId()){
		        	 //player wins
		        	 if(playerTwo.hasMagicItem()&&playerTwo.getMagicItem().getType()=="Mangel-Slayer"){
		        		 dragonLives =  false;
		        		 Pwin = true;
		        		 playerTwo.setGold(playerTwo.getGold()+dragon.getGold());
		        		 playerTwo.setMagicItem(dragon.getMagicItem());
		        		 lblDragonPosition.setText("Dragon has been slain!");
		        	 } else { //dragon wins
		        		 Dwin = true;
			        	 dragon.addGold(playerTwo.getGold());
			        	 if(playerTwo.hasMagicItem()){
			        		 dragon.AddMagic(playerTwo.getMagicItem());
			        	 }
			        	 playerTwo.death();
			        	 lblDragonPosition.setText("Knight of Derelin Incinerated!");
		        	 }
		         }
		         if(numPlayers > 2 &&dragonLives && playerThree.getSpace().getId() == dragon.getSpace().getId()){
		        	 //player wins
		        	 if(playerThree.hasMagicItem()&&playerThree.getMagicItem().getType()=="Mangel-Slayer"){
		        		 dragonLives =  false;
		        		 Pwin = true;
		        		 playerThree.setGold(playerThree.getGold()+dragon.getGold());
		        		 playerThree.setMagicItem(dragon.getMagicItem());
		        		 lblDragonPosition.setText("Dragon has been slain!");
		        	 } else { //dragon wins
		        		 Dwin = true;
			        	 dragon.addGold(playerThree.getGold());
			        	 if(playerThree.hasMagicItem()){
			        		 dragon.AddMagic(playerThree.getMagicItem());
			        	 }
			        	 playerThree.death();
			        	 lblDragonPosition.setText("Knight of WybengaLand Incinerated!");
		        	 }
		         }
		         if(numPlayers > 3 &&dragonLives && playerFour.getSpace().getId() == dragon.getSpace().getId()){
		        	 //player wins
		        	 if(playerFour.hasMagicItem()&&playerFour.getMagicItem().getType()=="Mangel-Slayer"){
		        		 dragonLives =  false;
		        		 Pwin = true;
		        		 playerFour.setGold(playerFour.getGold()+dragon.getGold());
		        		 playerFour.setMagicItem(dragon.getMagicItem());
		        		 lblDragonPosition.setText("Dragon has been slain!");
		        	 } else { //dragon wins
		        		 Dwin = true;
			        	 dragon.addGold(playerFour.getGold());
			        	 if(playerFour.hasMagicItem()){
			        		 dragon.AddMagic(playerFour.getMagicItem());
			        	 }
			        	 playerFour.death();
			        	 lblDragonPosition.setText("Knight of Mangia Incinerated!");
		        	 }
		         }
		         
		 		 if(i>1 || Dwin || Pwin){
		 			 if(Dwin){
		 				 play("/resources/dragonAppears.wav");
		 			 } else if(Pwin){
		 				 play("/resources/happy.wav");
		 			 } else {
		 				lblDragonPosition.setText("Landed");
		 			 }
		        	 btnDReady.setEnabled(true);
		        	 btnDReady.setVisible(true);
		        	 t.stop();
		         }
		 		 dragonMove();
		         i++;
		     }
		});
		t.setRepeats(true);
		t.start();
		
	}
	
	public void dragonMove(){
		Space s = dragon.getSpace();
		int opts = 1;
		Space[] spaces = {s,null,null,null,null};
		Space r = s.getCount();
		Space l = s.getClock();
		Space up = s.getInner();
		Space d = s.getOuter();
		if(r != null && !r.isKingdom() && r.getId() != 3){
			spaces[opts] = r;
			opts++;
		}
		if(l != null && !l.isKingdom() && l.getId() != 3){
			spaces[opts] = l;
			opts++;
		}
		if(up != null && !up.isKingdom() && up.getId() != 3){
			spaces[opts] = up;
			opts++;
		}
		if(d != null && !d.isKingdom() && d.getId() != 3){
			spaces[opts] = d;
			opts++;
		}
		int ran = rando(0,opts-1);
		dragon.setSpace(spaces[ran]);
	}
	
	public void lootter(String type){
		play("/resources/happy.wav");
		lootPanel.setVisible(true);
		if(type == "Royal Staircase" || type == "Courtyard" || type == "Throne Room"){
			//Royal: usually potion
			String pot = potions[rando(0,1)];
			if(pot == "Health Potion"){
				lblLootValue.setText("+20HP for 1 round");
				lblLootName.setText("Health Potion");
			} else {
				lblLootValue.setText("+20CP for 1 round");
				lblLootName.setText("Battle Elixir");
			}
		} else if (type == "epic") {
			//Epic: usually potion or trap, sometime magic item, rarely gold
			int r = rando(1,10);
			// 5->p/t, 3->g, 2->m
			if(r<=5){
				//potion or trap
				if(rando(1,2)==1){
					//potion
					String pot = potions[rando(0,2)];
					lblLootName.setText(pot);
					if(pot == "Health Potion"){
						lblLootValue.setText("+20HP for 1 round");
					} else if(pot == "Battle Elixir"){
						lblLootValue.setText("+20CP for 1 round");
					} else {
						lblLootValue.setText("Instantly Cures Disease");
					}
				} else {
					//trap
					String trp = traps[rando(0,3)];
					lblLootName.setText(trp);
					if(trp == "Plagued Rats"){
						lblLootValue.setText("Causes next player in space to become Diseased");
					} else if(trp == "Thief"){
						lblLootValue.setText("Causes next player in space to become Robbed");
					} else if (trp == "Caltrops"){
						lblLootValue.setText("Causes next player in space to become Slowed");
					} else {
						lblLootValue.setText("Causes next player in space to become Lost");
					}
				}
			} else if(r>=9){
				//magic item
				String m;
				if(rando(1,10)<9){
					m = magicItems[rando(1,2)];
				} else {
					m = magicItems[rando(0,2)];
				}
				
				MagicItem temp = new MagicItem(m);
				lblLootName.setText(m);
				lblLootValue.setText(temp.getDesc());
			} else {
				//gold
				lblLootName.setText("Gold");
				int g = 25*rando(1,4);
				lblLootValue.setText(String.valueOf(g));
			}
		} else {
			//standard: usually gold, sometimes potion or trap
			int r = rando(1,10);
			// 7->g,3->p/t
			if(r<=2){
				//potion or trap
				if(rando(1,2)==1){
					//potion
					String pot = potions[rando(0,2)];
					lblLootName.setText(pot);
					if(pot == "Health Potion"){
						lblLootValue.setText("+20HP for 1 round");
					} else if(pot == "Battle Elixir"){
						lblLootValue.setText("+20CP for 1 round");
					} else {
						lblLootValue.setText("Instantly Cures Disease");
					}
				} else {
					//trap
					String trp = traps[rando(0,3)];
					lblLootName.setText(trp);
					if(trp == "Plagued Rats"){
						lblLootValue.setText("Causes next player in space to become Diseased");
					} else if(trp == "Thief"){
						lblLootValue.setText("Causes next player in space to become Robbed");
					} else if (trp == "Caltrops"){
						lblLootValue.setText("Causes next player in space to become Slowed");
					} else {
						lblLootValue.setText("Causes next player in space to become Lost");
					}
				}
			} else {
				//gold
				lblLootName.setText("Gold");
				int g = 5*rando(1,8);
				lblLootValue.setText(String.valueOf(g));
			}
		}	
	}
	
	public void accept(){
		//add item/gold/magic/trap to player inventory
		String item = lblLootName.getText();
		String effect = lblLootValue.getText();
		switch(item){
			case "Gold":
				currentPlayer.setGold(currentPlayer.getGold()+Integer.valueOf(effect));
				break;
			case "Health Potion":
				currentPlayer.setPotion(new Potion(item));
				break;
			case "Battle Elixir":
				currentPlayer.setPotion(new Potion(item));
				break;
			case "Cure Disease":
				currentPlayer.setPotion(new Potion(item));
				break;
			case "Plagued Rats":
				currentPlayer.setTrap(new Trap(item));
				break;
			case "Thief":
				currentPlayer.setTrap(new Trap(item));
				break;
			case "Caltrops":
				currentPlayer.setTrap(new Trap(item));
				break;
			case "Roadblock":
				currentPlayer.setTrap(new Trap(item));
				break;
			case "Mangel-Slayer":
				currentPlayer.setMagicItem(new MagicItem(item));
				break;
			case "Mantle of Perception":
				currentPlayer.setMagicItem(new MagicItem(item));
				break;
			case "Climbing Gear":
				currentPlayer.setMagicItem(new MagicItem(item));
				break;
		}
	}
	
	//plays .wav files
	public void play(String f){
		try {
			InputStream in;
			in = Screen.class.getResourceAsStream(f);
			AudioStream aud = new AudioStream(in);
			AudioPlayer.player.start(aud);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public int rando(int min, int max){
		//generate random number between min and max (inclusive)
		Random ran = new Random();
		int r = ran.nextInt(max-min+1) + min;
		return r;
	}
}








