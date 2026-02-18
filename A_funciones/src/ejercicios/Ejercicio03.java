package ejercicios;

import java.util.Scanner;


public class Ejercicio03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*PROGRAMA QUE PIDA LA BASE Y EXPONENTE Y, MEDIANTE UNA LLAMADA A LA FUNCION POTENCIA, CALCULE LA POTENCIA DEL PRIMERO ELEVADO AL SEGUNDO
		 */
		int numero,potencia;
		Scanner sc;

		sc=new Scanner(System.in);

		System.out.println("Introduce el numero al que le quieras aplicar la potencia: ");
		numero=sc.nextInt();

		System.out.println("Introduce la potencia que le quieras aplicar al numero: ");
		potencia=sc.nextInt();

		potencia(numero,potencia);

	}


	/* HAZ UNA FUNCION QUE RECIBA COMO PARAMETROS DOS NUMEROS ENTEROS Y DEVUELVA EL RESULTADO DE 
	 * LA POTENCIA DEL PRIMERO ELEVADO AL SEGUNDO(no vale utilizar la funcion pow) *
	 * RESULTADO:double
	 */

	public static double potencia(int num, int pot) {
		double resultado=1;

		if(pot==0) {
			System.out.println("El resultado de tu exponente es "+resultado);
		}
		
		else if(pot<0) {

			for(int i=0;i>pot;i--) {
				resultado*=num;
			}
			resultado=(1/resultado);
			System.out.println("La potencia de tu numero es "+resultado);
		}
		
		else if(pot>0) {

			for(int i=0;i<pot;i++) {
				resultado*=num;
			}
			System.out.println("La potencia de tu numero es "+resultado);
		}
		return resultado;
	}
}
