import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GamePanel extends JPanel {
	public static final Font TEXT_FONT = new Font("Serif", Font.PLAIN, 15);
	Random rand = new Random();
	// stars
	int stars = 200;
	
	public GamePanel() {
		setBackground(Color.BLACK);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		// draw stars
		g2d.setColor(Color.WHITE);
		for (int i = 0; i < stars; i++) {
			int x = rand.nextInt(getWidth());
			int y = rand.nextInt(getHeight());
			//draw
			g2d.fillOval(x, y, 3, 3);
		}
	}
}
