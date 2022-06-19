package code;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankGamePanel extends Frame {
	GameModel gm = new GameModel();
	// initialize the size of the window
	static final int gameWidth = 1500, gameHeight = 800;

	// initialize the place where the tank spawn
	// create "tankData" class for better coding format and easier to get data if
	// there are other tanks needed
	public TankGamePanel() {
		// Frame and JFrame
		// .setSize to set the window size
		// .setResizable to let the user change the size or not
		// .set Visible to make sure it display on the screen
		// no need to add window. because it is extended and can directly use all the
		// functions by using this
		this.setIconImage(ResourceMgr.icon);
		this.setTitle("Battle City -- Kyle Shi");
		this.setSize(gameWidth, gameHeight);
		this.setResizable(false);
		this.setVisible(true);

		// let users to close the window when X is being clicked
		// keyListener function to allow the computer monitoring the keyborad events
		// https://www.javatpoint.com/java-close-awt-window#:~:text=We%20can%20close%20the%20AWT,WindowAdapter%20class%20implements%20WindowListener%20interfaces.
		this.addKeyListener(new MyKeylistener());
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	// Solve the flashes of the image on the panel
	// create a memory that draw the panel first and put everything in the memory
	// panel directly onto the actual game panel
	// https://blog.csdn.net/oopsl/article/details/105334235
	Image offScreenImage = null;

	@Override
	public void update(Graphics g) {
		if (offScreenImage == null)
			offScreenImage = this.createImage(gameWidth, gameHeight);
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.BLACK);
		gOffScreen.fillRect(0, 0, gameWidth, gameHeight);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}

	// give the panel a pen
	@Override
	public void paint(Graphics pen) {
		int Score = bullet.Score;
		int Health = bullet.health;
		gm.paint(pen);
		pen.setColor(Color.YELLOW);
		pen.drawString("Your Score: " + Score, 15, 780);
		pen.drawString("HP: " + Health, 15, 760);
		if (bullet.health <= 0) {
			Font currentFont = pen.getFont();
			Font newFont = currentFont.deriveFont(currentFont.getSize() * 10F);
			pen.setFont(newFont);
			pen.setColor(Color.WHITE);
			pen.drawString("You Lost", 500, 500);

		}
		if (bullet.Score == 6) {
			Font currentFont = pen.getFont();
			Font newFont = currentFont.deriveFont(currentFont.getSize() * 10F);
			pen.setFont(newFont);
			pen.setColor(Color.WHITE);
			pen.drawString("You Win", 500, 500);

		}
	}

	// define a class that can receive keyboard events
	class MyKeylistener extends KeyAdapter {
		// set the direction in boolean data type to avoid the short delay when holding
		// the key
		boolean bLeft = false;
		boolean bDown = false;
		boolean bRight = false;
		boolean bUp = false;

		@Override
		// when a key is pressed the computer receive
		public void keyPressed(KeyEvent e) {
			// each key has a distinct number that represents it
			int keyCode = e.getKeyCode();
			// switch loop to set the moving direction to be true
			switch (keyCode) {
			case KeyEvent.VK_LEFT:
				bLeft = true;
				break;
			case KeyEvent.VK_UP:
				bUp = true;
				break;
			case KeyEvent.VK_RIGHT:
				bRight = true;
				break;
			case KeyEvent.VK_DOWN:
				bDown = true;
				break;
			case KeyEvent.VK_A:
				bLeft = true;
				break;
			case KeyEvent.VK_W:
				bUp = true;
				break;
			case KeyEvent.VK_D:
				bRight = true;
				break;
			case KeyEvent.VK_S:
				bDown = true;
				break;

			default:
				break;
			}
			setMainTankDirection();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			int keyCode = e.getKeyCode();
			// after the key is relased, set the value to be false so that the playertank
			// will not move
			switch (keyCode) {
			case KeyEvent.VK_LEFT:
				bLeft = false;
				break;
			case KeyEvent.VK_UP:
				bUp = false;
				break;
			case KeyEvent.VK_RIGHT:
				bRight = false;
				break;
			case KeyEvent.VK_DOWN:
				bDown = false;
				break;
			case KeyEvent.VK_CONTROL:
				gm.getPlayerTank().fire();
				break;

			case KeyEvent.VK_A:
				bLeft = false;
				break;
			case KeyEvent.VK_W:
				bUp = false;
				break;
			case KeyEvent.VK_D:
				bRight = false;
				break;
			case KeyEvent.VK_S:
				bDown = false;
				break;
			case KeyEvent.VK_J:
				gm.getPlayerTank().fire();
				break;
			default:
				break;
			}
			setMainTankDirection();
		}

		private void setMainTankDirection() {
			tankData playerTank = gm.getPlayerTank();

			playerTank.setMoving(true);
			if (!bLeft && !bUp && !bRight && !bDown)
				playerTank.setMoving(false);
			else {
				if (bLeft)
					playerTank.setDirection(Direction.LEFT);
				if (bUp)
					playerTank.setDirection(Direction.UP);
				if (bRight)
					playerTank.setDirection(Direction.RIGHT);
				if (bDown)
					playerTank.setDirection(Direction.DOWN);
			}

		}

	}
}
