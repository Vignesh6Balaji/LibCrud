package Model;
import java.util.Comparator;
public class Author implements Comparator<Book> {
	@Override
	public int compare(Book o1, Book o2) {
		return o1.getAuthor().compareToIgnoreCase(o2.getAuthor());
	}
}
