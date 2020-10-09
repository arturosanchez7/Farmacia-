package farmacia;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class usuarios extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtnombre;
	private JTextField txtapellido;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					usuarios frame = new usuarios();
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
	public usuarios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(10, 11, 28, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(48, 8, 48, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(122, 11, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtnombre = new JTextField();
		txtnombre.setBounds(184, 8, 86, 20);
		contentPane.add(txtnombre);
		txtnombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido");
		lblNewLabel_2.setBounds(290, 11, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		txtapellido = new JTextField();
		txtapellido.setBounds(353, 8, 86, 20);
		contentPane.add(txtapellido);
		txtapellido.setColumns(10);
		
		JButton btnbuscar = new JButton("Buscar");
		btnbuscar.setBounds(504, 7, 89, 23);
		contentPane.add(btnbuscar);
		
		JButton Btnsalir1 = new JButton("Salir");
		Btnsalir1.setBounds(33, 298, 89, 23);
		contentPane.add(Btnsalir1);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(258, 298, 89, 23);
		contentPane.add(btnNuevo);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(367, 298, 89, 23);
		contentPane.add(btnEditar);
		
		JButton btnEliminar = new JButton("Eliminar ");
		btnEliminar.setBounds(470, 298, 89, 23);
		contentPane.add(btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 87, 486, 193);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombre", "Apellido", "Otro"
			}
		));
		scrollPane.setViewportView(table);
	}
}
