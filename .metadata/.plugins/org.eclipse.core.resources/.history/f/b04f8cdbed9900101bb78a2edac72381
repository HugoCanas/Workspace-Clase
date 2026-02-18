package For;

import java.util.Scanner;

/*PROGRAMA QUE PIDA POR TECLADO EL NUMERO DE ALUMNOS MATRICULADOS (>0) 
 * A CONTINUACION, PARA CADA ALUMNO PEDIR POR TECLADO COMO ENTERO LA NOTA DE CADA ALUMNO  
 * AL FINAL MOSTRAR POR PANTALLA EL NUMERO DE APROBADOS Y LA NOTA MEDIA DE TODOS
 * 
 * EJEMPLO:
 * 		Introduce el numero de alumnos:6
 * 		Introduce las notas de los alumnos  
 * 		Alumno 1: 7
 * 		Alumno 2: 3
 * 		Alumno 3: 10
 * 		Alumno 4: 8
 * 		Alumno 5: 6
 * 		Alumno 6: 4
 * 		El numero de aprobados es: 5
 * 		La nota media es: 6,33
 * 
 */
public class Ejercicio07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nota,alumnos,total=0,aprob=0;
		double media;
		Scanner sc;

		sc=new Scanner(System.in); 

		do{
			System.out.println("introduce el numero de alumnos (>0): ");
			alumnos=sc.nextInt();
		}while(alumnos<=1);

		System.out.println("Introduce las notas de los alumnos: ");

		for(int cont=1;alumnos>=cont;cont++) {
			//numAprobados=0;
			//numAprobados=0;
			do {
				System.out.println("Alumno " +cont+ ":");
				nota=sc.nextInt();
			} while(nota < 0 || nota > 10);
			total+=nota;
			if(nota>=5) {
				aprob++;
			}
		}
		System.out.println("La nota media de los alumnos es :" +total/alumnos);
		System.out.println("La cantidad de aprobados es: " +aprob);
	}
}
/*Solo cuando la nota sea válidase sale del bucle do-while y se suma al total
 *Entonces el contador avanza al siguiente alumno en el bucle for
 */


