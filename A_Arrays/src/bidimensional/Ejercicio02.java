package bidimensional;

import java.util.Scanner;

/*TENEMOS UN ARRAY DE NUMEROS ENTEROS DE 5 FILAS Y 10 COLUMNAS
 * LLENARLO CON NUMEROS ALEATORIOS DE DOS DIGITOS
 * MOSTRARLO POR PANTALA CON LAS FILAS NUMERADAS
 * PEDIR POR TECLADO DOS NUMEROS DE CILA E INTECAMBIAR SUS CONTENIDOS (LOS DE LA FILA COMPLETA)
 * VOLVER A MOSTRAR EL ARRAY 
 * 
 * Ejemplo:
 * 	Fila 1: 12 15 16 18 19 18 19 35 35 45
 *  Fila 2: 14 25 98 78 45 25 35 36 25 67
 *  ....
 *  Fila 5: 95 94 23 65 98 87 45 21 54 89
 *  introduce las filas a intercambiar:
 *  	Fila 1: 2
 *  	Fila 2: 5
 *  El array queda asi:
 *   Fila 1: 12 15 16 18 19 18 19 35 35 45
 *   Fila 2: 95 94 23 65 98 87 45 21 54 89
 *   ... 
 *   Fila 5: 95 94 23 65 98 87 45 21 54 67
 */
public class Ejercicio02 {
	public static int FILA=5;
	public static int COLUMNA=10;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc;
		int numeros[][],aux[][],num,fila1,fila2;

		sc=new Scanner(System.in); 
		
		numeros=new int [FILA][COLUMNA];
		aux=new int [FILA][COLUMNA];

		for(int pos=0;pos<=FILA-1;pos++) {
			System.out.print("Fila "+ (pos+1)+ ": ");

			for(int posi=0;posi<=COLUMNA-1;posi++) {
				num = (int)(Math.random() * 90+10);
				numeros[pos][posi]=num;
				System.out.print(numeros[pos][posi]+ " ");
			}
			System.out.println();
		}

		do {

			System.out.println("Introduce el numero de las filas a intercambiar: ");
			System.out.println("Fila: ");
			fila1=sc.nextInt();

			System.out.println("Fila: ");
			fila2=sc.nextInt();
		}while(fila1<1 || fila1>FILA || fila2<1 || fila2>FILA);


		for(int posi=0;posi<=COLUMNA-1;posi++) {
			aux[fila1][posi]=numeros[fila1-1][posi];
			numeros[fila1-1][posi]=numeros[fila2-1][posi];
			numeros[fila2-1][posi]=aux[fila1][posi];
		}

		System.out.println("El array queda asi: ");
		for(int pos=0;pos<=FILA-1;pos++) {
			System.out.print("Fila "+ (pos+1)+ ": ");
			for(int posi=0;posi<=COLUMNA-1;posi++) {
				System.out.print(numeros[pos][posi]+ " ");
			}
			System.out.println();
		}
	}
}
