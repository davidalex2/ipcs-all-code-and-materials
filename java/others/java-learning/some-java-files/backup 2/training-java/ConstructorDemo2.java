class Student {

	String id;
	String studentName;
	String deptName;
	
	void displayStudent() {
		System.out.println("Id is: "+id);
		System.out.println("student name:"+ studentName);
		System.out.println("dept name:"+deptName);
	}

}

public class ConstructorDemo2 {
		
	public static void main(String[] args){
		Student obj = new Student();
		obj.id = "23CS001";
		obj.studentName = "Arun";
		obj.deptName = "BSc";	
		
	
		obj.displayStudent();
	}
		
}