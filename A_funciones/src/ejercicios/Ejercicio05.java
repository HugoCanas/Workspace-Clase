package ejercicios;

public class Ejercicio05 {
	/*MEDIANTE LLAMADAS A LAS FUNCIONES:
	 * LLENAR DOS ARRAY DE 20 ELEMENTOS CON NUMEROS ENTEROS
	 * MOSTRAR DOS ARRAY DE NUMEROS ENTEROS
	 */
	public static final int TAM=20;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numeros1[],numeros2[],numeros3[];

		numeros1=new int [TAM];
		numeros2=new int [TAM];
		numeros3=new int [40];

		llenar(numeros1);

		llenar(numeros2);

		System.out.println("Sin ordenar : ");

		mostrar(numeros1);

		mostrar(numeros2);

		System.out.println("Ordenado :");

		burbuja(numeros1);

		burbuja(numeros2);

		mostrar(numeros1);

		mostrar(numeros2);

		fusionar(numeros1,numeros2,numeros3);
		
		System.out.println("Fusionado: ");
		
		mostrar(numeros3);

	}
	
	/*HACER LAS SIGUIENTES FUNCIONES: */
	public static void llenar (int n1[]){
		/* FUNCION PARA LLENAR UN ARRAY RECIBIDO COMO PARAMETRO CON NUMEROS ENTEROS ALEATORIOS DE DOS DIGITOS*/
		int num;

		for(int pos=0;pos<TAM;pos++) {
			num = (int)(Math.random() * 90+10);
			n1[pos]=num;
		}
	}
	public static void mostrar(int n1[]) {
		/*FUNCION PARA MOSTRAR POR PANTALLA UN ARRAY RECIBIDO COMO PARAMETRO.*/

		for(int i=0;i<n1.length;i++) {
			System.out.print(n1[i]+ " ");
		}
		System.out.println();
	}
	/*FUNCION QUE ORDENE DE FORMA ASCENDENTE UN ARRAY RECIBIDO COMO PARAMETRO (METODO BURBUJA)
	 */

	public static void burbuja (int n1[]){
		boolean ordenado;
		int aux;

		for(int i=0;i<TAM;i++) {        
			ordenado=true;
			for(int x=0;x<TAM-i-1;x++){ 
				if(n1[x]>n1[x+1]) {
					aux=n1[x];
					n1[x]=n1[x+1];
					n1[x+1]=aux;
					ordenado=false;
				}
			}if(ordenado) {
				break;
			}
		}
	}
	public static void fusionar (int n1[],int n2[], int n3[]) {
		/*FUNCION QUE RECIBA DOS ARRAYS ORDENADOS COMO PARAMETROS Y VAYA METIENDO EN UN TERCER ARRAY
		 * TAMBIEN REICIBIDO COMO PARAMETRO LOS ELEMENTOS DE LOS DOS ARRAYS ANTERIORES DE FORMA ORDENADA
		 * (NO VALE LLAMAR A LA FUNCION ORDENAR)*/
		int cont1=0,cont2=0,cont3=0;
		
		do {
			if(n1[cont1]<n2[cont2]) {
				n3[cont1+cont2]=n1[cont1];
				cont1++;
				cont3++;
			}else {
				n3[cont1+cont2]=n2[cont2];
				cont2++;
				cont3++;
			}
		}while(cont1<20 && cont2<20);
		
		while(cont1<n1.length){
			n3[cont3]=n1[cont1];
			cont1++;
			cont3++;
		}
		
		while(cont2<n2.length) {
			n3[cont3]=n1[cont2];
			cont2++;
			cont3++;
		}
		
	}
}
