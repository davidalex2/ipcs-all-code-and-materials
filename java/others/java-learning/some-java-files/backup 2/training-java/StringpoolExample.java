public class StringpoolExample {

		public static void main(String[] args){
		String name1 = "Raja";
		String name2 = "Ragu";
		String name3 = "Raja";
	
		String name4 = new String ("Ragu");
		String name5 = new String ("Ragu").intern();
		 if(name1 == name3){
		
			System.out.println("same");
		 }
		 else{
			 System.out.println("not same");
		 }
		 if (name2 == name4){
			 System.out.println("same");
		 }
		 else{
			 System.out.println("not same");
		 } 
		 if (name2 == name5){
		    System.out.println("same");
			}
		 else{
		 System.out.println("not same");
		 }
		}
		
}