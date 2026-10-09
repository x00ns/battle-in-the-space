import java.awt.*;

public class UI {
	private static final Font TEXT_FONT = new Font("Serif", Font.PLAIN, 25);
	private static final int X = 0, Y = 0;
	private static final String JEIKOB_THUBNAIL = "";

	private static void drawStrings(Graphics2D g2d, Jeikob jeikob) {
		// hp
		g2d.setColor(Color.RED);
		g2d.setFont(TEXT_FONT);
		g2d.drawString("HP: " + (int)jeikob.getHp(), 5, 25);
		// bucks
		g2d.setColor(Color.GREEN);
		g2d.setFont(TEXT_FONT);
		g2d.drawString("Bucks: " + (int)jeikob.getBucks(), 100, 25);
	}
	
	public void draw(Graphics2D g2d, Jeikob jeikob) {
		// main label
		g2d.setColor(Color.LIGHT_GRAY);
		g2d.fillRect(0, Y, 1024, 40);
		// other labels
		drawStrings(g2d, jeikob);
	}
}
