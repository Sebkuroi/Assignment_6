import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TypeStudentTest {
	Customer Customer,Customer1;
	@Before
	public void setUp() throws Exception
	{
	
	}

	@After
	public void tearDown() throws Exception 
	{
	}

	@Test
	  public void testTypes() {
		assertEquals(Day.THURSDAY, Day.valueOf("THURSDAY"));
        assertEquals(Day.FRIDAY, Day.valueOf("FRIDAY"));
        assertEquals(Day.SATURDAY, Day.valueOf("SATURDAY"));
        assertEquals(Day.SUNDAY, Day.valueOf("SUNDAY"));
    }
	 
		


}