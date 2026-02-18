package bidimensional;
/*
 * CREAR UN ARRAY PARA GESTIONAR UN TABLERO DE AJEDREZ
 * LLENARLO CON LAS PIEZAS EN SU POSICION INICIAL 
 * MOSTRARLO POR PANTALLA
 * 
 * 
 * BLANCAS
 * T C A Q K A C T 
 * P P P P P P P P
 * . . . . . . . .
 * . . . . . . . .
 * . . . . . . . .
 * . . . . . . . .
 * P P P P P P P P
 * T C A Q K A C T 
 * NEGRAS
 */

import java.util.Scanner;


public class Ejercicio01 {

	public static final int TAM = 8;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char tablero [][];
		int numeros[];
		Scanner sc;
		int filaOrigen,columnaOrigen,filaFinal,columnaFinal;

		sc=new Scanner(System.in); 


		numeros=new int [TAM];
		tablero=new char [TAM][TAM];

		numeros[0]=1;
		numeros[1]=2;
		numeros[2]=3;
		numeros[3]=4;
		numeros[4]=5;
		numeros[5]=6;
		numeros[6]=7;
		numeros[7]=8;

		tablero[0][0]='T';
		tablero[0][1]='C';
		tablero[0][2]='A';
		tablero[0][3]='Q';
		tablero[0][4]='K';
		tablero[0][5]='A';
		tablero[0][6]='C';
		tablero[0][7]='T';

		tablero[7][0]='T';
		tablero[7][1]='C';
		tablero[7][2]='A';
		tablero[7][3]='Q';
		tablero[7][4]='K';
		tablero[7][5]='A';
		tablero[7][6]='C';
		tablero[7][7]='T';

		//Inicializar el tablero 
		for(int fila=1;fila<TAM-1;fila++) { //salto de linea
			for(int col=0;col<TAM;col++) { //casilla de la lineas
				if(fila==1 || fila==6) {
					tablero[fila][col]='P';
				}else
				{
					tablero[fila][col]='.';
				}
			}
		}
		System.out.println("BLANCAS");
		System.out.println("  1 2 3 4 5 6 7 8");
		for(int fila=0,cont=0;fila<TAM;fila++,cont++) {  //salto de linea
			System.out.print(numeros[cont]+ " "); //para los numeros
			for(int col=0;col<TAM;col++) { //casilla de la lineas
				System.out.print(tablero[fila][col]+" ");
			}
			System.out.println();
		}
		System.out.println("NEGRAS");

		System.out.println();
		System.out.println();
		System.out.println();

		//************************INVERTIDO************************

		for(int fila=1;fila<TAM-1;fila++) { //salto de linea
			for(int col=0;col<TAM;col++) { //casilla de la lineas
				if(fila==1 || fila==6) {
					tablero[fila][col]='P';
				}else
				{
					tablero[fila][col]='.';
				}
			}
		}
		System.out.println("NEGRAS");
		System.out.println("  8 7 6 5 4 3 2 1");
		for(int fila=TAM-1,cont=TAM-1;fila>-1;fila--,cont--) {  //salto de linea
			System.out.print(numeros[cont]+ " "); //para los numeros
			for(int col=TAM-1;col>-1;col--) { //casilla de la lineas
				System.out.print(tablero[fila][col]+" ");
			}
			System.out.println();
		}
		System.out.println("BLANCAS");

		//PEDIR UNA JUGADA PIDIENDO ORIGEN Y DESTINO
		//ORIGEN: Fila y Columna: debe estar entre 1-8 y ademas debe haber una ficha
		//DESTINO: Fila y Columna: debe estar entre 1-8

		System.out.println("Introduce la fila de la ficha que quieres mover: ");
		filaOrigen=sc.nextInt();

		System.out.println("Introduce la columna de la ficha que quieres mover: ");
		columnaOrigen=sc.nextInt();

		while(filaOrigen<1 || filaOrigen>8 || columnaOrigen<1 || columnaOrigen>8 || tablero[filaOrigen-1][columnaOrigen-1]=='.' ) {

			System.out.println("Esa posicion no es valida, introduzca de nuevo la fila de la ficha que quieres mover: ");
			filaOrigen=sc.nextInt();

			System.out.println("Introduzcame la columna de la ficha que quieres mover de nuevo: ");
			columnaOrigen=sc.nextInt();
		}

		System.out.println("Introduce la fila a la que quieres mover la ficha: ");
		filaFinal=sc.nextInt();


		System.out.println("introduce la columna a la que quieres mover la ficha: ");
		columnaFinal=sc.nextInt();

		while(filaFinal<1 || filaFinal>8 || columnaFinal<1 || columnaFinal>8) {

			System.out.println("Esa posicion no es valida, introduzca de nuevo la fila a la que quieres movwe la ficha: ");
			filaFinal=sc.nextInt();

			System.out.println("Introduzcame la columna a la que quieres mover la ficha: ");
			columnaFinal=sc.nextInt();
		}
		tablero[filaFinal-1][columnaFinal-1]=tablero[filaOrigen-1][columnaOrigen-1];
		tablero[filaOrigen-1][columnaOrigen-1]='.';

		//VOLVER A MOSTRAR EL TABLERO

		System.out.println("BLANCAS");
		System.out.println("  1 2 3 4 5 6 7 8");
		for(int fila=0,cont=0;fila<TAM;fila++,cont++) {  //salto de linea
			System.out.print(numeros[cont]+ " "); //para los numeros
			for(int col=0;col<TAM;col++) { //casilla de la lineas
				System.out.print(tablero[fila][col]+" ");
			}
			System.out.println();
		}
		System.out.println("NEGRAS");

	}
}
