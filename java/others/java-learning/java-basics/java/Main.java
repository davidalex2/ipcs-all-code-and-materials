class Detail1 {
	int a1;
	int b1;
	void just(int a,int b) {	
		a1=a;
		b1=b;
	}
	void just1() {
		System.out.println(a1+b1);
	}
}
public class Main{
	
	public static void main(String args[]) {
		System.out.println("Hi,Hello");
		Detail1 ob=new Detail1();
		ob.just(1,3);
		ob.just1();
 }
}

