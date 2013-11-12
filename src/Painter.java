//**********************************************************
// Assignment: ICS-462-50 PA2 JAVA DIY Operating System
//
// Author: Romeo Mai
//
// Honor Code: I pledge that this program represents my own
//   program code with the inspiration from Michael Dorin's works in designing and debugging my program.
//*********************************************************

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;


public class Painter extends JPanel implements MyTask {
 
	private static final long serialVersionUID = 1L;
	JFrame frame; 
	JPanel panel;
	JScrollPane scrollPane;
	JTextArea textArea;
	String logText= "Log text: ";
	public static final int SQUARE_SIZE = 400;
	LinkedList<MovingShape> shapeList = new LinkedList<MovingShape>();  
	
	public void addShape(MovingShape shape) {
		shapeList.add(shape);
	}
	
	public Painter() {
		frame = new JFrame("ICS462 PA2 DIY Operating System");
		setLayout(new GridLayout(2,1));
		frame.setSize(SQUARE_SIZE, SQUARE_SIZE);
		panel = this;
		panel.setSize(SQUARE_SIZE, SQUARE_SIZE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		textArea = new JTextArea(400,400);
		textArea.setText(logText);
		textArea.setAlignmentX(0);
		textArea.setAutoscrolls(true);
		
		DefaultCaret caret = (DefaultCaret)textArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
		scrollPane = new JScrollPane(textArea);
		scrollPane.setSize(SQUARE_SIZE, 400);
		scrollPane.setLocation(0, 400);
		
		frame.add(scrollPane);
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
		scrollPane.repaint();
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
