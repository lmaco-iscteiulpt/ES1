package antiSpamFilter;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI {

	private JFrame frame; //janela
	
	private JPanel panel1 = new JPanel(); //modo manual
	private JButton button1 = new JButton("Manual"); //manual
	
	private JPanel panel2 = new JPanel();	//modo automático
	private JButton button2 = new JButton("Automático"); //automático
	private JButton pesosAleatorios = new JButton("Gerar pesos aleatórios"); //gerar pesos aleatórios
	
	private JLabel label1 = new JLabel("Regras"); //Regras
	private JLabel label2 = new JLabel("Peso"); //Pesos
	private JLabel label3 = new JLabel("FP"); //FP (false positive)
	private JLabel label4 = new JLabel("FN"); //FN (false negative)
	
	private JTextArea regras= new JTextArea(); //lista de regras
	private JTextField text1 = new JTextField("Total"); // total
	private JTextField text2 = new JTextField(); //Balanço do peso das regras
	private JTextField text3 = new JTextField(); //Número total de falsos positivos
	private JTextField text4 = new JTextField(); // Número total de falsos negativos
	
	
	
	
	public GUI (){
		frame = new JFrame();
				
		frame.add(panel1);
		panel1.setLayout(new BorderLayout());
		
		frame.add(panel2);
		panel2.setLayout(new BorderLayout());
		
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		pesosAleatorios.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		
	}
	

	
}
