import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;

public class Jeikob {
	private static final double SPEED = 2.0;
	private static final double SCALEX = 50.0, SCALEY = 70.0;
	private  double x = 100, y = 300;
	private static final double MAX_HP = 100.0;
	private static final double MIN_HP = 0.0;
	private double hp = 100.0;
	private boolean left, right;
	// key pressed
	public void keyPressed(int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_D -> right = true;
			case KeyEvent.VK_A -> left = true;
		}
	}
	// key released
	public void keyReleased(int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_D -> right = false;
			case KeyEvent.VK_A -> left = false;
		}
	}
	// moving
	public void update() {
		if (left) x -= SPEED;
		if (right) x += SPEED;
	}
	// drawing
	public void draw(Graphics2D g2d) {
		g2d.setColor(Color.RED);
		g2d.fillRect((int) x, (int) y, (int) SCALEX, (int) SCALEY);
	}
}
