package list.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import generics.Child;
import generics.Parent;

public class ListService {
	/*
	 * Collection Framework : Java에서 제공하는 자료구조 모음 
	 * - Java.util 패키지에 존재
	 * 
	 * [Collection Framework 특징] 
	 * 1. 크기제한 없음 
	 * 2. 추가, 수정, 삭제, 정렬 등의 기능 제공 
	 * 3. 객체만 저장가능 
	 * - 기본 자료형은 Wrapper Class를 이용해서 저장
	 * - 기본적으로 타입제한은 없지만 개발의 편의성을 위해 한 가지 타입으로 제한 
	 *   ->제네릭스 사용
	 */

	/*
	 * [List(목록)] 
	 * - 데이터를 순차적으로 나열한 자료구조(배열 비슷)
	 * 
	 * [List 특징] 
	 * 
	 * - 각 데이터를 index를 이용해 구분 == 순서가 있음
	 * 
	 * - index 로 데이터 구분되기 때문에 중복 값 저장가능
	 */

	public void test1() {
		/*
		 * List 는 인터페이스! -> 직접 객체생성 불가 --> 상속 받아 구현한 자식 클래스 이용
		 * 
		 * [Array List] - 배열처럼 생긴 List
		 */

		// 제네릭을 이용한 타입 제한 미지정
		ArrayList list = new ArrayList();

		/* boolean add(E e) : 리스트 객체에 요소E 추가 후 true 반환 */
		list.add(new Object());
		list.add("hello world");
		list.add(123245);

		/* E get(int index) : List 에서 index 번째 요소E 반환 */
		list.get(0); // -> Object 타입 반환

		Object obj = list.get(1);
		if (obj instanceof String) { // 타입 검증
			System.out.println(obj);
			System.out.println(((String) obj).length()); // 다운 캐스팅
		}
	}
	/*
	 * ***불편하게 타입 검증, 다운캐스팅 하는 이유*** 
	 * - 여러 타입을 저장할 수 있다는 컬렉션의 특징이 오히려 독이됨 
	 *   -> 제네릭스를 이용해 타입을 제한! 
	 *      -> 한 타입만 있을 테니까 검증, 다운캐스팅 X
	 */

	public void test2() {
		ArrayList<String> menuList = new ArrayList<String>();

		// add() 확인
		// menuList.add(123); // 오류발생 (타입불일치)

		menuList.add("김치찌개");
		menuList.add("족발");
		menuList.add("보쌈");
		menuList.add("치킨");
		menuList.add("피자");
		menuList.add("국밥");
		menuList.add("아구찜");

		for (String menu : menuList) {
			System.out.println(menu);
		}

		System.out.println("------------------");
		for (int i = 0; i < menuList.size(); i++) {
			String menu = menuList.get(i);
			System.out.println(menu);
		}
		
		System.out.println("------------------");
		
		/* void add(int index, E e) : index 번째에 e 추가(중간 삽입) */
		menuList.add(1, "갈비탕");
		
		
		/* String toString() : 리스트에 저장된 값을 하나의 문자열로 반환 */
		System.out.println(menuList.toString());
		
		
		/* E set(int index, E e) 
		 * - index 번째 요소에 전달 받은 e를 세팅(수정)
		 * - 결과로 이전에 존재하던 요소(E)를 반환
		 * */


		String before = menuList.set(2, "불족발");
		System.out.println("------------------");
		System.out.println(menuList.toString());
		System.out.println(before + "이/가 수정 되었습니다. ");
		
		/* boolean contains(E e) 
		 * - 같은 객체가 있는지 확인
		 * - 비교하려는 객체가 equals()를 오버라이딩 해야함
		 * */
		
		System.out.println("보쌈 : "+menuList.contains("보쌈"));
		System.out.println(before+" : "+menuList.contains(before));
		
		
		/* int indexOf(E e)
		 * - 같은 객체가 있는 index 번호를 반환
		 * - 없으면 -1 반환
		 *  */
		System.out.println("-------------------");
		System.out.println("치킨 인덱스 : " + menuList.indexOf("치킨"));
		System.out.println("햄버거 인덱스 : " + menuList.indexOf("햄버거"));
		
		
		/* E remove(int index)
		 * - index 번째 요소 삭제
		 * - 삭제된 요소(E) 반환
		 * - 중간 요소가 삭제되면 알아서 빈 공간을 채움(앞으로 당기기)
		 */
		System.out.println("-------------------");
		System.out.println(menuList.remove(1) + "제거");
		System.out.println(menuList);

	}

	
	
	/* 컬렉션 객체의 참조 변수는
	 * 부모 타입(List 인터페이스)으로 설정하면 좋은 이유
	 * <pre>
	 * -> 프로그래밍 과정에서 미처 생각하지 못한
	 *    비효율적인 요소를 쉽게 제거하기 위해서
	 *    
	 * 1. ArrayList
	 * 	 - 배열 처럼 요소가 붙어서 존재
	 *   - 장점 : 검색 속도가 빠름
	 *   - 단점 : 중간에 추가, 수정, 삭제가 비효율적
	 * 2. LinkedList
	 *   - 요소를 서로 참조하는 형식으로 연결되어 있음
	 *   - 장점 : 중간에 추가, 수정, 삭제가 효율적
	 *   - 단점 : 검색 속도가 느림 
	 * </pre>  
	 */
	public void test3() {
		
		// 부모타입 참조 변수 List
//		List<Integer> list = new ArrayList<Integer>();
		
		// 중간 추가/수정/삭제가 빠른 LinkedList로 교체
		List<Integer> list = new LinkedList<Integer>();
		
		// 난수 생성 객체
		Random random = new Random(); 
		
		// long start = System.currentTimeMillis();
		// - 1970년 1월 1일 09:00:00.000 (대한민국 기준)
		// 위 시간을 기준으로 현재 얼마만큼 시간이 지났는지
		// ms(1/1000) 단위로 계산해서 반환
		long start = System.currentTimeMillis();
		
//		try {
//			Thread.sleep(1000); // 현재 스레드를 1000ms 동안 멈춤
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		list.add(random.nextInt(Integer.MAX_VALUE));
		list.add(random.nextInt(Integer.MAX_VALUE));
		
		for(int i=0; i<1000000; i++) {
			// 1번 인덱스에 난수 삽입(중간 삽입);
			list.add(1, random.nextInt(Integer.MAX_VALUE));
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("걸린시간: "+ (end - start) + "ms");
		
	}
	
	
	
	public void test4() {
		
		// 부모 타입만 저장 할수 있는 List 생성
		List<Parent> list1 = new ArrayList<Parent>();
		list1.add(new Parent());
		
		// 자식 타입만 저장할 수 있는 List 생성
		List<Child> list2 = new ArrayList<Child>();
		list2.add(new Child(1));
		list2.add(new Child(2));
		list2.add(new Child(3));

		// list1, list2 하나로 합치기
		List<Parent> list3 = new ArrayList<Parent>();
		
		// boolean addAll(Collection<? extends E> c)
		// - Collection 상속객체(List, Set)을
		// 	 현재 List 의 제일 뒤에 추가
		// - E : 현재 List에 제한된 타입 == Parent
		// - ? : Parent 또는 Child
		list3.addAll(list1); // List<Parent>
		list3.addAll(list2); // List<Child>
		
		List<String> temp = new ArrayList<String>();
		//list3.addAll(temp); // String은 Parent 상속 관계 X => error
		
	}
}
