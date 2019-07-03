package ERP;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class GlowneOkno {
	
	String uzytkownik = "";
	private JFrame ramka = new JFrame("ERP");
	private JTabbedPane zakladka = new JTabbedPane(JTabbedPane.TOP);

	private PanelDostepnosc panelDostepnosc = new PanelDostepnosc();
	private PanelDodaj panelDodaj = new PanelDodaj();
	private PanelWykorzystanie panelWykorzystanie = new PanelWykorzystanie();
	private PanelHistoria panelHistoria = new PanelHistoria();
	private PanelInformacja panelInformacja = new PanelInformacja();
	
	public void tworzOkno() {
		
		//tworzenie g³ównego okna aplikacji
		ramka.getContentPane().setLayout(new GridLayout(1, 1));
		
		//dodawanie zak³adek w zale¿noœci od zalogowanego u¿ytkownika
		if(uzytkownik.equals("Admin")) {
				
			zakladka.addTab("Dostêpne d³ugoœci", panelDostepnosc);
			zakladka.addTab("Dodawanie drewna", panelDodaj);
			zakladka.addTab("Wykorzystanie drewna", panelWykorzystanie);
			zakladka.addTab("Historia", panelHistoria);
			zakladka.addTab("informacja",panelInformacja);
		}
		if(uzytkownik.equals("Dyrektor")) {
			
			zakladka.addTab("Dostêpne d³ugoœci", panelDostepnosc);
			zakladka.addTab("Dodawanie drewna", panelDodaj);
			zakladka.addTab("Historia", panelHistoria);
			zakladka.addTab("informacja",panelInformacja);
			}
		if(uzytkownik.equals("Kierownik produkcji")) {
			
			zakladka.addTab("Dostêpne d³ugoœci", panelDostepnosc);
			zakladka.addTab("Wykorzystanie drewna", panelWykorzystanie);
			zakladka.addTab("Historia", panelHistoria);
			zakladka.addTab("informacja",panelInformacja);
			}
		if(uzytkownik.equals("Projektant")) {
			
			zakladka.addTab("Dostêpne d³ugoœci", panelDostepnosc);
			zakladka.addTab("Historia", panelHistoria);
			zakladka.addTab("informacja",panelInformacja);
		}
		
		
		zakladka.setBackground(Color.WHITE);	
		ramka.getContentPane().add(zakladka);
		ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ramka.setSize(580, 400);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		ramka.setLocation(dim.width/2-ramka.getSize().width/2, dim.height/2-ramka.getSize().height/2);
		
		ramka.setVisible(true);
				
	}
	
}
