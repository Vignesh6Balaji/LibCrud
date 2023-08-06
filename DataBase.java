package Control;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import View.LibraryDriver;
public class DataBase {
	static String q3;
	static Control cont=LibraryDriver.con;
	
	public static String addBook(String title, int bid, String author, double price, boolean b){
		return "insert into library.books values("+bid+", '"+title+"' , '"+author+"' ,"+price+","+b+")";
	}
	
	public static String updateBook(int bid, String title, String author, boolean b) {
		for(int i=0;i<cont.books.size();i++) {
			if(cont.books.get(i).getBid()==bid&&b==true)
				q3="update library.books set IsAvailable='n' where bid="+bid;
			else if(cont.books.get(i).getBid()==bid&&b==false)
				q3="update library.books set IsAvailable='y' where bid="+bid;
		}
		return q3;
	}
	
	public static String removeBook(int bid) {
		return "delete from library.books where Bid="+bid;
	}
	
	public static void DbCon(int a,int b) {
		Connection con=null;
		Statement stmt=null;
		String title=null;
		String author=null;
		int bid=0;
		double price=0.0;
		boolean available=false;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library?user=root&password=admin");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt=con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Welcome to Library Data Base");
		if(a==1) {
			for(int i=0;i<cont.books.size();i++) {
				title=cont.books.get(i).getTitle();
				author=cont.books.get(i).getAuthor();
				bid=cont.books.get(i).getBid();
				price=cont.books.get(i).getPrice();
			}
			try {
				stmt.execute(addBook(title, bid, author, price, true));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Book added to DataBase Successfully");
		}
		else if(a==5) {
			for(int i=0;i<cont.books.size();i++) {
				bid=cont.books.get(i).getBid();
				if(bid==b) {
					try {
						stmt.execute(removeBook(b));
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Book removed from DataBase Successfully");
			}
		}
		else if(a==3||a==4) {
			for(int i=0;i<cont.books.size();i++) {
				title=cont.books.get(i).getTitle();
				author=cont.books.get(i).getAuthor();
				available=cont.books.get(i).isAvailable();
				bid=cont.books.get(i).getBid();
				if(bid==b) {
					try {
						stmt.executeUpdate(updateBook(b,title,author,available));
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				else if(bid==b) {
					try {
						stmt.executeUpdate(updateBook(b,title,author,available));
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			System.out.println("DataBase updated Successfully");
		}
		try {}
		finally {
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
