import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejercicio3 {
	public static final int TAM = 1000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scFich;
		String strJuego;
		int precio;
		int suma=0;

		System.out.println("LISTADO DE LOS JUEGOS COMPRADOS: ");
		try {
			scFich= new Scanner(new File("Juegos.txt"));
			while(scFich.hasNext()){
				if(scFich.hasNextInt()){
					precio=+scFich.nextInt();
					suma = suma+precio;
				}else {
					strJuego=scFich.nextLine();
					System.out.print(strJuego+",");
				}
			}
		}catch (FileNotFoundException e) {
			//e.printStackTrace();
			System.out.println("No se ha encontrado el fichero");
		}


		System.out.println();
		System.out.println("PRECIO TOTAL: "+suma+ "€");
	}

}
