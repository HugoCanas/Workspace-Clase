package For;

import java.util.Scanner;

/*4.	Haz un programa que lea un número entero por teclado y muestre por pantalla los múltiplos de 3 desde el 1 hasta el número introducido por teclado.
EJEMPLO:
	INTRODUCE UN NUMERO: 41
	Los múltiplos de 3 desde el 1 al 41 son: 	3 6 9 12 15 18 ......... 39
 */
public class Ejercicio04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1;
		Scanner sc;   

		sc=new Scanner(System.in); 

		System.out.println("Introduce el numero del que quieras saber los multiplos del 3: ");
		num1=sc.nextInt();	
		if(num1<3) {
			System.out.println("No existe ningun multiplo de 3 entre 1 y " +num1);
			return;
		}

		System.out.println("Los numeros multiplos del 3 del numero " +num1+ " son: ");

		for(int aux=3; aux<=num1;aux=aux+3) {
			System.out.print(aux+ " ");
		}
	} 

}


