import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Color;

public class TresEnRaya extends JFrame {

	private static final long serialVersionUID = 1L;
	public static final int NO_FIN=0;
	public static final int TABLAS=1;
	public static final int GANADOR=2;

	private JPanel contentPane;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JLabel lblJ1;
	private JButton btnColor1;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JLabel lblJ2;
	private JButton btnColor2;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JButton btnNueva;
	private JButton btnSalir;
	private JButton []arrayBotones;
	private int turno;
	private JColorChooser dlgColor;

	private Timer reloj;
	private int pos1,pos2,pos3;
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TresEnRaya frame = new TresEnRaya();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TresEnRaya() {
		setTitle("TresEnRaya - ALMI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 5, 0, 0));

		btn1 = new JButton("");
		contentPane.add(btn1);

		btn2 = new JButton("");
		contentPane.add(btn2);

		btn3 = new JButton("");
		contentPane.add(btn3);

		lblJ1 = new JLabel("Jugador 1");
		lblJ1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblJ1);

		btnColor1 = new JButton("");
		btnColor1.setBackground(Color.RED);
		contentPane.add(btnColor1);

		btn4 = new JButton("");
		contentPane.add(btn4);

		btn5 = new JButton("");
		contentPane.add(btn5);

		btn6 = new JButton("");
		contentPane.add(btn6);

		lblJ2 = new JLabel("Jugador 2");
		lblJ2.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblJ2);

		btnColor2 = new JButton("");
		btnColor2.setBackground(Color.BLUE);
		contentPane.add(btnColor2);

		btn7 = new JButton("");
		contentPane.add(btn7);

		btn8 = new JButton("");
		contentPane.add(btn8);

		btn9 = new JButton("");
		contentPane.add(btn9);

		btnNueva = new JButton("Nueva partida");
		contentPane.add(btnNueva);

		btnSalir = new JButton("Salir");
		contentPane.add(btnSalir);

		arrayBotones=new JButton[9];
		turno=1;
		llenarArray(arrayBotones);
		registrarEventos();
		estadoBotones(false);

	}//FIN DEL CONSTRUCTOR

	public void registrarEventos() {
		reloj=new Timer(500, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(turno==1) {
					if(arrayBotones[pos1].getBackground().equals(btnColor1.getBackground())) {
						arrayBotones[pos1].setBackground(null);
						arrayBotones[pos2].setBackground(null);
						arrayBotones[pos3].setBackground(null);
					}else {
						arrayBotones[pos1].setBackground(btnColor1.getBackground());
						arrayBotones[pos2].setBackground(btnColor1.getBackground());
						arrayBotones[pos3].setBackground(btnColor1.getBackground());
					}
				}else {
					if(arrayBotones[pos1].getBackground().equals(btnColor2.getBackground())) {
						arrayBotones[pos1].setBackground(null);
						arrayBotones[pos2].setBackground(null);
						arrayBotones[pos3].setBackground(null);
					}else {
						arrayBotones[pos1].setBackground(btnColor2.getBackground());
						arrayBotones[pos2].setBackground(btnColor2.getBackground());
						arrayBotones[pos3].setBackground(btnColor2.getBackground());
					}
				}
			}
		});

		btnSalir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		btnNueva.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//habilitar los 9 botones del juego
				estadoBotones(true);
				restaurarColor();
				//deshabilitarse a sí mismo
				btnNueva.setEnabled(false);
				//deshabilitar los botones de los colores
				btnColor1.setEnabled(false);
				btnColor2.setEnabled(false);
				elegirJugadores();
				resaltarNombre();
			}
		});

		btnColor1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dlgColor=new JColorChooser(); 
				Color color;
				color=dlgColor.showDialog(rootPane, "Elige color", btnColor1.getBackground());
				if(color!=null) {
					btnColor1.setBackground(color);
				}
			}
		});

		btnColor2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dlgColor=new JColorChooser(); 
				Color color;
				color=dlgColor.showDialog(rootPane, "Elige color", btnColor2.getBackground());
				if(color!=null) {
					btnColor2.setBackground(color);
				}
			}
		});

		for(JButton boton: arrayBotones)	
		{
			boton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					int resultado;
					//deshabilitar el botón
					boton.setEnabled(false);
					//poner el color según el turno
					if(turno==1) {
						boton.setBackground(btnColor1.getBackground());
					}else {
						boton.setBackground(btnColor2.getBackground());
					}
					//comprobar fin de juego
					resultado=comprobarFin();
					if(resultado==TABLAS) {
						JOptionPane.showMessageDialog(TresEnRaya.this, "TABLAS");
					}else if (resultado==GANADOR) {
						estadoBotones(false);
						if(turno==1) {
							JOptionPane.showMessageDialog(TresEnRaya.this, "Ganador: " + lblJ1.getText());
						}else {
							JOptionPane.showMessageDialog(TresEnRaya.this, "Ganador: "+ lblJ2.getText());
						}
						btnNueva.setEnabled(true);
					}
					//cambiar el turno
					if(turno==1) {
						turno=2;
					}else {
						turno=1;
					}
					resaltarNombre();
					//turno=(turno%2)+1;
				}
			});
		}

	}//FIN DE REGISTRAR EVENTOS

	public int comprobarFin() {
		//1º: COMPROBAR SI HAY 3 EN RAYA
		//COMPROBAR LAS 3 FILAS
		for(int fila=0;fila<3; fila++) {
			if(arrayBotones[fila*3+0].getBackground().equals(arrayBotones[fila*3+1].getBackground()) &&
					arrayBotones[fila*3+0].getBackground().equals(arrayBotones[fila*3+2].getBackground()) &&	
					!arrayBotones[fila*3+0].getBackground().equals(btnSalir.getBackground())) {
				pos1=fila*3;
				pos2=fila*3+1;
				pos3=fila*3+2;
				return GANADOR;
			}
		}
		//COMPROBAR LAS 3 COLUMNAS
		for(int col=0;col<3; col++) {
			if(arrayBotones[col].getBackground().equals(arrayBotones[col+3].getBackground()) &&
					arrayBotones[col].getBackground().equals(arrayBotones[col+6].getBackground()) &&	
					!arrayBotones[col].getBackground().equals(btnSalir.getBackground())) {
				pos1=col;
				pos2=col+3;
				pos3=col+6;
				return GANADOR;
			}
		}
		//COMPROBAR LAS DOS DIAGONALES
		if(arrayBotones[0].getBackground().equals(arrayBotones[4].getBackground()) &&
				arrayBotones[0].getBackground().equals(arrayBotones[8].getBackground()) &&	
				!arrayBotones[0].getBackground().equals(btnSalir.getBackground())) {
			pos1=0;
			pos2=4;
			pos3=8;
			return GANADOR;
		}
		if(arrayBotones[2].getBackground().equals(arrayBotones[4].getBackground()) &&
				arrayBotones[2].getBackground().equals(arrayBotones[6].getBackground()) &&	
				!arrayBotones[2].getBackground().equals(btnSalir.getBackground())) {
			pos1=2;
			pos2=4;
			pos3=6;
			return GANADOR;
		}
		//COMPROBAR TABLAS (contar cuantas están activadas. Si no hay ninguna hay tablas)
		int activadas=0;
		for(int i=0;i<arrayBotones.length;i++) {
			if(arrayBotones[i].isEnabled()) {
				activadas++;
			}
		}
		if(activadas==0) {
			return TABLAS;
		}

		return NO_FIN;
	}

	protected void elegirJugadores() {
		// ELEGIR DOS JUGADORES DEL FICHERO JUGADORES.TXT DE FORMA ALEATORIA Y PONER SUS 
		//NOMBRES EN LOS DOS JTEXTFIELD
		Scanner sc;
		String linea, ruta;
		int numJugadores, j1, j2;
		try {
			sc = new Scanner(new File("Jugadores.txt"));
			sc.nextLine();
			numJugadores=sc.nextInt(); //falta por leer el ENTER
			sc.nextLine();
			//generar dos numeros aleatorios (SIN REPETIR) entre 1 y numJugadores
			j1=(int)(Math.random()*numJugadores+1);
			do {
				j2=(int)(Math.random()*numJugadores+1);
			} while(j1==j2);
			for(int i=1;i<=numJugadores;i++) {
				linea=sc.nextLine();
				if(j1==i) {
					lblJ1.setText(linea);
				}
				if(j2==i) {
					lblJ2.setText(linea);
				}
			}
			sc.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}





	}

	private void llenarArray(JButton[] arrayBotones) {
		arrayBotones[0]=btn1;
		arrayBotones[1]=btn2;
		arrayBotones[2]=btn3;
		arrayBotones[3]=btn4;
		arrayBotones[4]=btn5;
		arrayBotones[5]=btn6;
		arrayBotones[6]=btn7;
		arrayBotones[7]=btn8;
		arrayBotones[8]=btn9;
	}

	/*FUNCIÓN QUE SIRVA PARA HABILITAR Y PARA DESHABILITAR TOOOOOOOODOS LOS BOTONES DEL JUEGO*/
	public void estadoBotones(boolean estado) {
		for(int i=0;i<arrayBotones.length;i++) {
			arrayBotones[i].setEnabled(estado);
		}
	}

	/*FUNCION PARA RESTAURAR EL COLOR DE LOS 9 BOTONES DEL ARRAY*/
	public void restaurarColor() {
		for(int i=0;i<arrayBotones.length;i++) {
			arrayBotones[i].setBackground(btnSalir.getBackground());
		}
	}
	
	public void resaltarNombre() {
		if(turno==1) {
			lblJ1.setFont(new Font("Tahoma",Font.BOLD + Font.ITALIC,14));
			lblJ1.setForeground(btnColor1.getBackground());
			//quitar el resalte al jugador 2
			lblJ2.setFont(new Font("Tahoma",Font.PLAIN,14));
			lblJ2.setForeground(Color.BLACK);
		}else {
			lblJ2.setFont(new Font("Tahoma",Font.BOLD + Font.ITALIC,14));
			lblJ2.setForeground(btnColor2.getBackground());
			lblJ1.setFont(new Font("Tahoma",Font.PLAIN,14));
			lblJ1.setForeground(Color.BLACK);
		}
	}

}