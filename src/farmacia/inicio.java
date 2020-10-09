package farmacia;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class inicio extends JFrame {

	private JPanel contentPane;
	private JTextField txtusuario;
	private JTextField txtcontra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inicio frame = new inicio();
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
	public inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtusuario = new JTextField();
		txtusuario.setBounds(145, 67, 86, 20);
		contentPane.add(txtusuario);
		txtusuario.setColumns(10);
		
		txtcontra = new JTextField();
		txtcontra.setBounds(145, 125, 86, 20);
		contentPane.add(txtcontra);
		txtcontra.setColumns(10);
		
		JLabel usuario = new JLabel("Usuario");
		usuario.setBounds(64, 70, 46, 14);
		contentPane.add(usuario);
		
		JLabel contra = new JLabel("Contrase\u00F1a");
		contra.setBounds(29, 128, 81, 14);
		contentPane.add(contra);
		
		JButton btnsalir = new JButton("Salir");
		btnsalir.setBounds(50, 187, 89, 23);
		contentPane.add(btnsalir);
		
		JButton btnacceder = new JButton("Acceder");
		btnacceder.setBounds(202, 187, 89, 23);
		contentPane.add(btnacceder);
	}
}
