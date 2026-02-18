import java.util.Scanner;

//*********************ENUNCIADO*********************
//LEER POR TECLADO COMO INT LA BASE Y LA ALTURA DE UN TRIANGULO Y MUESTRE POR PANTALLA SU AREA
//CONTROLAR QUE LA BASE Y LA ALTURA NO SEAN NEGATIVAS
public class Ejercicio02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ENTRADA DE DATOS POR TECLADO
		Scanner sc;//variables delcarar, objetos instanciar
		float base=0,altura=0,area;

		//INSTANCIAR EL SCANNER
		sc=new Scanner(System.in); 

/* CON WHILE
		while(base<=0) {
			//LEER DATOS POR TECLADO 
			System.out.print("Introduce la base del triangulo : ");
			base=sc.nextFloat();


			if(base<=0) {
				System.out.println("La base no puede ser negativa o cero");
			}
		}

		while(altura<=0) {
			System.out.print("Introduce la base del triangulo : ");
			base=sc.nextFloat();

			if(altura<=0) {
				System.out.println("La altura no puede ser negativa o cero");
			}
		}
*/
		
		System.out.print("Introduce la base del triangulo: ");
		base=sc.nextFloat();
		
		System.out.print("Introduce la base del triangulo: ");
		base=sc.nextFloat();
		
		if(base>0 && altura>0){
		
			area=base*altura/2;
			
			System.out.println("El resultado del area es "+area);
		}else {
			System.out.println("El area o la altura no pueden ser un valor negativo");
			System.out.println("El programa ha finalizado.");
			sc.close();
		}
		
		/*ALTERNATIVA SI USASE INTS Y CASTEO
		area=(float)base*altura/2  */

		//MOSTRAR VALORES

		/*OTRA VARIABLE
		System.out.println("El resultado del area es "+(base*altura/2);
		 */

	}

}
