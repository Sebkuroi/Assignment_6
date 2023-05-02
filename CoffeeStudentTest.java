import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CoffeeStudentTest {

	Coffee Coffee,Coffee1;
	@Before
	public void setUp() throws Exception {
		Coffee = new  Coffee ("Homebrew", Size.SMALL, false,false );
		
		Coffee1 = new  Coffee ("Honey coffe", Size.LARGE, true, true );
		
	}

	@After
	public void tearDown() throws Exception {
		Coffee=Coffee1=null;
	}
	
	@Test
	public void testGetBasePrice()
	{
		assertEquals(2.0,Coffee.getBasePrice(), .01);
		assertEquals(2,Coffee1.getBasePrice(), .01);
	}

	@Test
	public void testCalPrice() {
		
		assertEquals(2,Coffee.calcPrice(), .01 );
		assertEquals(5,Coffee1.calcPrice(), .01 );
		 
	}
	@Test
	public void testToString() {
		
		assertTrue(Coffee.toString().contains(Coffee.getBevName()));
		assertTrue(Coffee.toString().contains(Coffee.getSize().toString() ));
	 
	 
	}
}