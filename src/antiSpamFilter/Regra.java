package antiSpamFilter;

public class Regra {
	
	private String palavra;
	private double peso;
	
	public Regra(String palavra) {
		this.palavra = palavra;
		this.peso = 0; //new Random().nextInt(11)-5;
	}
	
	public Regra(String palavra, double peso) {
		this.palavra = palavra;
		this.peso = peso;
	}
	
	public String getPalavra() {
		return palavra;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	@Override
	public String toString() {
		return peso + " -> " + palavra;
	}

}
