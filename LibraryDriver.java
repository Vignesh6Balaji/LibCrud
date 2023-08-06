package View;
import java.sql.SQLException;
import java.util.Scanner;
import Control.Control;
public class LibraryDriver {
	public static Control con=new Control();
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner s=new Scanner(System.in);
		System.out.println("Welcome to Library management system");
		char c='y';
		boolean b=true;
		while(b||c=='y'||c=='Y') {
			System.out.println("Enter 1 for adding books");
			System.out.println("Enter 2 for search book");
			System.out.println("Enter 3 for borrow book");
			System.out.println("Enter 4 for return book");
			System.out.println("Enter 5 for remove book");
			System.out.println("Enter 6 for View all the books present in library");
			System.out.println("Enter your choice : ");
			int choice=s.nextInt();
			switch(choice) {
			case 1:con.addBook(choice);
			break;
			case 2:con.searchBook();
			break;
			case 3:con.borrowBook(choice);
			break;
			case 4:con.returnBook(choice);
			break;
			case 5:con.removeBook(choice);
			break;
			case 6:con.sort();
			break;
			default :System.out.println("Invalid choice!!!");
			}
			b=false;
			System.out.println("Do you want to continue any operation?");
			System.out.println("If yes type y or no type n");
			c=s.next().charAt(0);
		}
	}
}
