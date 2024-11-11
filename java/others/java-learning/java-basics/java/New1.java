import java.util.*;
class New1
{
public static void main(String args[])
{
Simple ob=new Simple();
ob.fun();
Switch1 obj=new Switch1();
obj.fun1();
}

}
class Simple
{

Scanner n=new Scanner(System.in);
System.out.println("Enter a number:");
int a=n.nextInt();
void fun()
{
if(a<10)
{
System.out.println("if");
System.out.println("a:"+a);
}
else if(a>10)
{
System.out.println("else if");
System.out.println("a:"+a);

}
else
{
System.out.println("else");
System.out.println("values is valid");
}
}
}

class Switch1
{
public void fun1()
{
int b;
Scanner n=new Scanner(System.in);
b=n.nextInt();
switch(b)
{
case 2:
 System.out.println("hi");
 break;
case 5:
 System.out.println("hello");
 break;
}
Switch1 ab=new Switch1;
ab.b=29;

}
}
