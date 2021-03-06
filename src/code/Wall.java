package code;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Wall extends GameObject {

	int w, h;
	public Rectangle rect;

	public Wall(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.rect = new Rectangle(x, y, w, h);
	}

	@Override
	public void paint(Graphics pen) {
		pen.drawImage(ResourceMgr.wall, x, y, w, h, null);

	}

}
