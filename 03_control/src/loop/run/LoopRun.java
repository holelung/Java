package loop.run;

import loop.service.LoopService1;
import loop.service.LoopService2;

public class LoopRun {
	
	public static void main(String[] args) {
		LoopService1 service1 = new LoopService1();
		LoopService2 service2 = new LoopService2();
		// service1.displayMenu();
		
		service2.displayMenu();
	}

}
