package vista;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import modelo.Pieza;

public class PanelTablero extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final int FILAS = 8;
	private static final int COLS  = 8;
	private static final int CELDA = 50;
	private Pieza pieza;

	public PanelTablero() {
		setBackground(Color.BLACK);

		int[][] forma = {
			{1, 0, 0},
			{1, 0, 0},
			{1, 1, 0}
		};
		pieza = new Pieza(forma, Color.BLUE);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		dibujarTablero(g);
		dibujarPieza(g);
	}

	private void dibujarTablero(Graphics g) {
		for (int fila = 0; fila < FILAS; fila++) {
			for (int col = 0; col < COLS; col++) {
				int x = col*CELDA;
				int y = fila*CELDA;
				g.setColor(new Color(30, 30, 50));
				g.fillRect(x+2, y+2, CELDA-4, CELDA-4);
				g.setColor(new Color(60, 60, 90));
				g.drawRect(x+2, y+2, CELDA-4, CELDA-4);
			}
		}
	}

	private void dibujarPieza(Graphics g) {
		int[][] forma = pieza.getForma();
		for (int fila = 0; fila < 3; fila++) {
			for (int col = 0; col < 3; col++) {
				if (forma[fila][col] == 1) {
					int x = col*CELDA;
					int y = fila*CELDA;
					g.setColor(pieza.getColor());
					g.fillRect(x+2, y+2, CELDA-4, CELDA-4);
				}
			}
		}
	}
}