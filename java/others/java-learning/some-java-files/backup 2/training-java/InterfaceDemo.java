interface Teacher {

	public void marks();
	
}
	
class Student implements Teacher {
	public void marks(){
		System.out.println("Student marks");
	}
	
}
public class InterfaceDemo {

	public static void main(String[] args){
		Student x =  new Student();
		x.marks();
		}
}