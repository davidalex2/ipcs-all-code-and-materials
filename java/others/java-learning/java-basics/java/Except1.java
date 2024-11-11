
import java.io.*;
class UserDefinedException extends Exception  
{  
    public UserDefinedException(String str)  
    {  
        // Calling constructor of parent Exception  
        super(str);  
    }  
}  
class MyException extends Exception {
	public MyException(String s) {
		super(s);
	}
}
public class Except1 {
	public static void main(String[] args) {
		try {
			throw new MyException("This is a sample");
			//throw new UserDefinedException("This is custom exception");
		}
		catch(ArithmeticException e) {
			System.out.println(e);
		}
		//catch(UserDefinedException a) {
			//System.out.println("Exception success");
		//}
		catch(MyException b) {
			System.out.println("MyExceptionis success");
		}
		finally {
			System.out.println("This is sample exception");
		}
		M obj=new M();
		obj.newf();
	}

}
class M {
	void functionF() throws ArithmeticException {
		int a,b;
		a=5;
		b=0;
		int c=a/b;
		System.out.println(c);
	}
	
	void newf() {
	try {
		//System.out.println(ob.functionF());
		M ob=new M();
		ob.functionF();
	}
	catch(ArithmeticException e) {
		System.out.println("Throws is sucess");
	}
	}
}