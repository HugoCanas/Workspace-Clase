package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import modelo.Pieza;
import modelo.Tablero;
import vista.AreaJuego;

public class EventosAreaJuego {

	private AreaJuego areaJuego;
	private Pieza piezaSeleccionada;
	int despX,despY;

	public EventosAreaJuego(AreaJuego areaJuego) {
		this.areaJuego=areaJuego;

		this.areaJuego.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				if(areaJuego.getEstado()==AreaJuego.GAME_OVER) return;
				//Comprobar si hemos pulsado sobre una pieza
				for(Pieza p : areaJuego.getArrayPiezas()) {
					if(!p.isColocada() && p.contiene(e.getX(),e.getY())) {
						piezaSeleccionada=p;
						despX=e.getX()-p.getPosX();
						despY=e.getY()-p.getPosY();
						break;
					}
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if(piezaSeleccionada==null) return;

				Tablero t=areaJuego.getTablero();
				//Calcular fila y col usando el bloque donde se agarro
				int fila=Math.round((float)(piezaSeleccionada.getPosY()-AreaJuego.OFFSET_Y)/Pieza.TAM);
				int col=Math.round((float)(piezaSeleccionada.getPosX()-AreaJuego.OFFSET_X)/Pieza.TAM);

				if(t.cabe(piezaSeleccionada,fila,col)) {
					//Colocar la pieza
					t.colocar(piezaSeleccionada,fila,col);
					piezaSeleccionada.setColocada(true);

					//Comprobar si las 3 estan colocadas para generar nueva ronda
					boolean todasColocadas=true;
					for(Pieza p : areaJuego.getArrayPiezas()) {
						if(!p.isColocada()) {
							todasColocadas=false;
							break;
						}
					}
					if(todasColocadas) {
						areaJuego.generarPiezas();
					}

					//Comprobar game over
					if(areaJuego.hayGameOver()) {
						areaJuego.setEstado(AreaJuego.GAME_OVER);
					}
				} else {
					//No cabe, vuelve a su sitio
					piezaSeleccionada.volverAInicio();
				}

				piezaSeleccionada=null;
				areaJuego.setMostrarPreview(false);
				areaJuego.repaint();
			}
		}); //FIN DEL MOUSE LISTENER

		areaJuego.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				if(piezaSeleccionada==null) return;
				piezaSeleccionada.setPosX(e.getX()-despX);
				piezaSeleccionada.setPosY(e.getY()-despY);

				//Calcular preview
				int fila=Math.round((float)(piezaSeleccionada.getPosY()-AreaJuego.OFFSET_Y)/Pieza.TAM);
				int col=Math.round((float)(piezaSeleccionada.getPosX()-AreaJuego.OFFSET_X)/Pieza.TAM);
				areaJuego.setPreviewFila(fila);
				areaJuego.setPreviewCol(col);
				areaJuego.setMostrarPreview(true);

				areaJuego.repaint();
			}
		});
	}

	//GETTERS Y SETTERS
	public AreaJuego getAreaJuego() {
		return areaJuego;
	}

	public void setAreaJuego(AreaJuego areaJuego) {
		this.areaJuego=areaJuego;
	}

	public Pieza getPiezaSeleccionada() {
		return piezaSeleccionada;
	}

	public void setPiezaSeleccionada(Pieza piezaSeleccionada) {
		this.piezaSeleccionada=piezaSeleccionada;
	}
}