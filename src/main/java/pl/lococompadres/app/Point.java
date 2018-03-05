package pl.lococompadres.app;

public class Point {

	public String name;
	public boolean enemy;
	public int pointAP;
	public int distanceToEnemy;
	public Long cash;
	public Long thugs;
	public Long ladies;
	public Long dealers;

	public Point() {};
	
	public Point(String name, boolean enemy, int pointAP, int distanceToEnemy, Long cash, Long thugs, Long ladies,
			Long dealers) {
		super();
		this.name = name;
		this.enemy = enemy;
		this.pointAP = pointAP;
		this.distanceToEnemy = distanceToEnemy;
		this.cash = cash;
		this.thugs = thugs;
		this.ladies = ladies;
		this.dealers = dealers;
	}

	@Override
	public String toString() {
		return "" + name + "," + enemy + "," + pointAP + "," + distanceToEnemy + "," + cash + "," + thugs + "," + ladies + "," + dealers;
	}

}