package generics;


public class Box<T> {
/* Generic : 일반적인, 포괄적인
 * 
 * Java에서 Generics : 
 *  데이터 타입을 일반화
 * -> 지정된 타입 하나로 변경 
 * 
 * - 사용 이유
 *  1) 타입 안정성 보장(컴파일 단계에서 강력한 타입 검증)
 *  2) 타입체크, 형변환 코드 생략가능
 *  3) 코드 재사용성 증가
 *  
 *  - 주요 파라미터 타입 관례
 *  T : Type (아무 타입이나 작성)
 *  E : Element (아무 객체 == Object)
 *  K : Key 
 *  V : Value
 *  N : Number
 *  
 */
	
	private T value;

	public void setValue(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}
	

}
