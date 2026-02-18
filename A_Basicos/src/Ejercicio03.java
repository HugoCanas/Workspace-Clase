/*LEER DOS NUMEROS ENTEROS POR TECLADO Y GuARDALOS EN DOS VARIABLES.
 * A CONINUACION MOSTRAR POR PANTALLA SUS VALORES.
 * A CONTINUACION INTERCAMBIAR SUS VALORES DE FORMA QUE LA PRIMERA VARIABLE CONTENGA EL VALOR DE LA SEGUNDA Y LA SEGUNDA EL VALOR DE LA PRIMERA
 * VOLVER A MOSYRAR LOS VALORES DE CADA VARIABLE.
 */

import java.util.Scanner;

public class Ejercicio03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//DECLARAR VARIABLES
		Scanner sc;
		int num1,num2,aux;

		//INSTANCIAR
		sc=new Scanner(System.in); 

		//LEER DATOS POR TECLADO
		System.out.println("Introduce el primer numero que quieras");
		num1=sc.nextInt();

		System.out.println("Introduce el segunfo numero que quieras");
		num2=sc.nextInt();

		//MOSTRAR EL VALOR DE CADA VARIABLE
		System.out.println("El valor del primer numero es "+num1);

		System.out.println("El valor del segundo numero es "+num2);

		//REALIZAR EL INTERCAMBIO DE DATOS
		aux=num1;
		num1=num2;
		num2=aux;

		// MOSTRAR LOS VALORES INTERCAMBIADOS
		System.out.println("Intercambiado: ");
		System.out.println("El nuevo valor del primer numero es "+num1);
		System.out.println("El nuevo valor del segundo numero es "+num2);

		if(num1>num2) {
			System.out.println("El numero "+num1+ " es mayor que " +num2);
		}else if(num2>num1){		
			System.out.println("El numero "+num2+ " es mayor que " +num1);
		}else {
			System.out.println("Los dos numeros son del mismo valor. "+num1+ " = " +num2);
		}
	}

}
