package model;

import java.util.ArrayList;
import java.util.HashSet;

public class Board {
	private Vector2D size;
	private ArrayList<Point> points = new ArrayList<>();
	
	public Board(double x, double y) {
		this.size = new Vector2D(x,y);
	}
	public ArrayList<Point> getPoints() {
		return this.points;
	}
	public Point getPoint(int i) {
		return this.points.get(i);
	}
	public void addPoint(Point p) {
		this.points.add(p);
	}
	
	public void next() {
		Vector2D temp;
		//new position
		for(Point p : this.points) {
			double x = p.getPosition().getX() + p.getSpeed().getX();
			if(x < 0) x=0;
			if(x > size.getX()) x= size.getX();
			double y = p.getPosition().getY()+p.getSpeed().getY();
			if(y<0) y=0;
			if(y > size.getY()) y= size.getY();		
			temp = new Vector2D(x,y);
			p.setState(temp);
		}
		//hit
		HashSet<Point> set = new HashSet<Point>();
		for(Point p : this.points) {
			//board
			if(Math.round(p.getPosition().getX()) <= 0 || Math.round(p.getPosition().getX()) >= size.getX() ) {
				temp = new Vector2D(p.getPosition().getX() * -1 , p.getPosition().getY());
				p.setState(temp);
			}
			if(Math.round(p.getPosition().getY()) <= 0 || Math.round(p.getPosition().getY()) >= size.getY() ) {
				temp = new Vector2D(p.getPosition().getX(), p.getPosition().getY() * -1);
				p.setState(temp);
			}
			//points
			set.add(p);
		}
	}
}
