package ejercicios;

import java.util.Scanner;

public class Ejercicio06 {

	public static final int TAM=20;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1,num2,numeros[];
		Scanner sc;
		boolean comprobadoGeneral;

		sc=new Scanner(System.in);
		
		numeros=new int [TAM];

		llenar(numeros);

		mostrar(numeros);

		System.out.println("Introduce el primer numero del que quieras saber si esta en el array. ");
		num1=sc.nextInt();

		System.out.println("Introduce el segundo numero del que quieras saber si esta en el array: ");
		num2=sc.nextInt();

		comprobadoGeneral = comprobar(numeros,num1,num2);
		/*UTILIZANDO FUNCIONES:
		 * LLENAR UN ARRAY CON 20 NUMEROS ALEATORIOS ENTRE 1 Y 100.
		 * MOSTRARLO PARA PODER COMPROBAR
		 * PEDIR POR TELCADO DOS VALORES NUMERICOS.
		 * MEDIANTE UNA LLAMADA A LA FUNCION MOSTRAR UN MENSAJE POR PANTALLA INDICADO
		 * SI LOS DOS NUMEROS ESYAN EN EL ARRAY O NO.
		 */

		if(comprobadoGeneral==false) {
			System.out.println("Los numeros "+num1+ " "+num2+ " no pertenecen al array");
		}else if (comprobadoGeneral==true) {
			System.out.println("Los numeros "+num1+ " "+num2+ " pertenecen al array");
		}

	}

	public static void llenar (int n1[]){
		/* FUNCION PARA LLENAR UN ARRAY RECIBIDO COMO PARAMETRO CON NUMEROS ENTEROS ALEATORIOS DE DOS DIGITOS*/
		int num;

		for(int pos=0;pos<n1.length;pos++) {
			num = (int)(Math.random() * 90+10);
			n1[pos]=num;
		}
	}

	public static void mostrar(int n1[]) {
		/*FUNCION PARA MOSTRAR POR PANTALLA UN ARRAY RECIBIDO COMO PARAMETRO.*/

		for(int i=0;i<n1.length;i++) {
			System.out.print(n1[i]+ " ");
		}
		System.out.println();
	}

	public static boolean comprobar (int array[],int n1, int n2) {
		/*FUNCION QUE RECIBA COMO PARAMETROS UN ARRAY DE NUMEROS ENTEROS Y DOS NUMERO Y DEVUELVA
		 * EL VALOR VERDADERO SOLO SI LOS DOS NUMEROS ESTAN EN EL ARRAY. FALSO EN CASO CONTRARIO
		 */
		boolean comprobado1=false;
		boolean comprobado2=false;
		boolean comprobadoGeneral=false;

		for(int i=0;i<array.length;i++) {
			if(array[i]==n1) {
				comprobado1=true;
			}else if(array[i]==n2) {
				comprobado2=true;
			}
		}
		if(comprobado1==true && comprobado2==true) {
			comprobadoGeneral=true;
		}
		return comprobadoGeneral;
	}
	
}


















