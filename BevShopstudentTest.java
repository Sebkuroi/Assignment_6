import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BevShopstudentTest {

	BevShop bevShop;
	@Before
	public void setUp() throws Exception {
		bevShop = new BevShop();
	}

	@After
	public void tearDown() throws Exception {
		bevShop = null;
	}

	@Test
	public void testValidTime()
	{
		assertFalse(bevShop.validTime(2));
		assertTrue(bevShop.validTime(18));
	}
	 
	@Test
	public void testValidAge()
	{
		assertFalse(bevShop.validAge(4));
		assertTrue(bevShop.validAge(27));
	}
	
	@Test
	public void testStartNewOrder()
	{
		bevShop.startNewOrder(12,Day.SUNDAY,"Sebastian", 22);
		assertEquals(12, bevShop.getCurrentOrder().getOrderTime());
		assertEquals(0,bevShop.getNumOfAlcoholDrink());
	
	}
	
	@Test
	public void testProcessAlcoholOrder()
	{
		bevShop.startNewOrder(12,Day.MONDAY,"Fred", 38);
		
		bevShop.processAlcoholOrder("Gin", Size.LARGE);
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getBevName().equals("Gin"));
		assertTrue(bevShop.eligibleForMore());
		
		
	}
	
	@Test
	public void testProcessSmoothieOrder()
	{
		bevShop.startNewOrder(15,Day.TUESDAY,"SENI", 10);
		
		assertFalse ( bevShop.isMaxFruit(5) );
		bevShop.processSmoothieOrder("chocolate", Size.SMALL, 5, false);
		assertTrue(bevShop.getCurrentOrder().getTotalItems() == 1);
	}
		
	@Test
	public void testProcessCoffeeOrder()
	{
	
		bevShop.startNewOrder(14,Day.FRIDAY,"Vicky", 24);
		bevShop.processCoffeeOrder("french blend", Size.MEDIUM, true, true);
		assertTrue(bevShop.getCurrentOrder().getTotalItems() == 1);
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getBevName().equals("french blend"));
		
		
	}
	
	@Test
	public void testFindOrder()
	{
	 
		int orderNum;
		bevShop.startNewOrder(14,Day.FRIDAY,"Vicky", 24);
		bevShop.processCoffeeOrder("french blend", Size.MEDIUM, true, true);
		bevShop.processCoffeeOrder("orange", Size.LARGE, false, false);
		
		orderNum = bevShop.getCurrentOrder().Generatenumber();
		
		bevShop.startNewOrder(8,Day.SUNDAY,"John", 30);
		bevShop.processSmoothieOrder("Vine", Size.SMALL, 1, false);
		
		assertEquals(0,bevShop.findOrder(orderNum));
		
		orderNum = bevShop.getCurrentOrder().Generatenumber();
		assertEquals(0,bevShop.findOrder(orderNum));
		
	}
	@Test
	public void testTotalOrderPrice()
	{
	 	int orderNum1;
		
	 	bevShop.startNewOrder(14,Day.FRIDAY,"Vicky", 24);
		bevShop.processCoffeeOrder("french blend", Size.MEDIUM, true, true);
		bevShop.processCoffeeOrder("orange", Size.LARGE, false, false);
		
		orderNum1 = bevShop.getCurrentOrder().Generatenumber();
	
		assertEquals(8,bevShop.totalOrderPrice(orderNum1),.01);
	
		
	}
	@Test
	public void testTotalMonthlySale()
	{
		bevShop.startNewOrder(14,Day.FRIDAY,"Vicky", 24);
		bevShop.processCoffeeOrder("french blend", Size.MEDIUM, true, true);
		bevShop.processCoffeeOrder("orange", Size.LARGE, false, false);
	
		bevShop.startNewOrder(14,Day.FRIDAY,"mandy", 22);
		bevShop.processCoffeeOrder("french blend", Size.LARGE, true, true);
		bevShop.processCoffeeOrder("orange", Size.LARGE, true, true);	 

	 
		assertEquals(18, bevShop.totalMonthlySale(), .01 );
 
	}
	
	@Test
	public void testSortOrders()
	{
		bevShop.startNewOrder(8,Day.MONDAY,"Kate", 20);
		bevShop.startNewOrder(8,Day.SUNDAY,"John", 30);
		bevShop.startNewOrder(12,Day.SATURDAY,"Amy", 43);
		
		bevShop.sortOrders();
		assertFalse(bevShop.getOrderAtIndex(0).Generatenumber()> bevShop.getOrderAtIndex(2).Generatenumber());
		
	}@Test
	public void testToString() {
		
		bevShop.startNewOrder(8,Day.MONDAY,"Kate", 20);
		bevShop.processCoffeeOrder("french blend", Size.SMALL, true, false); 
		bevShop.processCoffeeOrder("orange", Size.LARGE, false, false);
		bevShop.startNewOrder(8,Day.SUNDAY,"John", 30);
		bevShop.processSmoothieOrder("potato", Size.SMALL, 1, false);
			  
		 
		
		assertTrue(bevShop.toString().contains(bevShop.getOrderAtIndex(0).getBeverage(0).getSize().toString()) )  ;
		assertTrue(bevShop.toString().contains(bevShop.getOrderAtIndex(0).getBeverage(0).getBevName()) );
		assertTrue(bevShop.toString().contains(bevShop.getOrderAtIndex(1).getBeverage(0).getSize().toString()) )  ;
		assertTrue(bevShop.toString().contains(bevShop.getOrderAtIndex(1).getBeverage(0).getBevName()) );
		
		
 
		 
	}
}	