abstract class Teacher {

	abstract void marks();
	
}
	
class Student extends Teacher {
	public void marks(){
		System.out.println("Student marks");
	}
	
}
public class AbstractDemo {

	public static void main(String[] args){
		Student x =  new Student();
		x.marks();
		}
}