import.java.*;
public class New extends Class1
{
public static void main(String arg[])

{
	Class1 obj=new Class1();
	obj.myFun();
	obj.sample();
}
}
class Class1
{
	public  void myFun()
	{
		System.out.println("Hello");
		int a=5;
		int b=10;
		int c=a+b;
		System.out.println("The Total is::"+c);
		System.out.println(c);
	}
	void sample()
	{
	int a=3;
	int b=5;
	int c=a/b;
	System.out.println("Division"+c);
	}
}
class ForR
{
int a,b;
System.out.println(a.random());
}

