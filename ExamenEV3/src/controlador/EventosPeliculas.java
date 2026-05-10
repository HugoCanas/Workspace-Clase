package controlador;

import vista.VistaPeliculas;

public class EventosPeliculas {


	private VistaPeliculas vistaPeliculas;
	private String [] peliculas;
	private int [] fechas;
	private int seleccionActual;

	public EventosPeliculas(VistaPeliculas vistaPeliculas) {
		this.vistaPeliculas=vistaPeliculas;
        seleccionActual = -1;
        
        // ── Botón SALIR ────────────────────────────────────────────────
       // vistaPeliculas.getBtnSalir().addActionListener(e -> System.exit(0));
	}
	
	

}
