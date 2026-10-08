import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Jeikob {
	private static final double SPEED = 3.5;
	private static final double SCALEX = 50.0, SCALEY = 70.0;
	private  double x = 100, y = 300;
	private double vx = 0, vy = 0;
	private static final double GRAVITY = 0.5, JUMP = -10;
	private static final double MAX_HP = 100.0;
	private static final double MIN_HP = 0.0;
	private double hp = 100.0;
	private boolean left, right, jump;
	private boolean onLadder;
	// key pressed
	public void keyPressed(int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_D -> right = true;
			case KeyEvent.VK_A -> left = true;
			case KeyEvent.VK_SPACE -> jump = true;
		}
	}
	// key released
	public void keyReleased(int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_D -> right = false;
			case KeyEvent.VK_A -> left = false;
			case KeyEvent.VK_SPACE -> jump = false;
		}
	}
	// moving
	public void update(ArrayList<Rectangle> platforms, ArrayList<Rectangle> ladders) {
		// <===== LADDERS PHYSICS =====>
		Rectangle ladder = getLadder(ladders);
		
		if (ladder != null && !onLadder) {
			onLadder = true;
			vy = 0;
		}
		
		if (onLadder) {
			vy = 0;
			vx = 0;
			
			if (right) vy = -SPEED;
			if (left) vy = SPEED;
			
			x += vx;
			y += vy;
			
			if (ladder == null) {
	            onLadder = false;
	        }
			
			return;
		}
		// <===== LADDERS PHYSICS =====>
		vx = 0;
		if (left) vx -= SPEED;
		if (right) vx += SPEED;
		// gravity
		vy += GRAVITY;
		// jump
		if (jump && onGround(platforms)) vy = JUMP;
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
		
		if (x < 0) {
			x = 0;
			vx = 0;
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
	// on ground
	private boolean onGround(ArrayList<Rectangle> platforms) {
		Rectangle foot = new Rectangle((int) x, (int)(y + SCALEY), (int) SCALEX, 1);
		
		for (Rectangle p : platforms) {
			if (foot.intersects(p)) return true;
		}
		
		return false;
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
	// collision getter
	public Rectangle getHitbox() {
		return new Rectangle((int) x, (int) y, (int) SCALEX, (int) SCALEY);
	}
	
	private Rectangle getLadder(ArrayList<Rectangle> ladders) {
	    for (Rectangle l : ladders) {
	        if (getHitbox().intersects(l)) return l;
	    }
	    return null;
	}
}
