import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;


public class EventosAreaJuego {
	private AreaJuego areaJuego;
	private int []estadoTeclas;
	private Timer reloj;


	public EventosAreaJuego(AreaJuego areaJuego) {
		this.areaJuego=areaJuego;
		estadoTeclas=new int[4];

		for(int i=0;i<estadoTeclas.length;i++) {
			estadoTeclas[i]=0;
		}

		reloj=new Timer(40, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//MOVER TODOS LOS ELEMENTOS QUE FORMAN PARTE DEL JUEGO
				areaJuego.getCaballo().mover();
				areaJuego.repaint();
			}
		});
		reloj.start();

		areaJuego.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}



			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_LEFT) {
					estadoTeclas[0]=0;
				}else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
					estadoTeclas[1]=0;
				}
				//areaJuego.getCaballo().setEstado(Caballo.QUIETO);
				areaJuego.repaint();
			}


			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_LEFT ) { //|| e.getKeyCode()==KeyEvent.VK_A
					if(areaJuego.getCaballo().getDirH()!=-1) {
						areaJuego.getCaballo().setDirH(-1);
					}else {
						//MODIFICAR POSICION
						areaJuego.getCaballo().setEstado(Caballo.CORRIENDO);
						//areaJuego.getCaballo().mover();
						estadoTeclas[0]=1;
						estadoTeclas[1]=0;
					}
				}else if(e.getKeyCode()==KeyEvent.VK_RIGHT ) { //|| e.getKeyCode()==KeyEvent.VK_D
					if(areaJuego.getCaballo().getDirH()!=1) {
						areaJuego.getCaballo().setDirH(1);
					}else {
						areaJuego.getCaballo().setEstado(Caballo.CORRIENDO);
						//areaJuego.getCaballo().mover();
						estadoTeclas[0]=0;
						estadoTeclas[1]=1;
					}
				}
				areaJuego.repaint();
			}
		});
	}
}