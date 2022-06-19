package code;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class tank {

	public static void main(String[] args) throws Exception {
		// connect the panel to the main running function
		TankGamePanel window = new TankGamePanel();

		// repaint the screen every 20ms
		while (bullet.health > 0 && bullet.Score < 6) {
			Thread.sleep(20);
			window.repaint();
		}
		// after the player die it will auto closed
		Thread.sleep(5000);
		System.exit(0);
	}

}
