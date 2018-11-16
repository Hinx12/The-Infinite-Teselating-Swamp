// Class Represents and Item in our Game
public class Item  {	
	
	private String name;
	private int xCoord;
	private int yCoord;
	private boolean isTreasure = false;
	private boolean isFound = false;
	
	public Item(String name) {
		this.name = name;
		this.xCoord = (int) (Math.random() * (20 - 1)) + 1;
		this.yCoord = (int) (Math.random() * (20 - 1)) + 1;
	}
	
	public String getName() {
		return name;
	}
	
	public int getXCoord() {
		return xCoord;
	}
	
	public int getYCoord() {
		return yCoord;
	}
		
	public String toString() {
		return "Name of Item: " + name;
	}
	
	public boolean getIsTreasure() {
		return isTreasure;
	}
	
	public void setIsTreasure (boolean treasure) {
		isTreasure = true;
	}
	
	public boolean getIsFound() {
		return isFound;
	}
	
	public void setIsFound() {
		this.isFound = true;
	}
}