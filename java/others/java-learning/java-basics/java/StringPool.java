class StringPool
{
public static void main(String args[])
{
String a="good";
String b="boy";
String c="good";
String d=new String("good");
System.out.println(a==c);//== operator only helps to thr string pol difference
System.out.println(d==a);
System.out.println(a.equals(c));//juc=st compares the charectors
System.out.println(d.equals(a));
System.out.println(a.compareTo(c));
System.out.println(a.compareTo(d));
}
}
