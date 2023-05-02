import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AlcoholTestStudent {
	Alcohol Alcohol,Alcohol1;

	@Before
	public void setUp() throws Exception {
		Alcohol = new Alcohol("Gin&tonic", Size.MEDIUM, true);
		Alcohol1 = new Alcohol("beer", Size.SMALL, false);

	}

	@After
	public void tearDown() throws Exception {
		Alcohol = null;
	}

	@Test
	public void testCalPrice() 
	{

		assertEquals(3.6, Alcohol.calcPrice(), .01);
		assertEquals(2, Alcohol1.calcPrice(), .001);
	}

	@Test
	public void testToString() {

		assertTrue(Alcohol.toString().contains(Alcohol.getBevName()));
		assertTrue(Alcohol1.toString().contains(String.valueOf(Alcohol1.calcPrice())));
		

	}

}