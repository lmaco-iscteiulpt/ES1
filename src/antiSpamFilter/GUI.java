package antiSpamFilter;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GUI {

	private JFrame frame; //janela
	
	private static final double THRESHOLD = 5.0;
	private static final String FICHEIRO_RF = "experimentBaseDirectory/referenceFronts/AntiSpamFilterProblem.NSGAII.rf";
	private static final String FICHEIRO_RS = "experimentBaseDirectory/referenceFronts/AntiSpamFilterProblem.NSGAII.rs";

	private Object[] colunas = new Object[]{"Regra", "Peso"};

	private JTextField textFicheiroRegras;
	private JTextField textFicheiroHam;
	private JTextField textFicheiroSpam;

	private JPanel panelManual;
	private JTable tblManual;
	private JScrollPane scrollManual;
	private ArrayList<Regra> listaRegrasManual;
	private Object[][] valoresManual;
	private JTextField textFalsosPositivosManual;
	private JTextField textFalsosNegativosManual;

	private JPanel panelAutomatico;
	private JTable tblAutomatico;
	private JScrollPane scrollAutomatico;
	private JTextField textFalsosPositivosAutomatico;
	private JTextField textFalsosNegativosAutomatico;
	private ArrayList<Regra> listaRegrasAutomatico;
	private Object[][] valoresAutomatico;

	public GUI(){
		frame = new JFrame();
		frame.setLayout(new GridLayout(3, 1));

		frame.setTitle("Configuração manual do filtro anti-spam");
		createPanel1();
		createPanelManual();
		createPanelAutomatico();

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
	}

	public void open() {
		frame.setVisible(true);
	}

	private void createPanel1() {
		JPanel panel1 = new JPanel(new GridLayout(3, 1));

		// Linha Regras
		JPanel panelRegras = new JPanel(new FlowLayout());
		panelRegras.add(new JLabel("Ficheiro regras: "));
		textFicheiroRegras = new JTextField(30);
		textFicheiroRegras.setText("C:\\Users\\ligia\\git\\ES1-2017-IC2-88\\rules.cf");
		panelRegras.add(textFicheiroRegras);
		panel1.add(panelRegras);

		// Linha Ham
		JPanel panelHam = new JPanel(new FlowLayout());
		panelHam.add(new JLabel("Ficheiro Ham:     "));
		textFicheiroHam = new JTextField(30);
		textFicheiroHam.setText("C:\\Users\\ligia\\git\\ES1-2017-IC2-88\\ham.log");
		panelHam.add(textFicheiroHam);
		panel1.add(panelHam);

		// Linha Spam
		JPanel panelSpam = new JPanel(new FlowLayout());
		panelSpam.add(new JLabel("Ficheiro Spam:    "));
		textFicheiroSpam = new JTextField(30);
		textFicheiroSpam.setText("C:\\Users\\ligia\\git\\ES1-2017-IC2-88\\spam.log");
		panelSpam.add(textFicheiroSpam);
		panel1.add(panelSpam);

		frame.add(panel1);
	}

	private void createPanelManual() {
		panelManual = new JPanel(new BorderLayout());


		JLabel titulo = new JLabel("Configuração Manual");
		titulo.setHorizontalAlignment(JLabel.CENTER);
		panelManual.add(titulo, BorderLayout.NORTH);

		// Tabela
		tblManual = new JTable(new Object[0][0], colunas);
		tblManual.setPreferredScrollableViewportSize(new Dimension(500, 70));
		tblManual.setFillsViewportHeight(true);
		scrollManual = new JScrollPane(tblManual);
		panelManual.add(scrollManual, BorderLayout.CENTER);

		// Botoes
		JPanel panelBotoes = new JPanel(new GridLayout(3, 1));

		JButton btnCarregar = new JButton("Carregar Regras");
		btnCarregar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				carregarRegras();
			}
		});
		panelBotoes.add(btnCarregar);


		JButton btnAvaliar = new JButton("Avaliar Filtro Manual");
		btnAvaliar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				avaliaFiltroManual();
			}
		});
		panelBotoes.add(btnAvaliar);

		JButton btnGuardar = new JButton("Guardar Regras");
		btnGuardar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				guardarRegrasManual();
			}

		});
		panelBotoes.add(btnGuardar);
		panelManual.add(panelBotoes, BorderLayout.EAST);

		// Labels
		JPanel panelLabels = new JPanel(new FlowLayout());
		panelLabels.add(new JLabel("FP: "));
		textFalsosPositivosManual = new JTextField(5);
		textFalsosPositivosManual.setEditable(false);
		panelLabels.add(textFalsosPositivosManual);
		panelLabels.add(new JLabel("FN: "));
		textFalsosNegativosManual = new JTextField(5);
		textFalsosNegativosManual.setEditable(false);
		panelLabels.add(textFalsosNegativosManual);
		panelManual.add(panelLabels, BorderLayout.SOUTH);

		frame.add(panelManual);
	}

	private void createPanelAutomatico() {
		panelAutomatico = new JPanel(new BorderLayout());

		JLabel titulo = new JLabel("Configuração Automática");
		titulo.setHorizontalAlignment(JLabel.CENTER);
		panelAutomatico.add(titulo, BorderLayout.NORTH);

		tblAutomatico = new JTable(new Object[0][0], colunas);
		tblAutomatico.setPreferredScrollableViewportSize(new Dimension(500, 70));
		tblAutomatico.setFillsViewportHeight(true);
		scrollAutomatico = new JScrollPane(tblAutomatico);
		panelAutomatico.add(scrollAutomatico, BorderLayout.CENTER);

		JPanel panelBotoes = new JPanel(new GridLayout(2, 1));
		JButton btnAvaliar = new JButton("Avaliar Filtro Automatico");
		btnAvaliar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				avaliaFiltroAutomatico();
			}
		});
		panelBotoes.add(btnAvaliar);
		JButton btnGuardar = new JButton("Guardar Regras");
		btnGuardar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				guardarRegrasAutomatico();
			}
		});
		panelBotoes.add(btnGuardar);
		panelAutomatico.add(panelBotoes, BorderLayout.EAST);

		JPanel panelLabels = new JPanel(new FlowLayout());
		panelLabels.add(new JLabel("FP: "));
		textFalsosPositivosAutomatico = new JTextField(5);
		textFalsosPositivosAutomatico.setEditable(false);
		panelLabels.add(textFalsosPositivosAutomatico);
		panelLabels.add(new JLabel("FN: "));
		textFalsosNegativosAutomatico = new JTextField(5);
		textFalsosNegativosAutomatico.setEditable(false);
		panelLabels.add(textFalsosNegativosAutomatico);
		panelAutomatico.add(panelLabels, BorderLayout.SOUTH);


		frame.add(panelAutomatico);
	}

	public void carregarRegras() {
		String diretoria = textFicheiroRegras.getText();
		File file = new File(diretoria);
		if(file.exists()) {
			listaRegrasManual = IO.leRegras(file);
			System.out.println("Carreguei " + listaRegrasManual.size() + " regras");
			valoresManual = new Object[listaRegrasManual.size()][colunas.length];
			for (int linha = 0; linha < listaRegrasManual.size(); linha++) {
				valoresManual[linha][0] = listaRegrasManual.get(linha).getPalavra();
				valoresManual[linha][1] = new Double(listaRegrasManual.get(linha).getPeso());
			}

			panelManual.remove(scrollManual);

			tblManual = new JTable(valoresManual, colunas);
			scrollManual = new JScrollPane(tblManual);
			panelManual.add(scrollManual, BorderLayout.CENTER);

			frame.validate();
		}
	}
		
	public void guardarRegrasManual() {
		String diretoria = JOptionPane.showInputDialog("Diretoria:");
		guardaFicheiroDaMatrizNaLista();
		IO.escreveRegras(listaRegrasManual, diretoria);
	}
	
	public void guardarRegrasAutomatico() {
		String diretoria = JOptionPane.showInputDialog("Diretoria:");
		IO.escreveRegras(listaRegrasAutomatico, diretoria);
	}
			
		public void avaliaFiltroManual() {
			File fileSpam = new File(textFicheiroSpam.getText());
			File fileHam = new File(textFicheiroHam.getText());

			if(fileSpam.exists() && fileHam.exists()) {

				guardaFicheiroDaMatrizNaLista();

				int falsosPositivos = 0;
				ArrayList<Mail> listaMailsHam = IO.leMails(fileHam, true);
				System.out.println("Carreguei " + listaMailsHam.size() + " mails de ham.");
				for (Mail mail : listaMailsHam) {
					double media = mail.somaPesos(listaRegrasManual);
					if(media > THRESHOLD) {
						falsosPositivos++;
					}
				}
				textFalsosPositivosManual.setText(falsosPositivos + "");


				int falsosNegativos = 0;
				ArrayList<Mail> listaMailsSpam = IO.leMails(fileSpam, false);
				System.out.println("Carreguei " + listaMailsSpam.size() + " mails de spam.");
				for (Mail mail : listaMailsSpam) {
					double media = mail.somaPesos(listaRegrasManual);
					if(media <= THRESHOLD) {
						falsosNegativos++;
					}
				}
				textFalsosNegativosManual.setText(falsosNegativos + "");
			}
		}
		
		public void avaliaFiltroAutomatico() {
			try {

				String diretoria = textFicheiroRegras.getText();
				File file = new File(diretoria);
				if(file.exists()) {
					listaRegrasAutomatico = IO.leRegras(file);

					AntiSpamFilterAutomaticConfiguration.main(null);

					File fileRF = new File(FICHEIRO_RF);
					File filePesos = new File(FICHEIRO_RS);
					
					

					ArrayList<Double> listaPesos = IO.lePesosAutomaticos(fileRF, filePesos);

					for (int i = 0; i < listaPesos.size(); i++) {
						listaRegrasAutomatico.get(i).setPeso(listaPesos.get(i));
					}

					System.out.println("Carreguei " + listaRegrasAutomatico.size() + " regras");
					valoresAutomatico = new Object[listaRegrasAutomatico.size()][colunas.length];
					for (int linha = 0; linha < listaRegrasAutomatico.size(); linha++) {
						valoresAutomatico[linha][0] = listaRegrasAutomatico.get(linha).getPalavra();
						valoresAutomatico[linha][1] = new Double(listaRegrasAutomatico.get(linha).getPeso());
					}

					panelAutomatico.remove(scrollAutomatico);

					tblAutomatico = new JTable(valoresAutomatico, colunas);
					scrollAutomatico = new JScrollPane(tblAutomatico);
					panelAutomatico.add(scrollAutomatico, BorderLayout.CENTER);

					frame.validate();
				}
				
				
				File fileSpam = new File(textFicheiroSpam.getText());
				File fileHam = new File(textFicheiroHam.getText());

				if(fileSpam.exists() && fileHam.exists()) {


					int falsosPositivos = 0;
					ArrayList<Mail> listaMailsHam = IO.leMails(fileHam, true);
					System.out.println("Carreguei " + listaMailsHam.size() + " mails de ham.");
					for (Mail mail : listaMailsHam) {
						double media = mail.somaPesos(listaRegrasAutomatico);
						if(media > THRESHOLD) {
							falsosPositivos++;
						}
					}
					textFalsosPositivosAutomatico.setText(falsosPositivos + "");


					int falsosNegativos = 0;
					ArrayList<Mail> listaMailsSpam = IO.leMails(fileSpam, false);
					System.out.println("Carreguei " + listaMailsSpam.size() + " mails de spam.");
					for (Mail mail : listaMailsSpam) {
						double media = mail.somaPesos(listaRegrasAutomatico);
						if(media <= THRESHOLD) {
							falsosNegativos++;
						}
					}
					textFalsosNegativosAutomatico.setText(falsosNegativos + "");
				}


			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		private void guardaFicheiroDaMatrizNaLista() {
			for (int linha = 0; linha < valoresManual.length; linha++) {
				if(valoresManual[linha][1] instanceof Double) {
					listaRegrasManual.get(linha).setPeso((Double)valoresManual[linha][1]);
				}
				else if(valoresManual[linha][1] instanceof String) {
					double d = Double.valueOf((String)valoresManual[linha][1]);
					listaRegrasManual.get(linha).setPeso(d);
				}
			}
		}
		
	public static void main(String[] args) {
		GUI gui = new GUI();
		gui.open();
	}

}

