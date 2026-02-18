import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JTextArea;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class EnviarMail extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPara;
	private JTextField txtCC;
	private JTextField txtAsunto;
	private JTextArea txtMensaje;
	private JList <String> lstMails;
	private JButton btnFlecha;
	private JButton btnEnviar;
	private JButton btnVolver;
	private GestionCorreo gestionCorreo;
	private DefaultListModel <String> modeloMails;
	private Timer reloj;



	/**
	 * Create the frame.
	 */
	public EnviarMail(GestionCorreo gestionCorreo) {
		setResizable(false);
		this.gestionCorreo=gestionCorreo;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Para:");
		lblNewLabel.setBounds(10, 29, 46, 14);
		contentPane.add(lblNewLabel);

		txtPara = new JTextField();
		txtPara.setEditable(false);
		txtPara.setBounds(81, 26, 448, 20);
		contentPane.add(txtPara);
		txtPara.setColumns(10);

		JLabel lblCc = new JLabel("CC:");
		lblCc.setBounds(10, 72, 46, 14);
		contentPane.add(lblCc);

		JLabel lblAsunto = new JLabel("Asunto:");
		lblAsunto.setBounds(10, 115, 46, 14);
		contentPane.add(lblAsunto);

		txtCC = new JTextField();
		txtCC.setEditable(false);
		txtCC.setColumns(10);
		txtCC.setBounds(81, 69, 448, 20);
		contentPane.add(txtCC);

		txtAsunto = new JTextField();
		txtAsunto.setColumns(10);
		txtAsunto.setBounds(81, 112, 448, 20);
		contentPane.add(txtAsunto);

		JLabel lblMensaje = new JLabel("Mensaje:");
		lblMensaje.setBounds(10, 160, 46, 14);
		contentPane.add(lblMensaje);

		txtMensaje = new JTextArea();
		txtMensaje.setLineWrap(true);
		txtMensaje.setBounds(81, 155, 448, 234);
		contentPane.add(txtMensaje);

		btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(562, 232, 89, 23);
		contentPane.add(btnEnviar);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(562, 291, 89, 23);
		contentPane.add(btnVolver);

		btnFlecha = new JButton(">");
		btnFlecha.setBounds(562, 29, 89, 72);
		contentPane.add(btnFlecha);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(685, 41, 270, 297);
		contentPane.add(scrollPane);

		lstMails = new JList<String>();
		scrollPane.setViewportView(lstMails);
		modeloMails=new DefaultListModel<String>();
		lstMails.setModel(modeloMails);

		registrarEventos();

	}//FIN DEL CONSTRUCTOR
	
	

	public void recibirDatos() {

		if(gestionCorreo.getLstCorreo().getSelectedIndex()!=-1) {

			txtPara.setText(gestionCorreo.getLstCorreo().getSelectedValue());

		}

		for(int i=0;i<gestionCorreo.getLstCorreo().getModel().getSize();i++) {
			//si la i diferente al selectedIndex 

			if(i != gestionCorreo.getLstCorreo().getSelectedIndex()) {
				modeloMails.addElement(gestionCorreo.getLstCorreo().getModel().getElementAt(i));
			}

		}
	}

	private void registrarEventos() {
		btnEnviar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int idMail;
				
				if((idMail=gestionCorreo.getBd().guardarMail(txtAsunto.getText(), txtMensaje.getText()))==0) {
					JOptionPane.showMessageDialog(null, "No se ha podido guardar el mensaje");
					return;
				}
				
				if(gestionCorreo.getBd().guardarEnvios(idMail,txtPara.getText())==0) {
					JOptionPane.showMessageDialog(null, "No se han podido guardar todos los envios");
					return;
				}
			}
		});
		
		lstMails.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				/* si se ha hecho doble click 
				 * pasar el elemento seleccionado 
				 */

				if(e.getClickCount()==2) {
					if(lstMails.getSelectedIndex()>=0) { //si se ha seleccionado algun elemento de la lista 
						if(txtPara.getText().equals("")) { //si no se ha seleccionado ninguno 
							txtPara.setText(lstMails.getSelectedValue()); // set texto de el que has seleccionado 
						}else {
							txtPara.setText(txtPara.getText() + ", " + lstMails.getSelectedValue()); //para hacer concatenar el texto que ya tenias puesto mas el que acabas de clickar 
						}
						modeloMails.remove(lstMails.getSelectedIndex()); //para quitar de la lista el seleccionado 
					}


				}
			}
		});

		reloj=new Timer (25,new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				EnviarMail enviarMail = EnviarMail.this;
				if(btnFlecha.getText().equals(">")) {
					enviarMail.setSize(enviarMail.getWidth()+5, enviarMail.getHeight());
					if(enviarMail.getWidth()>=1000) {
						btnFlecha.setText("<");
						reloj.stop();
					}
				}else {//ES PARA REDUCIR
					enviarMail.setSize(enviarMail.getWidth()-5, enviarMail.getHeight());
					if(enviarMail.getWidth()<=700) {
						btnFlecha.setText(">");
						reloj.stop();
					}
				}
				
			}	
		});

		btnFlecha.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				reloj.start();
			}

		});

		btnVolver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				gestionCorreo.setVisible(true);
				EnviarMail.this.dispose();
			}
		});


	}
}
