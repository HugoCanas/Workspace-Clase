import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventosAhorcado {

	private Ahorcado ahorcado;
	
	public EventosAhorcado (Ahorcado ahorcado) {
		ahorcado.getBtnNueva().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ahorcado.elegirPalabra();
				ahorcado.getBtnNueva().setEnabled(false);	
				ahorcado.getAreaDibujo().setDesplazamiento(0);
				
			}
		});
		ahorcado.getBtnSalir().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(67);
			}
		});
	}
	
}
