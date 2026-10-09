import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Jeikob {
	private static final double SPEED = 3.0;
	private static final double SCALEX = 20.0, SCALEY = 40.0;
	private  double x = 512 - SCALEX, y = 300 - SCALEY;
	private double vx = 0, vy = 0;
	public static final double MAX_HP = 100.0;
	public static final double MIN_HP = 0.0;
	private double hp = 100.0;
	private double bucks = 0;
	private boolean left, right, up, down;
	// key pressed
	public void keyPressed(int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_D -> right = true;
			case KeyEvent.VK_A -> left = true;
			case KeyEvent.VK_W -> up = true;
			case KeyEvent.VK_S -> down = true;
		}
	}
	// key released
	public void keyReleased(int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_D -> right = false;
			case KeyEvent.VK_A -> left = false;
			case KeyEvent.VK_W -> up = false;
			case KeyEvent.VK_S -> down = false;
		}
	}
	// moving
	public void update(ArrayList<Rectangle> platforms) {
		vx = 0;
		vy = 0;
		
		if (left) vx -= SPEED;
		if (right) vx += SPEED;
		if (up) vy -= SPEED;
		if (down) vy += SPEED;
		// x
		x += vx;
		for (Rectangle p : platforms) {
			if (getHitbox().intersects(p)) {
				if (vx > 0) {
					x = p.x - SCALEX;
					vx = 0;
				} else if (vx < 0) {
					x = p.x + p.width;
					vx = 0;
				}
			}
		}
		// y
		y += vy;
		for (Rectangle p : platforms) {
			if (getHitbox().intersects(p)) {
				if (vy > 0) {
					y = p.y - SCALEY;
					vy = 0;
				} else if (vy < 0) {
					y = p.y + p.height;
					vy = 0;
				}
			}
		}
	}
	// drawing
	public void draw(Graphics2D g2d) {
		g2d.setColor(Color.RED);
		g2d.fillRect((int) x, (int) y, (int) SCALEX, (int) SCALEY);
	}
	// getters
	public double getX() { return x; }
	public double getY() { return y; }
	public double getScaleX() { return SCALEX; }
	public double getScaleY() { return SCALEY; }
	public double getHp() { return hp; }
	public double getBucks() { return bucks; }
	// collision getters
	public Rectangle getHitbox() {
		return new Rectangle((int) x, (int) y, (int) SCALEX, (int) SCALEY);
	}
	// setter
	public void setHp() { hp = this.hp; }
	public void setBucks() { bucks = this.bucks; }
}
