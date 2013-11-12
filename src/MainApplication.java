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
	
	public static final int defaultTimer = 30;
	public static final int defaultPriority = 3;
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
			painter.textArea.setText(painter.logText += " test \n");
			myString =  getChar();
			if (myString != null && !myString.isEmpty()){
					myString.trim();
					String[] ar = myString.split(" ");
					
					if(ar.length < 2)
					{
						System.out.println("Error: Not Enough Argument!");
						printUsage();
						continue;
					}
					
					int test = 0;
					for(int i = 1; i < ar.length; i++){
						try{
							test = Integer.parseInt(ar[i]);
						} catch (NumberFormatException e1){
							System.err.println("Argument '" + ar[i] + "' must be an integer");
							ar[0] = "Error";
						}
					}
					
					switch(ar[0].trim().toLowerCase()) {
					case "autoadd":
						for (int i = 0; i < Integer.parseInt(ar[1]); i++){
							if(tcbList.size() % 2 == 0){
								ms = new MovingShape(10, 10, tcbList.size()*15, 0, Color.BLUE, MovingShape.RECTANGLE);
							} else {
								ms = new MovingShape(10, 10, tcbList.size()*15, 0, Color.RED, MovingShape.OVAL);
							}
							ms.setTimer(MainApplication.defaultTimer);
							painter.addShape(ms);
							tcb = new TaskControlBlock(ms,MainApplication.defaultPriority);
							tcbList.add(tcb);
						}
						break;
					case "add":
						if(ar.length <= 2){		//must have 2 args
							System.out.println("Error: Not Enough Argument!");
							printUsage();
							break;
						}
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
							if(Integer.parseInt(ar[1]) >= tcbList.size()){
								System.out.println("No task number exist, try a number 1 - " + (tcbList.size()-1));
								break;
							}
							kernel.addTCB(tcbList.get(Integer.parseInt(ar[1])));
							System.out.println("Started task number " + ar[1]);
						break;
					case "stop":
							if(Integer.parseInt(ar[1]) >= tcbList.size()){
								System.out.println("No task number exist, try a number 1 - " + (tcbList.size()-1));
								break;
							}
							kernel.removeTCB(tcbList.get(Integer.parseInt(ar[1])));
							System.out.println("Stoped task number " + ar[1]);
						break;
					default: 
							System.out.println("Invalid Command!");
							printUsage();
						break;
					}
					
			}else{
//				System.out.print("");
			}
		
			try {
				Thread.sleep(100);
				//Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void printUsage(){
		System.out.println(
				"[USAGE]" +
				"\nAUTOADD NumberOfTask(int)		-Add multiple tasks at once" +
				"\nADD SetTimer(int) Priority(int)		-Add single task" +
				"\nSTART TASKNUMBER(int)			-Start a task" +
				"\nSTOP TASKNUMBER(int)			-Stop a task" +
				"");
	}

	public static void main(String args[]) {
		MainApplication ma = new MainApplication();
		printUsage();
		ma.myMain();
	}
}