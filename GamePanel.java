import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GamePanel extends JPanel {
	private static final int STARS = 200;
	private int[] starsX = new int[STARS], starsY = new int[STARS];
	private boolean initialized = false;
	// Jeikob
	Jeikob jeikob = new Jeikob();
	// UI
	UI ui = new UI();
	// city
	City city = new City();
	// constructor
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
		jeikob.update(city.getPlatforms(), city.getLadders());
	}
	// init stars
	private void initStars() {
		Random rand = new Random();
		
		for (int i = 0; i < STARS; i++) {
			starsX[i] = rand.nextInt(getWidth());
			starsY[i] = rand.nextInt(getHeight());
		}
		
		initialized = true;
	}
	// draw stars
	private void drawStars(Graphics2D g2d) {	
		g2d.setColor(Color.WHITE);
		
		for (int i = 0; i < STARS; i++) {
			//draw
			g2d.fillOval(starsX[i], starsY[i], 3, 3);
		}
	}
	// main draw method
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		// draw stars
		if (!initialized) initStars();
		drawStars(g2d);
		// draw Jeikob
		jeikob.draw(g2d);
		// draw houses
		g2d.setColor(Color.GRAY);
		for (Rectangle p : city.getPlatforms()) {
			g2d.fillRect(p.x, p.y, p.width, p.height);
		}
		// draw ladders
		g2d.setColor(Color.CYAN);
		for (Rectangle l : city.getLadders()) {
			g2d.fillRect(l.x, l.y, l.width, l.height);
		}
		//UI
		ui.draw(g2d, jeikob);
	}
}
