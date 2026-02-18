package arrays;

import java.util.Scanner;

/*
 * PROGRAMA QUE PIDA POR TECLADO EL NUMERO DE PERSONAS QUE QUIERO GESTIONAR
 *CREAR DOS ARRAYS PARA GUARDAR LOS NOMBRES Y LAS EDADES DE TANTAS PESONAS COMO HAYA INDICADO EL USUARIO.
 *PEDIR POR TELCADO LOS NOMBRES Y LAS EDADES Y GUARDARLAS. 
 *MOSTRAR POR PANTALLA NOMBRE Y EDAD DE LOS MAYORES DE 18 AÑOS
 *Ejemplo : ¿Cuantas personas quieres? 4
 *
 * 
 */
public class Ejercicio04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tam,numPersonas;
		String nombre[];
		int edad[];
		Scanner sc;


		sc=new Scanner(System.in); 

		System.out.println("Indicame el numero de personas que quieres gestionar");
		numPersonas=sc.nextInt();
		nombre= new String[numPersonas];
		edad= new int [numPersonas];

		//LLENAR LOS ARRAYS 		
		for(int pos=0;pos<nombre.length;pos++) {
			System.out.println("Introduce el nombre del alumno: " +(pos+1));
			nombre[pos]= sc.next();
			System.out.println("Introduce la edad del alumno: " +(pos+1));
			edad [pos]= sc.nextInt();
		}
		//BUSCAR Y MOSTRAR LOS MAYORES DE EDAD
		for(int pos=0;pos<nombre.length;pos++) {
			if(edad[pos]>=18) {
				System.out.println("El nombre del alumno mayor de edad es "+nombre[pos]);
				System.out.println("La edad de " +nombre[pos] + " es de " +edad[pos]);
			}
			System.out.println();
		}

	}

}
