public class Coffee extends Beverage
{
	private boolean Shot;
	private boolean Syrup;
	private final double EXTRASHOT = .5;
	private final double EXTRASYRUP = .5;
	
	public Coffee(String Beveragename, Size Size, boolean shot, boolean syrup) 
	{
		super(Beveragename, Type.COFFEE, Size);
		this.Shot = shot;
		this.Syrup = syrup;
	}
	
	public String toString() 
	{
		String order = super.toString();
		order += "," + Shot + "," + Syrup + "," + calcPrice();
		return order;
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
		
		if (Shot) {
			totalprice += EXTRASHOT;
		}
		if (Syrup) {
			totalprice += EXTRASYRUP;
		}
		
		return totalprice;
	}
	public boolean equals(Coffee anotherdrink)
	{
		return (super.equals(anotherdrink) && Shot==anotherdrink.getExtraShot() && Syrup==anotherdrink.getExtraSyrup());
		
	}
	
	public boolean getExtraShot() 
	{
		return Shot;
	}
	public boolean getExtraSyrup() 
	{
		return Syrup;
	}
	
	
}