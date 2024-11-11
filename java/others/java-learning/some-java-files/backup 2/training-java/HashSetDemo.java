import java.util.*;

public class HashSetDemo {

	public static void main(String[] srgs) {
		Set<String> words = new HashSet<String>();
		words.add("Ram");
		words.add("Hi");
		words.add("Hello");
		words.add("Hi");
		System.out.println(words);
		Iterator<String> itr = words.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}
		
}