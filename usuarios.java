package Usuarios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;

import Conexion.Conexion;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class usuarios extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtnombre;
	private JTextField txtapellido;
	private JTable table;
	private Conexion conector;
	private DefaultTableModel modelo = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombre", "A.Paterno", "A.materno","Edad"
			}
		);
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
		setBounds(100, 100, 544, 317);
		contentPane = new JPanel();
		this.setTitle("Usuarios");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(21, 11, 28, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(46, 8, 48, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(104, 11, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtnombre = new JTextField();
		txtnombre.setBounds(160, 8, 86, 20);
		contentPane.add(txtnombre);
		txtnombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido");
		lblNewLabel_2.setBounds(256, 11, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		txtapellido = new JTextField();
		txtapellido.setBounds(312, 8, 86, 20);
		contentPane.add(txtapellido);
		txtapellido.setColumns(10);
		
		JButton btnbuscar = new JButton("Buscar");
		btnbuscar.setBounds(418, 7, 89, 23);
		btnbuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			limpiarTabla();
			if(txtnombre.getText().equals(null)||txtnombre.getText().equals("")) {
				listar();
			}else {
				Buscar();
			}
			
				
			}
		});
		contentPane.add(btnbuscar);
		
		JButton Btnsalir1 = new JButton("Salir");
		Btnsalir1.setBounds(21, 245, 89, 23);
		contentPane.add(Btnsalir1);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(197, 245, 89, 23);
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Registro m1 = new Registro(true,0);
				m1.setTitle("Nuevo Usuario");
				m1.setVisible(true);
				
				
			}
		});
		
		contentPane.add(btnNuevo);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(312, 245, 89, 23);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int adios = Integer.valueOf((String) modelo.getValueAt(table.getSelectedRow(),0));
				Registro m1 = new Registro(false,adios);
				m1.setTitle("Editar Usuario");

				m1.setVisible(true);
				
				
			}
		});
		contentPane.add(btnEditar);
		
		JButton btnEliminar = new JButton("Eliminar ");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminar();
			}
		});
		btnEliminar.setBounds(418, 245, 89, 23);
		contentPane.add(btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 41, 486, 193);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(modelo);
		scrollPane.setViewportView(table);
		listar();
	}
	
	public void listar() {
		PreparedStatement ps;
		ResultSet rs;
		conector = new Conexion();
		Connection conexion;try {
			conexion = conector.conectar();
			ps=conexion.prepareStatement("SELECT*FROM mempleado");
			rs =  ps.executeQuery();
			while((rs).next()) {
				String []empleado = new String[5];
				empleado[0] = Integer.toString(rs.getInt("id_empleado"));
				empleado[1] = rs.getString("nombre");
				empleado[2] = rs.getString("apat_emp");
				empleado[3] = rs.getString("amat_emp");
				empleado[4] = Integer.toString( rs.getInt("edad"));
			
				modelo.addRow(empleado);
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
			JOptionPane.showMessageDialog(null,"Error el el proceso");
		}	
	}
	
	
	
	private void salirMetodo() {
		this.dispose();		
	}
	
	public void eliminar() {

		int adios = Integer.valueOf((String) modelo.getValueAt(table.getSelectedRow(),0));
		int id = 0;
		PreparedStatement ps;
		ResultSet rs;
		conector = new Conexion();
		Conexion conector2 = new Conexion();
		Connection conexion;
		Connection conexion2;
		Connection conexion3;
		try {
			conexion = conector.conectar();
				
			

			ps=conexion.prepareStatement("DELETE FROM `usu_farmacia`.`musuario` WHERE (`id_empleado` = ?);");
			ps.setInt(1,(adios));
			ps.executeUpdate();
			
				ps=conexion.prepareStatement("DELETE FROM `usu_farmacia`.`mempleado` WHERE (`id_empleado` = ?);");
				ps.setInt(1,(adios));
			
				ps.executeUpdate();
				
	
				
				JOptionPane.showMessageDialog(null,"Registro eliminado");
				limpiarTabla();
				listar();
				
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
			
	
}
	
	public void limpiarTabla(){
		try {
		DefaultTableModel modelo=(DefaultTableModel) table.getModel();
		int filas=table.getRowCount();
		for (int i = 0;i<=filas; i++) {
		modelo.removeRow(0);
		}
		} catch (Exception e) {
	//	JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
		}
		}
	
	
	
	
	
	
	public void Buscar() {
		PreparedStatement ps;
		ResultSet rs;
		conector = new Conexion();
		Connection conexion;try {
			conexion = conector.conectar();
			ps=conexion.prepareStatement("SELECT*FROM mempleado where nombre = ?");
			ps.setString(1,(txtnombre.getText()));
			rs =  ps.executeQuery();
			while((rs).next()) {
				String []empleado = new String[5];
				empleado[0] = Integer.toString(rs.getInt("id_empleado"));
				empleado[1] = rs.getString("nombre");
				empleado[2] = rs.getString("apat_emp");
				empleado[3] = rs.getString("amat_emp");
				empleado[4] = Integer.toString( rs.getInt("edad"));
			
				modelo.addRow(empleado);
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
			JOptionPane.showMessageDialog(null,"Error el el proceso");
		}	
	}
	
	
	
	
	
	
	
}
