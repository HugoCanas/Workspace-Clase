package vista;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import controlador.EventosPanelJuego;
import modelo.Pieza;

public class PanelJuego extends JPanel {
	private static final long serialVersionUID = 1L;

	public static final int CELDA = 40;
	public static final int FILAS = 8;
	public static final int COLS = 8;
	public static final int OFFSET_X = 40;
	public static final int OFFSET_Y = 20;

	// Posiciones X donde aparecen las 3 piezas abajo
	public static final int Y_PIEZAS = 380;
	public static final int[] X_PIEZAS = {20, 170, 320};

	private ArrayList<Pieza> piezas;

	public PanelJuego() {
		setBackground(Color.BLACK);
		setPreferredSize(new java.awt.Dimension(460, 560));
		piezas = new ArrayList<>();
		generarPiezas();
		new EventosPanelJuego(this);
	}

	public void generarPiezas() {
		piezas.clear();
		for (int i = 0; i < 3; i++) {
			piezas.add(new Pieza(X_PIEZAS[i], Y_PIEZAS));
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		dibujarTablero(g);
		for (Pieza p : piezas) {
			if (!p.isColocada()) {
				p.dibujar(g, CELDA);
			}
		}
	}

	private void dibujarTablero(Graphics g) {
		for (int f=0;f<FILAS;f++) {
			for (int c=0;c<COLS;c++) {
				int x=OFFSET_X+c*CELDA;
				int y=OFFSET_Y+f*CELDA;
				g.setColor(new Color(30, 30, 50));
				g.fillRect(x+2,y+2,CELDA-4,CELDA-4);
				g.setColor(new Color(60, 60, 90));
				g.drawRect(x+2,y+2,CELDA-4,CELDA-4);
			}
		}
	}
	
	

	public ArrayList<Pieza> getPiezas() { 
		return piezas;
	}
}