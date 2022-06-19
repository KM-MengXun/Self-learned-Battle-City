package code;

import java.awt.Graphics;

public class Explode extends GameObject {
	public static int width = ResourceMgr.explodes[0].getWidth();
	public static int height = ResourceMgr.explodes[0].getHeight();

	private int x, y;

	GameModel gm = null;
	private int number = 0;

	public Explode(int x, int y, GameModel gm) {
		this.x = x;
		this.y = y;
		this.gm = gm;
	}
	
	public void paint(Graphics g) {
		//since explosion has 16 pictures so output the picture from the first to the last
		g.drawImage(ResourceMgr.explodes[number++], x, y, null);
		if (number >= ResourceMgr.explodes.length)
			gm.remove(this);

	}
}
