import java.util.*;
class List12 {
	public static void main(String[] args) {
		String[] list12={"abc","def","ghi","abc"};
		//System.out.println(Array.toString(list12));
		List<String> ablist=new ArrayList<String>();
		for(String a:list12) {
			ablist.add(a);
			System.out.println("Show all the list::"+ablist);
		}
		System.out.println("Show from the variable:"+list12);
		List<String> llist=new LinkedList<String>();
		for(String s:list12) {
			llist.add(s);
			System.out.println("LinkedList:"+llist);
		}
		


	}
}