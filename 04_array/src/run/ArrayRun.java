package run;

import service.ArrayService1;
import service.ArrayService2;

public class ArrayRun {
	
	public static void main(String[] args) {
		
		// new : Heap영역에 생성하겠다.
		ArrayService1 service1 = new ArrayService1();
		ArrayService2 service2 = new ArrayService2();
		
		// service1.method5();
		service2.method3();
	}
}
