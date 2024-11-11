class PolyR {
	void main(int a,int b) {
		System.out.println(a+b);
	}
}
class PolyR1 extends PolyR{
	void main(int a,int b) {
		System.out.println(a*b);
	}
}
class PolyR3 {
	public static void main(String[] args) {
		
		PolyR1 ob=new PolyR1();
		ob.main(4,5);
		
	}
}//overriding