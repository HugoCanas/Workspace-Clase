package For;

import java.util.Scanner;

/*PROGRAMA QUE LEA UN NUMERO ENTERO POR TECLADO Y MUESTRE SU TABLA DE MULTIPLICAR DEL 1 AL 10:
 * EJEMPLO:
 * Introduce un numero para calcular su tabla de multiplicar: 6
 * 6 x 1 = 6
 * 6 x 2 = 12
 * 6 x 3 = 18
 * 6 x 4 = 24
 * 6 x 5 = 30
 * 6 x 6 = 36
 * 6 x 7 = 42
 * 6 x 8 = 48
 * 6 x 9 = 54
 * 6 x 10 = 60
 */
public class Ejercicio09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num;
		Scanner sc;

		sc=new Scanner(System.in); 

		System.out.println("Introduce un numero para calcular su tabla de multiplicar: ");
		num=sc.nextInt();

		for(int cont=1; cont<=10; cont++) {
			System.out.println(num+ " x " +cont+ " = " +num*cont);
		}

	}

}
