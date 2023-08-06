package Control;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import Model.Author;
import Model.Bid;
import Model.Book;
import Model.Title;
public class Control {
	ArrayList<Book> books=new ArrayList();
	Scanner s=new Scanner(System.in);
	
	public void addBook(int i){
		System.out.println("Enter the title of the book :");
		String title=s.next();
		System.out.println("Enter the author name :");
		String author=s.next();
		System.out.println("Enter the Bid :");
		int bid=s.nextInt();
		System.out.println("Enter the book price :");
		double price=s.nextDouble();
		
		Book b=new Book(title,bid,author,price,true);
		books.add(b);
		System.out.println("Book is added successfully...");
		System.out.println("Do you want to add this book in DataBase?");
		System.out.println("For yes type y for no type n");
		char c=s.next().charAt(0);
		if(c=='y'||c=='Y')
			DataBase.DbCon(i,0);
	}
	
	public void removeBook(int a){
		System.out.println("Enter book id of book you want to remove :");
		int remove=s.nextInt();
		boolean found=false;
		
		for(int i=0;i<books.size();i++) {
			Book b=books.get(i);
			if(b.getBid()==remove&&b.isAvailable()) {
				System.out.println("Do you want to remove this book in DataBase?");
				System.out.println("For yes type y for no type n");
				char c=s.next().charAt(0);
				if(c=='y'||c=='Y')
					DataBase.DbCon(a,remove);
				books.remove(i);
				System.out.println("Book removed successfully...");
				found=true;
				break;
			}
		}
		
		if(found==false)
			System.out.println("Book is not there to remove!!!");
	}
	
	public void borrowBook(int i){
		System.out.println("Enter book title or author name of book you want to borrow book :");
		String borrow=s.next();
		boolean found=false;
		
		for(Book b:books) {
			if(b.getTitle().equalsIgnoreCase(borrow)||b.getAuthor().equalsIgnoreCase(borrow)&&b.isAvailable()) {
				int id=b.getBid();
				System.out.println("Do you want to update this book in DataBase?");
				System.out.println("For yes type y for no type n");
				char c=s.next().charAt(0);
				if(c=='y'||c=='Y')
					DataBase.DbCon(i,id);
				b.setAvailable(false);
				System.out.println("Book borrowed Successfully...");
				found=true;
				break;
			}
		}
		if(found==false)
			System.out.println("Book is not available right now please try after some time");
	}
	
	public void returnBook(int i){
		System.out.println("Enter book title or author name of book you want to return book :");
		String ret=s.next();
		boolean found=false;
		
		for(Book b:books) {
			if(b.getTitle().equalsIgnoreCase(ret)||b.getAuthor().equalsIgnoreCase(ret)&&b.isAvailable()) {
				int id=b.getBid();
				System.out.println("Do you want to update this book in DataBase?");
				System.out.println("For yes type y for no type n");
				char c=s.next().charAt(0);
				if(c=='y'||c=='Y')
					DataBase.DbCon(i,id);
				b.setAvailable(true);
				System.out.println("Book returned Successfully...");
				found=true;
				break;
			}
		}
		if(found==false)
			System.out.println("Book is not available!!!");
	}
	
	public void searchBook(){
		System.out.println("Enter the title or author to search book : ");
		String search=s.next();
		boolean found=false;
		for(Book b: books) {
			if(b.getAuthor().equalsIgnoreCase(search)||b.getTitle().equalsIgnoreCase(search)&&b.isAvailable()) {
				System.out.println("Book Found : ");
				System.out.println(b);
				found=true;
				break;
			}
		}
		if(found==false)
			System.out.println("Book is not available!!!");
	}
	
	public void sort() {
		System.out.println("What basis do you want to view the library?");
		System.out.println("Enter 1 for sort based on title");
		System.out.println("Enter 2 for sort based on author");
		System.out.println("Enter 3 for sort based on bid");
		int choice=s.nextInt();
		Comparator d=null;
		switch(choice) {
		case 1:d=new Title();
		break;
		case 2:d=new Author();
		break;
		case 3:d=new Bid();
		break;
		default :System.out.println("Please enter the proper choice!!!");
		}
		Collections.sort(books,d);
		System.out.println(books);
	}
}
