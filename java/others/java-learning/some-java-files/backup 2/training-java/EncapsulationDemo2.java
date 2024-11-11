class Customer {

		private String name;
		private int id;
		private float money;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
}
public class EncapsulationDemo2 {

	public static void main(String[] args) {
		Customer x = new Customer();
		x.setName ("Arun");
		System.out.println(""+x.getName());
		x.setId (578);
		System.out.println(""+x.getId());
		x.setMoney (467.6f);
		System.out.println(""+x.getMoney());
	}
		
}
	
		
	