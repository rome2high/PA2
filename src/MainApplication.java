//**********************************************************
// Assignment: ICS-462-50 PA2 JAVA DIY Operating System
//
// Author: Romeo Mai
//
// Honor Code: I pledge that this program represents my own
//   program code with the inspiration from Michael Dorin's works in designing and debugging my program.
//*********************************************************

import java.awt.Color;


public class MainApplication {
	
	
	public void myMain() {
		
		Br br = new Br();
		System.out.println("Enter a number process you wish to run:");
		//String userinput = br.GetUserInput();
		
		
		Kernel kernel = new Kernel();
		Painter painter = new Painter();
		painter.setTimer(30); 
		TaskControlBlock tcb = new TaskControlBlock(painter, 3);
		kernel.addTCB(tcb);
		
		MovingShape ms = new MovingShape(5, 5, 3, 0, Color.BLUE, MovingShape.RECTANGLE);
		ms.setTimer(30);
		painter.addShape(ms);
		tcb = new TaskControlBlock(ms, 2);
		kernel.addTCB(tcb);
		
		kernel.start();
		br.start();
		
		
		//kernel.run();
	}
	
	public static void main(String args[]) {
		MainApplication ma = new MainApplication();
		
		ma.myMain();
	}
}

//--------------------------//

//MovingShape ms = new MovingShape(5, 5, 3, 0, Color.BLUE, MovingShape.RECTANGLE);
//ms.setTimer(3);
//painter.addShape(ms);
//tcb = new TaskControlBlock(ms, 2);
//kernel.addTCB(tcb);
//
//ms = new MovingShape(10, 10, 15, 0, Color.RED, MovingShape.OVAL);
//ms.setTimer(4);
//painter.addShape(ms);
//tcb = new TaskControlBlock(ms,0);
//kernel.addTCB(tcb);
//
//ms = new MovingShape(10, 10, 25, 0, Color.RED, MovingShape.OVAL);
//ms.setTimer(5);
//painter.addShape(ms);
//tcb = new TaskControlBlock(ms, 3);
//kernel.addTCB(tcb);
//
//ms = new MovingShape(10, 10, 35, 0, Color.RED, MovingShape.OVAL);
//ms.setTimer(5);
//painter.addShape(ms);
//tcb = new TaskControlBlock(ms, 4);
//kernel.addTCB(tcb);
//
//ms = new MovingShape(10, 10, 55, 0, Color.RED, MovingShape.OVAL);
//ms.setTimer(5);
//painter.addShape(ms);
//tcb = new TaskControlBlock(ms, 5);
//kernel.addTCB(tcb);