public class Method1 {

	static int boxvolume(int length,int breadth,int height) {
		int volume;
		volume = length*breadth*height;
		return volume;
	}
	public static void main (String[] args) {
		int volume = boxvolume(8,9,6);
		System.out.println(volume);
	}
	
}


//with return types & with parameters