// ICS-462 Demo Code for PA2
// By Michael Dorin
// Metro State University
//
import java.awt.Color;


public class MainApplication {
	
	
	public void myMain() {
		Kernel kernel = new Kernel();
		Painter painter = new Painter();
		painter.setTimer(30); 
		//kernel.addTask(painter);
		TaskControlBlock tcb = new TaskControlBlock(painter, 0);
		kernel.addTCB(tcb);
		
		
		MovingShape ms = new MovingShape(5, 5, 3, 0, Color.BLUE, MovingShape.RECTANGLE);
		ms.setTimer(50);
		//kernel.addTask(ms);
		painter.addShape(ms);
		tcb = new TaskControlBlock(ms, 2);
		kernel.addTCB(tcb);
		
		ms = new MovingShape(10, 10, 15, 0, Color.RED, MovingShape.OVAL);
		ms.setTimer(170);
		//kernel.addTask(ms);
		painter.addShape(ms);
		tcb = new TaskControlBlock(ms, 1);
		kernel.addTCB(tcb);
		
		ms = new MovingShape(10, 10, 25, 0, Color.RED, MovingShape.OVAL);
		ms.setTimer(15);
		//kernel.addTask(ms);
		painter.addShape(ms);
		tcb = new TaskControlBlock(ms, 3);
		kernel.addTCB(tcb);
		
		kernel.run();
	}
	
	public static void main(String args[]) {
		MainApplication ma = new MainApplication();
		ma.myMain();
	}
}
