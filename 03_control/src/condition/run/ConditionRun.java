package condition.run;

import condition.service.ConditionService;

/**
 * 실행용 클래스
 */
public class ConditionRun {
	public static void main(String[] args) {
		
		// ConditionService 객체 생성
		ConditionService service = new ConditionService();
		
		// service.메서드명();-
		
		service.displayMenu();
		
		
	}
}
