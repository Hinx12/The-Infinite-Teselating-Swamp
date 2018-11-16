import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GameManager {
	
	private ArrayList<Item> items;
	private Scanner in;
	private Player player;

	public static void main (String[] args) {
		
		GameManager game = new GameManager();
		game.intro();
		game.createItems();
		game.gameDesc();
		game.startGame();
	}
	
	public void intro() {
		
		System.out.println("----------------------------------------------------------------------------------");
		
		System.out.println("Hello and Welcome to the Infinite Terrain System\n");
		System.out.println("Please enter your name:");
		
		in = new Scanner(System.in);
		String playerName = in.nextLine();
		player = new Player(playerName);
		System.out.println("\nHello " + player.getName() + " and Welcome to the Game\n");
		System.out.println("You have just been randomly dropped into an Infinite Grey Swamp");
		System.out.println("Along with this, 5 Items have also been randomly dropped in the Grey Swamp\n");
	}
	
	public void createItems() {
		
		items = new ArrayList<Item>();
		
		items.add(new Item ("Pen"));
		items.add(new Item ("Sword"));
		items.add(new Item ("Glasses"));
		items.add(new Item ("Cup"));
		
		Item treasure = new Item("Treasure");
		treasure.setIsTreasure(true);
		items.add(treasure);
		
		System.out.println("The Items are:\n");
		
		for (Item item : items) {
			System.out.println(item);
		}
	}
		
	
	public void gameDesc() {
		
		System.out.println("\nYou have also been given a magic compass which tells you the distance of the closest item.");
		System.out.println("You can move either north, south, east or west based of this information.");
		System.out.println("Your job is to locate the treasure, once located you win the game.");
		System.out.println("Good Luck");
		
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("----------------------------------------------------------------------------------");
	}
	
	public Double closestItem() {
		
		ArrayList<Double> distances = new ArrayList<Double>();
		
		for (Item item : items) {
			if(item.getIsFound() == false) {
				double dist = (double) Math.sqrt(Math.pow(player.getXCoord() - item.getXCoord(), 2.0) + Math.pow(player.getYCoord() - item.getYCoord(), 2.0));
				distances.add(dist);
			}
		}
		return Collections.min(distances);
	}
	
	public void printItems() {
		
		System.out.println("----------------------------------------------------------------------------------");
		
		for (Item item : items) {
			if (item.getIsFound() == false) {
				System.out.println(item);
			} else {
				continue;
			}
		}
	}
	
	public void startGame() {
		
		boolean isFinished = false;
		while (!isFinished && checkFound() == false) {
			
			System.out.println("\n----------------------------------------------------------------------------------");
			
			System.out.println("\nYour current location is (" + player.getXCoord() + "," + player.getYCoord() + ")");
			System.out.println("\nThe closest item is " + closestItem() + "m Away");
				
			System.out.println("\nWhat would you like to do?\n");
		
			System.out.println("(n)");
			System.out.println("(e)");
			System.out.println("(s)");
			System.out.println("(w)");
			System.out.println("(p) to print the listof remaining items in the swamp");
			System.out.println("(q) to quit the game");
			
			
			String answer = in.nextLine();
					
			switch (answer) {
				case "n":
					player.goNorth();
					break;				 
				case "e":
					player.goEast();
					break;				 
				case "s":
					player.goSouth();
					break;  		     
				case "w":
					player.goWest();
					break;				
				case "p":
					printItems();
					break;
				case "q":
					isFinished = true;
					System.out.println("You gave up but thanks for playing");
					break;			     
				default:                
					System.out.println("need to enter a correct command guy");
			}
			
			System.out.println("----------------------------------------------------------------------------------");
			
			checkFound();
		}
	}
	
	public boolean checkFound() {
		
		boolean treasureFound = false;
		
		for (Item item : items) {
			if (player.getXCoord() == item.getXCoord() && player.getYCoord() == item.getYCoord() && item.getIsTreasure() == true) {
				item.setIsFound();
				System.out.println("Congratulations you found the " + item.getName() + " and you have won the Game!");
				treasureFound = true;
			
			} else if (player.getXCoord() == item.getXCoord() && player.getYCoord() == item.getYCoord() && item.getIsTreasure() == false) {
				item.setIsFound();
				System.out.println("Congratulations you found the " + item.getName() + " but that isnt the treasure");
			
			} else {
				continue;
			}
		}
		return treasureFound;
	}
}
