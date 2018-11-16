
public class Player {
	
	private String name;
	private int xCoord;
	private int yCoord;
	
	public Player (String name) {
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
	
	public void goNorth() {
		System.out.println("Heading North");
		yCoord++;
	}
	
	public void goSouth() {
		System.out.println("Heading South");
		yCoord--;
	}
	
	public void goEast() {
		System.out.println("Heading East");
		xCoord++;
	}
	
	public void goWest() {
		System.out.println("Heading West");
		xCoord--;
	}

}
