package collider;

import code.GameObject;
import code.bullet;
import code.tankData;

public class TankTankCollider implements Collider {

	@Override
	public boolean collide(GameObject o1, GameObject o2) {
		// TODO Auto-generated method stub
		if (o1 instanceof tankData && o2 instanceof tankData) {
			tankData t1 = (tankData) o1;
			tankData t2 = (tankData) o2;
			if (t1.getRect().intersects(t2.getRect())) {
				t1.back();
				t2.back();
			}
		}

		return true;
	}

}
