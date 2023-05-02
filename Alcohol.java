public class Alcohol extends Beverage
{
	boolean isWeekend;
	private final double WEEKEND_FEE = .6;
	
	public Alcohol(String drink, Size size, boolean isWeekend) 
	{
		super(drink, Type.ALCOHOL, size);
		this.isWeekend = isWeekend;
	}
	
	public String toString() 
	{
		String order = super.toString();
		order += "," + isWeekend + "," + calcPrice();
		return order;
	}
	public boolean equals(Alcohol anotherdrink)
	{
		return (super.equals(anotherdrink) && anotherdrink.isWeekend == isWeekend);
		
	}
	public double calcPrice() 
	{
		double totalprice = super.getBasePrice();
		
		if (super.getSize() == Size.MEDIUM)
		{
			totalprice += super.getSizePrice();
		}
		else if (super.getSize() == Size.LARGE) 
		{
			totalprice += 2 * super.getSizePrice();
		}
		
		if (isWeekend) 
		{
			totalprice += WEEKEND_FEE;
		}
		
		return totalprice; 
	}
	

}