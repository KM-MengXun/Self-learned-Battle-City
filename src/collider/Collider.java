package collider;

import code.GameObject;

public interface Collider {
	boolean collide(GameObject o1, GameObject o2);
}
