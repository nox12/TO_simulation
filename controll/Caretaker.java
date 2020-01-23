package controll;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.Board;
import model.Point;
import model.PointMemento;
import model.Vector2D;

public class Caretaker extends JPanel{ 
	private Board mapa;
	private int x,y;
	private ArrayList<PointMemento> mementos = new ArrayList<>();
	private boolean start = false;
	private boolean paint=true;
	private Caretaker pointer = this;
    public Caretaker() {    
    	this.x = 600;
    	this.y = 600;
    	mapa = new Board(x,y);
    	this.setBounds(10,10,x,y);    
        this.setBackground(Color.gray);
    	JButton run=new JButton("Run");     
        run.setBounds(50,100,40,20);    
        run.setBackground(Color.green);  
        run.setVisible(true);
        run.setFocusable(true);
        this.add(run);
        run.addActionListener(new ActionListener() {
	        
			public void actionPerformed(ActionEvent arg0) {
				if(start) {
					start = false;
					repaint();
					return;
				}
				start=true;
				StartRunnable runnable = new StartRunnable(pointer);
				Thread startThread = new Thread(runnable);
				startThread.start();
			}          
	      });
        JButton save=new JButton("Save");   
        save.setBounds(100,50,40,20);    
        save.setBackground(Color.gray);   
        save.addActionListener(new ActionListener() {
	        
			public void actionPerformed(ActionEvent arg0) {
				mementos.clear();
				for(Point p : mapa.getPoints()) {
					mementos.add(p.save());
				}
			}          
	      });
        JButton load = new JButton("Load");
        load.setBounds(150,50,40,20);    
        load.setBackground(Color.gray);
        load.addActionListener(new ActionListener() {
	        
			public void actionPerformed(ActionEvent arg0) {
				if(mementos.size() >0) {
					for(int i=0; i< mementos.size(); ++i) {
						mapa.getPoint(i).load(mementos.get(i));
					}
					repaint();
				}
			}          
	      });
         this.add(save);  
         this.add(load);
         
         this.mapa.addPoint(new Point(new Vector2D(20,10), new Vector2D(2,3)));
         this.mapa.addPoint(new Point(new Vector2D(158,75), new Vector2D(1,-2)));
         this.mapa.addPoint(new Point(new Vector2D(56,250), new Vector2D(4,2)));
         this.mapa.addPoint(new Point(new Vector2D(256,235), new Vector2D(2,1)));
         this.mapa.addPoint(new Point(new Vector2D(183,14), new Vector2D(1,1)));
         this.mapa.addPoint(new Point(new Vector2D(24,167), new Vector2D(2,2)));
         this.mapa.addPoint(new Point(new Vector2D(456,360), new Vector2D(3,-1)));
         this.mapa.addPoint(new Point(new Vector2D(280,480), new Vector2D(2,-2)));
    }
    @Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.white);
		g.fillRect(0, 0, x, y);
		for(Point p : this.mapa.getPoints()) {
			p.rysuj((Graphics2D) g);
		}
		
	}
    
    void startF() {
    	while(this.start) {
    		if(!this.start) break;
    		this.mapa.next();
    		if(this.paint) {
    			PaintRunnable runnable = new PaintRunnable(this);
    			Thread t = new Thread(runnable);
    			t.start();
    		}
    	}
    }
    
    public boolean getStart() {
    	return this.start;
    }
    public boolean getPaint() {
    	return this.paint;
    }
    public void setPaint(boolean p) {
    	this.paint = p;
    }
}
