package Usuarios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Conexion.Conexion;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class InicioSesion extends JFrame {

//************************************ COMPONENTES *******************************************************************

	private JPanel Panel=null;
	private	JLabel NombreLabel=null;
	private	JLabel ContraseñaLabel=null;
	private JTextField Usuario=null;
	private JTextField Contraseña=null;
	private JButton Acceder=null;
	private JButton Salir=null;
	
	private Conexion conector;
//************************************************ MAIN *************************************************************	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioSesion frame = new InicioSesion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

//*********************************** CONSTRUCTOR  **********************************************************************
	
	public InicioSesion() {
		inicia();							
	}
	
//*********************************** CONFIGURACION PANELES **********************************************************************
		
	private JPanel getPanel() {
			if (Panel == null) {
				Panel = new JPanel();
				Panel.setLayout(null);
				Panel.add(nombrelabel());
				Panel.add(usuario());
				Panel.add(contresañalabel());
				Panel.add(contraseña());
				Panel.add(acceder());
				Panel.add(salir());
			}
			return Panel;
		}
	
//************************************ CONFIGURACION COMPONENTES *******************************************************************

		private JLabel nombrelabel() {
		if (NombreLabel== null) {
			NombreLabel = new JLabel();
			NombreLabel.setText("Usuario");
			NombreLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			NombreLabel.setBounds(45, 30, 75, 35);
			NombreLabel.setVisible(true);
		}
		return NombreLabel;
		
	}
	private JTextField usuario() {
		if (Usuario== null) {
			Usuario = new JTextField();
			Usuario.setBounds(153, 39, 144, 20);
			Usuario.setColumns(10);
		}
		return Usuario;
		
	}
	private JLabel contresañalabel() {
		if (ContraseñaLabel== null) {
			ContraseñaLabel = new JLabel();
			ContraseñaLabel.setText("Contrase");
			ContraseñaLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			ContraseñaLabel.setBounds(45, 76, 75, 35);
		}
		return ContraseñaLabel;
		
	}
	private JTextField contraseña() {
		if (Contraseña== null) {
			Contraseña = new JTextField();
			Contraseña.setColumns(10);
			Contraseña.setBounds(153, 85, 144, 20);
		}
		return Contraseña;
		
	}
	private JButton acceder() {
		if (Acceder== null) {
			Acceder = new JButton();
			Acceder.setText("Acceder");
			Acceder.setBounds(208, 148, 89, 23);
			Acceder.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					logeo();
					
				}
			});
		}
		return Acceder;
		
	}
	private JButton salir() {
		if (Salir== null) {
			Salir = new JButton();
			Salir.setText("Salir");
			Salir.setBounds(45, 148, 89, 23);
			Salir.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					salirMetodo();
					
				}
			});
		}
		return Salir;
		
	}
	
//********************************** METODOS ************************************************************************

	private void inicia() {
		this.setContentPane(getPanel());
		this.setSize(343, 219);
		this.setResizable(false);
		this.setTitle("Inicio de sesion");
		this.setName("Inicio de sesion");
	}
	
	public void logeo(){
		PreparedStatement ps;
		ResultSet rs;
		conector = new Conexion();
		Connection conexion;
		try {
			conexion = conector.conectar();
			ps=conexion.prepareStatement("SELECT*FROM musuario WHERE nombre_usuario = ?");
			ps.setString(1, Usuario.getText());
			rs =  ps.executeQuery();
			if((rs).next()) {
				String Contrasena = rs.getString("contraseña");
				int nivel = rs.getInt("id_puesto");
				if(Contrasena.equals(Contraseña.getText())){
					
					dispose();
					usuarios m1 = new usuarios();
					m1.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Clave incorrecta");
				}
				
				
			} else {
				JOptionPane.showMessageDialog(null, "El usuario no existe");
			}
			
		} catch (Exception e) {
			
		}	
	}
	
	private void salirMetodo() {
		this.dispose();		
	}
	
}
