import java.util.*;
class Map1 {
	public static void main(String[] args) {
		Map<Integer,String> nm=new HashMap<Integer,String>();
		nm.put(1,"abc");
		nm.put(2,"def");
		nm.put(3,"ghi");
	
		
		for(Map.Entry m:nm.entrySet()) {
			
			System.out.println(m.getKey()+""+m.getValue());
		}
	}

}