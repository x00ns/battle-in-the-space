import java.awt.*;

public class Ladder {
	private Rectangle ladderCollision;
	
	public Ladder(int x, int y, int w, int h) {
		this.ladderCollision = new Rectangle(x, y, w, h);
	}
	
	public Rectangle getLadderBounds() { return ladderCollision; }
}
