class Encapsulate1 extends NewClass {
	private void myFuncion() {
		System.out.println("Encapsulation");
	}
	public static void main(String[] args) {
		Encapsulate1 ob=new Encapsulate1();
		ob.myFuncion();
		NewClass ob1=new NewClass();
		ob1.newFunction();
	}
}
class NewClass {
	private void newFunction() {
		System.out.println("Next class");
	}
}