package ejercicios;

import java.util.Scanner;

public class Ejercicio02 {
	public static final int  TAM=10;
	public static void main(String[] args) {
		/*TODO Auto-generated method stub
		 *PROGRAMA QUE CALCULE EL FACTORIAL DE LOS NUMEROS INTRODUCIDOS POR TECLADO
		 *EL PROGRAMA MOSTRARA UN MENSAJE DE ERROR Y NO LLAMARA A LA FUNCION PARA NUMEROS NEGATIVOS

		/*FUNCION QUE CALCULE EL FACTORIAL DE UN NUMERO CON PARAMETROS U DEVUELVA SU RESULTADO
		 * NUMERO RECIBIDO COMO PARAMETRO: int
		 * RESULTADO:double
		 */
		Scanner sc;
		int num,numeros[];
		double result;

		numeros=new int [TAM];

		sc=new Scanner(System.in);

		do {
			System.out.println("Introduceme el numero del que quieras saber el factorial (-99 para terminar): ");
			num=sc.nextInt();
			if( num>=0 ) {
				result=factorial(num);

				System.out.println("El resultado del factorial es "+result);
			}else {
				System.out.println("No existe el factorial de numeros negativos");
			}
		}while(num!=-99);
		/*
		 * A CONTINUACION, LLENAR UN ARRAY DE 10 ELEMENTOS CON LOS 10 PRIMEROS NUMEROS IMPARES (FUNCION)
		 */
		System.out.println("El resultado del array lleno de 10 numeros impares es: ");
		
		llenar(numeros);
		mostrar(numeros);
	
	}

	public static double factorial(int n1) {
		double factorial=1;
		for(int i=n1;i>0;i--) {
			factorial=factorial*i;
		}
		return factorial;
	}

	/*FUNCION QUE LLENE UN ARRAY CON LOS 10 PRIMEROS NUMEROS ENTEROS IMPARES POSITIVOS
	 */
	public static void llenar(int numeros[]) {
		int aux=1;
		for(int pos=0;pos<numeros.length;pos++) {
			numeros[pos]=aux;
			aux=aux+2;
		}
		
		//OTRA FORMA
		for(int pos=0;pos<numeros.length;pos++) {
			numeros[pos]=pos*2+1;
		}
		
	}
	
	public static void mostrar (int numeros[]) {
		for(int pos=0;pos<numeros.length;pos++) {
			System.out.print(numeros[pos]+" ");
		}
	}
}

