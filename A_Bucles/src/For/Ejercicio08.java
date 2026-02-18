package For;

import java.util.Scanner;

/* LEER UN NUMERO ENTERO POR TECLADO Y MUESTRE POR PANTALLA EL RESULTADO DE SU FACTORIAL.
 * 6!=5*5*4*3*2*1
 * !0=1
 * 13! > 2.100.000.000
 * SI EL NUMERO ES MAYOR QUE 0 -> CAULCULAR EL RESULTADO HACIENDO VARIAS MULTIPLICACIONES 
 */
public class Ejercicio08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//(INT/DOUBLE)
		int num;
		double resultado=1;
		String respuesta;
		Scanner sc;

		sc=new Scanner(System.in); 

		do {

			do{
				System.out.println("Introduce el numero del que quieras saber el factorial (>0) : "); 
				num=sc.nextInt();
			}while(num<0); 

			for (int aux=1; aux<=num; aux++) {			
				resultado=resultado*aux;
			}

			System.out.println("El factorial del numero es: " +resultado);
			System.out.println("Quieres calcular otro factorial ? (S/N): ");
			respuesta=sc.next();

		}while(respuesta.equalsIgnoreCase("S"));
	}

}
