class Game {

	public void play(){
		System.out.println("playing");
		}
}
class Player1 extends Game {

	public void play(){
		System.out.println("playing cricket");
		}
}
class Player2 extends Game {

	public void play() {
		System.out.println("playing volleyball");
		}
}
		//overriding
public class PolymorphisamDemo {

	public static void main(String[] args){
	Game x;
	x = new Player1();
	x.play();
	x = new Player2();
	x.play();
	}
	
}