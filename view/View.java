package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controll.Caretaker;

public class View extends JFrame{
	public View(){
		super("Symulacja");
		JPanel panel=new Caretaker();   
		
		this.setSize(620,620); 
        this.add(panel);     
        this.setLayout(null);    
        this.setVisible(true);    
	}
}
