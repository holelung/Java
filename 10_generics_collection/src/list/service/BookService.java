package list.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import list.dto.BookDTO;

/**
 * 도서 관리 프로그램 기능 제공 클래스
 */
public class BookService {

	private List<BookDTO> bookList = new ArrayList<>();

	// 기본생성자
	public BookService() {
		// 샘플 데이터 추가
		bookList.add(new BookDTO("소년이 온다", "한강", 15000, "창비"));
		bookList.add(new BookDTO("초역 부처의 말", "코이케 류노스케", 17000, "포레스트북스"));
		bookList.add(new BookDTO("채식 주의자", "한강", 15000, "창비"));
		bookList.add(new BookDTO("작별하지 않는다", "한강", 16800, "문학동네"));
		bookList.add(new BookDTO("모순", "양귀자", 13000, "쓰다"));
	}

	// getter
	public List<BookDTO> getBookList() {
		return bookList;
	}
	
	/** 전달 받은 index 번째 bookList 요소 반환
	 * 단, 범위 초과 시 null 반환
	 * 
	 * @param index
	 * @return BookDTO 참조 주소 또는 null
	 */
	public BookDTO selectIndex(int index) {
		if(!checkIndex(index)) {
			return null;
		}
		return bookList.get(index);
	}
	
	/** chekcIndex
	 * 전달 받은 index가 정상 범위인지 확인
	 * @param index
	 * @return 정상 true, 아니면 false
	 */
	public boolean checkIndex(int index) {
		if(index < 0 || index > bookList.size()) {
			return false;
		}
		return true;
	}
	
	/** addBook
	 * 전달받은 book을 bookList에 추가하는데
	 * 책 정보가 모두 중복되는 경우 추가 X
	 * @param book
	 * @return 추가 O : true, 추가 X : false
	 */
	public boolean addBook(BookDTO book) {
		// 책 정보 비교 방법 1) 필드값 하나씩 꺼내서 비교
		// 책 정보 비교 방법 2) equals() 오버라이딩 후 이용

//		for(BookDTO b : bookList) {
//			if(b.equals(book)) return false;
//		}
		
		// 책 정보 비교 방법 3) contains(Object o) 사용
		// -> equals() 오버라이딩 필요
		if(bookList.contains(book)) return false;
		
		return bookList.add(book);
	}
	
	/**
	 * 책 가격 변경하기
	 * @param index 
	 * @param price 받을 가
	 * @return "[책제목] 가격이 [이전가격] -> [수정된 가격]으로 수정되었습니다."
	 */
	public String modifyBookPrice(int index, int price) {
		BookDTO book = bookList.get(index);
		int before = book.getPrice();
		book.setPrice(price);
		
		return String.format("[%s] 가격이 [%d] -> [%d]으로 수정되었습니다.",book.getTitle(), before, book.getPrice());
	}
	
	/**
	 * 책 제거하기
	 * @param index
	 * @return
	 */
	public String deleteBook(int index) {
		if(!checkIndex(index)) {
			return null;
		}
		BookDTO before = bookList.remove(index);
		return String.format("[%s]책을 제거했습니다.", before.getTitle());
	}
	
	
	/**
	 * 제목으로 책 찾기
	 */
	public String selectTitle(String bookTitle) {
		int target = checkTitle(bookTitle);
		
		if (target== -1) {
			return String.format("[%s]책이 없습니다.", bookTitle);
		}
		return bookList.get(target).toString();
	}
	
	/**
	 * 제목 확인 메서드
	 * @param inputTitle : 책 제목
	 * @return 매개변수와 같은 값의 요소가 있다면 해당 index/ 없다면 -1
	 */
	public int checkTitle(String inputTitle) {
		for(int i=0; i<bookList.size(); i++) {
			if(bookList.get(i).getTitle().equals(inputTitle)) {
				return i;
			}
		}
		
		return -1;
	}
	
	/**
	 * 책 제목 받아서 삭제하기
	 * @param bookTitle
	 * @return 삭제 성공: 책이 삭제되었습니다/ 실패: 책이 없습니다.
	 */
	public String deleteBookTitle(String bookTitle) {
		int target = checkTitle(bookTitle);
		
		if(target==-1) {
			return String.format("[%s]책이 없습니다.", bookTitle);
		}
		bookList.remove(target);
		
		return String.format("[%s]책이 삭제되었습니다.", bookTitle);
	}
	
	/**
	 * 출판사이름이 같은 책 모두찾기
	 * @param publisher : 출판
	 * @return 0~n 개의 결과를 가지는 List
	 */
	public List<BookDTO> selectPublisherAll(String publisher) {
		List<BookDTO> samePub = new ArrayList<BookDTO>();
		
		for(BookDTO b : bookList) {
			if(b.getPublisher().equals(publisher)) {
				samePub.add(b);
			}
		}
		
		return samePub;
	}
	
	/**
	 * 저자이름이 같은 책 모두 찾기
	 * @param author : 저자 이름
	 * @return 0~n 개의 결과를 가지는 List
	 */
	public List<BookDTO> selectAuthorAll(String author) {
		List<BookDTO> sameAuthor = new ArrayList<BookDTO>();
		
		for(BookDTO b : bookList) {
			if(b.getAuthor().equals(author)) {
				sameAuthor.add(b);
			}
		}
		
		return sameAuthor;
	}
	
	/**
	 * 검색어에 포함된 모든 책 조회하기(책 제목, 저자)
	 * @param keyword : 검색어
	 * @return 0~n 개의 결과를 가지는 List
	 */
	public List<BookDTO> searchBook(String keyword){
		List<BookDTO> searchResult = new ArrayList<>();
		
		for(BookDTO b : bookList) {
			//제목
			if(	b.getTitle().contains(keyword)) {
				searchResult.add(b);
				continue;
			}
			// 저자
			if( b.getAuthor().contains(keyword)) {
				searchResult.add(b);
				continue;
			}
			// 출판사
			if( b.getPublisher().contains(keyword)) {
				searchResult.add(b);
				continue;
			}
		}
		return searchResult;
	}
	
	/**
	 * 제목 오름차순 정렬
	 */
	public void bookListSorting() {
		Collections.sort(bookList);
	}
	
}
