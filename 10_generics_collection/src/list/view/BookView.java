package list.view;

import java.util.List;
import java.util.Scanner;

import list.dto.BookDTO;
import list.service.BookService;

/**
 * 도서 관리 프로그램 입/출력 담당 클래스(UI)
 * 
 */
public class BookView {
	
	private Scanner sc = new Scanner(System.in);
	private BookService service = new BookService();
	
	/**
	 * 프로그램 메인 메뉴
	 */
	public void displayMenu() {
		int input = 0; // 메뉴번호 저장 변수
		
		do {
			System.out.println("\n******* 도서 관리 프로그램 *******\n");
			System.out.println("1. 전체 조회");
			System.out.println("2. index 번호로 조회");
			System.out.println("3. 책 추가하기");
			System.out.println("4. 책 가격 수정하기");
			System.out.println("5. 책 제거하기");
			
			// 추가 메뉴
			System.out.println("6. 제목이 일치하는 책 한권 조회하기");
			System.out.println("7. 제목이 일치하는 책 제거하기");
			System.out.println("8. 출판사가 일치하는 책 모두 조회하기");
			System.out.println("9. 저자가 일치하는 책 모두 조회하기");
			System.out.println("10. 검색어가 제목, 저자에 포함된 모든 책 조회하기");
			
			// 정렬
			System.out.println("11. bookList 제목 오름 차순으로 정렬시키기");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 번호 입력 >>> ");
			input = sc.nextInt();
			sc.nextLine(); // 입력 버퍼에 나아있는 문자열 제거(오류방지)
			
			System.out.println("-----------------------------------");
			switch(input) {
				case 1: selectAll(); break;
				case 2: selectIndex(); break;
				case 3: addBook(); break;
				case 4: modifyBookPrice(); break;
				case 5: deleteBook(); break;
				case 6: selectTitle(); break;
				case 7: deleteBookTitle(); break;
				case 8: selectPublisherAll(); break;
				case 9: selectAuthorAll(); break;
				case 10: searchBook(); break;
				case 11: bookListSorting(); break;
				case 0: System.out.println("프로그램이 종료됩니다!"); break;
				default: System.out.println("@@@ 메뉴 번호 잘못 입력 @@@");
			}	
			
		}while(input != 0);
		
		
		
		
	}

	/**
	 * 전체 조회
	 * <pre>
	 * - BookService의 필드 bookList를 얻어와
	 * 일반 for문을 이용하여 모든 요소 정보 출력
	 * 
	 * 단, bookList에저장된 정보가 없으면
	 *  "저장된 책이 존재하지 않습니다." 출력
	 * </pre>
	 */
	private void selectAll() {
		System.out.println("\n### 전체 조회 ###\n");
		
		List<BookDTO> list = service.getBookList();
		
		// 전달 받은 list에 데이터가 있는지 확인
		
		// int size() : 저장된 객체의 개수 반환
		// boolean isEmpty() : 저장된 객체가 없으면 true 반환
//		if(list.size() == 0)
		if(list.isEmpty()) { // 컬렉션에서는 isEmpty()많이쓴다.
			System.out.println("저장된 책이 존재하지 않습니다.");
			return;
		}
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(i + ") " + list.get(i));
		}
	}
	
	/**
	 * 인덱스 번호로 조회
	 * <pre>
	 * - index 번호가 bookList 의 범위를 초과하면
	 * 	 "해당 인덱스에 책이 존재하지 않습니다."출력
	 * 
	 * - bookService로 부터 index 번째 bookDTO 반환 받기
	 * 
	 * </pre>
	 */
	private void selectIndex() {
		System.out.println("\n### index번호 조회 ###\n");
		System.out.print("index 번호 입력 >> ");
		int input = sc.nextInt();
		
		BookDTO book = service.selectIndex(input);
		if(book == null) {
			System.out.println("해당 인덱스에 책이 존재하지 않습니다.");
			return;
		}
		System.out.println("제목: " + book.getTitle());
		System.out.println("저자: " + book.getAuthor());
		System.out.println("가격: " + book.getPrice());
		System.out.println("출판사: " + book.getPublisher());
	}

	/** addBook()
	 * <pre>
	 * 책 정보(제목, 저자, 가격, 출판사)를 입력받아
	 * BookService의 BookList에 마지막 요소로 추가
	 * 
	 * 단, 모든 정보가 일치하는 책은 추가 X(중복 저장X)
	 * </pre>
	 */
	private void addBook() {
		System.out.println("\n### 책 추가하기 ###\n");
		
		System.out.print("제목 >> ");
		String title = sc.nextLine(); 
		// 엔터가 입력되기 전 까지의 문자열 얻어오기(띄어쓰기 가능)
		
		System.out.print("저자 >> ");
		String author = sc.nextLine();
		
		System.out.print("가격 >> ");
		int price = sc.nextInt();
		sc.nextLine(); // 입력 버퍼 남은 문자열 제거
		// -> sc.next(); / sc.nextInt() 등을 수행 후 무조건 작성
		
		System.out.print("출판사 >> ");
		String publisher = sc.nextLine();
		
		// 서비스 호출
	  boolean result = service.addBook(new BookDTO(title, author, price, publisher));
	  
	  if(result) { // 추가 성공
	  	System.out.println(title + " 책이 추가되었습니다.");
	  }else { // 추가 실패
	  	System.out.println(title + " 책이 이미 존재합니다.");
	  }
	}
	
	// 데이터 일부 수정 : modify
	// 데이터 전체 수정 : update
	// 데이터 구조 변경 : ..?
	
	/** modifyBookPrice()
	 * <pre>
	 * index 번호를 입력받아
	 * - 해당 인덱스에 책이 없다면 : "해당 인덱스에 책이 존재하지 않습니다"
	 * 
	 * - 해당 인덱스에 책이 있다면 :
	 * 	 1) "수정할 가격 입력 : " 출력 
	 *   2) 스캐너로 가격 입력 받기 
	 *   3) 입력받은 인덱스 번째 요소의 가격 수정 
	 *   4) [책제목] 가격이 [이전가격] -> [수정된 가격]으로 수정되었습니다."
	 * </pre>
	 * 
	 */
	private void modifyBookPrice() {
		System.out.println("\n### 책 가격 변경 ###\n");
		System.out.print("index 번호 입력 >> ");
		int input = sc.nextInt();
		sc.nextLine();
		
		// 인덱스 유효성 검사
		if(!service.checkIndex(input)) {
			System.out.println("해당 인덱스에 책이 존재하지 않습니다");
			return;
		}
		
		System.out.print("수정할 가격 입력 : ");
		int price = sc.nextInt();
		sc.nextLine();
		
		System.out.println(service.modifyBookPrice(input, price));		
	}
	
	/**
	 * 책 제거하기
	 * 
	 */
	private void deleteBook() {
		System.out.println("\n### 책 제거하기 ###\n");
		
		System.out.print("index 번호 입력 >> ");
		int input = sc.nextInt();
		sc.nextLine();
		
		// 인덱스 유효성 검사
		if(!service.checkIndex(input)) {
			System.out.println("해당 인덱스에 책이 존재하지 않습니다");
			return;
		}
		
		System.out.printf(service.deleteBook(input));	
	}
	
	
	/**
	 * 6. 제목이 일치하는 책 조회하기
	 */
	private void selectTitle() {
		System.out.println("\n### 제목으로 책 찾기 ###\n");
		System.out.print("책 제목 입력 : ");
		String bookTitle = sc.nextLine();
		
		System.out.println(service.selectTitle(bookTitle));
	}
	
	/**
	 * 7. 제목이 일치하는 책 제거하기
	 */
	private void deleteBookTitle() {
		System.out.println("\n### 제목으로 책 제거하기 ###\n");
		System.out.print("책 제목 입력 : ");
		String bookTitle = sc.nextLine();
		
		System.out.println(service.deleteBookTitle(bookTitle));
	}
	

	/**
	 * 8. 출판사가 일치하는 책 모두 조회하기
	 */
	private void selectPublisherAll() {
		System.out.println("\n### 출판사로 책 조회하기 ###\n");
		System.out.print("출판사 이름 입력 : ");
		String publisher = sc.nextLine();
		
		List<BookDTO> samePub = service.selectPublisherAll(publisher);
		
		if(samePub.size() == 0) {
			System.out.printf("[%s] 해당 출판사가 출판한 책이 없습니다.",publisher);
			return;
		}
		System.out.println(publisher+"출판사가 발간한 책");
		for(BookDTO b : samePub) {
			System.out.println(b);
		}
	}
	
	/**
	 * 9. 저자가 일치하는 책 모두 조회하기
	 */
	private void selectAuthorAll(){
		System.out.println("\n### 저자 이름으로 책 찾기 ###\n");
		System.out.print("저자 입력 : ");
		String author = sc.nextLine();
		
		List<BookDTO> sameAuthor = service.selectPublisherAll(author);
		
		if(sameAuthor.size() == 0) {
			System.out.printf("[%s] 해당 출판사가 출판한 책이 없습니다.",author);
			return;
		}
		System.out.println(author+"출판사가 발간한 책");
		for(BookDTO b : sameAuthor) {
			System.out.println(b);
		}
	}
	
	
	/** 
	 * 10. 검색어가 제목, 저자에 포함된 모든 책 조회하기
	 */
	private void searchBook(){
		System.out.println("\n### 책 검색하기(제목, 저자) ###\n");
		System.out.print("검색어 입력 : ");
		String keyword = sc.nextLine();
		
		List<BookDTO> searchResult = service.searchBook(keyword);
		if(searchResult.isEmpty()) {
			System.out.println("검색 결과가 없습니다.");
			return;
		}
		
		System.out.println("***** 검색 결과 *****");
		for(BookDTO b : searchResult) {
			System.out.println(b);
		}
		
	}
	
	/**
	 * 11. bookList 제목 기준으로 오름차순으로 정렬시키기
	 */
	private void bookListSorting() {
		System.out.println("\n### 제목 오름 차순 정렬 시키기 ###\n");
		
		service.bookListSorting();
		
		System.out.println("정렬 되었습니다.");
	}
}

