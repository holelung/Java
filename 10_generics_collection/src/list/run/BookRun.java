package list.run;

import list.view.BookView;

public class BookRun {
	public static void main(String[] args) {
		// 객체를 1회성으로 사용할 때 사용하는 방법
		new BookView().displayMenu();
	}
}
