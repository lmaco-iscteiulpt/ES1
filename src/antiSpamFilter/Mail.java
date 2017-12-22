package antiSpamFilter;

import java.util.ArrayList;

public class Mail {

	/**
	 * Boolean isSpam
	 */
	private boolean isSpam;
	
	/**
	 * String token
	 */
	private String token;
	
	/**
	 * ArrayList listaConteudo
	 */
	private ArrayList<String> listaConteudo;
	
	/**
	 * Construtor da Classe Mail
	 * @param isSpam
	 * @param token
	 * @param listaConteudo
	 */
	public Mail(boolean isSpam, String token, ArrayList<String> listaConteudo) {
		this.isSpam = isSpam;
		this.token = token;
		this.listaConteudo = listaConteudo;
	}
	
	/**
	 * Devolve o Boolean isSpam
	 * @return isSpam
	 */
	public boolean isSpam() {
		return isSpam;
	}
	
	/**
	 * Devolve o String token
	 * @return token
	 */
	public String getToken() {
		return token;
	}
	
	/**
	 * Devolve a lista listaConteudo
	 * @return listaConteudo
	 */
	public ArrayList<String> getListaConteudo() {
		return listaConteudo;
	}
	
	/**
	 * Soma dos pesos das regras
	 * 
	 * @param listaRegras
	 * @return somatorioPesos
	 */
	public double somaPesos(ArrayList<Regra> listaRegras) {
		double somatorioPesos = 0;
		for (String palavraConteudo : listaConteudo) {
			for (Regra regra : listaRegras) {
				if(palavraConteudo.equals(regra.getPalavra())) {
					somatorioPesos += regra.getPeso();
				}
			}
		}
		return somatorioPesos;
	}
}
