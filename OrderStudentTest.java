import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrderStudentTest {

	Order r1,r2,r3;
	@Before
	public void setUp() throws Exception {
		r1 = new Order (8, Day.MONDAY, new Customer ("seb", 22));
		r2 = new Order (22, Day.SATURDAY, new Customer ("kat", 45));
		r3 = new Order (11, Day.FRIDAY, new Customer ("Fred", 31));
	}

	@After
	public void tearDown() throws Exception {
		r1=r2=r3=null;
	}
	
	@Test 
	public void testGetBeverage( )
	{
		Coffee coffee = new Coffee("Coffee", Size.SMALL, false,false);
		Smoothie smoothie = new Smoothie("Money", Size.LARGE,1,false);
		
		r1.addNewBeverage("Coffee", Size.SMALL, false,false);
		r1.addNewBeverage("Money", Size.MEDIUM,1,false); 
		assertTrue(r1.getBeverage(0).equals(coffee) );
		assertFalse(r1.getBeverage(1).equals(smoothie) );
	}

	@Test
	public void testAddNewBeverage() throws NullPointerException   {
		
		assertTrue(r1.getTotalItems() == 0);
		r1.addNewBeverage("Carmel Coffee", Size.SMALL, false,false);
	 	assertTrue(r1.getBeverage(0).getType().equals(Type.COFFEE));
		r2.addNewBeverage("Money", Size.MEDIUM,4,true); 
		assertTrue(r2.getBeverage(0).getType().equals(Type.SMOOTHIE));
		
		 
	}
	 
	@Test
	public void testisWeekend()   {
		
		assertFalse(r1.isWeekend());
		assertTrue(r2.isWeekend());

		 
	}
	
	@Test
	public void testCalcOrderTotal()   {
		r1.addNewBeverage("Coffee", Size.SMALL, true,false);
	 	r1.addNewBeverage("Mohito", Size.SMALL); 
		assertEquals(4.5,r1.calcOrderTotal(),.01);
		r2.addNewBeverage("happy shake", Size.MEDIUM,4,true); 
		assertEquals(6.5,r2.calcOrderTotal(),.01);
		 
	}
	
	@Test
	public void testFindNumOfBeveType()
	{

		r1.addNewBeverage("Detox", Size.MEDIUM,1,false); 
		assertEquals(0, r1.findNumOfBeveType(Type.ALCOHOL));
		
		r2.addNewBeverage("regular Coffee", Size.MEDIUM, true,false);
	 	assertEquals(0, r2.findNumOfBeveType(Type.SMOOTHIE));
	}
	@Test
	public void testToString() {
		
		r1.addNewBeverage("regular Coffee", Size.SMALL, false,false);
	 	r1.addNewBeverage("Mohito", Size.LARGE); 
		 

		assertTrue(r1.toString().contains(r1.getBeverage(0).getSize().toString()) )  ;
		assertTrue(r1.toString().contains( String.valueOf(r1.getBeverage(1).calcPrice()) ));
		 
	 
	 
	}

}