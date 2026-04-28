package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import modelo.Pieza;
import vista.PanelJuego;

public class EventosPanelJuego {
    private PanelJuego panel;
    private Pieza piezaSeleccionada;
    private int despX, despY;

    public EventosPanelJuego(PanelJuego panel) {
        this.panel = panel;

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                for (Pieza p : panel.getPiezas()) {
                    if (!p.isColocada() && p.contiene(e.getX(),e.getY(),PanelJuego.CELDA)) {
                        piezaSeleccionada =p;
                        despX =e.getX()-p.getPosX();
                        despY =e.getY()-p.getPosY();
                        break;
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (piezaSeleccionada !=null) {
                    // Por ahora solo vuelve a su sitio
                    piezaSeleccionada.volverAInicio();
                    piezaSeleccionada =null;
                    panel.repaint();
                }
            }
        });

        panel.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseMoved(MouseEvent e) {
            	
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if (piezaSeleccionada !=null) {
                    piezaSeleccionada.setPosX(e.getX()-despX);
                    piezaSeleccionada.setPosY(e.getY()-despY);
                    panel.repaint();
                }
            }
        });
    }
}