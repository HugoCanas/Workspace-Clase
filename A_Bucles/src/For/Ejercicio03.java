package For;

import java.util.Scanner;

/*3.Programa que lea dos números por teclado y muestre por pantalla todos los números que hay entre ambos,
 *  empezando por el menor hasta llegar al mayor.*/

public class Ejercicio03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1,num2;
		Scanner sc;

		sc=new Scanner(System.in); 

		System.out.println("Introduceme tu primer numero: ");
		num1=sc.nextInt();
		
		
		System.out.println("Introduceme tu segundo numero: ");
		num2=sc.nextInt();
		
		for(num1=num1,num2=num2;num1<num2;num1++) {
			System.out.print(num1+ ",");
		}
		
		for(num1=num1,num2=num2;num1>num2;num2++) {
			System.out.print(num2+ ",");
		}
	}
}
