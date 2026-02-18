package For;

import java.util.Scanner;

/*Leer numeros enteros por teclado hasta que se teclee el -99 
y mostrar por pantalla cuantos positivos, cuantos negativos y cuantos nules (0)
SE HAN INTRODUCIDO
EJEMPLO:
	Introduce un nuevo numero (-99 oara terminar): 25
	Introduce un nuevo numero (-99 oara terminar): 12
	Introduce un nuevo numero (-99 oara terminar): 0
	Introduce un nuevo numero (-99 oara terminar): -25
	Introduce un nuevo numero (-99 oara terminar): 51
	Introduce un nuevo numero (-99 oara terminar): -56
	Introduce un nuevo numero (-99 oara terminar): 0
	Introduce un nuevo numero (-99 oara terminar): -99

Has introducido 3 numeros positivos
Has introducido 2 numeros positivos
Has introducido 2 numeros nulos
 */
public class Ejercicio05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=0,neg=0,pos=0,nul=0;
		Scanner sc;

		sc=new Scanner(System.in); 

		while(num!=-99) { 
			System.out.println("Introduce un numero  (-99 para terminar)");
			num=sc.nextInt();

			if(num==0) {
				nul++;
			}
			else if(num>0) {
				pos++;
			}else if(num<0 && num!=-99) {
				neg++;
			}
		}
		System.out.println("Has introducido "+pos+ " numeros positivos");
		System.out.println("Has introducido "+neg+ " numeros negativos");
		System.out.println("Has introducido "+nul+ " numeros nulos");
	}
}
