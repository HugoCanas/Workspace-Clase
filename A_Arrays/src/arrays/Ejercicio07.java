package arrays;
/*
 * LLENAR UN ARRAY DEL 20 ELEMENTOS CON NUMEROS ALEATORIOS ENTEROS POSITIVOS DE 2 DIGITOS. MOSTRARLO.
 * A CONTINUACION ORDENARLO DE FORMA ASCENDENTE
 * VOLVER A MOSTRARLO 
 */
public class Ejercicio07 {

	public static final int TAM = 20;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numeros[],aux;
		boolean ordenado;

		numeros=new int [TAM];
		aux=0;

		for(int pos=0;pos<TAM; pos++) {
			numeros[pos] = (int)(Math.random() * 90+10);
			System.out.print(numeros[pos]+ " ");
		}

		//ORDENARLO DE MENOR A MAYOR - *******************METODO DE LA BURBUJA******************* 
		//comparar cada uno con el siguiente hasta que llegue donde le toca 
		for(int i=0;i<TAM;i++) {        
			ordenado=true;
			for(int x=0;x<TAM-i-1;x++){ 
				if(numeros[x]>numeros[x+1]) {
					aux=numeros[x];
					numeros[x]=numeros[x+1];
					numeros[x+1]=aux;
					ordenado=false;
				}
			} 
			if(ordenado) {
				break;
			}
		}
		//VOLVER A MOSTRAR EL ARRAY 
		System.out.println();
		System.out.println("Array Ordenado: ");

		for(int pos=0;pos<TAM; pos++) {
			System.out.print(numeros[pos]+ " ");
		}	
	}
}
