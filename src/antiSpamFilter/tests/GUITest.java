package antiSpamFilter.tests;

import org.junit.Test;

import antiSpamFilter.GUI;

public class GUITest {

	@Test
	public void test() {
		
		/**
		 * Cria��o de uma nova GUI
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
		 * Avalia o Filtro Manual
		 */
		gui.avaliaFiltroManual();
		
		/**
		 * Guarda as Regras Manuais
		 */
		gui.guardarRegrasManual();
		
		/**
		 * Avalia o Filtro Autom�tico
		 */
		gui.avaliaFiltroAutomatico();
		
		/**
		 * Guarda as Regras Autom�ticas
		 */
		gui.guardarRegrasAutomatico();
	}

}
