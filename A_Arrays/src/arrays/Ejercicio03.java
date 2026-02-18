package arrays;

public class Ejercicio03 {

	public static final int TAM = 35;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num, max=100, min=10, par=0,total=0;
		int numeros[];
		
		numeros=new int [TAM];

		for(int pos=0; pos<TAM; pos++) {
			num= (int)(Math.random() * (max - min) + min); //max - min define el tamaño del rango y + min ajusta el punto de inicio del rango
			numeros[pos]=num;
		}

		System.out.println("35 números aleatorios (10-99):");
		for(int pos=0; pos<TAM; pos++) {
			System.out.print(numeros[pos] + " ");
			if((pos+1)%10==0){
				System.out.println();
			}
		}

		//Mostrar por patalla sumar y contar los elementos pares
		//Los elementos pares son:

		System.out.println();
		System.out.println("Los números pares son:");


		for(int pos=0; pos<TAM; pos++) {
			if((numeros[pos])%2==0){
				System.out.print(numeros[pos] + " ");
				total+=numeros[pos];
				par++;
			}
		}

		System.out.println();
		System.out.println("El numero de elementos pares es: " + par);
		System.out.println("La suma de los pares es "+total);
	}

}