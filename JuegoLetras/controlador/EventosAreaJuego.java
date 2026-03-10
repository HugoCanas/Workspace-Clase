import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Iterator;

import javax.swing.Timer;

public class EventosAreaJuego {

	private AreaJuego areaJuego;
	private Circulo circuloSeleccionado;
	private Cuadrado cuadradoSeleccionado;
	public Timer reloj;
	int despX,despY;

	public EventosAreaJuego(AreaJuego areaJuego) {
		this.areaJuego=areaJuego;
		circuloSeleccionado= null;
		cuadradoSeleccionado = null;
		despX=despY=0;

		reloj=new Timer(20, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//MOVER TODOS LOS OBJETOS QUE FORMAN PARTE DEL JUEGO
				areaJuego.getCuadrado().mover();
				areaJuego.getCirculo().mover();
				//SI EL CUADRADO COLISIONA CON EL CIRCULO
				if(areaJuego.getCuadrado().getRect().intersects(areaJuego.getCirculo().getRect())) {
					reloj.stop();
				}

				areaJuego.repaint();	
			}
		});

		reloj.start();

		this.areaJuego.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				int mouseX, mouseY;
				mouseX=e.getX();
				mouseY=e.getY();
				Rectangle mouseRect;
				mouseRect = new Rectangle(e.getX(), e.getY(), 1, 1); //LE HACEMOS UN PRQUEÑO RECTANGULO AL RATON 
				//COMPROBAR SI HEMOS COGIDO UN CIRCULO Y ASIGNARLO
				for ( Circulo  circulo : areaJuego.getArrayCirculos() ) {
					if (mouseRect.intersects(circulo.getRect())) {
						circuloSeleccionado = circulo;
						despX=e.getX()-circuloSeleccionado.getPosX();
						despY=e.getY()-circuloSeleccionado.getPosY();
						break;
					}
				}
			}
		}); // FIN DEL MOUSE LISTENER

		areaJuego.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub


			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				if(circuloSeleccionado != null) {
					circuloSeleccionado.setPosX(e.getX()-despX);
					circuloSeleccionado.setPosY(e.getY()-despY);
					areaJuego.repaint();
				}
			}
		});
	}

	public AreaJuego getAreaJuego() {
		return areaJuego;
	}

	public void setAreaJuego(AreaJuego areaJuego) {
		this.areaJuego = areaJuego;
	}

	public Timer getReloj() {
		return reloj;
	}

	public void setReloj(Timer reloj) {
		this.reloj = reloj;
	}


}
