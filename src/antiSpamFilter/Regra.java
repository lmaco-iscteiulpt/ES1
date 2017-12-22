package antiSpamFilter;

/**
 * Classe Regra
 *
 */
public class Regra {
	
	/**
	 * String palavra
	 */
	private String palavra;
	
	/**
	 * Double peso
	 */
	private double peso;
	
	/**
	 * Construtor da classe Regra
	 * @param palavra
	 */
	public Regra(String palavra) {
		this.palavra = palavra;
		this.peso = 0; //new Random().nextInt(11)-5;
	}
	
	/**
	 * Construtor da classe Regra
	 * @param palavra
	 * @param peso
	 */
	public Regra(String palavra, double peso) {
		this.palavra = palavra;
		this.peso = peso;
	}
	
	/**
	 * Devolve a String palavra
	 * @return palavra
	 */
	public String getPalavra() {
		return palavra;
	}
	
	/**
	 * Devolve o Double peso
	 * @return peso
	 */
	public double getPeso() {
		return peso;
	}
	
	/**
	 * Altera o Double peso
	 * @param peso
	 */
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	/**
	 * Devolve o toString
	 */
	@Override
	public String toString() {
		return peso + " -> " + palavra;
	}

}
