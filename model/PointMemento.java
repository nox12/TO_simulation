package model;

public class PointMemento {
	private Vector2D position;
	private Vector2D speed;
	
	public PointMemento(Vector2D p, Vector2D s) {
		this.position=p;
		this.speed=s;
	}
	
	public Vector2D getPosition() {
		return this.position;
	}
	public Vector2D getSpeed() {
		return this.speed;
	}
}
