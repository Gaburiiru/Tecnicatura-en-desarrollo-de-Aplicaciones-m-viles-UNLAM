package contraseña;
import java.util.Scanner;

public class validarContraseña {
	public static void main(String []args){	         
		// Especificar_el_número_máximo_de_letras_en_una_contraseña
		final int MAX=8;
	     
		// Especificando_el_número_de_letras_mayúsculas_en_la_contraseña
		final int MIN_Uppercase=2;
		
		// Especificando_el_mínimo_de_minúsculas_en_la_contraseña
	    final int MIN_Lowercase=2;
	    
	    // Especificando_el_número_de_dígitos_en_una_contraseña
        final int NUM_Digits=2;
        
        // Especificar_el_número_mínimo_de_letras_en_mayúsculas_y_minúsculas
        final int Special=2;
        
        // Contar_el_número_de_letras_mayúsculas_en_una_contraseña
	    int uppercaseCounter=0;
	    
	    // Contador_de_letras_minúsculas_en_una_contraseña
        int lowercaseCounter=0;
        
        // Contar_dígitos_en_una_contraseña
	    int digitCounter=0;
	    
	    // contar_letras_de_mayúsculas_y_minúsculas_en_una_contraseña
	    int specialCounter=0;
	             
	    // Toma_la_entrada_de_la_contraseña_del_usuario
	            
	    System.out.println("ingresa la contraseña pa\n");
	            
	    Scanner teclado = new Scanner(System.in);

	    // Toma_la_entrada_de_contraseña_del_usuario_y_guárdela_en_la_contraseña_de_cadena
	            
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
	    	System.out.println("Contraseña válida uwu");
	    }
	    else {
	    	System.out.println("Su contraseña no contiene lo siguiente:");
	    	if(password.length() < MAX)
	    		System.out.println("Al menos 8 carácteres");
	    	if (lowercaseCounter < MIN_Lowercase) 
	    		System.out.println("Letras minúsculas mínimas");
	        if (uppercaseCounter < MIN_Uppercase) 
	        	System.out.println("Letras mayúsculas mínimas");
	        if(digitCounter < NUM_Digits) 
	        	System.out.println("Número mínimo de dígitos numéricos");
	        if(specialCounter < Special)
	        	System.out.println("La contraseña debe contener al menos 3 caracteres especiales");               
	    }
	    teclado.close();
	}
}
