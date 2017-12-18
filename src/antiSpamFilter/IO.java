package antiSpamFilter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class IO {

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
}
