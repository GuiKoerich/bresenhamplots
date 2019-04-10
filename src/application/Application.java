package application;

import javax.swing.JFrame;

public class Application {
	private static final int TOP = 300;
	private static final int LEFT = 90;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static final String TITLE = "Bresenham Algorithm - Guilherme Koerich";
	
	public static void main(String[] args) {
		JFrame jf = new JFrame();
		
		jf.setBounds(TOP, LEFT, WIDTH, HEIGHT);
		jf.setTitle(TITLE);
		jf.setResizable(false);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(new MouseTracker());
		
	}
}
