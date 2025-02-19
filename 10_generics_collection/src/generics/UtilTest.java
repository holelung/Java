package generics;

public class UtilTest<T extends Number> {
  // 제네릭 메서드: 어떤 타입(T)이든 받을 수 있음
  // 꼭 static일 필요는 없음
  public static <T> void printArray(T[] array) {
  // <T>는 타입매개변수로 호출 시점에서 타입이 결정됨
  // printArray(T[] array)는 어떤 타입의 배열이든 받아서 출력가능
      for (T element : array) {
          System.out.print(element + " ");
      }
      System.out.println();
  }
  
  

}
