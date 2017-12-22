package antiSpamFilter.tests;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import antiSpamFilter.IO;

public class IOTest {

	@Test
	public void test() {
		
		File file = null;
		
		IO io = new IO();
		
		io.leRegras(file);
		
		boolean isSpam = false;
		
		IO.leMails(file, isSpam);
		
		File filePesos = null;
		IO.lePesosAutomaticos(file, filePesos);
		
		
	}

}
