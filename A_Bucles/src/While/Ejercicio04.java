package While;

import java.util.Scanner;

/*3.	Programa que lea dos números por teclado y muestre por pantalla todos los números que hay entre ambos,
 *  empezando por el menor hasta llegar al mayor.
 */

public class Ejercicio04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1,num2=0;
		Scanner sc;

		sc=new Scanner(System.in); 

		System.out.println("Introduceme tu primer numero: ");
		num1=sc.nextInt();

		while(num1==num2) {
			System.out.println("Introduceme tu segundo numero: ");
			num2=sc.nextInt();
		}

		while(num1!=num2) {
			if(num1>num2) {
				System.out.print(+num2+ ","); 
				num2++;
			}else{
				System.out.print(+num1+ ",");
				num1++;
			}
		}
	}
}
