import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.TitledBorder;

public class JuegoLetras extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JRadioButton rdbtnDificil;
	private JRadioButton rdbtnMedio;
	private JRadioButton rdbtnFacil;
	private JButton btnEmpezar;
	private JButton btnSalir;
	private ButtonGroup grpNivel;
	private AreaJuego areajuego;
	private EventosJuegoLetras eventosJuegoLetras;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JuegoLetras frame = new JuegoLetras();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JuegoLetras() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel, BorderLayout.WEST);
		
		rdbtnFacil = new JRadioButton("Facil");
		rdbtnFacil.setSelected(true);
		
		rdbtnMedio = new JRadioButton("Medio");
		
		rdbtnDificil = new JRadioButton("Dificil");
		
		grpNivel = new ButtonGroup();
		grpNivel.add(rdbtnFacil);
		grpNivel.add(rdbtnMedio);
		grpNivel.add(rdbtnDificil);
		
		
		btnSalir = new JButton("Salir");
		
		btnEmpezar = new JButton("Empezar");
		
		JLabel lblNewLabel = new JLabel("Elige nivel:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnSalir, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnEmpezar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(rdbtnFacil, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(rdbtnMedio, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
						.addComponent(rdbtnDificil, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnFacil)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnMedio)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnDificil)
					.addPreferredGap(ComponentPlacement.RELATED, 288, Short.MAX_VALUE)
					.addComponent(btnEmpezar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSalir)
					.addGap(5))
		);
		panel.setLayout(gl_panel);

		areajuego = new AreaJuego(this);
		contentPane.add(areajuego, BorderLayout.CENTER);
		//PASAMOS AL CUADRADO Y AL CIRCULO AL OBJETO areaJuego para que puyedan conocer su dimension
		areajuego.getCuadrado().setAreaJuego(areajuego);
		areajuego.getCirculo().setAreaJuego(areajuego);
		eventosJuegoLetras = new EventosJuegoLetras(this);
	}

	public JRadioButton getRdbtnDificil() {
		return rdbtnDificil;
	}

	public void setRdbtnDificil(JRadioButton rdbtnDificil) {
		this.rdbtnDificil = rdbtnDificil;
	}

	public JRadioButton getRdbtnMedio() {
		return rdbtnMedio;
	}

	public void setRdbtnMedio(JRadioButton rdbtnMedio) {
		this.rdbtnMedio = rdbtnMedio;
	}

	public JRadioButton getRdbtnFacil() {
		return rdbtnFacil;
	}

	public void setRdbtnFacil(JRadioButton rdbtnFacil) {
		this.rdbtnFacil = rdbtnFacil;
	}

	public JButton getBtnEmpezar() {
		return btnEmpezar;
	}

	public void setBtnEmpezar(JButton btnEmpezar) {
		this.btnEmpezar = btnEmpezar;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}

	public ButtonGroup getGrpNivel() {
		return grpNivel;
	}

	public void setGrpNivel(ButtonGroup grpNivel) {
		this.grpNivel = grpNivel;
	}

	public AreaJuego getAreajuego() {
		return areajuego;
	}

	public void setAreajuego(AreaJuego areajuego) {
		this.areajuego = areajuego;
	}
}
