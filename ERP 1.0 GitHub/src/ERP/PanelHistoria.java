package ERP;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

//panel z histori¹ akcji. Odœwie¿a siê przy starcie aplikacji. Odczytywana jest z pliku historia.txt
public class PanelHistoria extends JPanel{
	
	private Historia historia = new Historia();
	private JTextArea aHistoria;
	private JScrollPane sHistoria;
	
	public PanelHistoria() {
		this.setBackground(Color.white);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		aHistoria = historia.odczytajHistorie();	
		sHistoria = new JScrollPane(aHistoria);
		this.add(sHistoria);
		aHistoria.setEditable(false);
		sHistoria.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		sHistoria.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
		
	}

}

