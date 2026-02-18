package For;

import java.util.Scanner;

/*PROGRAMA QUE LEA PALABRA POR TECLADO
 * A CONTINUACION PEDIR UN NUMERO ENTERO POR TECLADO. SEGUIR PIDIENDO PALABRAS HASTA QUE EL USUARIO INTRODUZCA UNO POSITIVO
 * 
 * MOSTRAR LA PANTALLA LA PALABRA LEIDA TANTAS VECES COMO INDICA EL NUMERO
 * 
 * EJEMPLO:
 * 			Introduce un numero positivo: -9
 *  		Introduce un numero positivo: -9
 *   		Introduce un numero positivo: -9
 *    		Introduce un numero positivo: -9
 *     		Introduce un numero positivo: -9
 *      	Introduce un numero positivo: 6
 */
public class Ejercicio06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=0;
		int cont=1;
		String palabra;
		Scanner sc;

		sc=new Scanner(System.in); 

		System.out.println("Introduce una palabra: ");
		palabra=sc.nextLine();

		while(num<=0) {
			System.out.println("Introduce un numero positivo:");
			num=sc.nextInt();
			if(num<=0){
				System.out.println("Introduzca un numero positivo por favor");
			}
		}

		for(num=num;num>=1;num--) {
			System.out.println(cont+"."+palabra);
			cont++;
		}
	}
}
