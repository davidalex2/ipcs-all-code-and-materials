class Father {

	public void work(){
		System.out.println("I am working");
	}
}
	
class Son extends Father {

	public void play(){
		System.out.println("I am playing");
	}
	
}
public class  InheritanceDemo{

	public static void main( String[] args){
		Son x = new Son();
		x.work();
		x.play();
		
		}
}	

