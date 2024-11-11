class Student {

	String id;
	String studentName;
	String deptName;

}

public class ConstructorDemo {
		
	public static void main(String[] args){
		Student obj = new Student();
		obj.id = "23CS001";
		obj.studentName = "Arun";
		obj.deptName = "BSc";	
		System.out.println(obj.id);
		System.out.println(obj.studentName);
		System.out.println(obj.deptName);

		}
		
}