package basic;

public class BasicRun {
	
	public static void main(String[] args) {
		
		Car car1= new Car("HYUNDAI", "SONATA", 2025);
		Car car2= new Car("HYUNDAI", "GRANDEUR", 2025);
		Car car3= new Car("BMW", "M340i", 2024);
		
		car1.info();
		car1.start();
		car1.stop();
		
		car2.info();
		car2.start();
		car2.stop();
		
		car3.info();
	}
}
