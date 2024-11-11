import java.util.*;

public class LinkedlistDemo {

	public static void main(String[] args) {
		LinkedList<String>list = new LinkedList<String>();
		list.add("Hi");
		list.add("Roja");
		list.addFirst("Arun");
		list.addLast("Hello");
		System.out.println(list.contains("Roja"));//(true,false)
		System.out.println(list);
		}

}