package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import modelo.Pieza;
import modelo.PiezaEspecial;
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
				if(areaJuego.getEstado()==AreaJuego.GAME_OVER) {
					comprobarBotonesGameOver(e.getX(),e.getY());
					return;
				}
				if(areaJuego.isParpadeoActivo()) return;
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
				//Calculo fila y col
				int fila=Math.round((float)(piezaSeleccionada.getPosY()-AreaJuego.MARGEN_Y)/Pieza.TAM);
				int col=Math.round((float)(piezaSeleccionada.getPosX()-AreaJuego.MARGEN_X)/Pieza.TAM);

				if(t.cabe(piezaSeleccionada,fila,col)) {
					t.colocar(piezaSeleccionada,fila,col);
					piezaSeleccionada.setColocada(true);

					int lineas=t.detectarLineas();
					if(lineas>0) {
						areaJuego.setParpadeoActivo(true);
						areaJuego.getRelojParpadeo().start();
						//Sumar combo
						areaJuego.setCombo(areaJuego.getCombo()+1);
						//Puntos combo
						int pts=lineas*10*areaJuego.getCombo();
						if(piezaSeleccionada instanceof PiezaEspecial) {
							pts=pts*2;
						}
						areaJuego.setPuntuacion(areaJuego.getPuntuacion()+pts);
						if(lineas>=2) {
							areaJuego.getRelojVibracion().start();
						}
					} else {
						areaJuego.setCombo(0);
					}


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


					if(areaJuego.comprobarGameOver()) {
						areaJuego.setEstado(AreaJuego.GAME_OVER);
					}
				} else {
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

				//Calculo preview
				int fila=Math.round((float)(piezaSeleccionada.getPosY()-AreaJuego.MARGEN_Y)/Pieza.TAM);
				int col=Math.round((float)(piezaSeleccionada.getPosX()-AreaJuego.MARGEN_X)/Pieza.TAM);
				areaJuego.setPreviewFila(fila);
				areaJuego.setPreviewCol(col);
				areaJuego.setMostrarPreview(true);

				areaJuego.repaint();
			}
		});
	}


	private void comprobarBotonesGameOver(int mx, int my) {
		int imgX=areaJuego.getImgDibX();
		int imgY=areaJuego.getImgDibY();
		int imgW=areaJuego.getImgDibAncho();
		int imgH=areaJuego.getImgDibAlto();

		//clic a porcentaje en imagen
		double porcX=(double)(mx-imgX)/imgW;
		double porcY=(double)(my-imgY)/imgH;


		if(porcX>=0.30 && porcX<=0.48 && porcY>=0.78 && porcY<=0.93) {
			areaJuego.reiniciar();
		}

		if(porcX>=0.52 && porcX<=0.70 && porcY>=0.78 && porcY<=0.93) {
			System.exit(0);
		}
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