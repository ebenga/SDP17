import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class Screen {

	private Board gameBoard;
	private JFrame frame;
	private JPanel startPanel;
	private JPanel playerStartPanel;
	private JPanel settingsPanel;
	private JPanel inventoryPanel;
	private JPanel movePanel;
	private JPanel combatPanel;
	private JPanel bazzarPanel;
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
	private JButton btnSave;
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
		titleLabel.setBounds(10, 64, 304, 94);
		startPanel.add(titleLabel);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					startPanel.setVisible(false);
					settingsPanel.setVisible(true);
			}
		});
		btnLoad.setBackground(new Color(128, 128, 128));
		btnLoad.setFont(new Font("Cambria", Font.BOLD, 16));
		btnLoad.setBounds(204, 11, 110, 25);
		startPanel.add(btnLoad);
		
		JLabel lblNewLabel = new JLabel("Number of Players:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 16));
		lblNewLabel.setBounds(35, 148, 251, 25);
		startPanel.add(lblNewLabel);
		
		JButton btnOnePlayer = new JButton("ONE");
		btnOnePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numPlayers = 1;
				startPanel.setVisible(false);
				boarder();
				playerStartPanel.setVisible(true);
			}
		});
		btnOnePlayer.setFont(new Font("Cambria", Font.BOLD, 16));
		btnOnePlayer.setBackground(Color.WHITE);
		btnOnePlayer.setBounds(90, 184, 119, 40);
		startPanel.add(btnOnePlayer);
		
		JButton btnTwoPlayer = new JButton("TWO");
		btnTwoPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numPlayers = 2;
				startPanel.setVisible(false);
				boarder();
				playerStartPanel.setVisible(true);
			}
		});
		btnTwoPlayer.setFont(new Font("Cambria", Font.BOLD, 16));
		btnTwoPlayer.setBackground(Color.WHITE);
		btnTwoPlayer.setBounds(90, 242, 119, 40);
		startPanel.add(btnTwoPlayer);
		
		JButton btnThreePlayer = new JButton("THREE");
		btnThreePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numPlayers = 3;
				startPanel.setVisible(false);
				boarder();
				playerStartPanel.setVisible(true);
			}
		});
		btnThreePlayer.setFont(new Font("Cambria", Font.BOLD, 16));
		btnThreePlayer.setBackground(Color.WHITE);
		btnThreePlayer.setBounds(90, 304, 121, 40);
		startPanel.add(btnThreePlayer);
		
		JButton btnFourPlayer = new JButton("FOUR");
		btnFourPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numPlayers = 4;
				startPanel.setVisible(false);
				boarder();
				playerStartPanel.setVisible(true);
			}
		});
		btnFourPlayer.setFont(new Font("Cambria", Font.BOLD, 16));
		btnFourPlayer.setBackground(Color.WHITE);
		btnFourPlayer.setBounds(88, 361, 121, 40);
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
		
		btnSave = new JButton("Save");
		btnSave.setFont(new Font("Cambria", Font.BOLD, 16));
		btnSave.setBackground(Color.GRAY);
		btnSave.setBounds(204, 11, 110, 25);
		playerStartPanel.add(btnSave);


		lblcurrentPlayer = new JLabel("Knight of " + currentPlayer.getHomeKingdom());
		lblcurrentPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		lblcurrentPlayer.setFont(new Font("Cambria", Font.BOLD, 19));
		lblcurrentPlayer.setBounds(49, 47, 214, 47);
		playerStartPanel.add(lblcurrentPlayer);
		
		btnInventory = new JButton("Inventory");
		btnInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				playerStartPanel.setVisible(false);
				repopulate();
				if(currentPlayer.isLost()){
					currentPlayer.setLost(false);
					currentPlayer = currentPlayer.nextPlayer();
					rotatePanel.setVisible(true);
				}
				else{
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
					currentPlayer.setLost(false);
					currentPlayer = currentPlayer.nextPlayer();
					rotatePanel.setVisible(true);
				}
				else{
					movePanel.setVisible(true);
				}
			}
		});
		btnMove.setBackground(Color.WHITE);
		btnMove.setFont(new Font("Cambria", Font.BOLD, 16));
		btnMove.setBounds(160, 105, 125, 47);
		playerStartPanel.add(btnMove);
		
		lblGold = new JLabel("Gold:");
		lblGold.setForeground(Color.ORANGE);
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
		magicPane.setForeground(Color.MAGENTA);
		magicPane.setFont(new Font("Cambria", Font.BOLD, 14));
		magicPane.setEditable(false);
		magicPane.setBackground(Color.LIGHT_GRAY);
		magicPane.setBounds(183, 308, 119, 128);
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
					currentPlayer.usePotion();
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
				if(currentPlayer.hasTrap()){
					currentPlayer.useTrap();
					repopulate();
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
				currentPlayer = currentPlayer.nextPlayer();
				rotatePanel.setVisible(true);
			}
		});
		btnStay.setIcon(new ImageIcon(Screen.class.getResource("/resources/stay.png")));
		btnStay.setBounds(133, 208, 50, 50);
		movePanel.add(btnStay);
		
		btnDown = new JButton("");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				movePanel.setVisible(false);
				currentPlayer.setSpace(currentPlayer.getSpace().getOuter());
				//TODO do this in board.java? to set with eric?
				currentPlayer = currentPlayer.nextPlayer();
				repopulate();
				playerStartPanel.setVisible(true);
			}
		});
		btnDown.setIcon(null);
		btnDown.setBounds(133, 343, 50, 50);
		movePanel.add(btnDown);
		
		btnLeft = new JButton("");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				movePanel.setVisible(false);
				currentPlayer.setSpace(currentPlayer.getSpace().getClock());
				//TODO do this in board.java? to set with eric?
				currentPlayer = currentPlayer.nextPlayer();
				repopulate();
				playerStartPanel.setVisible(true);
			}
		});
		btnLeft.setIcon(null);
		btnLeft.setBounds(10, 208, 50, 50);
		movePanel.add(btnLeft);
		
		btnRight = new JButton("");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				movePanel.setVisible(false);
				currentPlayer.setSpace(currentPlayer.getSpace().getCount());
				//TODO do this in board.java? to set with eric?
				currentPlayer = currentPlayer.nextPlayer();
				repopulate();
				playerStartPanel.setVisible(true);
			}
		});
		btnRight.setIcon(null);
		btnRight.setBounds(258, 208, 50, 50);
		movePanel.add(btnRight);
		
		btnUp = new JButton("");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				movePanel.setVisible(false);
				currentPlayer.setSpace(currentPlayer.getSpace().getInner());
				//TODO do this in board.java? to set with eric?
				currentPlayer = currentPlayer.nextPlayer();
				repopulate();
				playerStartPanel.setVisible(true);
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
		
		//==================== BAZZAR PAGE =================================
		
		bazzarPanel = new JPanel();
		bazzarPanel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(bazzarPanel, "name_264106582521953");
		bazzarPanel.setLayout(null);
		
		//==================== RUINS PAGE ==================================
		
		ruinPanel = new JPanel();
		ruinPanel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(ruinPanel, "name_264108286407165");
		ruinPanel.setLayout(null);
		
		//==================== CAVES PAGE ==================================
		
		cavePanel = new JPanel();
		cavePanel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(cavePanel, "name_264109808785584");
		cavePanel.setLayout(null);
		
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
				repopulate();
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
		dragonPanel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(dragonPanel, "name_264250839698398");
		dragonPanel.setLayout(null);
		
		//===================== SETTINGS PAGE =============================
		
		settingsPanel = new JPanel();
		settingsPanel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(settingsPanel, "name_257950747583981");
		settingsPanel.setLayout(null);
	}
	
	public void boarder(){
		//set up # of players and put them in starting positions on board
		switch (numPlayers){
			case 1:
				playerOne = new Player();
				playerOne.setHomeKingdom("Lassallax");
				playerOne.setNextPlayer(playerOne);
				playerOne.makeFinalPlayer();
				gameBoard.initialize(1, playerOne, playerTwo, playerThree, playerFour);
				break;
			case 2:
				playerOne = new Player();
				playerOne.setHomeKingdom("Lassallax");
				playerTwo = new Player();
				playerTwo.setHomeKingdom("Derelin");
				playerOne.setNextPlayer(playerTwo);
				playerTwo.setNextPlayer(playerOne);
				playerTwo.makeFinalPlayer();
				gameBoard.initialize(2, playerOne, playerTwo, playerThree, playerFour);
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
				gameBoard.initialize(3, playerOne, playerTwo, playerThree, playerFour);
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
				gameBoard.initialize(4, playerOne, playerTwo, playerThree, playerFour);
				break;
		}
		currentPlayer = playerOne;
		repopulate();

		//TODO: SET PHYSICAL BOARD
	}
	
	//sets all the labels and text fields to the right value for the current player
	public void repopulate(){
		//==================== PLAYER START SCREEN ============================
		lblcurrentPlayer.setText("Knight of " + currentPlayer.getHomeKingdom());
		lblGold.setText("Gold: "+currentPlayer.getGold());
		lblHP.setText("HP: " + currentPlayer.getHealthPoints());
		lblCP.setText("CP: " + currentPlayer.getCombatPower());
		lblFood.setText("Food: " + currentPlayer.getFood());
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
			stats += "Starving: Loosing HP\n";
		}
		if(stats.length()<3){
			stats = "No Negative Effects\n";
		}
		statusPane.setText(stats);
		
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
		}
		//TRAPS
		if(currentPlayer.hasTrap()){
			btnTrap.setText(currentPlayer.getTrap().getType());
			btnTrap.setBackground(Color.WHITE);
		}
		else {
			btnTrap.setText("No Traps");
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
			magicPane.setText(currentPlayer.getMagicItem().getType()+"\n" + currentPlayer.getMagicItem().getEffect());
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
		
		
		
	}
}








