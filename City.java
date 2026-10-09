import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class City {
	private final ArrayList<Rectangle> platforms = new ArrayList<>();
	// constructor
	public City() {
		platforms.add(new Rectangle(0, -200, 600, 400));
		platforms.add(new Rectangle(0, 350, 600, 400));
	}
	// getter
	public ArrayList<Rectangle> getPlatforms() { return platforms; }
}