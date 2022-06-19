package collider;

import code.GameObject;
import code.bullet;
import code.tankData;

public class BulletTankCollider implements Collider {

	@Override
	public boolean collide(GameObject o1, GameObject o2) {
		// instanceof function help to determine if something belongs to a class
		if (o1 instanceof bullet && o2 instanceof tankData) {
			bullet b = (bullet) o1;
			tankData t = (tankData) o2;
			if (b.collideWith(t))
				;
			return false;
		} else if (o1 instanceof tankData && o2 instanceof bullet)
			return collide(o2, o1);
		return true;

	}

}
