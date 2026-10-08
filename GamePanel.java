import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GamePanel extends JPanel {
	public static final Font TEXT_FONT = new Font("Serif", Font.PLAIN, 15);
	private static final int STARS = 200;
	private int[] starsX = new int[STARS], starsY = new int[STARS];
	private boolean initialized = false;
	// ship
	Jeikob jeikob = new Jeikob();
	
	public GamePanel() {
		setFocusable(true);
		setBackground(Color.BLACK);
		
		 addKeyListener(new java.awt.event.KeyAdapter() {
		        @Override public void keyPressed(java.awt.event.KeyEvent e) {
		            jeikob.keyPressed(e.getKeyCode());
		        }
		        @Override public void keyReleased(java.awt.event.KeyEvent e) {
		            jeikob.keyReleased(e.getKeyCode());
		        }
		 	});
	}
	
	public void update() {
		jeikob.update();
	}
	
	private void initStars() {
		Random rand = new Random();
		
		for (int i = 0; i < STARS; i++) {
			starsX[i] = rand.nextInt(getWidth());
			starsY[i] = rand.nextInt(getHeight());
		}
		
		initialized = true;
	}
	
	private void drawStars(Graphics2D g2d) {	
		for (int i = 0; i < STARS; i++) {
			//draw
			g2d.setColor(Color.WHITE);
			g2d.fillOval(starsX[i], starsY[i], 3, 3);
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		// draw stars
		if (!initialized) initStars();
		drawStars(g2d);
		// draw Jeikob
		jeikob.draw(g2d);
	}
}
