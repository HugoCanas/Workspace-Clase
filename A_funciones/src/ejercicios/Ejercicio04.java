package ejercicios;

import java.util.Scanner;

public class Ejercicio04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int option,resultado=0,num;
		Scanner sc;

		sc=new Scanner(System.in);

		do {
			System.out.println("Bienvenido al programa, indique que quieres hacer");
			System.out.println("1.Sumar pares");
			System.out.println("2.Sumar impares");
			System.out.println("3.Sumar todos (impar & par)");
			System.out.println("4.Fin de programa");
			option=sc.nextInt();


			switch(option) {
			case 1:
				resultado=0;
				do {
					System.out.println("Introduce el numero par que quieras sumar (0 para salir): ");
					num=sc.nextInt();	
					if(num%2==0) {
						resultado+=num;	
					}
				}while(num!=0);
				System.out.println("El resultado de la suma de todos los numeros pares es "+resultado);
				System.out.println();
				break;

			case 2:
				resultado=0;
				do {
					System.out.println("Introduce el numero impar que quieras sumar (0 para salir): ");
					num=sc.nextInt();	
					if(num%2!=0) {
						resultado+=num;	
					}
				}while(num!=0);
				System.out.println("El resultado de la suma de todos los numeros impares es "+resultado);
				System.out.println();
				break;

			case 3:
				resultado=0;
				do {
					System.out.println("Introduce el numero  que quieras sumar (0 para salir): ");
					num=sc.nextInt();	
					resultado+=num;	
				}while(num!=0);
				System.out.println("El resultado de la suma de todos los numeros  es "+resultado);
				System.out.println();
				break;

			case 4:
				System.out.println("Gracias por su visita");
				break;
			}
		}while(option!=4);
	}

}
