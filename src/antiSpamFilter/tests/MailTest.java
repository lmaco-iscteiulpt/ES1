package antiSpamFilter.tests;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import antiSpamFilter.Mail;
import antiSpamFilter.Regra;

public class MailTest {

	@Test
	public void test() {
		
		/**
		 * ArrayList de String listaConteudo
		 */
		ArrayList<String> listaConteudo = new ArrayList<String>();
		
		/**
		 * Adiciona à listaConteudo "BAYES_00"
		 */
		listaConteudo.add("BAYES_00");
		
		/**
		 * Criação de um Mail
		 */
		Mail mail = new Mail(true, "0016d82758030e304d41fb3f4ebbb7d9dd91", listaConteudo);
		
		Assert.assertEquals("0016d82758030e304d41fb3f4ebbb7d9dd91", mail.getToken());
		Assert.assertTrue(mail.isSpam());
		Assert.assertNotNull(mail.getListaConteudo());
		Assert.assertEquals(1, mail.getListaConteudo().size());
		
		/**
		 * ArrayList de Regras listaRegras
		 */
		ArrayList<Regra> listaRegras = new ArrayList<>();
		
		/**
		 * Adiciona à listaRegras o "BAYES_00", com peso 5
		 */
		listaRegras.add(new Regra("BAYES_00", 5));
		
		/**
		 * Adiciona à listaRegras o "BAYES_007", com peso -5
		 */
		listaRegras.add(new Regra("BAYES_007", -5));
		double somatorioPesos = mail.somaPesos(listaRegras);
		Assert.assertEquals(5.0, somatorioPesos, 0.00001);
		
	}

}
