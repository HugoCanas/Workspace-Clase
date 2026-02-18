package For;
//1.	Programa que muestre los números del 1 al 100 en orden ascendente (20 números por línea)

public class Ejercicio01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Aqui tienes los numeros del 1 al 100 en orden ascendente y espaciados cada 20 numeros: ");
		for (int num=1; (num!=20 ||num!=40 || num!=60 || num!=80) && num<=100 ; num++) {
			if(num==20 || num==40 || num==60 || num==80) {
				System.out.println(+num+ " ");
			}else {
				System.out.print(+num+ " ");
			}
		}
	}
}
