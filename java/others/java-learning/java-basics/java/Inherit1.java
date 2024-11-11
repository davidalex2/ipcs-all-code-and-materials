class Inherit {
	
	public int main(int a,int b) {
		int c=a*b;
		return c;
	}
}

//single level inheritance
class Inherit2 extends Inherit {
	public void main() {
		Inherit ob=new Inherit();
		int d=ob.main(5,4);
		System.out.println(d);
		Hinherit ob1=new Hinherit();
		ob1.mainH();
		
	}
	
}//hierarchical Inheritance
class Hinherit extends Inherit {
	void mainH() {
		System.out.println("This is Hierarchical inheritance");
	}
	
}//
class Inherit1 {
	public static void main(String[] args) {
		Inherit2 obj=new Inherit2();
		obj.main();
	}
	
}


