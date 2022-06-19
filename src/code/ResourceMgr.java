package code;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ResourceMgr {
	// define four tank in four directions
	public static BufferedImage tankL, tankU, tankR, tankD;
	public static BufferedImage playerTankL, playerTankU, playerTankR, playerTankD;
	// define four bullet in four directions
	public static BufferedImage bulletL, bulletU, bulletR, bulletD;
	public static BufferedImage wall;
	public static BufferedImage[] explodes = new BufferedImage[16];
	public static BufferedImage icon;
	static {
		try {
			// give defined tank the image that are in the images package
			tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTankL.png"));
			tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTankU.png"));
			tankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTankR.png"));
			tankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTankD.png"));

			playerTankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank4.png"));
			playerTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
			playerTankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank2.png"));
			playerTankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank3.png"));

			wall = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/square2.jpg"));

			icon = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
			// give defined bullet the image that are in the images package
			bulletL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
			bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
			bulletR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
			bulletD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));

			for (int i = 0; i < 16; i++)
				explodes[i] = ImageIO
						.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e" + (i + 1) + ".gif"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
