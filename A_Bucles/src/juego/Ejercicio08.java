package juego;

import java.util.Scanner;

/*
 * PROGRAMA QUE "PIENSE" UN NUMERO ENTERO ALEATORIO ENTRE 1 Y 1000 
 * (EN LA FASE DE PRUEBAS MOSTRARLO)
 * 
 * EL USUARIO DEBE ADIVINAR EL NUMERO EN UN MAXIMO DE 10 INTENTOS
 * PARA ELLO EL PROGRAMA NOS IRA DICIENDO  SI ES MAYOR O MENOR 
 * 
 * EJEMPLO: 
 * 		YA HE PENSADO EL NUMERO . ADIVINALO 
 * 		Te quedan 10 intentos. Introduce nº [1-1000]: 18
 * 		Te quedan 9 intentos. Introduce nº [1-18]: 180
 * 		Te quedan 10 intentos. Introduce nº [1-18]: 18
 * 
 * 		ACIERTAS
 * 		Felicidades, acertaste que el numero es x
 */
public class Ejercicio08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int max=1000,min=1,intento=10,num=0,respuesta=0;
		boolean acierto=false;
		Scanner sc;

		sc = new Scanner (System.in);

		respuesta=(int)(Math.random() * (max - min) + min);

		do {
			if(num<1 || num>1000 || num<min || num>max) {
				System.out.println("Tienes "+intento+ " intentos. Introduce nº ["+min+"-"+max+"]: ");
				num=sc.nextInt();
			}else {
				if(num>respuesta) {
					max=num;
					intento--;
					if(intento>0) {
						System.out.println("Tienes " +intento+ " intentos. Introduce nº ["+min+"-"+max+"]:");
						num=sc.nextInt();
					}
				}else if (num<respuesta) {
					min=num;
					intento--;
					if(intento>0) {
						System.out.println("Tienes " +intento+ " intentos. Introduce nº ["+min+"-"+max+"]:");
						num=sc.nextInt();
					}
				}else if(respuesta==num){
					acierto=true;
					System.out.println("Acertaste, el numero que se habia pensado era "+respuesta);
					break;
				}
			}
		}while(intento>0 && !acierto);

		if(intento==0) {
			System.out.println("Perdiste, el numero que habia qe acertar era "+respuesta);
		}
	}
}
