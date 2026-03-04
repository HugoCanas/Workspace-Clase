import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class EventosAreaJuego {

	private AreaJuego areaJuego;
	public Timer reloj;
	
	public EventosAreaJuego(AreaJuego areaJuego) {
		this.areaJuego=areaJuego;
		
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
