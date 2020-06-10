package first_travisci;

import org.junit.Assert;
import org.junit.Test;

public class TestSayHello {

	@Test
	public void testSayHello() {
		
		Assert.assertEquals("Hello Remy", SayHello.sayHello("Remy"));
	}
}
