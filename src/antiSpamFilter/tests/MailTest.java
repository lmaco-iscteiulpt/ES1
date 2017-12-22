package antiSpamFilter.tests;

import java.util.ArrayList;

import org.junit.Test;

import antiSpamFilter.Mail;
import antiSpamFilter.Regra;
import junit.framework.Assert;

class MailTest {
	
	@Test
	public void test() {
		
		ArrayList<String> listaConteudo = new ArrayList<String>();
		listaConteudo.add("BAYES_00");
		
		Mail mail = new Mail(true, "0016d82758030e304d41fb3f4ebbb7d9dd91", listaConteudo);
		
		Assert.assertEquals("0016d82758030e304d41fb3f4ebbb7d9dd91", mail.getToken());
		Assert.assertTrue(mail.isSpam());
		Assert.assertNotNull(mail.getListaConteudo());
		Assert.assertEquals(1, mail.getListaConteudo().size());
		
		ArrayList<Regra> listaRegras = new ArrayList<>();
		listaRegras.add(new Regra("BAYES_00", 5));
		listaRegras.add(new Regra("BAYES_007", -5));
		double somatorioPesos = mail.somaPesos(listaRegras);
		Assert.assertEquals(5.0, somatorioPesos, 0.00001);
		
	}


}
