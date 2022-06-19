package code;

import java.awt.Graphics;
import java.awt.Rectangle;

public class bullet extends GameObject {
	public static final int bulletSpeed = Integer.parseInt((String) PropertyMgr.get("bulletSpeed"));
	private int bulletX, bulletY;
	public static int bWidth = ResourceMgr.bulletD.getWidth();
	public static int bHeight = ResourceMgr.bulletR.getHeight();
	private Direction bulletDir;
	private Sides group = Sides.ENEMY;
	public Rectangle rect = new Rectangle();
	private boolean living = true;
	GameModel gm = null;

	public static int health = Integer.parseInt((String) PropertyMgr.get("health"));
	static int Score = 0;
	//define components of bullet
	public bullet(int x, int y, Direction bulletDir, Sides group, GameModel gm) {
		this.bulletX = x;
		this.bulletY = y;
		this.bulletDir = bulletDir;
		this.group = group;
		this.gm = gm;

		rect.x = this.bulletX;
		rect.y = this.bulletY;
		rect.width = bWidth;
		rect.height = bHeight;

		gm.add(this);
	}

	public Sides getGroup() {
		return group;
	}

	public void setGroup(Sides group) {
		this.group = group;
	}

	public void paint(Graphics pen) {
		//remove the bullet if it is out of bound or hit something
		if (!living) {
			gm.remove(this);
		}
		//out put the pictures
		switch (bulletDir) {
		case LEFT:
			pen.drawImage(ResourceMgr.bulletL, bulletX, bulletY, null);
			break;
		case UP:
			pen.drawImage(ResourceMgr.bulletU, bulletX, bulletY, null);
			break;
		case RIGHT:
			pen.drawImage(ResourceMgr.bulletR, bulletX, bulletY, null);
			break;
		case DOWN:
			pen.drawImage(ResourceMgr.bulletD, bulletX, bulletY, null);
			break;

		}

		move();

	}

	private void move() {
		//to make the bullet move

		switch (bulletDir) {
		case LEFT:
			bulletX -= bulletSpeed;
			break;
		case UP:
			bulletY -= bulletSpeed;
			break;
		case RIGHT:
			bulletX += bulletSpeed;
			break;
		case DOWN:
			bulletY += bulletSpeed;
			break;
		}
		rect.x = this.bulletX;
		rect.y = this.bulletY;
		if (bulletX < 0 || bulletY < 0 || bulletX > TankGamePanel.gameWidth || bulletY > TankGamePanel.gameHeight)
			living = false;
	}
	//determine when playerTank bullet collide with enemy tank
	public boolean collideWith(tankData tank) {
		if (this.group == tank.getGroup())
			return false;

		if (this.rect.intersects(tank.rect)) {
			tank.die();
			this.die();
			//eX eY to locate where the explosion take place
			int eX = tank.getTankX() + tankData.tankWidth / 2 - Explode.width / 2 - 10;
			int eY = tank.getTankY() + tankData.tankHeight / 2 - Explode.height / 2 - 10;
			gm.add(new Explode(eX, eY, gm));
			Score += 1;
			return true;
		}
		return false;

	}

	// playerTank Enemy Bullet collide
	public boolean enemyBulletPlayerTankCollide(tankData playerTank) {
		if (this.group == playerTank.getGroup())
			return false;
		if (this.rect.intersects(playerTank.rect)) {
			this.die();
			health -= 1;
			return true;
		}
//		if(health == 0)
//		{	
//			int playerX = playerTank.getTankX() + tankData.tankWidth/2 - Explode.width/2 - 10;
//			int playerY = playerTank.getTankX() + tankData.tankWidth/2 - Explode.width/2 - 10;
//			
//			gm.add(new Explode(playerX, playerY, gm));
//			return false;
//		}

		return true;
	}

	public void die() {
		// TODO Auto-generated method stub
		this.living = false;
	}

}
