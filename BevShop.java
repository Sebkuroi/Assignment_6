import java.util.ArrayList;

public class BevShop implements BevShopInterface{
	private int numOfAlcoholInOrder;
	private int currentOrderIdx;
	private ArrayList<Order> orders;
	
	public BevShop() 
	{
		orders = new ArrayList<>();
	}
	
	public boolean validTime(int time)
	{
		if(time <= MAX_TIME && time >= MIN_TIME)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int getMaxNumOfFruits()
	{
		
		return MAX_FRUIT;
	}
	
	public int getMinAgeForAlcohol() 
	{
		return MIN_AGE_FOR_ALCOHOL;
	}
	
	public boolean isMaxFruit(int numOfFruits)
{
		if (numOfFruits > MAX_FRUIT) 
			return true;
		else
			return false;
	}
	
	public int getMaxOrderForAlcohol() 
	{
		return MAX_ORDER_FOR_ALCOHOL;
	}
	
	public boolean eligibleForMore() 
	{
		if (numOfAlcoholInOrder < MAX_ORDER_FOR_ALCOHOL) 
			return true;
		else
			return false;
	}
	
	public int getNumOfAlcoholDrink() 
	{
		return getCurrentOrder().findNumOfBeveType(Type.ALCOHOL); 
	}
	
	public boolean validAge(int age) 
	{
		if (age >= MIN_AGE_FOR_ALCOHOL) 
			return true;
		else
			return false;
	}
	
	public void startNewOrder(int time, Day day, String customerName, int customerAge) 
	{
		Customer customer = new Customer(customerName, customerAge);
		Order order = new Order(time, day, customer);
		orders.add(order);
		currentOrderIdx = orders.indexOf(order);
		numOfAlcoholInOrder = 0;
	}
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) 
	{
		orders.get(currentOrderIdx).addNewBeverage(bevName, size, extraShot, extraSyrup);
	}
	public void processAlcoholOrder(String bevName, Size size)
	{
		orders.get(currentOrderIdx).addNewBeverage(bevName, size);
		numOfAlcoholInOrder++;
	}
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) 
	{
		orders.get(currentOrderIdx).addNewBeverage(bevName, size, numOfFruits, addProtein);
	}
	
	public int findOrder(int orderNo)
	{
		for (int number = 0; number < orders.size(); number++) 
		{
			if (orders.get(number).Generatenumber() == orderNo)
			{
				return number;
			}
		}
		
		return -0;
	}
	
	public double totalOrderPrice(int orderNo)
	{
		return orders.get(findOrder(orderNo)).calcOrderTotal();
	}
	
	public double totalMonthlySale() 
	{
		double totalSale = 0;
		
		for (int number = 0; number < orders.size(); number++) 
		{
			totalSale += orders.get(number).calcOrderTotal();
		}
		return totalSale;
	}
	public int totalNumOfMonthlyOrders() 
	{
		return orders.size();
	}
	
	public Order getCurrentOrder() 
	{
		return orders.get(currentOrderIdx);
	}
	
	public Order getOrderAtIndex(int index) 
	{
		return orders.get(index);
	}
	
	
public void sortOrders() {
		
		for (int number = 0; number < orders.size()-1; number++) 
		{
			int orderindex = number;
			for (int index = number+1; index < orders.size(); index++) 
			{
				if (orders.get(index).Generatenumber() < orders.get(orderindex).Generatenumber
						()) {
					orderindex = index;
				}
			}
				
			Order temp = orders.get(orderindex);
			orders.set(orderindex, orders.get(number));
			orders.set(number, temp);
		}
	}

	@Override
	public String toString() 
	{
		String sale = "Monthly Orders";
		
		for (Order o : orders) {
			sale += o.toString();
		}
		sale += "Total Sale: " +totalMonthlySale();
		
		return sale;
	}

	@Override
	public boolean isValidTime(int time) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEligibleForMore() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isValidAge(int age) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
	