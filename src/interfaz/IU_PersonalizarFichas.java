package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import codigo.ColorFichas;

import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;

public class IU_PersonalizarFichas extends JFrame {

	private JPanel contentPane;
	private JRadioButton rdbtnRojoJ1;
	private JRadioButton rdbtnAzulJ1;
	private JRadioButton rdbtnMoradoJ1;
	private JRadioButton rdbtnRojoJ2;
	private JRadioButton rdbtnAzulJ2;
	private JRadioButton rdbtnMoradoJ2;

	public ColorFichas colores;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_PersonalizarFichas frame = new IU_PersonalizarFichas(new ColorFichas());
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
	public IU_PersonalizarFichas(ColorFichas ficha) {
		colores = ficha;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 321);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnquColorQuieres = new JTextPane();
		txtpnquColorQuieres.setForeground(Color.BLACK);
		txtpnquColorQuieres.setBackground(SystemColor.control);
		txtpnquColorQuieres.setText("\u00BFQu\u00E9 color quieres para el Jugador 1?");
		txtpnquColorQuieres.setBounds(39, 30, 291, 20);
		contentPane.add(txtpnquColorQuieres);
		
		JTextPane txtpnquColorQuieres_1 = new JTextPane();
		txtpnquColorQuieres_1.setBackground(SystemColor.control);
		txtpnquColorQuieres_1.setText("\u00BFQu\u00E9 color quieres para el Jugador 2?");
		txtpnquColorQuieres_1.setBounds(39, 168, 271, 20);
		contentPane.add(txtpnquColorQuieres_1);
		
		rdbtnRojoJ1 = new JRadioButton("Rojo");
		rdbtnRojoJ1.addActionListener(new ActionListener() {
			//Si el rojo para J1 ha sido seleccionado
			public void actionPerformed(ActionEvent e) {
				if (rdbtnRojoJ1.isSelected()) {
					//Deshabilitar rojo para J2 y el resto de opciones para J1
					rdbtnRojoJ2.setSelected(false);
					
					rdbtnAzulJ1.setSelected(false);
					rdbtnMoradoJ1.setSelected(false);
				}
					
			}
		});
		rdbtnRojoJ1.setBounds(39, 70, 111, 23);
		contentPane.add(rdbtnRojoJ1);
		
		rdbtnAzulJ1 = new JRadioButton("Azul");
		rdbtnAzulJ1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnAzulJ1.isSelected()) {
					//Deshabilitar rojo para J2 y el resto de opciones para J1
					rdbtnAzulJ2.setSelected(false);
					
					rdbtnRojoJ1.setSelected(false);
					rdbtnMoradoJ1.setSelected(false);
				}
					
			}
		});
		rdbtnAzulJ1.setBounds(39, 96, 111, 23);
		contentPane.add(rdbtnAzulJ1);
		
		rdbtnMoradoJ1 = new JRadioButton("Morado");
		rdbtnMoradoJ1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnMoradoJ1.isSelected()) {
					//Deshabilitar rojo para J2 y el resto de opciones para J1
					rdbtnMoradoJ2.setSelected(false);
					
					rdbtnRojoJ1.setSelected(false);
					rdbtnAzulJ1.setSelected(false);
				}
					
			}
		});
		rdbtnMoradoJ1.setBounds(39, 122, 111, 23);
		contentPane.add(rdbtnMoradoJ1);
		
		rdbtnRojoJ2 = new JRadioButton("Rojo");
		rdbtnRojoJ2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnRojoJ2.isSelected()) {
					//Deshabilitar rojo para J2 y el resto de opciones para J1
					rdbtnRojoJ1.setSelected(false);
					
					rdbtnAzulJ2.setSelected(false);
					rdbtnMoradoJ2.setSelected(false);
				}
					
			}
		});
		rdbtnRojoJ2.setBounds(39, 202, 111, 23);
		contentPane.add(rdbtnRojoJ2);
		
		rdbtnAzulJ2 = new JRadioButton("Azul");
		rdbtnAzulJ2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnAzulJ2.isSelected()) {
					//Deshabilitar rojo para J2 y el resto de opciones para J1
					rdbtnAzulJ1.setSelected(false);
					
					rdbtnRojoJ2.setSelected(false);
					rdbtnMoradoJ2.setSelected(false);
				}
					
			}
		});
		rdbtnAzulJ2.setBounds(39, 228, 111, 23);
		contentPane.add(rdbtnAzulJ2);
		
		rdbtnMoradoJ2 = new JRadioButton("Morado");
		rdbtnMoradoJ2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnMoradoJ2.isSelected()) {
					//Deshabilitar rojo para J2 y el resto de opciones para J1
					rdbtnMoradoJ1.setSelected(false);
					
					rdbtnRojoJ2.setSelected(false);
					rdbtnAzulJ2.setSelected(false);
				}
					
			}
		});
		rdbtnMoradoJ2.setBounds(39, 254, 111, 23);
		contentPane.add(rdbtnMoradoJ2);
		
		JButton btnVolver = new JButton("Aceptar");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//IU_menu1 atras = new IU_menu1();
				//atras.setVisible(true);
				
				if (fijaColores()) {
					setVisible(false);
				}
				
				
			}
		});
		btnVolver.setBounds(370, 254, 89, 23);
		contentPane.add(btnVolver);
	}
	
	private boolean fijaColores() {
		String color1;
		if (rdbtnRojoJ1.isSelected() ) {
			color1 = "rojo.png";
		}else if(rdbtnAzulJ1.isSelected()) {
			color1 = "azul.png";
		}else {
			color1 = "morado.png";
		}
		String color2;
		if (rdbtnRojoJ2.isSelected()) {
			color2 = "rojo.png";
		}else if(rdbtnAzulJ2.isSelected()) {
			color2 = "azul.png";
		}else {
			color2 = "morado.png";
		}
		colores.colorJ1 = color1;
		colores.colorJ2 = color2;
		return true;
	}
	
	public String seleccionJ1() {
		String color1;
		if (rdbtnRojoJ1.isSelected() ) {
			color1 = "rojo.png";
		}else if(rdbtnAzulJ1.isSelected()) {
			color1 = "azul.png";
		}else {
			color1 = "morado.png";
		}
		return color1;
	}
	
	public String seleccionJ2() {
		String color2;
		if (rdbtnRojoJ2.isSelected()) {
			color2 = "rojo.png";
		}else if(rdbtnAzulJ2.isSelected()) {
			color2 = "azul.png";
		}else {
			color2 = "morado.png";
		}
		return color2;
	}
}
