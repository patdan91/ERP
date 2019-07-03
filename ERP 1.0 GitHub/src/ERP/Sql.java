package ERP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//klasa z poleceniami SQL wykorzystanymi w aplikacji
public class Sql{

	private Connection con = null;
    private Statement st = null;
    private ResultSet rs = null;

    private String url = "jdbc:mysql://localhost:3306/erp?autoReconnect=true&useSSL=false";
    private String user = "root";
    private String password = "wiazar";
    
    
    
	public int obliczDostepnosc(String grubosc, String szerokosc, String dlugosc) {
	
	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	        con = DriverManager.getConnection(url, user, password);
	        System.out.println("Database connected!");
	        st = con.createStatement();
	        rs = st.executeQuery("SELECT SUM(`"+dlugosc+"`) FROM " +grubosc+"x"+szerokosc+";");
	        System.out.println("SELECT SUM(`"+dlugosc+"`) FROM " +grubosc+"x"+szerokosc+";");
	        
	        if(rs.first()){	     
	        	return(rs.getInt(1));
	        	
	        }
	        else {
	        	return(0);
	        }  
	       
	    }

	    catch (SQLException e) {
	        
	    System.out.println(e);
	    return(-1);
	    } 
	    catch (ClassNotFoundException e) {
	    	
	    System.out.println(e);
	    return(-1);
		}
	    
	    	    
	}
	
	public int sprawdzDostawe1(String dostawa) {
		
		
	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	        con = DriverManager.getConnection(url, user, password);
	        System.out.println("Database connected!");
	        st = con.createStatement();
	        rs = st.executeQuery("SELECT * FROM `dostawa` where `numer_dostawy` = '"+ dostawa +"';");
	        
	        if(rs.first()){	     
	        	return(1);
	        	
	        }
	        else {
	        	return(0);
	        }  
	      
	    }

	    catch (SQLException e) {
	        
	    System.out.println(e);
	    return(-1);
	    } 
	    catch (ClassNotFoundException e) {
	    	
	    System.out.println(e);
	    return(-1);
		}
	    
	    	    
	}
	
	public int sprawdzDostawe2(String grubosc, String szerokosc, String dostawa) {
		
		
	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	        con = DriverManager.getConnection(url, user, password);
	        System.out.println("Database connected!");
	        st = con.createStatement();
	        rs = st.executeQuery("SELECT * FROM `" +grubosc+"x"+szerokosc+"` where `numer_dostawy` = '"+ dostawa +"';");
	        
	        if(rs.first()){	     
	        	return(1);
	        	
	        }
	        else {
	        	return(0);
	        }  
	      
	    }

	    catch (SQLException e) {
	        
	    System.out.println(e);
	    return(-1);
	    } 
	    catch (ClassNotFoundException e) {
	    	
	    System.out.println(e);
	    return(-1);
		}
	    
	    	    
	}
		
	public int sprawdzPrace1(String praca) {
		
		
	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	        con = DriverManager.getConnection(url, user, password);
	        System.out.println("Database connected!");
	        st = con.createStatement();
	        rs = st.executeQuery("SELECT * FROM `praca` where `numer_pracy` = '"+ praca +"';");
	        
	        if(rs.first()){	     
	        	return(1);
	        	
	        }
	        else {
	        	return(0);
	        }  
	      
	    }

	    catch (SQLException e) {
	        
	    System.out.println(e);
	    return(-1);
	    } 
	    catch (ClassNotFoundException e) {
	    	
	    System.out.println(e);
	    return(-1);
		}
	    
	    	    
	}
	
	public int sprawdzPrace2(String grubosc, String szerokosc, String praca) {
		
		
	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	        con = DriverManager.getConnection(url, user, password);
	        System.out.println("Database connected!");
	        st = con.createStatement();
	        rs = st.executeQuery("SELECT * FROM `" +grubosc+"x"+szerokosc+"` where `numer_pracy` = '"+ praca +"';");
	        
	        if(rs.first()){	     
	        	return(1);
	        	
	        }
	        else {
	        	return(0);
	        }  
	      
	    }

	    catch (SQLException e) {
	        
	    System.out.println(e);
	    return(-1);
	    } 
	    catch (ClassNotFoundException e) {
	    	
	    System.out.println(e);
	    return(-1);
		}
	    
	    	    
	}
	
	public void dodajDostawe(String dostawa, String data) {
		try {
	        Class.forName("com.mysql.jdbc.Driver");
	        con = DriverManager.getConnection(url, user, password);
	        System.out.println("Database connected!");
	        st = con.createStatement();   
	        st.executeUpdate("INSERT INTO `dostawa` values('"+dostawa+"','"+data+"');");        
	        st.close();
	        
	    }

	     catch (SQLException e) {
	     
	    	 System.out.println(e);
	    	

	    } 
	    catch (ClassNotFoundException e) {
	    	
	    	System.out.println(e);
	    	
		} 
	}

	public void dodajPrace(String praca, String data) {
		try {
	        Class.forName("com.mysql.jdbc.Driver");
	        con = DriverManager.getConnection(url, user, password);
	        System.out.println("Database connected!");
	        st = con.createStatement();   
	        st.executeUpdate("INSERT INTO `praca` values('"+praca+"','"+data+"');");        
	        st.close();
	        
	    }

	     catch (SQLException e) {
	     
	    	 System.out.println(e);
	    	

	    } 
	    catch (ClassNotFoundException e) {
	    	
	    	System.out.println(e);
	    	
		} 
	}
	
	public String dodajDrewno(String grubosc, String szerokosc, String dostawa, String dlugosc, String ilosc, String data) {
		try {
	        Class.forName("com.mysql.jdbc.Driver");
	        con = DriverManager.getConnection(url, user, password);
	        System.out.println("Database connected!");
	        st = con.createStatement();   
	        st.executeUpdate("INSERT INTO `" +grubosc+"x"+szerokosc+"`(`"+
	    			dlugosc+"`,`numer_dostawy`) VALUES ('"+ilosc+"','"+dostawa+"'); ");        
	        st.close();
	        return(dostawa+ " - "+
					data+ " - "+
					grubosc+"x"+
					szerokosc+"x"+
					dlugosc+"x"+
					ilosc+
					"\n"							
	        		);
	        
	    }

	     catch (SQLException e) {
	    	 return(e.getMessage());
	    	

	    } 
	    catch (ClassNotFoundException e) {	    	
	    	return(e.getMessage());
	    	
		} 
	}

	public String odejmijDrewno(String grubosc, String szerokosc, String praca, String dlugosc, String ilosc, String data) {
		try {
	        Class.forName("com.mysql.jdbc.Driver");
	        con = DriverManager.getConnection(url, user, password);
	        System.out.println("Database connected!");
	        st = con.createStatement();   
	        st.executeUpdate("INSERT INTO `" +grubosc+"x"+szerokosc+"`(`"+
	    			dlugosc+"`,`numer_pracy`) VALUES ('"+ilosc+"','"+praca+"'); ");        
	        st.close();
	        return(praca+ " - "+
					data+ " - "+
					grubosc+"x"+
					szerokosc+"x"+
					dlugosc+"x"+
					ilosc+
					"\n"							
	        		);
	        
	    }

	     catch (SQLException e) {
	    	 return(e.getMessage());
	    	

	    } 
	    catch (ClassNotFoundException e) {	    	
	    	return(e.getMessage());
	    	
		} 
	}
	
	public String aktualizujDrewno(String grubosc, String szerokosc, String dostawa, String dlugosc, String ilosc, String data) {
		
		try {
	        Class.forName("com.mysql.jdbc.Driver");
	        con = DriverManager.getConnection(url, user, password);
	        System.out.println("Database connected!");
	        st = con.createStatement();
	        st.executeUpdate("UPDATE `" +grubosc+"x"+szerokosc+"` SET `"+dlugosc+"`='"+ilosc+"' WHERE `numer_dostawy`='"+dostawa+"'; ");
	        st.close();
	        return(dostawa+ " - "+
					data+ " - "+
					grubosc+"x"+
					szerokosc+"x"+
					dlugosc+"x"+
					ilosc+
					"\n"							
	        		);
	        
	    }

	     catch (SQLException e) {
	    	 return(e.getMessage());
	    	

	    } 
	    catch (ClassNotFoundException e) {    	
	    	return(e.getMessage());
		} 
		}

	public String aktualizujPrace(String grubosc, String szerokosc, String praca, String dlugosc, String ilosc, String data) {
		
		try {
	        Class.forName("com.mysql.jdbc.Driver");
	        con = DriverManager.getConnection(url, user, password);
	        System.out.println("Database connected!");
	        st = con.createStatement();
	        st.executeUpdate("UPDATE `" +grubosc+"x"+szerokosc+"` SET `"+dlugosc+"`='"+ilosc+"' WHERE `numer_pracy`='"+praca+"'; ");
	        st.close();
	        return(praca+ " - "+
					data+ " - "+
					grubosc+"x"+
					szerokosc+"x"+
					dlugosc+"x"+
					ilosc+
					"\n"							
	        		);
	        
	    }

	     catch (SQLException e) {
	    	 return(e.getMessage());
	    	

	    } 
	    catch (ClassNotFoundException e) {    	
	    	return(e.getMessage());
		} 
		}
	
}
