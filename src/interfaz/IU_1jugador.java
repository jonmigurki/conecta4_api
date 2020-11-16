package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import codigo.Conecta4;
import codigo.EnumTipo;
import codigo.Jugador;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class IU_1jugador extends JFrame {

	private JPanel contentPane;
	private JPanel panelTexto;
	private JPanel panelBtn;
	private JTextField nJugador;
	private JLabel lblNombre;
	private JButton btnAceptar;
	private JButton btnAtras;
	private String level = "";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_1jugador frame = new IU_1jugador();
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
	public IU_1jugador() {
		Image icono = new ImageIcon("icono.png").getImage();
		setIconImage(icono);
		setTitle("CONECTA 4");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 384, 255);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanelTexto(), BorderLayout.CENTER);
		contentPane.add(getPanelBtn(), BorderLayout.SOUTH);
	}
	
	public void ponerDificultad(String lvl) {
		level = lvl;
	}

	private JPanel getPanelTexto() {
		if (panelTexto == null) {
			panelTexto = new JPanel();
			panelTexto.setLayout(null);
			panelTexto.add(getLblNombre());
			panelTexto.add(getNJugador());
		}
		return panelTexto;
	}
	private JPanel getPanelBtn() {
		if (panelBtn == null) {
			panelBtn = new JPanel();
			panelBtn.add(getBtnAceptar());
			panelBtn.add(getBtnAtras());
		}
		return panelBtn;
	}
	private JTextField getNJugador() {
		if (nJugador == null) {
			nJugador = new JTextField();
			nJugador.setBounds(81, 100, 180, 20);
			nJugador.setColumns(10);
		}
		return nJugador;
	}
	private JLabel getLblNombre() {
		if (lblNombre == null) {
			if (Conecta4.getConecta4().getIdioma().equals("Castellano")) {
				lblNombre = new JLabel("Introduzca su nombre/apodo");
				lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblNombre.setBounds(81, 46, 180, 14);
			}
			else {
				if (Conecta4.getConecta4().getIdioma().equals("Euskera")) {
					lblNombre = new JLabel("Idatzi zure izena/gaitzizena");
					lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
					lblNombre.setBounds(81, 46, 180, 14);
				}
				else {
					lblNombre = new JLabel("Input your name/nickname");
					lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
					lblNombre.setBounds(81, 46, 180, 14);
				}
			}
		}
		return lblNombre;
	}
	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Ok");
			btnAceptar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Jugador persona = new Jugador(EnumTipo.USUARIO, getNJugador().getText(),1);
					Jugador maquina;
					if(level.equals("FACIL")) {
						 maquina = new Jugador(EnumTipo.FACIL, "Maquina", 2);
					}else {
						 maquina = new Jugador(EnumTipo.DIFICIL, "Maquina", 2);
					}
					Conecta4.getConecta4().empezarPartida();
					Conecta4.getConecta4().getTablero().setJugadores(persona, maquina);
					Conecta4.getConecta4().getTablero().generarTablero();
					Conecta4.getConecta4().getTablero().iniciarPartida();
					
					IU_juego juego = new IU_juego();
					juego.setModo(level);

					setVisible(false);
					juego.setVisible(true);
				}
			});
		}
		return btnAceptar;
	}
	private JButton getBtnAtras() {
		if (btnAtras == null) {
			btnAtras = new JButton("<<<<");
			btnAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					IU_menu1 atras = new IU_menu1();
					atras.setVisible(true);
					setVisible(false);
				}
			});
		}
		return btnAtras;
	}
}