package application;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import bresenham.Bresenham;
import bresenham.Point;

public class MouseTracker extends JPanel implements MouseListener {

	private static final long serialVersionUID = 7471387263173353804L;
	
	private Point initalPoint;
	private Point finalPoint;
	private boolean firstPotion = true;
	private Bresenham bresenham = new Bresenham();
	
	public MouseTracker() {
		addMouseListener(this);
		setLayout(new FlowLayout(1));
		setVisible(true);
		setFocusable(true);
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(firstPotion) {
			this.initalPoint = new Point(e.getX(), e.getY());
			this.firstPotion = false;
			this.paintPoint(this.initalPoint);
		} else {
			this.finalPoint = new Point(e.getX(), e.getY());
			this.firstPotion = true;
			this.paintPoint(this.finalPoint);
			this.drawBresenhamLine();
		}
	}
	
	public void drawBresenhamLine() {
//		Graphics g = getGraphics();
//		
//		g.drawLine(this.initalPoint.getPosX(), this.initalPoint.getPosY(), this.finalPoint.getPosX(), this.finalPoint.getPosY());
		
		bresenham.calculateLine(this.initalPoint, this.finalPoint);
		
		for(Point point : bresenham.getLine()) {
			this.paintPixel(point);
		}
		
		bresenham.clearLine();
	}
	
	private void paintPoint(Point point) {
		Graphics g = this.getGraphics();
		
		g.drawLine(point.getPosX(), point.getPosY(), point.getPosX(), point.getPosY() - 4);
		g.drawLine(point.getPosX(), point.getPosY(), point.getPosX(), point.getPosY() + 4);
		g.drawLine(point.getPosX(), point.getPosY(), point.getPosX() - 4, point.getPosY());
		g.drawLine(point.getPosX(), point.getPosY(), point.getPosX() + 4, point.getPosY());
		
		g.dispose();
	}
	
	private void paintPixel(Point point) {
		Graphics g = this.getGraphics();
		
		g.drawLine(point.getPosX(), point.getPosY(), point.getPosX(), point.getPosY());
		
		g.dispose();
	}
	
	public Point getInitalPoint() {
		return this.initalPoint;
	}
	
	public Point getFinalPoint() {
		return this.finalPoint;
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
