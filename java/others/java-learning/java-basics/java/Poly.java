class Poly {//overloading
	public void main(int a,int b) {
		System.out.println(a+b);
	}
	public void main(int a, int b,int c) {
		System.out.println(a+b+c);
	}
	public static void main(String[] args) {
		Poly ob=new Poly();
		ob.main(2,3);
		ob.main(2,3,4);
	 }
}
