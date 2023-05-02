import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SmoothieStudentTest {

	Smoothie Smoothie,Smoothie1;
	@Before
	public void setUp() throws Exception {
		Smoothie = new  Smoothie ("HELOO", Size.SMALL, 1,true );
		Smoothie1 = new  Smoothie ("VERGO", Size.SMALL, 6, false );
		
	}

	@After
	public void tearDown() throws Exception {
		Smoothie=Smoothie1=null;
	}
	
	@Test
	public void testGetBasePrice()
	{
		assertEquals(2.0,Smoothie.getBasePrice(), .01);
		assertEquals(2,Smoothie1.getBasePrice(), .01);
	}
 
	@Test
	public void testCalPrice() {
		
		assertEquals(4,Smoothie.calcPrice(), .01 );
		assertEquals(5,Smoothie1.calcPrice(), .01 );
		 
	}
	@Test
	public void testToString() {
		
		assertTrue(Smoothie.toString().contains(Smoothie.getBevName()));
		assertTrue(Smoothie.toString().contains( String.valueOf(Smoothie.getNumOfFruits()) ));
  
	}
}
