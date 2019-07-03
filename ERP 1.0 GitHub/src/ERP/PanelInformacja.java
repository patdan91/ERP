package ERP;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
//tworzenie panelu z podstawowymi informacjami
public class PanelInformacja extends JPanel{
	
	private JTextArea informacje = new JTextArea("Aplikacja do zarz¹dzanie stanem drewna w zak³adzie prefabrykacji \n"
			+ "Autor: Patryk Danielski \n" + "Informacje odnoœnie konfiguracji bazy danych znajduj¹ siê w pliku MySQL.txt");
	
	public PanelInformacja() {
		this.setBackground(Color.white);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(informacje);
		informacje.setEditable(false);
		
	}

}
