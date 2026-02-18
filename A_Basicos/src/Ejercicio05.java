/*PROGRAMA QUE LEA UNA NOTA NUMERICA ENTERA POR TECLADO Y MUESTRE POR PANTALLA ESA NOTA EN 
 FORMA DE TEXTO SEGÚN ESTA TABLA: 
 0<=nota<3 -> MD o OG
 3<=nota<5 -> INS o GU
 5<=nota<6 -> SF o NH 
 6<=nota<7 -> BN o ON
 7<=nota<9 -> NT o OO
 p<=nota<=10 -> SB o BK

 Ejemplo:
 Introduce una nota (0-10): 15
 Nota no valida -> Se acaba el programa
 *
 Introduce una nota (0-10:) 7
 Has sacado NT o OO
 */
import java.util.Scanner;
public class Ejercicio05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nota;
		Scanner sc;

		sc=new Scanner(System.in); 

		System.out.println("Introduce tu nota: ");
		nota=sc.nextInt();
		
		
		
		switch(nota) {
			case 0: System.out.println("Tu nota es muy deficiente o oso gutxi");
				break;
			case 1: System.out.println("Tu nota es muy deficiente o oso gutxi");
				break;
			case 2: System.out.println("Tu nota es muy deficiente o oso gutxi");
				break;
			// case 0,1,2: ("Tu nota es muy deficiente o oso gutxi")
			case 3: System.out.println("Tu nota es insuficiente o gutxi");
				break;
			case 4: System.out.println("Tu nota es insuficiente o gutxi");
				break;
			case 5: System.out.println("Tu nota es suficiente o nahiko");
				break;
			case 6: System.out.println("Tu nota es bien o ondo");
				break;
			case 7: System.out.println("Tu nota es notable o oso ondo");
				break;
			case 8: System.out.println("Tu nota es notable o oso ondo");
				break;
			case 9: System.out.println("Tu nota es sobresaliente o bikain");
				break;
			case 10: System.out.println("Tu nota es sobresaliente o bikain");
				break;
			default: System.out.println("La nota que has introducido no es valida, tiene que ser un valor entre 0 a 10");
		}
	}
}


