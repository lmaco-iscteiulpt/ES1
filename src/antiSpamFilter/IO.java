package antiSpamFilter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class IO {

	/**
	 * Devolve lista listaRegras
	 * @param file
	 * @return listaRegras
	 */
	public static ArrayList<Regra> leRegras(File file) {
		ArrayList<Regra> listaRegras = new ArrayList<>();
		
		try {
			Scanner scanner = new Scanner(file);
			
			while(scanner.hasNextLine()) {
				String linha = scanner.nextLine();
				Regra regra = new Regra(linha);
				listaRegras.add(regra);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return listaRegras;
	}
	
	/**
	 * Altera lista listaRegras
	 * @param listaRegras
	 * @param diretoria
	 */
	
	public static void escreveRegras(ArrayList<Regra> listaRegras, String diretoria) {
		try {
			PrintWriter printWriter = new PrintWriter(new File(diretoria));
			for (Regra regra : listaRegras) {
				printWriter.println(regra.getPalavra() + " " + regra.getPeso());
			}
			printWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Devolve lista listaMails
	 * @param file
	 * @param isSpam
	 * @return listaRegras
	 */
	
	public static ArrayList<Mail> leMails(File file, boolean isSpam) {
		ArrayList<Mail> listaMails = new ArrayList<>();
		
		try {
			Scanner scanner = new Scanner(file);
			
			while(scanner.hasNextLine()) {
				String linha = scanner.nextLine();
				String[] palavras = linha.split("\\s");
				
//				System.out.println("Linha: " + linha);
//				for (int i = 0; i < palavras.length; i++) {
//					System.out.println(i + " -> " + palavras[i]);
//				}
				
				ArrayList<String> listaConteudo = new ArrayList<String>();
				for (int i = 1; i < palavras.length; i++) {
					listaConteudo.add(palavras[i]);
				}
				
				Mail mail = new Mail(isSpam, palavras[0], listaConteudo);
				listaMails.add(mail);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return listaMails;
	}
	
	/**
	 * Devolve lista listaPesos
	 * @param file
	 * @param filePesos
	 * @return listaPesos
	 */
	
	public static ArrayList<Double> lePesosAutomaticos(File file, File filePesos) {
		
		
		try {
			double min = 0;
			int indiceLinhaMin = 0;
			int indiceLinha = 0;
			boolean primeiroValor = true;
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()) {
				String linha = scanner.nextLine();
				String[] valores = linha.split(" ");
				double valor = Double.valueOf(valores[0]);
				if(primeiroValor) {
					primeiroValor = false;
					min = valor;
					indiceLinhaMin = 0;
				} else {
					if(valor < min) {
						min = valor;
						indiceLinhaMin = indiceLinha;
					}
				}
				
				indiceLinha++;
			}
			scanner.close();
			
			
			ArrayList<Double> listaPesos = new ArrayList<Double>();
			indiceLinha = 0;
			scanner = new Scanner(filePesos);
			while(scanner.hasNextLine()) {
				String linha = scanner.nextLine();
				
				if(indiceLinha == indiceLinhaMin) {
					String[] valores = linha.split(" ");
					for (String valor : valores) {
						double peso = Double.valueOf(valor);
						listaPesos.add(peso);
					}
				}
				indiceLinha++;
			}
			scanner.close();
			
			return listaPesos;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
