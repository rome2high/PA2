import java.awt.Color;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Br extends Thread implements Runnable{
	InputStreamReader ir = new InputStreamReader(System.in);
	BufferedReader br =  new BufferedReader(ir);

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

	public void run() {
		String myString = "";
		while(true) {
			myString =  getChar();
			if (myString != null){
				System.out.println(myString);
				//if(myString == "123"){
					System.out.println("This is myString : " + myString);
					Kernel kernel = new Kernel();
					Painter painter = new Painter();
					MovingShape ms = new MovingShape(10, 10, 15, 0, Color.RED, MovingShape.OVAL);
					ms.setTimer(4);
					painter.addShape(ms);
					TaskControlBlock tcb = new TaskControlBlock(ms,0);
					kernel.addTCB(tcb);
				//}
				
			}else{
				System.out.print(".");
			}
		
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

//	public static void main(String args[]) {
//
//	Br br = new Br();
//
//	br.myMain();
//
//	}
	
}
