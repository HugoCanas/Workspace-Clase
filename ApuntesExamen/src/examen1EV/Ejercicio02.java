package examen1EV;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {
		/*PROGRAMA QUE PIDA POR TECLADO LOS NOMBRES DE LOS FICHEROS ORIGEN Y DESTINO
		 * EL PROGRAMA REALIZARÁ UNA COPIA DEL ORIGEN SOBRE EL DESTINO
		 * COSAS A CONTROLAR:
		 * 		SI EL FICHERO ORIGEN NO EXISTE => NO SE PUEDE HACER NADA (SE ACABA EL PROGRAMA)
		 * 		SI EL FICHERO DESTINO EXISTE => AVISO Y PREGUNTAR AL USUARIO
		 * 			SI EL USUARIO QUIERE CONTINUAR => REALIZAR LA COPIA
		 * 			SI NO => NO HACER LA COPIA (SE ACABA EL PROGRAMA)
		 */
		//DECLARACIÓN
		File f;
		Scanner scTeclado, scOrigen;
		PrintWriter pw;
		String strOrigen, strDestino, linea;
		
		//INSTANCIAR
		scTeclado=new Scanner(System.in);
		
		//PEDIR POR TECLADO NOMBRES DE FICHEROS ORIGEN Y DESTINO
		System.out.print("introduce el fichero origen: ");
		strOrigen=scTeclado.nextLine();
		System.out.print("introduce el fichero destino: ");
		strDestino=scTeclado.nextLine();
		f=new File(strDestino);
		
		//SI NO EXISTE EL ORIGEN: SE ACABA EL PROGRAMA
		try {
			scOrigen=new Scanner(new File(strOrigen));
			//NO HA HABIDO ERROR, POR LO TANTO EL FICHERO EXISTE
			//si existe el destino: preguntar si queremos sobreescribir
			if(f.exists()) {
				System.out.print("El destino existe. ¿Quieres sobreescriobir? (S/N): ");
				String resp=scTeclado.next();
				if(resp.equalsIgnoreCase("S")) {
					//HACER LA COPIA
					pw=new PrintWriter(f);
					while (scOrigen.hasNext()) {
						linea=scOrigen.nextLine();
						pw.println(linea);
					}
					System.out.println("Copia realizada con exito");
					pw.close();
					scOrigen.close();
				}else { 
					System.exit(0);
				}
			}else {
				//TAMBIEN HAY QUE REALIZAR LA COPIA
				pw=new PrintWriter(f);
				while (scOrigen.hasNext()) {
					linea=scOrigen.nextLine();
					pw.println(linea);
				}
				System.out.println("Copia realizada con exito");
				pw.close();
				scOrigen.close();
			}
		} catch (FileNotFoundException e) {
			//EL FICHERO ORIGEN NO EXISTE: MENSAJE DE AVISO Y SE ACABA EL PROGRAMA
			e.printStackTrace();
			System.out.println("No se ha encontrado el archivo origen...");
			System.exit(0);
		}
	}

}







