package code;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import collider.BulletTankCollider;
import collider.BulletWallCollider;
import collider.Collider;
import collider.EnemyBulletPlayerTankCollider;
import collider.TankTankCollider;
import collider.TankWallCollider;

public class GameModel {

	tankData playerTank = new tankData(0, 600, Direction.RIGHT, Sides.ALLY, this);
	// creat list to store and remove data
//	List<bullet> bullets = new ArrayList<>();
//	List<tankData> enemy = new ArrayList<>();
//	List<Explode> explodes =new  ArrayList<>();
	// put in a gameobject list and use instanceof function to find the which type
	// of object list I need
	private List<GameObject> objects = new ArrayList<>();

	Collider collider = new BulletTankCollider();
	Collider collider2 = new TankTankCollider();
	Collider collider3 = new BulletWallCollider();
	Collider collider4 = new TankWallCollider();
	Collider collider5 = new EnemyBulletPlayerTankCollider();

	public GameModel() {
		int initTankCount = Integer.parseInt((String) PropertyMgr.get("initTankCount"));
		// initialize enemy tank
		for (int i = 0; i < initTankCount; i++) {
			add(new tankData(50 + i * 80, 200, Direction.DOWN, Sides.ENEMY, this));
		}
		add(new tankData(1350, 200, Direction.UP, Sides.ENEMY, this));

		// adding horizontal wall
		for (int i = 0; i < 7; i++)
			add(new Wall(0 + 50 * i, 550, 50, 50));
		for (int i = 0; i < 7; i++)
			add(new Wall(0 + 50 * i, 30, 50, 50));
		for (int i = 0; i < 7; i++)
			add(new Wall(1145 + 50 * i, 550, 50, 50));
		for (int i = 0; i < 2; i++)
			add(new Wall(850 + 50 * i, 750, 50, 50));
		for (int i = 0; i < 2; i++)
			add(new Wall(850 + 50 * i, 700, 50, 50));
		for (int i = 0; i < 2; i++)
			add(new Wall(1395 + 50 * i, 600, 50, 50));
		for (int i = 0; i < 5; i++)
			add(new Wall(700 + 50 * i, 30, 50, 50));
		for (int i = 0; i < 5; i++)
			add(new Wall(700 + 50 * i, 80, 50, 50));
		for (int i = 0; i < 4; i++)
			add(new Wall(600 + 50 * i, 700, 50, 50));
		for (int i = 0; i < 1; i++)
			add(new Wall(600 + 50 * i, 750, 50, 50));
		// add vertical wall
		for (int i = 0; i < 5; i++)
			add(new Wall(1295, 550 - 50 * i, 50, 50));
		for (int i = 0; i < 8; i++)
			add(new Wall(800, 800 - 50 * i, 50, 50));
		for (int i = 0; i < 5; i++)
			add(new Wall(1295, 30 + 50 * i, 50, 50));
		for (int i = 0; i < 3; i++)
			add(new Wall(1445, 650 + 50 * i, 50, 50));
		for (int i = 0; i < 2; i++)
			add(new Wall(500, 300 + 50 * i, 50, 50));
		for (int i = 0; i < 2; i++)
			add(new Wall(550, 300 + 50 * i, 50, 50));
		for (int i = 0; i < 2; i++)
			add(new Wall(1050, 150 + 50 * i, 50, 50));
		for (int i = 0; i < 2; i++)
			add(new Wall(1100, 150 + 50 * i, 50, 50));
		for (int i = 0; i < 2; i++)
			add(new Wall(950, 350 + 50 * i, 50, 50));
		for (int i = 0; i < 2; i++)
			add(new Wall(1000, 350 + 50 * i, 50, 50));
	}
	//allow adding objects into the list
	public void add(GameObject ob) {
		this.objects.add(ob);
	}

	public void remove(GameObject ob) {
		this.objects.remove(ob);
	}

	public void paint(Graphics pen) {
		// draw the playerTank on to the screen
		playerTank.paint(pen);

		// pen.drawString("Score: " , 1400, 100);
		for (int i = 0; i < objects.size(); i++)
			objects.get(i).paint(pen);

		for (int i = 0; i < objects.size(); i++) {
			for (int j = i + 1; j < objects.size(); j++) {
				GameObject o1 = objects.get(i);
				GameObject o2 = objects.get(j);
				//collide between objects that is in the list
				collider.collide(o1, o2);
				collider2.collide(o1, o2);
				collider3.collide(o1, o2);
				collider4.collide(o1, o2);
				//colide between objects and playertank
				collider2.collide(o1, playerTank);
				collider4.collide(o1, playerTank);
				collider5.collide(o1, playerTank);
				collider5.collide(playerTank, o2);

			}
		}
//		if(bullet.health <= 0)
//		{
//			Font currentFont = pen.getFont();
//			Font newFont = currentFont.deriveFont(currentFont.getSize() * 10F);
//			pen.setFont(newFont);
//			pen.setColor(Color.WHITE);
//			pen.drawString("You Lost", 500, 500);
//			
//		}
	}

	public tankData getPlayerTank() {
		return playerTank;
	}

}
