
public class Ejercicio2 {

	public static final int TAM = 40;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []numeros;	


		numeros=new int [TAM];
		llenar(numeros);
		mostrarArray(numeros);
		numeroAlto(numeros);

	}


	public static void numeroAlto(int n1[]) {
		int maximo = n1[0];
		int contador=0;
		for (int i = 1; i < n1.length; i++) {
			if (n1[i] >= maximo) {
				maximo = n1[i];
			}
		}
		for (int i = 1; i < n1.length; i++) {
			if(n1[i]==maximo) {
				contador++;
			}
		}
		System.out.println();
		System.out.println("El numero de veces que se repite el numero mas alto, que en este caso es " +maximo+ " es de " +contador+ " veces");

	}

	public static void llenar (int n1[]){
		/* FUNCION PARA LLENAR UN ARRAY RECIBIDO COMO PARAMETRO CON NUMEROS ENTEROS ALEATORIOS DE DOS DIGITOS*/
		int num;

		for(int pos=0;pos<n1.length;pos++) {
			num = (int)(Math.random() * -22 + 11);
			n1[pos]=num;
		}
	}

	public static void mostrarArray(int n1[]) {
		for (int i = 0; i < n1.length; i++) {
			System.out.print(n1[i] + " ");
			if(i==19) {
				System.out.println();
			}
		}
	}
}

