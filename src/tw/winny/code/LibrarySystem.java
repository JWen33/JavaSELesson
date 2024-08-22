package tw.winny.code;

import java.util.ArrayList;
import java.util.Scanner;

import tw.winny.apis.Book;
import tw.winny.apis.Library;

public class LibrarySystem {

	public static void main(String[] args) {
//		Book b1 = new Book("三隻小豬", "王曉明", "2006");
//		Book b2 = new Book("兩隻老虎", "陳庫馬", "2016");
//		Book b3 = new Book("Java技術手冊", "張奇奇", "2020");
//		System.out.println(b1.getBookInfo());
		
		Scanner scanner = new Scanner(System.in);
		Library myLibrary = new Library();
//		myLibrary.addBook(b1);
//		myLibrary.addBook(b2);
//		myLibrary.addBook(b3);
//		
//		myLibrary.getBookList();
		while (true) {
			System.out.println("\n圖書館理系統");
			System.out.println("1. 添加書籍");
            System.out.println("2. 顯示所有書籍");
            System.out.println("3. 按作者搜索書籍");
            System.out.println("4. 退出");
            System.out.print("請選擇操作: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice) {
            case 1: 
            	System.out.print("請輸入書名：");
            	String title = scanner.nextLine();
            	System.out.print("請輸入作者：");
            	String author = scanner.nextLine();
            	System.out.print("請輸入年份：");
            	String publishYear = scanner.nextLine();
            	Book newBook = new Book(title, author, publishYear);
            	myLibrary.addBook(newBook);
            	break;
            case 2:
            	myLibrary.getBookList();
            	break;
            case 3:
            	System.out.print("請輸入要搜索的作者名稱：");
            	String reachAuthor = scanner.nextLine();
            	myLibrary.searchByAuthor(reachAuthor);
            	break;
            case 4:
            	System.out.println("退出系統");
                scanner.close();
                return;
            default:
            	System.out.println("無效的選擇，請重新選擇");
            }
		}
		
		
	}

}

