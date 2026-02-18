/*PROGRAMA QUE LEA LOS DOS NUMEROS POR TECLADO Y LOS MUESTRE POR PANTALLA EN ORDEN ASCENDENTE*/
import java.util.Scanner;

public class Ejercicio04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//DECLARAR VARIABLES
		int num1,num2;
		Scanner sc;

		//INSTANCIAR
		sc=new Scanner(System.in); 

		//LEER DATOS POR TECLADO
		System.out.println("Introduce el primer numero: ");
		num1=sc.nextInt();

		System.out.println("Introuce el segundo numero: ");
		num2=sc.nextInt();

		if(num1>num2) {
			System.out.println("Los numeros ordenados ascendentemente son: "+num2+","+num1);
		}else if(num1==num2) {
			System.out.println("Los dos numeros son iguales : " +num1+ "," +num2);
		}else { //RECUERDA QUE LOS ELSE SOLO APLICAN AL ULTIMO IF O ELSE IF 
			System.out.println("Los numeros ordenados ascendentemente son :" +num1+ "," +num2);
		}
	}
}
