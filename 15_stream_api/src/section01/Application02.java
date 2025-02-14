package section01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Application02 {
	public static void main(String[] args) {
		/* 스트림 생성 방법 */
		
		// 1) 배열 -> 스트림
		String[] names = {"짱구", "훈이", "맹구"};
		Stream<String> nameStream = Arrays.stream(names);
		
		// 스트림 + 메서드 참조
		nameStream.forEach(System.out::println);
		// java.lang.IllegalStateException: // 잘못된 상태 예외
		// stream has already been operated upon or closed
		// -> 스트림은 이미 작동되었거나 종료되었습니다
		// -> 스트림은 일회용
//		nameStream.forEach(System.out::println);
		
		// 2) 컬렉션 -> Stream
		List<String> animals = Arrays.asList("dog","cat","cow","rat","pig");
		// 고정된 길이의 List 생성 및 요소 추가 방법
		
		Stream<String> animalStream = animals.stream();
		System.out.println();
		animalStream.filter(animal -> animal.startsWith("c")).forEach(System.out::println);
		                       // c 로 시작하는 동물만 필터링
		
		// 3) Stream 객체 생성
		IntStream intStream1 = IntStream.range(3, 7); // 3 이상 7 미만
		IntStream intStream2 = IntStream.rangeClosed(3, 7); // 3이상 7 이하
		
		System.out.println();
		intStream1.forEach(System.out::print);
		System.out.println();
		intStream2.forEach(System.out::print);
		
		LongStream longStream = LongStream.rangeClosed(1, 9);
		System.out.println();
		longStream.forEach(System.out::print);
		
		
		DoubleStream doubleStream = DoubleStream.of(3.14, 4.5, 11.7);
		
		double sum = doubleStream.reduce(0, Double::sum);
		System.out.println("\n합계 : "+sum);
		
		Stream<String> fruitStream = Stream.of("사과","딸기","바나나");
		fruitStream.forEach(System.out::println);
		
	}
}
