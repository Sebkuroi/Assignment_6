public class Customer {
	private String name;
	private int age;
	

	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public Customer(Customer customer) {
		name = customer.getName();
		age = customer.getAge();
	}
	
	public String toString() 
	{
		return name +", " +age +"years old";
	}
	
	
	public String getName() 
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
}