package set.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import set.dto.Person;

public class SetService {
	/* Set(집합)
	 * - 기본적으로 순서 유지 X
	 * - 중복 데이터(객체) 저장 X
	 * 	-> 중복된 객체가 들어오면 덮어쓰기
	 * 	-> *중요* equals(), hashCode() 오버라이딩 필수
	 * 		(동등 비교를 하기 위해서)
	 * 
	 * Set 인터페이스를 구현한 구현체
	 * 
	 * 1. HashSet : 처리속도가 빠른 Set(제일 많이 사용)
	 * 
	 * 2. LinkedHashSet : 순서를 유지하는 Set
	 * 
	 * 3. TreeSet : 자동 정렬을 지원하는 Set
	 */
	
	
	/**
	 * Set/HashSet 기본 사용법
	 */
	public void test1() {
		
		// HashSet 객체 생성
		Set<String> set = new HashSet<String>();
		
		// * String 은 equals(), hashCode() 오버라이딩 상태
		
		/* boolean add(E e) : 요소 추가 */
		set.add("네이버");
		set.add("카카오");
		set.add("라인");
		set.add("쿠팡");
		set.add("배달의민족");
		set.add("토스");
		set.add("당근마켓");
		set.add("직방");
		set.add("야놀자");
		
		System.out.println(set);
		
		/* 중복 허용 X 확인 */
		set.add("배달의민족");
		set.add("배달의민족");
		set.add("배달의민족");
		
		System.out.println(set);
		
		/* null(참조X) 중복 허용 X 확인 */
		set.add(null);
		set.add(null);
		set.add(null);
		System.out.println(set);
		
		/* int size() : 저장된 객체의 개수를 반환 */
		System.out.println("set.size() : " + set.size());
	
		
		/* boolean remove(E e) : 동등한 객체를 찾아서 제거 
		 * -> equals(), hashCode() 오버라이딩 필수!
		 * */
		System.out.println("쿠팡 제거됨? : "+ set.remove("쿠팡"));
		System.out.println("삼성 제거됨? : "+ set.remove("삼성"));
		System.out.println(set);
		
		/* boolean contains(E e) : 동등 객체 포함 여부 확인 
		 * -> equals(), hashCode() 오버라이딩 필수! */
		System.out.println("네이버 있음? : "+set.contains("네이버"));
		System.out.println("LG 있음? : "+set.contains("LG"));
		
		/* boolean isEmpty() : 비어있으면 true, 아니면 false */
		/* void clear() : 저장된 값 모두 제거 */
		
		System.out.println("clear() 전 isEmpty() : "+ set.isEmpty());
	  set.clear();
		System.out.println("clear() 후 isEmpty() : "+ set.isEmpty());
		System.out.println("set : "+set); // []	
	}
	
	/**
	 * <pre>
	 * Hash 단어가 포함된 컬렉션은
	 * 무조건 equals(), hashCode()가 오버라이딩 되어있어야 한다!
	 * 
	 * @@@ Object 가 제공하는 메서드 오버라이딩 목적 @@@
	 * 
	 * - equals() : 객체의 필드가 같은지 비교(동등 비교)
	 * 
	 * - hashCode() : 객체의 식별번호
	 * 								equals()가 true 이면 hashCode()도 같아야 한다.
	 * 								-> 빠르게 접근하기 위해 사용
	 * </pre>
	 */
	public void test2() {
		Person p1 = new Person("짱구", 5, '남');
		Person p2 = new Person("유리", 5, '여');
		Person p3 = new Person("유리", 6, '여');
		Person p4 = new Person("철수", 5, '남');
		Person p5 = new Person("철수", 5, '남'); // 중복 필드 객체 생성
		
		// set 객체 생성
		Set<Person> personSet = new LinkedHashSet<Person>();
		
		personSet.add(p1);
		personSet.add(p2);
		personSet.add(p3);
		personSet.add(p4);
		
		/* Set의 특징 : 순서유지 X, 중복 허용 X */
		for(Person p : personSet) {
			System.out.println(p);
		}
		
		// 1. equals(), hashCode() 오버라이딩 X
		// -> 중복 제거 안됨
		
		// 2. equals()오버라이딩 O, hasCode 오버라이딩 x
		// -> 중복 제거 안됨
		
		// 3. equals()오버라이딩 x, hasCode 오버라이딩 o
		// -> 중복 제거 안됨
		
		// 4. equals()오버라이딩 O, hasCode 오버라이딩 o
		// -> 중복 제거 됨
	}
	
	
	/** [Iterator<T> Set<T>.iterator()]
	 * <pre>
	 * - 해당 Set에 저장된 요소를 순차 접근할 수 있는
	 * 	 반복자(Iterator)를 반환하는 메서드
	 * 
	 * [Iterator 인터페이스]
	 * - 반복자 기능 제공 인터페이스
   * - <E>반복자가 반환하는 요소의 유형
   * 
   * 1. `boolean hasNext()` : 다음 반복 접근할 요소가 있으면 true, 없으면 false
   * 2. `E next()` : 다음 요소를 반환 -> 무조건 `hasNext()` 이후에 사용해야함
	 * 
	 * </pre>
	 */
	public void test3() {
		Set<String> snacks = new HashSet<String>();
		
		snacks.add("꼬북칩");
		snacks.add("포카칩");
		snacks.add("칙촉");
		snacks.add("홈런볼");
		snacks.add("쿠크다스");
		snacks.add("프링글스");
		snacks.add("다이제");
		
		
		// snacks(Set)에 저장된 값을 순차접근(반복 접근)하는 객체 반환받기
		Iterator<String> it = snacks.iterator();
		
		// 반복 접근할 객체(꺼낼 객체)가 존재하면 반복
		while(it.hasNext()) {
			String snack = it.next(); // 다음 값을 얻어옴;
			System.out.println(snack);
		}
		
		System.out.println("------------------------------");
		
		/*향상된 for문
		 * - 배열, 컬렉션(List, Set)의 요소를 하나씩 순차 접근
		 * 	-> Iterable 인터페이스 구현체에 대한 반복 접근 제공
		 * 
		 */
		for(String snack : snacks) {
			System.out.println(snack);
		}
		
		System.out.println("------------------------------");
		/* Set -> List 변환 */
		List<String> list = new ArrayList<String>(snacks);
		// -> snacks Set에 저장된 데이터를 이용해 ArrayList 생성
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
	}
	
	
	/*
	 * TreeSet
	 */
	public void test4() {
		// 순서를 저장하는 Set	
		// Set<String> set = new HashSet<String>();
		
		// 오름 차순 정렬
		Set<String> set = new TreeSet<String>();
			
		set.add("짱구");
		set.add("유리");
		set.add("철수");
		set.add("훈이");
		set.add("맹구");
		set.add("짱구2호");
		
		System.out.println(set);
		// HashSet : 순서 유지 x
	}

	// 로또 번호 6개(중복X, 오름차순 정렬)가 담긴 문자열 반환
	public String getLottoNumber() {
		Random random = new Random();
		
		Set<Integer> lotto = new TreeSet<Integer>();
		
		while(lotto.size() < 6) {
			lotto.add(random.nextInt(45)+1);
		}
		
		// System.out.println(lotto);
		
		return lotto.toString();
		
		// 기존 방법
//		int[] lotto = new int[6];
//		
//		for(int i=0; i<lotto.length; i++) {
//			int num = random.nextInt(45)+1;
//			lotto[i] = num;
//			
//			for(int x = 0 ; x<i; x++) {
//				if(lotto[x] == num) {
//					i--;
//					break;
//				}
//			}
//		}
//		Arrays.sort(lotto); // 정렬
//		
//		System.out.println(Arrays.toString(lotto));
		
		// 
	}
	
	/**
	 * 로또 번호 생성기
	 * - 입력된 수 만큼의 로또 번호 생성
	 * - 마지막에 가격출력( 1회당 1,000원 )
	 * 
	 */
	public void lottoNumberGenerator() {
		Scanner sc = new Scanner(System.in);
		System.out.print("생성할 로또 번호 갯수 입력 : ");
		int count = sc.nextInt();
		sc.close();
		
		for(int i=0;i<count; i++) {
			System.out.printf("[%d회] %s\n", i+1, getLottoNumber());
		}
	  System.out.println("금액 : "+ count * 1000 + "원");
	}
	
}
