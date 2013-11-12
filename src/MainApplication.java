//**********************************************************
// Assignment: ICS-462-50 PA2 JAVA DIY Operating System
//
// Author: Romeo Mai
//
// Honor Code: I pledge that this program represents my own
//   program code with the inspiration from Michael Dorin's works in designing and debugging my program.
//*********************************************************

import java.awt.Color;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class MainApplication {
	
	InputStreamReader ir = new InputStreamReader(System.in);
	BufferedReader br =  new BufferedReader(ir);
	ArrayList<TaskControlBlock> tcbList = new ArrayList<TaskControlBlock>(); //keep local tasks
	

	public String getChar() {
		String s=null;
		try {
			if (br.ready() == true) {
				s = br.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  
		return s;
	}
	
	public void myMain() {
		
		Kernel kernel = new Kernel();
		Painter painter = new Painter();
		MovingShape ms = new MovingShape();
		
		painter.setTimer(30); 
		TaskControlBlock tcb = new TaskControlBlock(painter, 3);
		tcbList.add(tcb);
		kernel.addTCB(tcb);
		
		kernel.start();
		
		try{
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		String myString = "";
		while(true) {
			myString =  getChar();
			if (myString != null && !myString.isEmpty()){
					System.out.println("This is myString : " + myString);

					myString.trim();
					String[] ar = myString.split(" ");
					
					int test = 0;
					for(int i = 1; i < ar.length; i++){
						try{
							test = Integer.parseInt(ar[i]);
						} catch (NumberFormatException e1){
							printUsage();
							ar[0] = "error";
						}
					}
					
					switch(ar[0].trim().toLowerCase()) {
					case "autoadd":
						
						break;
					case "add":
						if(tcbList.size() % 2 == 0){
							ms = new MovingShape(10, 10, tcbList.size()*15, 0, Color.BLUE, MovingShape.RECTANGLE);
						} else {
							ms = new MovingShape(10, 10, tcbList.size()*15, 0, Color.RED, MovingShape.OVAL);
						}
						ms.setTimer(Integer.parseInt(ar[1]));
						painter.addShape(ms);
						tcb = new TaskControlBlock(ms,Integer.parseInt(ar[2]));
						tcbList.add(tcb);
						break;
					case "start":
							kernel.addTCB(tcbList.get(Integer.parseInt(ar[1])));
						break;
					case "stop":
							kernel.removeTCB(tcbList.get(Integer.parseInt(ar[1])));
						break;
					default: System.out.println("Invalid Input!");
						break;
					}
					
			}else{
//				System.out.print("");
			}
		
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void printUsage(){
		System.out.println(" ADD TIMER(int) PRIORITY(int)" +
				"\n START TASKNUMBER(int)" +
				"\n STOP TASKNUMBER(int)" +
				"");
	}

	public static void main(String args[]) {
		MainApplication ma = new MainApplication();
		printUsage();
		ma.myMain();
	}
}