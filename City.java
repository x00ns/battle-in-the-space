import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class City {
	private final ArrayList<Rectangle> platforms = new ArrayList<>();
	private final ArrayList<Rectangle> ladders = new ArrayList<>();
	// constructor
	public City() {
		platforms.add(new Rectangle(0, 400, 400, 200));
		platforms.add(new Rectangle(550, 100, 400, 500));
		ladders.add(new Rectangle(530, 100, 20, 300));
	}
	// getter
	public ArrayList<Rectangle> getPlatforms() { return platforms; }
	public ArrayList<Rectangle> getLadders() { return ladders; }
}