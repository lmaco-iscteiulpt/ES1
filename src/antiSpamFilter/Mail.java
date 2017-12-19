package antiSpamFilter;

import java.util.ArrayList;


public class Mail {

	private boolean isSpam;
	private String token;
	private ArrayList<String> listaConteudo;
	
	public Mail(boolean isSpam, String token, ArrayList<String> listaConteudo) {
		this.isSpam = isSpam;
		this.token = token;
		this.listaConteudo = listaConteudo;
	}
	
	public boolean isSpam() {
		return isSpam;
	}
	
	public String getToken() {
		return token;
	}
	
	public ArrayList<String> getListaConteudo() {
		return listaConteudo;
	}
	
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
