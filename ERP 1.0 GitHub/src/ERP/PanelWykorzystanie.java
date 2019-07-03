package ERP;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import ERP.PanelDodaj.DodajListener;

public class PanelWykorzystanie extends JPanel{

	private JLabel lNumer = new JLabel("Podaj numer projektu");
	private JTextField tNumer = new JTextField("");
	private Date data = new Date();
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
	private JLabel lData = new JLabel("Data produkcji:");
	private JTextField tData = new JTextField(format.format(data));
	private JTextArea poleTekstowe = new JTextArea(200,200);
	private JScrollPane sPoleTekstowe = new JScrollPane(poleTekstowe);
	private JLabel lGrubosc = new JLabel("Wybierz gruboœæ[mm]:");
	private JLabel lSzerokosc = new JLabel("Wybierz szerokoœæ[mm]:");
	private JLabel lDlugosc = new JLabel("Wybierz d³ugoœæ[mm]:");
	private JLabel lIlosc = new JLabel("Podaj iloœæ [szt.]:");
	private String[] grubosc = {"45", "60"};
	private String[] szerokosc = {"95", "145", "170", "195", "220"};
	private String[] dlugosc = {"3200", "3500", "3800", "4100", "4400", "4700", "5000", "5300"};
	private JComboBox<String> cGrubosc = new JComboBox<String>(grubosc);
	private JComboBox<String> cSzerokosc  = new JComboBox<String>(szerokosc);
	private JComboBox<String> cDlugosc = new JComboBox<String>(dlugosc);
	private JTextField tIlosc = new JTextField();
	private JPanel panel = new JPanel();
	
	private JButton dodaj = new JButton("Dodaj");
	
	private Sql s = new Sql();
	private Historia historia = new Historia();
	
	//tworzenie panelu z mo¿liwoœci¹ dodawanie prac. Drewno w nich wykorzystane jest odejmowane od dostêpnej puli 
	public PanelWykorzystanie() {
		this.setBackground(Color.white);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.add(lNumer);
		lNumer.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(tNumer);
		tNumer.setAlignmentX(Component.CENTER_ALIGNMENT);
		tNumer.setBackground(Color.orange);
		this.add(lData);
		lData.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(tData);
		tData.setAlignmentX(Component.CENTER_ALIGNMENT);
		tData.setBackground(Color.orange);
		tData.setEditable(false);
		
		this.add(lGrubosc);
		lGrubosc.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(cGrubosc);
		cGrubosc.setAlignmentX(Component.CENTER_ALIGNMENT);
		cGrubosc.setBackground(Color.ORANGE);
		
		this.add(lSzerokosc);
		lSzerokosc.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(cSzerokosc);
		cSzerokosc.setAlignmentX(Component.CENTER_ALIGNMENT);
		cSzerokosc.setBackground(Color.ORANGE);
		
		this.add(lDlugosc);
		lDlugosc.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(cDlugosc);
		cDlugosc.setAlignmentX(Component.CENTER_ALIGNMENT);
		cDlugosc.setBackground(Color.ORANGE);
		
		this.add(lIlosc);
		lIlosc.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(tIlosc);
		tIlosc.setAlignmentX(Component.CENTER_ALIGNMENT);
		tIlosc.setBackground(Color.ORANGE);
		
		this.add(sPoleTekstowe);
		sPoleTekstowe.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		sPoleTekstowe.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
		poleTekstowe.setEditable(false);
		poleTekstowe.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		panel.setBackground(Color.white);
		this.add(panel);
		
		panel.add(dodaj);
		dodaj.addActionListener(new DodajListener());
		
	}
	
	public boolean isInteger( String liczba ) {
	    try {
	        Integer.parseInt( liczba );
	        return true;
	    }
	    catch( Exception e ) {
	   
	        return false;
	    }
	}

	
	class DodajListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//sprawdzenie prowid³owej iloœci wprowadzonego drewna oraz czy wprowadzono numer pracy
			//sprawdzenie czy praca o podany numerze jest ju¿ w tabeli "praca". Jeœli nie to dodajemy rekord. Nastêpnie sprawdzana jest tabela z konkretnym przekrojem drewna.
			// Jeœli w tabeli znajduje siê ju¿ rekord z kluczem obcym o numerze pracy to rekord jest aktualizowany, jeœli nie to rekord jest dodawany.
			
			if(isInteger(tIlosc.getText())&& !tNumer.getText().isEmpty()) {
			String zapis;
			if(s.sprawdzPrace2(grubosc[cGrubosc.getSelectedIndex()], szerokosc[cSzerokosc.getSelectedIndex()], tNumer.getText())==1) {
				zapis= s.aktualizujPrace(grubosc[cGrubosc.getSelectedIndex()], szerokosc[cSzerokosc.getSelectedIndex()], tNumer.getText(), dlugosc[cDlugosc.getSelectedIndex()],"-"+tIlosc.getText(), tData.getText());
				poleTekstowe.append(zapis);
				historia.zapiszHistorie(zapis);
			}
			else {
				if(s.sprawdzPrace1(tNumer.getText())==1) {
					zapis= s.odejmijDrewno(grubosc[cGrubosc.getSelectedIndex()], szerokosc[cSzerokosc.getSelectedIndex()], tNumer.getText(), dlugosc[cDlugosc.getSelectedIndex()], "-"+tIlosc.getText(), tData.getText());
					poleTekstowe.append(zapis);
					historia.zapiszHistorie(zapis);
				
				}
				else {
					s.dodajPrace(tNumer.getText(), tData.getText());
					zapis= s.odejmijDrewno(grubosc[cGrubosc.getSelectedIndex()], szerokosc[cSzerokosc.getSelectedIndex()], tNumer.getText(), dlugosc[cDlugosc.getSelectedIndex()], "-"+tIlosc.getText(), tData.getText());
					poleTekstowe.append(zapis);
					historia.zapiszHistorie(zapis);
				}
				
			}
			
			
			
			}
			else {
				
				poleTekstowe.append("Nieprawid³owa wartoœæ \n");
			}
		}
	
	}	
	
}
