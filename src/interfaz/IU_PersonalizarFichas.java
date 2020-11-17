package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import codigo.ColorFichas;
import codigo.Conecta4;

import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.UIManager;

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
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		rdbtnRojoJ1 = new JRadioButton("Rojo");
		rdbtnRojoJ1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		rdbtnRojoJ1.setForeground(Color.RED);
		rdbtnRojoJ1.setBackground(new Color(240, 248, 255));
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
		rdbtnRojoJ1.setBounds(39, 81, 111, 23);
		contentPane.add(rdbtnRojoJ1);
		
		rdbtnAzulJ1 = new JRadioButton("Azul");
		rdbtnAzulJ1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		rdbtnAzulJ1.setForeground(Color.BLUE);
		rdbtnAzulJ1.setBackground(new Color(240, 248, 255));
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
		rdbtnAzulJ1.setBounds(39, 107, 111, 23);
		contentPane.add(rdbtnAzulJ1);
		
		rdbtnMoradoJ1 = new JRadioButton("Morado");
		rdbtnMoradoJ1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		rdbtnMoradoJ1.setForeground(new Color(255, 0, 255));
		rdbtnMoradoJ1.setBackground(new Color(240, 248, 255));
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
		rdbtnMoradoJ1.setBounds(39, 133, 111, 23);
		contentPane.add(rdbtnMoradoJ1);
		
		rdbtnRojoJ2 = new JRadioButton("Rojo");
		rdbtnRojoJ2.setFont(new Font("Tahoma", Font.ITALIC, 11));
		rdbtnRojoJ2.setForeground(Color.RED);
		rdbtnRojoJ2.setBackground(new Color(240, 248, 255));
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
		rdbtnRojoJ2.setBounds(39, 188, 111, 23);
		contentPane.add(rdbtnRojoJ2);
		
		rdbtnAzulJ2 = new JRadioButton("Azul");
		rdbtnAzulJ2.setFont(new Font("Tahoma", Font.ITALIC, 11));
		rdbtnAzulJ2.setForeground(Color.BLUE);
		rdbtnAzulJ2.setBackground(new Color(240, 248, 255));
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
		rdbtnAzulJ2.setBounds(39, 214, 111, 23);
		contentPane.add(rdbtnAzulJ2);
		
		rdbtnMoradoJ2 = new JRadioButton("Morado");
		rdbtnMoradoJ2.setFont(new Font("Tahoma", Font.ITALIC, 11));
		rdbtnMoradoJ2.setForeground(Color.MAGENTA);
		rdbtnMoradoJ2.setBackground(new Color(240, 248, 255));
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
		rdbtnMoradoJ2.setBounds(39, 240, 111, 23);
		contentPane.add(rdbtnMoradoJ2);
		
		JButton btnVolver = new JButton("Aceptar");
		btnVolver.setForeground(Color.BLACK);
		btnVolver.setBackground(SystemColor.control);
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
		
		JLabel txtpnquColorQuieres_1 = new JLabel("Seleccione un color para el Jugador 2:");
		txtpnquColorQuieres_1.setBounds(39, 167, 351, 14);
		contentPane.add(txtpnquColorQuieres_1);
		
		JLabel txtpnquColorQuieres = new JLabel("Seleccione un color para el Jugador 1:");
		txtpnquColorQuieres.setBounds(39, 65, 367, 14);
		contentPane.add(txtpnquColorQuieres);
		
		JLabel lblNewLabel = new JLabel("\u00A1Seleccione un color para ambos jugadores, por favor!");
		lblNewLabel.setForeground(new Color(153, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel.setBounds(39, 29, 400, 14);
		contentPane.add(lblNewLabel);
		
		//Idioma
		if (Conecta4.getConecta4().getIdioma().equals("Euskera")) {
			txtpnquColorQuieres.setText("Aukeratu kolorea 1:");
			rdbtnRojoJ1.setText("Gorria");
			rdbtnAzulJ1.setText("Urdina");
			rdbtnMoradoJ1.setText("Morea");
			txtpnquColorQuieres_1.setText("Aukeratu kolorea 2:");
			rdbtnRojoJ2.setText("Gorria");
			rdbtnAzulJ2.setText("Urdina");
			rdbtnMoradoJ2.setText("Morea");
			btnVolver.setText("Itzuli");
		}
		else {
			if (Conecta4.getConecta4().getIdioma().equals("English")) {
				txtpnquColorQuieres.setText("Select a colour for Player 1:");
				rdbtnRojoJ1.setText("Red");
				rdbtnAzulJ1.setText("Blue");
				rdbtnMoradoJ1.setText("Purple");
				txtpnquColorQuieres_1.setText("Select a colour for Player 2:");
				rdbtnRojoJ2.setText("Red");
				rdbtnAzulJ2.setText("Blue");
				rdbtnMoradoJ2.setText("Purple");
				btnVolver.setText("Back");
			}
		}
		
	}
	
	private boolean fijaColores() {
		String color1;
		if (rdbtnRojoJ1.isSelected() ) {
			color1 = "rojo.png";
		}else if(rdbtnAzulJ1.isSelected()) {
			color1 = "azul.png";
		}else if(rdbtnMoradoJ1.isSelected()){
			color1 = "morado.png";
		}else {
			color1 ="rojo.png";
		}
		String color2;
		if (rdbtnRojoJ2.isSelected()) {
			color2 = "rojo.png";
		}else if(rdbtnAzulJ2.isSelected()) {
			color2 = "azul.png";
		}else if(rdbtnMoradoJ2.isSelected()){
			color2 = "morado.png";
		}else {
			color2 ="azul.png";
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
		}else if(rdbtnMoradoJ2.isSelected()){
			color1 = "morado.png";
		}else {
			color1 = "rojo.png";
		}
		return color1;
	}
	
	public String seleccionJ2() {
		String color2;
		if (rdbtnRojoJ2.isSelected()) {
			color2 = "rojo.png";
		}else if(rdbtnAzulJ2.isSelected()) {
			color2 = "azul.png";
		}else if(rdbtnMoradoJ2.isSelected()){
			color2 = "morado.png";
		}else {
			color2 = "azul.png";
		}
		return color2;
	}
}
