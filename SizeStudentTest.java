import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SizeStudentTest {
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
	 public void testSizes() {
        assertEquals(Size.SMALL, Size.valueOf("SMALL"));
        assertEquals(Size.MEDIUM, Size.valueOf("MEDIUM"));
        assertEquals(Size.LARGE, Size.valueOf("LARGE"));
    }
	 
		


}