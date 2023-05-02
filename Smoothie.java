public class Smoothie extends Beverage{
	int numOfFruits;
	boolean addProtein;
	private final double FRUIT_COST = .5;
	private final double PROTEIN_COST = 1.5;
	

	public Smoothie(String drink, Size Size, int NumOfFruits, boolean AddProtein) {
		super(drink, Type.SMOOTHIE, Size);
		this.numOfFruits = NumOfFruits;
		this.addProtein = AddProtein;
	}
	
	public String toString() {
		String order = super.toString();
		order += "," + addProtein  + "," + numOfFruits + "," + calcPrice();
		return order;
	}
	public boolean equals(Smoothie s) {
		if (super.equals(s) && numOfFruits==s.getNumOfFruits() && addProtein==s.getAddProtien()) {
			return true;
		}
		else {
			return false;
		}
	}
	public double calcPrice() {
		double totalprice = super.getBasePrice();
		
		if (super.getSize() == Size.MEDIUM)
		{
			totalprice += super.getSizePrice();
		}
		else if (super.getSize() == Size.LARGE) 
		{
			totalprice += 2 * super.getSizePrice();
		}
		
		totalprice += numOfFruits * FRUIT_COST;
		if (addProtein)
		{
			totalprice += PROTEIN_COST;
		}
		
		return totalprice;
	}
	
	public int getNumOfFruits() {
		return numOfFruits;
	}
	public boolean getAddProtien() {
		return addProtein;
	}

}