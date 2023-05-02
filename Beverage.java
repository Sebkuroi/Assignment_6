/*
 * Class: CMSC203 
 * Instructor:Grigoriy Grinberg
 * Description: (more or less building a property)
 * Due: 03/3/2023
 * Platform/compiler:eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Sebastian Black
*/
public abstract class Beverage
{
	private String name;
	private Type type;
	private Size size;
	private final double BASE_PRICE = 2.0;
	private final double SIZE_PRICE = 1.0;
	
	public Beverage(String Beveragename, Type Type, Size Size) 
	{
		name = Beveragename;
		type = Type;
		size = Size;
	}
		
	 abstract double calcPrice();

	public String toString() 
	{
		return name +", " +size;
	}
	
	public boolean equals(Beverage drink) 
	{
		if (name.equals(drink.getBevName()) && type==drink.getType()&& size==drink.getSize()) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	

	public String getBevName() 
	{
		return name;
	}
	public Type getType() 
	{
		return type;
	}
	public Size getSize() 
	{
		return size;
	}
	public double getBasePrice() 
	{
		return BASE_PRICE;
	}
	public double getSizePrice()
	{
		return SIZE_PRICE;
	}
}