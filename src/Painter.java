// ICS-462 Demo Code for PA2
// By Michael Dorin
// Metro State University
//
import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Painter extends JPanel implements MyTask {
 
	private static final long serialVersionUID = 1L;
	JFrame frame; 
	JPanel panel;
	public static final int SQUARE_SIZE = 400;
	LinkedList<MovingShape> shapeList = new LinkedList<MovingShape>();  
	
	public void addShape(MovingShape shape) {
		shapeList.add(shape);
	}
	
	public Painter() {
		frame = new JFrame("PA2 Frame");
		frame.setSize(SQUARE_SIZE,SQUARE_SIZE);
		panel = this;
		panel.setSize(SQUARE_SIZE, SQUARE_SIZE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	 
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		int count = shapeList.size();
		for (int i=0;i<count;i++) {
			MovingShape shape = shapeList.get(i);
			if (shape.getType() == shape.RECTANGLE) {
				g.setColor(shape.getColor());
				g.fill3DRect(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight(), true);
			} else  { // most be oval
				g.setColor(shape.getColor());
				g.fillOval(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
			}		
		}
	}
	
	public void paintPanel() {
		frame.repaint();
		panel.repaint();
	}
	
	
	//
	@Override
	public void execute() {
		paintPanel();
	}
	
	public int timer = 0;
	public int reload = 0;
	
	@Override
	public void resetTimer() {
		timer = reload;
	}

	@Override
	public boolean decrementTimer() {
		timer--;
		if (timer<0)
			return true;
		else 
			return false;
	}

	@Override
	public void setTimer(int _value) { 
		reload = _value;

	}
}
