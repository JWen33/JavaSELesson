package tw.winny.apis;

import java.util.ArrayList;
import java.util.List;

public class Library {
	private List<Book> BookList;

	public Library() {
		BookList = new ArrayList<Book>();
	}

	public void addBook(Book book) {
		BookList.add(book);
//		System.out.println("書籍已添加成功");
	}

	public List<Book> getBookList() {
		if (BookList.isEmpty()) {
			System.out.println("圖書館目前沒有任何書籍");
		} else {
			System.out.println("目前所有書籍：");
			for (Book book : BookList) {
				System.out.println(book);
			}
		}
		return BookList;
	}

	public void searchByAuthor(String author) {
		boolean isFound = false;
		for (Book book : BookList) {
			if (book.getAuthor().equalsIgnoreCase(author)) { // 忽略大小寫的比較
				if (!isFound) {
					System.out.println("找到以下書籍:");
					isFound = true;
				}
				System.out.println(book);
			}
		}
		if (!isFound) {
			System.out.println("沒有到該作者書籍");
		}
	}
}
