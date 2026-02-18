package ejercicios;

import java.util.Scanner;

public class Ejercicio1 {
	
	/*PROGRAMA QUE LEA POR TECLADO DOS NUMEROS Y MUESTRE POR PANTALLA LA SUMA DE AMBOS
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc;
		int num1,num2,resultado;
		
		sc=new Scanner(System.in);
		
		System.out.println("Introduce el primer numero que quieres que se muestre: ");
		num1=sc.nextInt();
		
		System.out.println("Introduce el segundo numero que quieres que se muestre: ");
		num2=sc.nextInt();
		
		resultado=sumar(num1,num2);
		
		System.out.println("El resultado de la suma es: "+resultado);
		
	}

	/*FUNCION QUE REALICE LA SUMA DE DOS NUMEROS RECIBIDOS COMO PARAMETROS Y DEVUELVA EL RESULTADO DE ESA SUMA
	 */
	
	public static int sumar(int n1,int n2) {
		int result;
		result=n1+n2;
		
		return result;
	}
}
