package collider;

import code.GameObject;
import code.bullet;
import code.tankData;
import code.Sides;

public class EnemyBulletPlayerTankCollider implements Collider {

	@Override
	public boolean collide(GameObject o1, GameObject o2) {
		// TODO Auto-generated method stub
		if (o1 instanceof bullet && o2 instanceof tankData) {
			bullet b = (bullet) o1;
			tankData t = (tankData) o2;
			if (b.enemyBulletPlayerTankCollide(t))
				return false;
		}

		return true;
	}

}
