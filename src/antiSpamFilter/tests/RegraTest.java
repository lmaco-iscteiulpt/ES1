package antiSpamFilter.tests;

import org.junit.Assert;
import org.junit.Test;

import antiSpamFilter.Regra;

public class RegraTest {

	@Test
	public void test() {
		Regra regra1 = new Regra("regra1");
		Assert.assertNotNull(regra1);
		Assert.assertEquals("regra1", regra1.getPalavra());
		Assert.assertEquals(0.0, regra1.getPeso(), 0.00001);
		Assert.assertEquals("0.0 -> regra1", regra1.toString());
		
		Regra regra2 = new Regra("regra2", 5);
		Assert.assertEquals("regra2", regra2.getPalavra());
		Assert.assertEquals(5.0, regra2.getPeso(), 0.00001);
		Assert.assertEquals("5.0 -> regra2", regra2.toString());
			
	
	}

}
