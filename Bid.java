package Model;
import java.util.Comparator;
public class Bid implements Comparator<Book> {
	@Override
	public int compare(Book o1, Book o2) {
		return o1.getBid()-o2.getBid();
	}
}
