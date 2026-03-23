import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class AreaJuego extends JPanel{
	//DATOS
	private int puntuación;
	private Image []fondos;
	private int nivel;
	private Caballo caballo;
	private EventosAreaJuego eventosAreaJuego;

	public AreaJuego() {
		//setBackground(Color.YELLOW);
		//CARGAR EL FONDO Y DIBUJAR
		nivel=1;
		fondos = new Image [3];
		for (int i=0;i<fondos.length;i++) {
			fondos[i] = new ImageIcon(getClass().getResource("mont"+(i+1)+".jpg")).getImage();
		}	
		caballo= new Caballo(this);
		eventosAreaJuego = new EventosAreaJuego(this);
		
	}//FIN DEL CONSTRUCTOR
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);	
		g.drawImage(fondos[nivel], 0, 0, getWidth(), getHeight(), null);
		caballo.dibujar(g);
	}

	public int getPuntuación() {
		return puntuación;
	}

	public void setPuntuación(int puntuación) {
		this.puntuación = puntuación;
	}

	public Image[] getFondos() {
		return fondos;
	}

	public void setFondos(Image[] fondos) {
		this.fondos = fondos;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public Caballo getCaballo() {
		return caballo;
	}

	public void setCaballo(Caballo caballo) {
		this.caballo = caballo;
	}

	public EventosAreaJuego getEventosAreaJuego() {
		return eventosAreaJuego;
	}

	public void setEventosAreaJuego(EventosAreaJuego eventosAreaJuego) {
		this.eventosAreaJuego = eventosAreaJuego;
	}
	
	
	
}
