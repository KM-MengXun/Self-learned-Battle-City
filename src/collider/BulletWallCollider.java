package collider;

import code.GameObject;
import code.Wall;
import code.bullet;

public class BulletWallCollider implements Collider {

	@Override
	public boolean collide(GameObject o1, GameObject o2) {
		// TODO Auto-generated method stub
		if (o1 instanceof bullet && o2 instanceof Wall) {
			bullet b = (bullet) o1;
			Wall w = (Wall) o2;
			if (b.rect.intersects(w.rect)) {
				b.die();
				return false;
			}
		} else if (o1 instanceof Wall && o2 instanceof bullet)
			return collide(o2, o1);
		return true;

	}

}
