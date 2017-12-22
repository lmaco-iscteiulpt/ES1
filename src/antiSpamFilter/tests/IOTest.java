/**
 * 
 */
package antiSpamFilter.tests;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.Test;

import antiSpamFilter.IO;
import antiSpamFilter.Mail;
import antiSpamFilter.Regra;

public class IOTest {

	/**
	 * Test method for {@link antiSpamFilter.IO#leRegras(java.io.File)}.
	 */
	@Test
	public void testLeRegras() {
		File file = new File("C:\\Users\\ligia\\git\\ES1-2017-IC2-88\\rules.cf");
		ArrayList<Regra> R = new ArrayList<Regra>();
		R = IO.leRegras(file);
		
		File file2 = new File("C:\\Users\\ligia\\git\\ES1-2017-IC2-88\\ruleeeees.cf");
		ArrayList<Regra> R2 = new ArrayList<Regra>();
		R2 = IO.leRegras(file2);
	}

	/**
	 * Test method for {@link antiSpamFilter.IO#escreveRegras(java.util.ArrayList, java.lang.String)}.
	 */
	@Test
	public void testEscreveRegras() {
		File file = new File("C:\\Users\\ligia\\git\\ES1-2017-IC2-88\\rules.cf");
		ArrayList<Regra> R1 = IO.leRegras(file);

		String diretorio = "C:\\Users\\ligia\\git\\ES1-2017-IC2-88\\rules.cf";
		IO.leRegras(file);
		IO.escreveRegras(R1, diretorio);
	}

	/**
	 * Test method for {@link antiSpamFilter.IO#leMails(java.io.File, boolean)}.
	 */
	@Test
	public void testLeMails() {
		File file = new File("C:\\Users\\ligia\\git\\ES1-2017-IC2-88\\spam.log");
		ArrayList<Mail> M = new ArrayList<Mail>();
		M = IO.leMails(file, true);
		
		File file2 = new File("C:\\Users\\ligia\\git\\ES1-2017-IC2-88\\ruleeeees.cf");
		ArrayList<Mail> M2 = new ArrayList<Mail>();
		M2 = IO.leMails(file2, false);
	}

	/**
	 * Test method for {@link antiSpamFilter.IO#lePesosAutomaticos(java.io.File, java.io.File)}.
	 */
	@Test
	public void testLePesosAutomaticos() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.Object#equals(java.lang.Object)}.
	 */
	@Test
	public void testEquals() {
		IO io1 = new IO();
		IO io2 = new IO();
		io1.equals(io2);
	}

	/**
	 * Test method for {@link java.lang.Object#toString()}.
	 */
	@Test
	public void testToString() {
		IO io = new IO();
		System.out.println(io.toString());
	}

}
