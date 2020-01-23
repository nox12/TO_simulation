package model;

import java.awt.Color;
import java.awt.Graphics2D;

public class Point {
	private Vector2D position;
	private Vector2D speed;
	
	public Point() {
		
	}
	public Point(Vector2D p, Vector2D s) {
		this.position=p;
		this.speed=s;
	}
	public void setState(Vector2D p) {
		this.position = p;
	}
	public Vector2D getSpeed() {
		return this.speed;
	}
	public Vector2D getPosition() {
		return this.position;
	}
	public void setSpeed(Vector2D s) {
		this.speed = s;
	}
	public PointMemento save() {
		return new PointMemento(this.position, this.speed);
	}
	public void load(PointMemento memento) {
		this.position = memento.getPosition();
		this.speed = memento.getSpeed();
	}
	
	public boolean equals(Object o) {
	      if ((o instanceof Point) && Math.round(((Point)o).getPosition().getX()) == Math.round(this.getPosition().getX()) && 
	    		  Math.round(((Point)o).getPosition().getY()) == Math.round(this.getPosition().getY())) {
	    	  Vector2D temp = this.getSpeed();
	    	  this.setSpeed(((Point)o).getSpeed());
	    	  ((Point)o).setSpeed(temp);
	    	  return true;
	      }
	      return false;
	  }
	
	public void rysuj(Graphics2D g) 
	{
		g.setColor(new Color(100,0,0));
		g.fillOval((int)Math.round(this.getPosition().getX()), (int)Math.round(this.getPosition().getY()), 5, 5);
	}
}
