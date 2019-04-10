package bresenham;

import java.util.ArrayList;
import java.util.List;

public final class Bresenham {
	private static final List<Point> LINE = new ArrayList<Point>();
	
	public void calculateLine(Point first, Point last) {
		
		int deltaX = Math.abs(last.getPosX() - first.getPosX());
		int deltaY = Math.abs(last.getPosY() - first.getPosY());
		
		int signalX = first.getPosX() < last.getPosX() ? 1 : -1;
		int signalY = first.getPosY() < last.getPosY() ? 1 : -1;
		
		int error = deltaX - deltaY;

        int doubleError;
        
        Point pointInLine = first;
        int newPosX = 0;
        int newPosY = 0;

        while(true) {
        	LINE.add(pointInLine);
        	
        	if(pointInLine.equals(last)) {
        		break;
        	}
        	
        	doubleError = 2 * error;
        	
        	if(doubleError > -deltaY) {
        		error -= deltaY;
        		newPosX = pointInLine.getPosX() + signalX;
        	}
        	
        	if(doubleError < deltaX) {
        		error += deltaX;
        		newPosY = pointInLine.getPosY() + signalY;
        	}
        	
        	pointInLine = new Point(newPosX, newPosY);
        	
        }  
        
	}
	
	public List<Point> getLine() {
		return LINE;
	}
	
	public void clearLine() {
		LINE.clear();
	}
	
}
