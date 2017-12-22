package antiSpamFilter.tests;

import org.junit.Test;

import antiSpamFilter.GUI;

public class GUITest {

	@Test
	public void test() {
		GUI gui = new GUI();
		gui.open();
		
		gui.carregarRegras();
		gui.avaliaFiltroManual();
		gui.guardarRegrasManual();
		
		gui.avaliaFiltroAutomatico();
		gui.guardarRegrasAutomatico();
	}

}
