package contraseña;
import java.util.Scanner;

public class validarcontraseña {
	public static void main(String []args){	         
		// Especificar_el_n�mero_m�ximo_de_letras_en_una_contrase�a
		final int MAX=8;
	     
		// Especificando_el_n�mero_de_letras_may�sculas_en_la_contrase�a
		final int MIN_Uppercase=2;
		
		// Especificando_el_m�nimo_de_min�sculas_en_la_contrase�a
	    final int MIN_Lowercase=2;
	    
	    // Especificando_el_n�mero_de_d�gitos_en_una_contrase�a
        final int NUM_Digits=2;
        
        // Especificar_el_n�mero_m�nimo_de_letras_en_may�sculas_y_min�sculas
        final int Special=2;
        
        // Contar_el_n�mero_de_letras_may�sculas_en_una_contrase�a
	    int uppercaseCounter=0;
	    
	    // Contador_de_letras_min�sculas_en_una_contrase�a
        int lowercaseCounter=0;
        
        // Contar_d�gitos_en_una_contrase�a
	    int digitCounter=0;
	    
	    // contar_letras_de_may�sculas_y_min�sculas_en_una_contrase�a
	    int specialCounter=0;
	             
	    // Toma_la_entrada_de_la_contrase�a_del_usuario
	            
	    System.out.println("ingresa la contrase�a pa\n");
	            
	    Scanner teclado = new Scanner(System.in);

	    // Toma_la_entrada_de_contrase�a_del_usuario_y_gu�rdela_en_la_contrase�a_de_cadena
	            
	    String password = teclado.nextLine();
	             
	    for (int i=0; i < password.length(); i++ ) {
	    	char c = password.charAt(i);
	        if(Character.isUpperCase(c)) 
	        	uppercaseCounter++;
	        else if(Character.isLowerCase(c)) 
	        	lowercaseCounter++;
	        else if(Character.isDigit(c)) 
	        	digitCounter++;     
	        if(c>=33&&c<=46||c==64){
	        	specialCounter++;
	        }
	                    
	    }
	             
	    if (password.length() >= MAX && uppercaseCounter >= MIN_Uppercase && lowercaseCounter >= MIN_Lowercase && digitCounter >= NUM_Digits && specialCounter >= Special) { 
	    	System.out.println("Contrase�a v�lida uwu");
	    }
	    else {
	    	System.out.println("Su contrase�a no contiene lo siguiente:");
	    	if(password.length() < MAX)
	    		System.out.println("Al menos 8 car�cteres");
	    	if (lowercaseCounter < MIN_Lowercase) 
	    		System.out.println("Letras min�sculas m�nimas");
	        if (uppercaseCounter < MIN_Uppercase) 
	        	System.out.println("Letras may�sculas m�nimas");
	        if(digitCounter < NUM_Digits) 
	        	System.out.println("N�mero m�nimo de d�gitos num�ricos");
	        if(specialCounter < Special)
	        	System.out.println("La contrase�a debe contener al menos 3 caracteres especiales");               
	    }
	    teclado.close();
	}
}
