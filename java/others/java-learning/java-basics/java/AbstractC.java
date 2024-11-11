abstract class A {
	abstract void run();
}
class B extends A{
	void run()
	{
		System.out.println("Abstraction");
	}
}
class AbstractC  extends B {
	public static void main(String args[])
	{
		B ob=new B();
		ob.run();
	}
}
