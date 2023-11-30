package ar.unlam.pb2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ManejoDeArchivos {

	public static void guardarObjeto(String path, Object actual) throws IOException {
		// TODO Auto-generated method stub
		FileOutputStream archivo = new FileOutputStream(path);
		ObjectOutputStream flujo = new ObjectOutputStream(archivo);
		
		flujo.writeObject(actual);
		
		archivo.close();
		flujo.close();
		
	}

	public static Object leerObjetos(String path) throws IOException, ClassNotFoundException{
		// TODO Auto-generated method stub
		Object leido;
		FileInputStream archivo = new FileInputStream(path);
		ObjectInputStream flujo = new ObjectInputStream(archivo);
		
		leido = flujo.readObject();
		
		flujo.close();
		archivo.close();
		
		return leido;
	}

}
