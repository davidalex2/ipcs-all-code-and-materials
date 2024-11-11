interface A {
	public void b();
}
abstract class Abc implements A{

}
class B extends Abc{
	public void b() {
		System.out.println("this is interface");
	}
}
public class Main12 extends B
{
 public static void main(String[] args) {
		A ob=new B();
		ob.b();
	}
}