import java.util.*;

public class ArraylistDemo {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("Hi");
		list.add("Raja");
		//list.set(0,"Arun");
		//list.remove("Hi");
		//list.clear();
		
		System.out.println(list.isEmpty());//boolean type
		System.out.println(list.indexOf("go"));//(-1,0)
		System.out.println(list);
		}

}