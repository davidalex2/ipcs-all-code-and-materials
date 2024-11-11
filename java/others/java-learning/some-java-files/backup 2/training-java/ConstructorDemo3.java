class Customer {

		String name;
		int mobileNo;
		int aadharNo;
		String cityname;
		
void CustomerDetails() {

	System.out.println(""+name);
	System.out.println(""+mobileNo);
	System.out.println(""+aadharNo);
	System.out.println(""+cityname);
	
	}
	
}

public class CunstructorDemo3 {

	public static void main(String[] args) {
		Customer obj = new Costomer();
		obj.name = "Raja";
		obj.mobileNo = 8764569;
		obj.aadharNo = 7483649;
		obj.cityname = "Thiruvanamalai";
		obj.CostomerDetails();
		
		}
		
}
		