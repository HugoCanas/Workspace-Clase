package arrays;
/*
 * LLENAR UN ARRAY DE 20 ELEMENTOS CON NUMEROS ALEATORIOS ENTEROS POSITIVOS ENTRE -50 Y 50 
 * MOSTRARLO POR PANTALLA EN LA MISMA LINEA
 * 
 */
public class Ejercicio05 {

	public static final int TAM = 20;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num,mayor;
		int numeros[];
		int posMayor;

		numeros=new int [TAM];
		mayor=numeros[0];
		posMayor=0;

		for(int pos=0; pos<TAM; pos++) {
			num= (int)(Math.random() * (101 - 50)); //max - min define el tamaño del rango y + min ajusta el punto de inicio del rango
			numeros[pos]=num;
			System.out.print(numeros[pos]+ " ");
			if(numeros[pos]>=mayor) {
				mayor=numeros[pos];
				//guardar la posicion
				posMayor=pos;
			}
		}
		System.out.println(); 
		System.out.println("El numero mayor es " +mayor);

		//INTERCAMBIE EL MAYOR CON EL DE LA ULTIMA POSICION

		int ultNum = numeros[TAM-1]; //NUMERO ULTIMA POSICION = ULTNUM 
		numeros[TAM-1] = mayor; //METO EN LA ULTIMA POSICION EL NUMERO MAYOR
		numeros[posMayor] = ultNum; //METO EL ULTIMO NUMERO EN LA POSICION DONDE ESTABA EL MAYOR

		
		System.out.println("Array después del intercambio:");
		for(int pos=0; pos<TAM; pos++) {
			System.out.print(numeros[pos]+ " ");
		}
	}
}