import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventosJuegoLetras {


	private JuegoLetras juegoLetras;

	public EventosJuegoLetras(JuegoLetras juegoLetras) {
		this.juegoLetras=juegoLetras;
		
		juegoLetras.getBtnEmpezar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//DESACTIVAR BOTON EMPEZAR
				juegoLetras.getBtnEmpezar().setEnabled(false);
				//DESACTIVAR RADIOBUTTON DE NIVEL
				juegoLetras.getRdbtnFacil().setEnabled(false);
				juegoLetras.getRdbtnMedio().setEnabled(false);
				juegoLetras.getRdbtnDificil().setEnabled(false);
				//CREAR LOS ARRAYS DE CIRCULOS Y CUADRADOS EN AREADIBUJO
				juegoLetras.getAreajuego().crearObjetos();
				//PARAR EL RELOJ
				juegoLetras.getAreajuego().getEventosAreaJuego().getReloj().stop();
				//CAMBIAR EL ESTADO JUEGO
				juegoLetras.getAreajuego().setEstadoJuego(AreaJuego.JUEGO);
				//REPAINT
				juegoLetras.getAreajuego().repaint();
			}
		});
	}
}
