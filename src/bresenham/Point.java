package bresenham;

public class Point {
	private int posX;
	private int posY;
	
	public Point(int x, int y) {
		this.posX = x;
		this.posY = y;
	}
	
	public int getPosX() {
		return this.posX;
	}
	
	public int getPosY() {
		return this.posY;
	}
	
	public void setNewPosition(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	@Override
	public boolean equals(Object obj) {
		Point anotherPoint = (Point) obj;
		
		if(this.posX == anotherPoint.getPosX() && this.posY == anotherPoint.getPosY()) {
			return true;
		}
		
		return false;
	}
}
