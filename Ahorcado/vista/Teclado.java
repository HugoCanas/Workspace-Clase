import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class Teclado extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton [] arrayTeclado;
	private String letras="ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
	private EventosTeclado eventosTeclado;
	private String palabra;
	private Ahorcado ahorcado;

	/**
	 * Create the panel.
	 */
	public Teclado(Ahorcado ahorcado) {
		this.ahorcado=ahorcado;
		setLayout(new GridLayout(7, 4, 0, 0));

		crearTeclado(); //AÑADIR LAS LETRAS DEL ALFABETO
		eventosTeclado = new EventosTeclado(this);
	}//FIN DEL CONSTRUCTOR


	
	
	private void crearTeclado() {
		//INSTANCIAR ARRAY
		arrayTeclado=new JButton[27];
		
		//AÑADIR LAS 27 TECLAS AL ARRAY Y AL PANEL 
		for(int cont=0;cont<arrayTeclado.length;cont++) {
			arrayTeclado[cont]=new JButton();
			//arrayTeclado[cont].setText('A'+cont+""); //A como caracter con codigo ASCII, por lo cual 65+1 y luego se va sumando mas llegando a la B,C,D...
			arrayTeclado[cont].setText(letras.charAt(cont)+"");
			arrayTeclado[cont].setText(letras.substring(cont,cont+1));
			this.add(arrayTeclado[cont]);
		}
		
	}

	public void estadoTeclado(boolean estado) {
		for (JButton btn : arrayTeclado) {
			btn.setEnabled(estado);
			if(estado) {
				btn.setBackground(null);
			}
		}
	}


	//GETTERS Y SETTERS
	public JButton[] getArrayTeclado() {
		return arrayTeclado;
	}

	public void setArrayTeclado(JButton[] arrayTeclado) {
		this.arrayTeclado = arrayTeclado;
	}




	public String getPalabra() {
		return palabra;
	}




	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}




	public Ahorcado getAhorcado() {
		return ahorcado;
	}




	public void setAhorcado(Ahorcado ahorcado) {
		this.ahorcado = ahorcado;
	}

	
	
}
