import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface, Comparable<Order>
{
	private int orderNumber;
	private int orderTime;
	private Day orderDay;
	private Customer customer;
	private ArrayList<Beverage> beverage;
	
	public Order(int orderTime, Day orderDay, Customer customer) 
	{
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.customer = customer;
		orderNumber = Generatenumber();
		beverage = new ArrayList<>();
	}
	
	
	public int Generatenumber()
	{
		Random rand = new Random();
		int randInt = rand.nextInt(90000-10000)+10000;
		return randInt;
	}
	
	public boolean isWeekend() 
	{
		if (orderDay == Day.SATURDAY || orderDay == Day.SUNDAY) 
		
			return true;
		else
			return false;
	}
	
	public Beverage getBeverage(int itemNum) 
	{
		return beverage.get(itemNum);
	}
	
	public void addNewBeverage(String name, Size size, boolean extraShot, boolean extraSyrup) 
	{
		Coffee coffee  = new Coffee(name, size, extraShot, extraSyrup);
		beverage.add(coffee);
	}
	
	public void addNewBeverage(String name, Size size, int numOfFruits, boolean proteinPowder) 
	{
		Smoothie smoothie = new Smoothie(name, size, numOfFruits, proteinPowder);
		beverage.add(smoothie);
	}
	
	public void addNewBeverage(String name, Size size)
	{
		boolean isWeekend = false;
		if (orderDay == Day.SATURDAY || orderDay == Day.SUNDAY) 
		{
			isWeekend = true;
		}
		Alcohol alcohol = new Alcohol(name, size, isWeekend);
		beverage.add(alcohol);
	}
	
	public double calcOrderTotal() 
	{
		double orderTotal = 0;
		
		for(int num = 0; num < beverage.size(); num++)
		{
			
			orderTotal += beverage.get(num).calcPrice();
		}
		
		return orderTotal;
	}
	
	public int findNumOfBeveType(Type type) 
	{
		int count = 0;
		
		for(int num = 0; num < beverage.size(); num++) 
		{
			if(beverage.get(num).getType() == type)
				count++;
		}
	
		
		return count;
	}
	
	public int getTotalItems() 
	{
		return beverage.size();
	}
	
	public String toString()
	{
		String order = super.toString();
		order += orderNumber + "," + orderTime + "," + orderDay + "," + customer.getName() + "," + customer.getAge();
		for(int num = 0; num < beverage.size(); num++) 
		{
			
			order += " Beverage " + num + ": " + beverage.get(num).toString();
			
		}
		return order;
	}
	
	
	public int compareTo(Order order) {
		if (orderNumber == order.getOrderNumber()) 
		{
			return 0;
		}
		else if (orderNumber > order.getOrderNumber()) 
		{
			return 1;
		}
		else 
		{
			return -1;
		}
	}
	/** Accessors */
	public int getOrderNumber() {
		return orderNumber;
	}
	public int getOrderTime() {
		return orderTime;
	}
}