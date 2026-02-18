package For;
//2.	Programa que muestre los números del 1 al 100 en orden descendente (20 números por línea)


public class Ejercicio02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Aqui tienes los numeros del 1 al 100 en orden descendente y espaciados cada 20 numeros: ");

		for (int num=100; num>0 ; num--) {
			System.out.print(+num+ " ");
			if(num%20==1){
				System.out.println();
			}
		}
	}
}
