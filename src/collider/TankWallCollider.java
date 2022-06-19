package collider;

import code.GameObject;
import code.Wall;
import code.bullet;
import code.tankData;

public class TankWallCollider implements Collider {

	@Override
	public boolean collide(GameObject o1, GameObject o2) {
		// TODO Auto-generated method stub
		if (o1 instanceof tankData && o2 instanceof Wall) {
			tankData t = (tankData) o1;
			Wall w = (Wall) o2;
			if (t.rect.intersects(w.rect)) {
				t.back();
			}
		} else if (o1 instanceof Wall && o2 instanceof tankData)
			return collide(o2, o1);
		return true;

	}

}
