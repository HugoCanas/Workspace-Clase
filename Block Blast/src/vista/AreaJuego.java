package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

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

	//Para la vibracion al hacer combo
	private Timer relojVibracion;
	private int vibracionX;
	private int contVibracion;

	//Para el parpadeo al limpiar lineas
	private Timer relojParpadeo;
	private int contParpadeo;
	private boolean parpadeoVisible;
	private boolean parpadeoActivo;

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
		imgGameOver=new ImageIcon("recursos/FotoDerrota.png").getImage();

		//Vibracion
		vibracionX=0;
		contVibracion=0;
		relojVibracion=new Timer(40,new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				contVibracion++;
				if(contVibracion%2==0) {
					vibracionX=5;
				} else {
					vibracionX=-5;
				}
				repaint();
				if(contVibracion>=8) {
					relojVibracion.stop();
					vibracionX=0;
					contVibracion=0;
					repaint();
				}
			}
		});

		//Parpadeo
		parpadeoActivo=false;
		parpadeoVisible=false;
		contParpadeo=0;
		relojParpadeo=new Timer(60,new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				contParpadeo++;
				parpadeoVisible=!parpadeoVisible;
				repaint();
				if(contParpadeo>=4) {
					relojParpadeo.stop();
					parpadeoActivo=false;
					parpadeoVisible=false;
					contParpadeo=0;
					tablero.limpiarMarcadas();
					repaint();
				}
			}
		});

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
				return false;
			}
		}
		return true;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		if(estado==JUEGO) {
			//Tablero con vibracion
			tablero.dibujar(g,MARGEN_X+vibracionX,MARGEN_Y,Pieza.TAM);

			//Parpadeo
			if(parpadeoActivo && parpadeoVisible) {
				tablero.dibujarParpadeo(g,MARGEN_X+vibracionX,MARGEN_Y,Pieza.TAM);
			}

			//Previsualizacion
			if(mostrarPreview && eventosAreaJuego.getPiezaSeleccionada()!=null) {
				Pieza sel=eventosAreaJuego.getPiezaSeleccionada();
				if(tablero.cabe(sel,previewFila,previewCol)) {
					tablero.dibujarPreview(g,sel,previewFila,previewCol,MARGEN_X+vibracionX,MARGEN_Y,Pieza.TAM);
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
			int imgW=imgGameOver.getWidth(this);
			int imgH=imgGameOver.getHeight(this);
			int panelW=getWidth();
			int panelH=getHeight();
			double escala=Math.max((double)panelW/imgW,(double)panelH/imgH);
			int anchoFinal=(int)(imgW*escala);
			int altoFinal=(int)(imgH*escala);
			int posX=(panelW-anchoFinal)/2;
			int posY=(panelH-altoFinal)/2;
			g.drawImage(imgGameOver,posX,posY,anchoFinal,altoFinal,this);
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

	public Timer getRelojVibracion() {
		return relojVibracion;
	}

	public boolean isParpadeoActivo() {
		return parpadeoActivo;
	}

	public void setParpadeoActivo(boolean parpadeoActivo) {
		this.parpadeoActivo=parpadeoActivo;
	}

	public Timer getRelojParpadeo() {
		return relojParpadeo;
	}
}