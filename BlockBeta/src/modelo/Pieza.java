package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Pieza {

	private static final Color[] COLORES = {
			Color.BLUE, Color.RED, Color.YELLOW,
			Color.GREEN, Color.MAGENTA
	};

	private static final int[][][] FORMAS = {
			{{1,0,0},{0,0,0},{0,0,0}},
			{{1,1,0},{0,0,0},{0,0,0}},
			{{1,1,1},{0,0,0},{0,0,0}},
			{{1,0,0},{1,0,0},{0,0,0}},
			{{1,0,0},{1,0,0},{1,0,0}},
			{{1,1,0},{1,1,0},{0,0,0}},
			{{1,1,1},{1,1,1},{1,1,1}},
			{{1,0,0},{1,0,0},{1,1,0}},
			{{0,1,0},{0,1,0},{1,1,0}},
			{{1,1,0},{1,0,0},{1,0,0}},
			{{1,1,0},{0,1,0},{0,1,0}},
			{{1,1,1},{0,1,0},{0,0,0}},
			{{0,1,1},{1,1,0},{0,0,0}},
			{{1,1,0},{0,1,1},{0,0,0}},
	};

	private int[][] forma;
	private Color color;
	private int posX, posY;
	private int posXinic, posYinic;
	private boolean colocada;

	public Pieza(int posX, int posY) {
		Random r = new Random();
		this.forma = FORMAS[r.nextInt(FORMAS.length)];
		this.color = COLORES[r.nextInt(COLORES.length)];
		this.posX = posX;
		this.posY = posY;
		this.posXinic = posX;
		this.posYinic = posY;
		this.colocada = false;
	}

	// Dibuja solo las celdas con 1
	public void dibujar(Graphics g, int celda) {
		for (int f=0;f<3;f++) {
			for (int c=0;c<3;c++) {
				if (forma[f][c] ==1) {
					int x =posX+c*celda;
					int y =posY+f*celda;
					g.setColor(color);
					g.fillRect(x+2,y+2,celda-4,celda-4);
					g.setColor(Color.BLACK);
					g.drawRect(x+2,y+2,celda-4,celda-4);
				}
			}
		}
	}

	// ¿El clic del ratón cae dentro de alguna celda activa?
	public boolean contiene(int mx,int my,int celda) {
		for (int f=0;f<3;f++) {
			for (int c=0;c<3;c++) {
				if (forma[f][c] ==1) {
					if (mx>=posX+c*celda && mx<posX+(c+1)*celda && my>=posY+f*celda &&my<posY+(f+1)*celda) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public void volverAInicio() {
		posX = posXinic;
		posY = posYinic;
	}

	// Getters y setters
	public int[][] getForma() {
		return forma;
	}
	public Color getColor() { 
		return color;
	}
	public int getPosX() { 
		return posX; 
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) { 
		this.posY = posY; 
	}
	public boolean isColocada() {
		return colocada; 
	}
	public void setColocada(boolean colocada) {
		this.colocada = colocada; 
	}
}