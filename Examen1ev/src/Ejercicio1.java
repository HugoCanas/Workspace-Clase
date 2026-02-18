import java.util.Scanner;

public class Ejercicio1 {	

	public static final int TAM = 1000;

	//Programa que lea por pantalla cuantas veces has repetido la secuencia 4,5,6,7 y muestre cuando hace click en 0 cuantas veces se ha repetido esa secuencia
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc;
		int cantidad=0;
		int []numeros;
		int numero;
		int contador=0;

		sc=new Scanner(System.in); 


		numeros=new int [TAM];

		do {
			System.out.println("Introduzca la secuencia de numeros que quiera (0 = salir)");
			numero=sc.nextInt();
			numeros[contador]=numero;
			contador++;
			/*if(numero==4) {
				if(numero==5) {
					System.out.println("Introduzca la secuencia de numeros que quiera (0 = salir)");
					if(numero==6) {
						System.out.println("Introduzca la secuencia de numeros que quiera (0 = salir)");
						if(numero==7) {
							System.out.println("Introduzca la secuencia de numeros que quiera (0 = salir)");
							cantidad++;
							System.out.println("he entrado en el ultimo if");
						}
					}
				}
			}*/
		}while(numero!=0);

		
		for (int i=0; i< numeros.length; i++) {
	            if(numeros[i]==4) {
	            	if(numeros[i+1]==5) {
	            		if(numeros[i+2]==6){
	            			if(numeros[i+3]==7) {
	            				cantidad++;
	            			}
	            		}
	            	}
	            }
	        } 

		System.out.println("El numero de veces que ha introducido la secuencia 4,5,6,7 son " +cantidad);

		System.out.println("Fin del programa.");
	}

}
