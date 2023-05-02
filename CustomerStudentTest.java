import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CustomerStudentTest {
	Customer Customer,Customer1;
	@Before
	public void setUp() throws Exception {
		Customer = new Customer("seb", 10);
		Customer1 = new Customer("seb", 11);
	}

	@After
	public void tearDown() throws Exception {
		
		Customer=null;
	}

	@Test
	public void testConstructor() {
		
		assertFalse(Customer == Customer1);
		assertTrue(Customer1.getName().equals(Customer.getName()));
		assertFalse(Customer1.getAge() == Customer.getAge());
		 
	}

	 
		


}