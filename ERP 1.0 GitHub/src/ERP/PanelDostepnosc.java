package ERP;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

public class PanelDostepnosc extends JPanel{
	
	private JLabel lGrubosc = new JLabel("Wybierz gruboœæ[mm]:");

	private JLabel ldlugosci = new JLabel("Dostêpne d³ugoœci drewna:");
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JRadioButton guzik45 = new JRadioButton("45");
	private JRadioButton guzik60 = new JRadioButton("60");
	private String grubosc = "45";
	private ButtonGroup grupa= new ButtonGroup();
	private JButton bOdswiez = new JButton("Odœwie¿");
	private JLabel[] TabLab = new JLabel[54];
	private String[] petla1 = {"95","145","170","195","220"};
	private String[] petla2 = {"3200","3500","3800","4100","4400","4700","5000","5300"};
	private Sql s = new Sql();
	
	public PanelDostepnosc() {
		
		//tworzenie panelu odpowedzialnego za pokazywanie dostêpnoœci poszczególnych d³ugoœci drewna
		this.setBackground(Color.ORANGE);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.add(lGrubosc);
		lGrubosc.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(panel1);
		
		
		panel1.setBackground(Color.ORANGE);
		grupa.add(guzik45);
		grupa.add(guzik60);
		
		
		panel1.add(guzik45);
		panel1.add(guzik60);
		guzik45.setBackground(Color.ORANGE);
		guzik60.setBackground(Color.ORANGE);
		guzik45.setSelected(true);
		guzik45.addActionListener(new GuzikListener());
		guzik60.addActionListener(new GuzikListener());
		
		this.add(bOdswiez);
		bOdswiez.setAlignmentX(Component.CENTER_ALIGNMENT);
		bOdswiez.addActionListener(new OdswiezListener());
		
		this.add(ldlugosci);
		ldlugosci.setAlignmentX(Component.CENTER_ALIGNMENT);
		
	
		panel2.setBackground(Color.white);	
		panel2.setLayout(new GridLayout(9, 6));
		this.add(panel2);
		
		//tworzenie okieniek z danymi i wpe³nianie ich poprzez ³¹czenie siê z baz¹ danych
		
		int k = 0;
		JLabel label = new JLabel(" ");
		Border border = BorderFactory.createLineBorder(Color.ORANGE, 1);
        label.setBorder(border);
        label.setBackground(Color.LIGHT_GRAY);
        label.setOpaque(true);
        panel2.add(label);
        TabLab[k]=label;
		k++;
					
		for(int i=0; i<5; i++) {
			label = new JLabel(petla1[i]);
	        label.setBorder(border);
	        label.setBackground(Color.LIGHT_GRAY);
	        label.setOpaque(true);
			panel2.add(label);
			TabLab[k]=label;
			k++;
		}
		
		for(int i=0; i<8; i++) {
			label = new JLabel(petla2[i]);
	        label.setBorder(border);
	        label.setBackground(Color.LIGHT_GRAY);
	        label.setOpaque(true);
			panel2.add(label);
			TabLab[k]=label;
			k++;
			
			for(int j=0; j<5; j++) {
				
				label = new JLabel(Integer.toString(s.obliczDostepnosc(grubosc, petla1[j], petla2[i])));
		        label.setBorder(border);
				panel2.add(label);
				TabLab[k]=label;
				k++;
			}
			
		}
			
		
	}
	
	//odœwie¿anie okienek
	public void odswiez() {
		int k = 1;
		
		for(int i=0; i<5; i++) {
			TabLab[k].setText(petla1[i]);
			k++;
		}
		
		for(int i=0; i<8; i++) {
			TabLab[k].setText(petla2[i]);
			k++;
			
			for(int j=0; j<5; j++) {
	
				TabLab[k].setText(Integer.toString(s.obliczDostepnosc(grubosc, petla1[j], petla2[i])));
				k++;
			}
		
		
		
	}
}
	
	class GuzikListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		grubosc = e.getActionCommand();
		odswiez();
		
	}
}
	class OdswiezListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		odswiez();
		
	}
}
}
