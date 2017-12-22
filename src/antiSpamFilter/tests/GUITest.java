package antiSpamFilter.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import antiSpamFilter.GUI;

class GUITest {

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
