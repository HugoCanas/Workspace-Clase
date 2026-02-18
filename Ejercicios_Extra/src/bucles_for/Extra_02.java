package bucles_for;

import java.util.Scanner;

//Solicita un número y muestra la cuenta atrás desde ese número hasta 1, mostrando sólo los números impares.
public class Extra_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num1=0;
		Scanner sc;

		sc=new Scanner(System.in); 

		while(num1<=0){
			System.out.println("Introduce el numero del que quieras saber los numeros impares: ");
			num1=sc.nextInt();
		}
		//if (numero%2==0)

		for(num1=num1;num1>=1;num1--){
			if(num1%2!=0){ // % significa si es modulo del nuero que se pone ahi 
				System.out.print(num1+ " ");
			}
		}
	}

}
