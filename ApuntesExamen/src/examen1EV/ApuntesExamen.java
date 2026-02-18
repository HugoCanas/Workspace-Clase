package examen1EV;

// ============================================================================
// APUNTES BÁSICOS PARA EL EXAMEN
// ============================================================================

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ApuntesExamen {
    
    public static final int TAM = 20;  // Constante global
    
    public static void main(String[] args) {
        
        // ====================================================================
        // 1. ARRAYS UNIDIMENSIONALES
        // ====================================================================
        
        // DECLARAR
        int[] numeros = new int[10];              // 10 elementos (0 a 9)
        String[] nombres = new String[5];
        
        // ACCEDER
        numeros[0] = 25;                          // Primer elemento
        numeros[9] = 50;                          // Último elemento
        
        // LLENAR con aleatorios (10-99)
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int)(Math.random() * 90 + 10);
        }
        
        // MOSTRAR
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }
        System.out.println();
        
        // BUSCAR MÁXIMO
        int maximo = numeros[0];
        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > maximo) {
                maximo = numeros[i];
            }
        }
        
        // ORDENAR (burbuja)
        int aux;
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros.length - i - 1; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    aux = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = aux;
                }
            }
        }
        
        
        // ====================================================================
        // 2. ARRAYS BIDIMENSIONALES (MATRICES)
        // ====================================================================
        
        // DECLARAR
        int[][] matriz = new int[5][10];          // 5 filas, 10 columnas
        
        // ACCEDER
        matriz[0][0] = 10;                        // Fila 0, columna 0
        matriz[2][5] = 25;                        // Fila 2, columna 5
        
        // LLENAR
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int col = 0; col < matriz[0].length; col++) {
                matriz[fila][col] = (int)(Math.random() * 90 + 10);
            }
        }
        
        // MOSTRAR
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int col = 0; col < matriz[0].length; col++) {
                System.out.print(matriz[fila][col] + " ");
            }
            System.out.println();  // Salto de línea al final de cada fila
        }
        
        // INTERCAMBIAR DOS FILAS
        int fila1 = 1;
        int fila2 = 3;
        for (int col = 0; col < matriz[0].length; col++) {
            aux = matriz[fila1][col];
            matriz[fila1][col] = matriz[fila2][col];
            matriz[fila2][col] = aux;
        }
        
        
        // ====================================================================
        // 3. BUCLES
        // ====================================================================
        
        // WHILE (cuando NO sabemos cuántas veces)
        int contador = 1;
        while (contador <= 10) {
            System.out.println(contador);
            contador++;  // IMPORTANTE: incrementar
        }
        
        // FOR (cuando SÍ sabemos cuántas veces)
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }
        
        // FOR descendente
        for (int i = 10; i >= 1; i--) {
            System.out.println(i);
        }
        
        
        // ====================================================================
        // 4. FICHEROS - LEER
        // ====================================================================
        
        Scanner scFich;
        String linea;
        
        try {
            scFich = new Scanner(new File("datos.txt"));
            
            while (scFich.hasNext()) {
                linea = scFich.nextLine();
                System.out.println(linea);
            }
            
            scFich.close();  // IMPORTANTE
            
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Fichero no encontrado");
        }
        
        
        // ====================================================================
        // 5. FICHEROS - ESCRIBIR
        // ====================================================================
        
        PrintWriter pw;
        
        try {
            pw = new PrintWriter(new File("salida.txt"));
            
            pw.println("Primera línea");
            pw.println("Segunda línea");
            
            pw.close();  // IMPORTANTE: si no cierras, NO se guarda
            
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: No se pudo crear");
        }
        
        
        // ====================================================================
        // 6. FICHEROS - COPIAR
        // ====================================================================
        
        Scanner scOrigen;
        PrintWriter pwDestino;
        
        try {
            scOrigen = new Scanner(new File("origen.txt"));
            pwDestino = new PrintWriter(new File("destino.txt"));
            
            while (scOrigen.hasNext()) {
                linea = scOrigen.nextLine();
                pwDestino.println(linea);
            }
            
            scOrigen.close();
            pwDestino.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("ERROR");
        }
        
        
        // ====================================================================
        // 7. FICHEROS - COMPROBAR SI EXISTE
        // ====================================================================
        
        File f = new File("datos.txt");
        
        if (f.exists()) {
            System.out.println("El fichero existe");
        } else {
            System.out.println("El fichero NO existe");
        }
        
    } // FIN MAIN
    
    
    // ========================================================================
    // FUNCIONES
    // ========================================================================
    
    // FUNCIÓN QUE DEVUELVE UN VALOR
    public static int sumar(int n1, int n2) {
        return n1 + n2;
    }
    
    // FUNCIÓN VOID (no devuelve nada)
    public static void llenar(int[] numeros) {
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int)(Math.random() * 90 + 10);
        }
    }
    
    public static void mostrar(int[] numeros) {
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }
        System.out.println();
    }
    
    // FUNCIÓN ORDENAR (burbuja)
    public static void ordenar(int[] numeros) {
        int aux;
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros.length - i - 1; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    aux = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = aux;
                }
            }
        }
    }
    
    // FUNCIÓN BUSCAR MÁXIMO
    public static int buscarMaximo(int[] numeros) {
        int maximo = numeros[0];
        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > maximo) {
                maximo = numeros[i];
            }
        }
        return maximo;
    }
    
    // FUNCIÓN BOOLEANA (buscar si está)
    public static boolean esta(int[] numeros, int numero) {
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == numero) {
                return true;
            }
        }
        return false;
    }
}

// ============================================================================
// RESUMEN EXAMEN
// ============================================================================
/*
 * ARRAYS:
 * int[] array = new int[10];
 * array[0] = valor;
 * array.length = tamaño
 * 
 * MATRICES:
 * int[][] matriz = new int[filas][columnas];
 * matriz.length = filas
 * matriz[0].length = columnas
 * 
 * FUNCIONES:
 * public static int nombre(int parametro) {
 *     return valor;
 * }
 * 
 * FICHEROS LEER:
 * Scanner sc = new Scanner(new File("archivo.txt"));
 * while (sc.hasNext()) {
 *     String linea = sc.nextLine();
 * }
 * sc.close();
 * 
 * FICHEROS ESCRIBIR:
 * PrintWriter pw = new PrintWriter(new File("archivo.txt"));
 * pw.println("texto");
 * pw.close();  // ¡IMPORTANTE!
 * 
 * SIEMPRE usar try-catch con ficheros
 */
