package code;

public class DefaultFireType implements FireType {

	@Override
	public void fire(tankData t) {
		//where the bullet start moving
		int a = t.tankX + tankData.tankWidth / 2 - bullet.bWidth / 2;
		int b = t.tankY + tankData.tankHeight / 2 - bullet.bHeight / 2;
		new bullet(a, b, t.direction, t.group, t.gm);
	}
}
