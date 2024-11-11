import java.util.*;
	
	public class LinkedHashmapDemo {
		public static void main(String[] args) {
			Map<Integer,String> name = new LinkedHashMap<Integer,String>();
			name.put(1,"Hi");
			name.put(5,"Varun");
			name.put(3,"Raja");
			name.put(3,"Ram");
			name.put(4,"Hi");
			name.put(6,null);
			name.put(7,null);
			System.out.println(name);
			System.out.println(name.containsKey(1));
			System.out.println(name.containsValue("Rani"));
			}
			
}