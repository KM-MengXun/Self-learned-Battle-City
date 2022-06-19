package code;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class tankData extends GameObject {

	// initialize the tank movement speed
	public static final int tankSpeed = Integer.parseInt((String) PropertyMgr.get("tankSpeed"));
	// get the width and height of the tank iamge
	public static int tankWidth = ResourceMgr.playerTankD.getWidth();
	public static int tankHeight = ResourceMgr.playerTankR.getHeight();
	int x, y;
	public Rectangle rect = new Rectangle();
	public int tankX, tankY;
	public Direction direction = null;
	private Random random = new Random();
	FireType ft = new DefaultFireType();
	public GameModel gm;
	private boolean moving = true;
	private boolean living = true;
	Sides group = Sides.ENEMY;

	public tankData(int x, int y, Direction direction, Sides group, GameModel gm) {
		super();
		this.tankX = x;
		this.tankY = y;
		this.direction = direction;
		this.group = group;
		this.gm = gm;

		rect.x = this.tankX;
		rect.y = this.tankY;
		rect.width = tankWidth;
		rect.height = tankHeight;

	}

	public void die() {
		// TODO Auto-generated method stub
		this.living = false;

	}

	// create methode that check if the tank hit the bounds
	private void edgeCheck() {
		// TODO Auto-generated method stub
		if (this.tankX < 0)
			tankX = 0;
		if (this.tankY < 30)
			tankY = 30;
		if (this.tankX > TankGamePanel.gameWidth - tankData.tankWidth)
			tankX = TankGamePanel.gameWidth - tankData.tankWidth;
		if (this.tankY > TankGamePanel.gameHeight - tankData.tankHeight)
			tankY = TankGamePanel.gameHeight - tankData.tankHeight;

	}

	public void fire() {
		ft.fire(this);
	}

	public Direction getDirection() {
		return direction;
	}

	public Sides getGroup() {
		return group;
	}

	public Rectangle getRect() {
		return rect;
	}

	public int getTankX() {
		return tankX;
	}

	public int getTankY() {
		return tankY;
	}

	public boolean isMoving() {
		return moving;
	}

	public void back() {
		tankX = x;
		tankY = y;
	}

	// Let the tank move when it receive key events
	private void move() {
		// connect to the setMoving methods, if it is moving == false, the tank won't
		// move
		x = tankX;
		y = tankY;
		if (!moving)
			return;
		switch (direction) {
		case LEFT:
			tankX -= tankSpeed;
			break;
		case UP:
			tankY -= tankSpeed;
			break;
		case RIGHT:
			tankX += tankSpeed;
			break;
		case DOWN:
			tankY += tankSpeed;
			break;
		}

		rect.x = this.tankX;
		rect.y = this.tankY;
		// set the Enemy tank fire randomly
		if (this.group == group.ENEMY && random.nextInt(100) == 1)
			this.fire();
		if (this.group == group.ENEMY && random.nextInt(50) == 1)
			randomDirection();
		edgeCheck();
		wallCheck();
	}

	private void wallCheck() {
		// TODO Auto-generated method stub

	}

	public void paint(Graphics pen) {

		// when the enemy tank die remove it from the list to avoid memory leaking
		if (!living) {
			gm.remove(this);
		}

		switch (direction) {
		case LEFT:
			pen.drawImage(this.group == Sides.ALLY ? ResourceMgr.playerTankL : ResourceMgr.tankL, tankX, tankY, null);
			break;
		case UP:
			pen.drawImage(this.group == Sides.ALLY ? ResourceMgr.playerTankU : ResourceMgr.tankU, tankX, tankY, null);
			break;
		case RIGHT:
			pen.drawImage(this.group == Sides.ALLY ? ResourceMgr.playerTankR : ResourceMgr.tankR, tankX, tankY, null);
			break;
		case DOWN:
			pen.drawImage(this.group == Sides.ALLY ? ResourceMgr.playerTankD : ResourceMgr.tankD, tankX, tankY, null);
			break;

		}

		move();

	}

	// random direction methods that indicates where the enemy tanks should go
	private void randomDirection() {
		// TODO Auto-generated method stub

		this.direction = Direction.values()[random.nextInt(4)];
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public void setGroup(Sides group) {
		this.group = group;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public void setTankX(int tankX) {
		this.tankX = tankX;
	}

	public void setTankY(int tankY) {
		this.tankY = tankY;
	}

	public void stop() {
		moving = false;
	}
}
