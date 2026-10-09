import java.awt.*;

public class UI {
	private static final Font TEXT_FONT = new Font("Serif", Font.PLAIN, 25);
	private static final int X = 0, Y = 0;

	private static void drawStrings(Graphics2D g2d, Jeikob jeikob) {
		// hp
		g2d.setColor(Color.WHITE);
		g2d.setFont(TEXT_FONT);
		g2d.drawString("HP: " + (int)jeikob.getHp(), 5, 25);
		// bucks
		g2d.drawString("Bucks: " + (int)jeikob.getBucks(), 5, 50);
	}
	
	public void draw(Graphics2D g2d, Jeikob jeikob) {
		// other labels
		drawStrings(g2d, jeikob);
	}
}
