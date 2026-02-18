package arrays;
/*
 * PROGRAMA QUE LLENE UN ARRAY DE 15 ELEMENTOC CON NUMEROS ALEATORIOS ENTEROS ENTRE 1 Y 100. MOSTRAR EL ARRAY EN UNA LINEA 
 * A CONTINUACION DESPLAZAR LOS ELEMENTOS DEL ARRAY A UNA POSICION A LA DERECHA, COLOCANDO EL ELEMENTO DE LA ULTIMA POSICION EN LA POSICION 0.
 * VOLVER A MOSTRAR EL ARRAY EN UNA LINEA
 */

public class Ejercicio06 {

	public static final int TAM = 15;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numeros[];
		int num,aux;

		numeros=new int [TAM];
		
		System.out.println("Original: ");
		System.out.println();
		for(int pos = 0; pos < TAM; pos++) {
            numeros[pos] = (int)(Math.random() * 100+1);
            System.out.print(numeros[pos]+ " ");
        }
		
        System.out.println();
        //DESPLAZAR EL CONTENIDO UNA POSICION A LA DERECHA
        aux=numeros[TAM-1];
        for(int pos=TAM-1;pos>0;pos--) {
        	numeros[pos]=numeros[pos-1];
        }
        
		numeros[0]=aux;     
		
		System.out.println();
		System.out.println("Despues de meter el ultimo numero en el cero");
		
		for(int pos=0;pos<TAM;pos++) {
        	System.out.print(numeros[pos]+ " ");;
        }
	}		
}


