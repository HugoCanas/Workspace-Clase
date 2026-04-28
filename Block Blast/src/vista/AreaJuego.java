package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import controlador.EventosAreaJuego;
import modelo.Pieza;
import modelo.Tablero;

public class AreaJuego extends JPanel {

	private static final long serialVersionUID = 1L;

	public static final int MARGEN_X=40;
	public static final int MARGEN_Y=20;
	public static final int Y_PIEZAS=380;
	public static final int[] X_PIEZAS={20,170,320};

	public static final int JUEGO=0;
	public static final int GAME_OVER=1;

	private Tablero tablero;
	private ArrayList<Pieza> arrayPiezas;
	private EventosAreaJuego eventosAreaJuego;
	private int estado;
	private int puntuacion;

	//Para la previsualizacion
	private int previewFila,previewCol;
	private boolean mostrarPreview;

	//Imagen game over
	private Image imgGameOver;

	//CONSTRUCTOR
	public AreaJuego() {
		setBackground(Color.BLACK);
		setPreferredSize(new java.awt.Dimension(460,560));
		tablero=new Tablero();
		arrayPiezas=new ArrayList<Pieza>();
		estado=JUEGO;
		puntuacion=0;
		mostrarPreview=false;
		previewFila=-1;
		previewCol=-1;
		imgGameOver=new ImageIcon(getClass().getResource("/FotoDerrota.png")).getImage();
		generarPiezas();
		eventosAreaJuego=new EventosAreaJuego(this);
	}

	//Crear 3 piezas nuevas
	public void generarPiezas() {
		arrayPiezas.clear();
		for(int i=0;i<3;i++) {
			arrayPiezas.add(new Pieza(X_PIEZAS[i],Y_PIEZAS));
		}
	}

	//Comprobar si ninguna pieza cabe -> game over
	public boolean comprobarGameOver() {
		for(Pieza p : arrayPiezas) {
			if(!p.isColocada() && tablero.cabeEnAlgunSitio(p)) {
				return false; //si alguna cabe no es game over
			}
		}
		return true;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		if(estado==JUEGO) {
			//Tablero
			tablero.dibujar(g,MARGEN_X,MARGEN_Y,Pieza.TAM);

			//Previsualizacion
			if(mostrarPreview && eventosAreaJuego.getPiezaSeleccionada()!=null) {
				Pieza sel=eventosAreaJuego.getPiezaSeleccionada();
				if(tablero.cabe(sel,previewFila,previewCol)) {
					tablero.dibujarPreview(g,sel,previewFila,previewCol,MARGEN_X,MARGEN_Y,Pieza.TAM);
				}
			}

			//Piezas no colocadas
			for(Pieza p : arrayPiezas) {
				if(!p.isColocada()) {
					p.dibujar(g);
				}
			}

			//Puntuacion abajo
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial",Font.BOLD,18));
			g.drawString("Puntos: "+puntuacion,20,540);

		} else if(estado==GAME_OVER) {
			//Dibujar la imagen de game over
			imgGameOver=new ImageIcon(getClass().getResource("/FotoDerrota.png")).getImage();
			}
	}

	//GETTERS Y SETTERS
	public Tablero getTablero() {
		return tablero;
	}

	public void setTablero(Tablero tablero) {
		this.tablero=tablero;
	}

	public ArrayList<Pieza> getArrayPiezas() {
		return arrayPiezas;
	}

	public void setArrayPiezas(ArrayList<Pieza> arrayPiezas) {
		this.arrayPiezas=arrayPiezas;
	}

	public EventosAreaJuego getEventosAreaJuego() {
		return eventosAreaJuego;
	}

	public void setEventosAreaJuego(EventosAreaJuego eventosAreaJuego) {
		this.eventosAreaJuego=eventosAreaJuego;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado=estado;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion=puntuacion;
	}

	public int getPreviewFila() {
		return previewFila;
	}

	public void setPreviewFila(int previewFila) {
		this.previewFila=previewFila;
	}

	public int getPreviewCol() {
		return previewCol;
	}

	public void setPreviewCol(int previewCol) {
		this.previewCol=previewCol;
	}

	public boolean isMostrarPreview() {
		return mostrarPreview;
	}

	public void setMostrarPreview(boolean mostrarPreview) {
		this.mostrarPreview=mostrarPreview;
	}
}