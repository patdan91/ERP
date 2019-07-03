package ERP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTextArea;
//klasa s³u¿¹ca do zapisów i odczytów z pliku historia.txt
public class Historia {
	
	public void zapiszHistorie(String zapis) {
		
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter("historia.txt", true));
			writer.append(zapis);
		    writer.close();
						
		} catch (IOException e) {
			
			System.out.println(e);
		}
	}
public JTextArea odczytajHistorie() {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("historia.txt"));
			String st; 
			JTextArea historia = new JTextArea();
			while ((st = reader.readLine()) != null) {
			historia.append(st+"\n");
			}
		    reader.close();
		    return(historia);
						
		} catch (IOException e) {
			
			JTextArea historia = new JTextArea();
			historia.append(e.getMessage());
			return(historia);
		}
	}
	
}
