package antiSpamFilter.tests;

import org.junit.Test;

import antiSpamFilter.GUI;

public class GUITest {

	@Test
	public void test() {
		
		/**
		 * Criação de GUI
		 */
		GUI gui = new GUI();
		
		/**
		 * Abertura da GUI
		 */
		gui.open();
		
		/**
		 * Carrega as Regras
		 */
		gui.carregarRegras();
		
		/**
		 * Avalia Filtro Manual
		 */
		gui.avaliaFiltroManual();
		
		/**
		 * Guarda Regras Manuais
		 */
		gui.guardarRegrasManual();
		
		/**
		 * Avalia Filtro Automatico
		 */
		gui.avaliaFiltroAutomatico();
		
		/**
		 * Guarda Regras Automatico
		 */
		gui.guardarRegrasAutomatico();
	}

}
