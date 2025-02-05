package section03.dto;


/* 인터페이스 다중 상속 확인
 * 
 */
public interface Machine {
	
	// 기계 On/Off
	void powerOn();
	void powerOff();
	
	// Calculator와 동일한 메서드
	int plus(int a, int b);
}
