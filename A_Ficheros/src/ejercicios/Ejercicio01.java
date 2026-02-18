
package ejercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejercicio01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scTeclado,scFich;
		String strLinea, strFichero;
		int a;
		
		scTeclado= new Scanner(System.in);

		//PEDIR NOMBRE DEL FICHERO POR TELCADO
		System.out.println("Introduceme el nombre del fichero que quieras");
		strFichero=scTeclado.nextLine();
		
		
		try {
			scFich= new Scanner(new File(strFichero));
			while(scFich.hasNext()){
				strLinea=scFich.nextLine();
				System.out.println(strLinea);
			}
		}catch (FileNotFoundException e) {
			//e.printStackTrace();
			System.out.println("No se ha encontrado el fichero");
		}
		//FUNCIONA
	}

}
