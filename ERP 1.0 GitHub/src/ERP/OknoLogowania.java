package ERP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class OknoLogowania {
	
	private JFrame ramka = new JFrame("Okno logowania");
	private JPanel panel = new JPanel();
	private JLabel podaj = new JLabel("Wybierz u¿ytkownika i podaj has³o:");
	private String[] uzytkownicy = {"Admin", "Dyrektor", "Kierownik produkcji", "Projektant"};
	private JComboBox<String> login = new JComboBox<String>(uzytkownicy);
	private JPasswordField haslo = new JPasswordField();
	private JLabel komunikat = new JLabel(" ");
	private JButton zaloguj = new JButton("Zaloguj");
	
	
	public void tworzOkno() {
		
		//tworzenie okna logowania	
		ramka.getContentPane().add(BorderLayout.CENTER, panel);
		panel.setBackground(Color.white);		
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(podaj);	
		podaj.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(login);	
		login.setAlignmentX(Component.CENTER_ALIGNMENT);
		login.setBackground(Color.orange);
		panel.add(haslo);	
		haslo.setAlignmentX(Component.CENTER_ALIGNMENT);
		haslo.setBackground(Color.white);
		haslo.addActionListener(new ZalogujListener());
		panel.add(komunikat);	
		komunikat.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(zaloguj);	
		zaloguj.setAlignmentX(Component.CENTER_ALIGNMENT);
		zaloguj.addActionListener(new ZalogujListener());
		
		ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ramka.setSize(300, 160);
		
		//umiejscawianie okna na œrodku ekranu
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		ramka.setLocation(dim.width/2-ramka.getSize().width/2, dim.height/2-ramka.getSize().height/2);
		
		ramka.setVisible(true);
		
	}
	
	class ZalogujListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		String zlogin= (String) login.getSelectedItem();
		String zhaslo= haslo.getText();
	
		//sprawdzenie poprawnoœci wpisaneho has³a
		if((zlogin.equals("Admin") && zhaslo.equals("admin"))
				||(zlogin.equals("Dyrektor") && zhaslo.equals("dyrektor"))
				||(zlogin.equals("Kierownik produkcji") && zhaslo.equals("kierownikprodukcji"))
				||(zlogin.equals("Projektant") && zhaslo.equals("projektant"))) {
			
			ramka.dispose();
			GlowneOkno okno = new GlowneOkno();
			okno.uzytkownik= zlogin;
			okno.tworzOkno();
			
		}
		else {
			komunikat.setText("Niepoprawne dane");
			komunikat.setForeground(Color.red);
		}
		}
		
	}
	
	
	
}

