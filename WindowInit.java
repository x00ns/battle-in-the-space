import javax.swing.*;

public class WindowInit extends JFrame {
	public GamePanel gamePanel;
	private Timer timer;
	private static final int WIDTH = 800, HEIGHT = 600;
	//window
	public WindowInit() {
		setTitle("Battle in the space");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		gamePanel = new GamePanel();
		
		timer = new Timer(16, e -> {
			gamePanel.update();
			gamePanel.repaint();
		});
		
		timer.start();
		
		add(gamePanel);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new WindowInit());
	}
}
