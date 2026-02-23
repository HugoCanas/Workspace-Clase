package examen1EV;

// ============================================================================
// APUNTES BÁSICOS PARA EL EXAMEN
// ============================================================================

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
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

// ====================================================================
// 2ª EVALUACIÓN - CÓDIGO FUNCIONAL
// ====================================================================

// ARRAYLIST - Cargar fichero en ArrayList (como Ahorcado)
	public static ArrayList<String> cargarEnArrayList(String ruta) {
		ArrayList<String> lista = new ArrayList<String>();
		try {
			Scanner sc = new Scanner(new File(ruta));
			while (sc.hasNext()) {
				lista.add(sc.nextLine());
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	// ARRAYLIST - Elegir elemento aleatorio y eliminarlo
	public static String elegirYEliminar(ArrayList<String> lista) {
		Random r = new Random();
		int pos = r.nextInt(lista.size());
		String elegido = lista.get(pos);
		lista.remove(pos);
		return elegido;
	}
	
	// RECURSIVIDAD - Factorial
	public static double factorial(int num) {
		if (num == 0 || num == 1) return 1;
		return num * factorial(num - 1);
	}
	
	// RECURSIVIDAD - Potencia
	public static double potencia(int num, int pot) {
		if (pot == 0) return 1;
		if (pot == 1) return num;
		return num * potencia(num, pot - 1);
	}
}


//############################################################################
//##                    2ª EVALUACIÓN - CONTENIDO NUEVO                     ##
//############################################################################

/*
 * ====================================================================
 * 8. ARRAYLIST
 * ====================================================================
 * 
 * import java.util.ArrayList;
 * 
 * ArrayList<String> lista = new ArrayList<String>();
 * 
 * lista.add("Hola");           // Añadir al final
 * lista.add(0, "Primero");     // Añadir en posición
 * lista.get(0);                // Obtener elemento
 * lista.remove(2);             // Eliminar posición 2
 * lista.size();                // Tamaño (como .length)
 * lista.clear();               // Vaciar
 * lista.contains("Hola");      // true si está
 * 
 * // RECORRER
 * for (int i = 0; i < lista.size(); i++) {
 *     System.out.println(lista.get(i));
 * }
 * // FOR-EACH
 * for (String elem : lista) {
 *     System.out.println(elem);
 * }
 * 
 * // ARRAY = tamaño fijo, primitivos, acceso con []
 * // ARRAYLIST = tamaño dinámico, solo objetos, acceso con .get()
 * 
 * 
 * 
 * ====================================================================
 * 11. COMPONENTES SWING
 * ====================================================================
 * 
 * // JLabel
 * lbl.setFont(new Font("Tahoma", Font.BOLD, 25));
 * lbl.setHorizontalAlignment(SwingConstants.CENTER);
 * 
 * // JTextField
 * txt.getText();               // Obtener texto
 * txt.setText("valor");        // Poner texto
 * txt.setEditable(false);      // Solo lectura
 * txt.requestFocus();          // Poner cursor aquí
 * txt.selectAll();             // Resaltar texto
 * 
 * // JButton
 * btn.setEnabled(false);       // Deshabilitar
 * btn.setBackground(Color.GREEN);
 * btn.setBackground(null);     // Color por defecto
 * 
 * // JCheckBox
 * chk.isSelected();            // true si marcado
 * 
 * // JRadioButton + ButtonGroup (solo 1 activo)
 * ButtonGroup grupo = new ButtonGroup();
 * grupo.add(rd1);
 * grupo.add(rd2);
 * if (rd1.isSelected()) { ... }
 * 
 * // JOptionPane
 * JOptionPane.showMessageDialog(null, "Mensaje");
 * int res = JOptionPane.showConfirmDialog(this, "¿Seguro?", "Aviso",
 *     JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
 * if (res == JOptionPane.YES_OPTION) { ... }
 * 
 * 
 * ====================================================================
 * 12. JList + DefaultListModel *** MUY IMPORTANTE ***
 * ====================================================================
 * 
 * // CREAR
 * DefaultListModel<String> modelo = new DefaultListModel<String>();
 * JList<String> lista = new JList<String>();
 * lista.setModel(modelo);
 * JScrollPane scroll = new JScrollPane();
 * scroll.setViewportView(lista);
 * contentPane.add(scroll);
 * 
 * // MODELO
 * modelo.addElement("Hola");        // Añadir
 * modelo.add(0, "Primero");         // Añadir en posición
 * modelo.remove(2);                 // Eliminar posición
 * modelo.clear();                   // Vaciar
 * 
 * // JLIST
 * lista.getSelectedIndex();         // Posición seleccionada (-1 si ninguna)
 * lista.getSelectedValue();         // Texto seleccionado
 * lista.setSelectedIndex(3);        // Seleccionar posición
 * 
 * // CARGAR FICHERO EN JLIST
 * Scanner sc = new Scanner(new File("Refran1.txt"));
 * modelo.clear();
 * while (sc.hasNext()) {
 *     modelo.addElement(sc.nextLine());
 * }
 * sc.close();
 * 
 * // SUBIR elemento
 * int pos = lista.getSelectedIndex();
 * String palabra = lista.getSelectedValue();
 * if (pos > 0) {
 *     modelo.remove(pos);
 *     modelo.add(pos - 1, palabra);
 *     lista.setSelectedIndex(pos - 1);
 * }
 * 
 * // BAJAR elemento
 * if (pos < modelo.getSize() - 1 && pos != -1) {
 *     modelo.remove(pos);
 *     modelo.add(pos + 1, palabra);
 *     lista.setSelectedIndex(pos + 1);
 * }
 * 
 * // ELIMINAR seleccionado
 * if (lista.getSelectedIndex() != -1) {
 *     modelo.remove(lista.getSelectedIndex());
 * }
 * 
 * 
 * ====================================================================
 * 13. EVENTOS *** MUY IMPORTANTE ***
 * ====================================================================
 * 
 * // ActionListener (botones)
 * btn.addActionListener(new ActionListener() {
 *     @Override
 *     public void actionPerformed(ActionEvent e) {
 *         // Código al pulsar
 *     }
 * });
 * 
 * // ItemListener (checkbox)
 * chk.addItemListener(new ItemListener() {
 *     @Override
 *     public void itemStateChanged(ItemEvent e) {
 *         panel.setVisible(chk.isSelected());
 *     }
 * });
 * 
 * // ListSelectionListener (JList)
 * lista.addListSelectionListener(new ListSelectionListener() {
 *     @Override
 *     public void valueChanged(ListSelectionEvent e) {
 *         int pos = lista.getSelectedIndex();
 *     }
 * });
 * 
 * // MouseAdapter (doble click)
 * lista.addMouseListener(new MouseAdapter() {
 *     @Override
 *     public void mouseClicked(MouseEvent e) {
 *         if (e.getClickCount() == 2) { ... }
 *     }
 * });
 * 
 * // Eventos en ARRAY de botones
 * for (JButton boton : arrayBotones) {
 *     boton.addActionListener(new ActionListener() {
 *         @Override
 *         public void actionPerformed(ActionEvent e) {
 *             boton.setEnabled(false);
 *             boton.setBackground(Color.RED);
 *         }
 *     });
 * }
 * 
 * 
 * ====================================================================
 * 14. TIMER
 * ====================================================================
 * 
 * import javax.swing.Timer;
 * 
 * Timer reloj = new Timer(40, new ActionListener() {
 *     @Override
 *     public void actionPerformed(ActionEvent e) {
 *         // Se ejecuta cada 40ms
 *     }
 * });
 * reloj.start();
 * reloj.stop();
 * 
 * 
 * ====================================================================
 * 15. HERENCIA
 * ====================================================================
 * 
 * public class Persona {
 *     protected String nombre;
 *     public Persona(String nombre) { this.nombre = nombre; }
 * }
 * 
 * public class Empleado extends Persona {
 *     protected int edad;
 *     public Empleado(String nombre, int edad) {
 *         super(nombre);       // Llama al constructor del padre
 *         this.edad = edad;
 *     }
 * }
 * 
 * // Casting
 * if (per.getClass() == Empleado.class) {
 *     Empleado emp = (Empleado) per;
 * }
 * 
 * 
 * ====================================================================
 * 16. MVC
 * ====================================================================
 * 
 * // MODELO → datos (Fichero.java, Persona.java)
 * // VISTA  → ventanas (Refranes.java) → crea controlador con: new EventosRefranes(this);
 * // CONTROLADOR → eventos (EventosRefranes.java) → accede con: refranes.getBtnCargar()
 * 
 * 
 * ====================================================================
 * 17. JDBC (MySQL)
 * ====================================================================
 * 
 * // CONECTAR
 * Connection cn = DriverManager.getConnection(
 *     "jdbc:mysql://localhost:3306/nombreBD", "root", "");
 * 
 * // INSERT
 * String sent = "INSERT INTO personas VALUES (null, ?, ?)";
 * PreparedStatement ps = cn.prepareStatement(sent);
 * ps.setString(1, "Hugo");
 * ps.setString(2, "hugo@mail.com");
 * int filas = ps.executeUpdate();    // Devuelve filas afectadas
 * 
 * // SELECT
 * sent = "SELECT * FROM personas";
 * ps = cn.prepareStatement(sent,
 *     ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
 * ResultSet rs = ps.executeQuery();
 * if (rs.first()) {
 *     do {
 *         String nombre = rs.getString("nombre");
 *         int edad = rs.getInt("edad");
 *     } while (rs.next());
 * }
 * 
 * // executeUpdate() → INSERT, UPDATE, DELETE (devuelve int)
 * // executeQuery()  → SELECT (devuelve ResultSet)
 * 
 * 
 * ====================================================================
 * 18. RECURSIVIDAD
 * ====================================================================
 * 
 * // FACTORIAL
 * public double factorial(int num) {
 *     if (num == 0 || num == 1) return 1;
 *     return num * factorial(num - 1);
 * }
 * 
 * // POTENCIA
 * public double potencia(int num, int pot) {
 *     if (pot == 0) return 1;
 *     if (pot == 1) return num;
 *     return num * potencia(num, pot - 1);
 * }
 * 
 * 
 * ====================================================================
 * 19. EXTRAS
 * ====================================================================
 * 
 * // String.split() → divide en array
 * String[] partes = "uno, dos, tres".split(", ");
 * 
 * // Conversión String → int
 * try {
 *     int num = Integer.parseInt(txt.getText());
 * } catch (NumberFormatException e) { return; }
 * 
 * // Navegar entre ventanas
 * ventana2.setVisible(true);     // Mostrar nueva
 * this.setVisible(false);        // Ocultar actual
 * this.dispose();                // Cerrar y liberar
 * 
 * // Salir del programa
 * System.exit(0);
 */

