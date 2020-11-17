package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import codigo.Conecta4;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IU_ayuda extends JFrame {

	private JPanel contentPane;
	private JLabel lblAyuda;
	private JLabel lblInstrucciones1;
	private JLabel lblInstrucciones2;
	private JLabel lblInstrucciones3;
	private JButton rdbtnAtras;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_ayuda frame = new IU_ayuda();
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
	public IU_ayuda() {
		Image icono = new ImageIcon("icono.png").getImage();
		setIconImage(icono);
		setTitle("Ayuda");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblAyuda());
		contentPane.add(getLblInstrucciones1());
		contentPane.add(getLblInstrucciones2());
		contentPane.add(getLblInstrucciones3());
		contentPane.add(getRdbtnAtras());
	}

	private JLabel getLblAyuda() {
		if (lblAyuda == null) {
			if (Conecta4.getConecta4().getIdioma().equals("Castellano")) {
				lblAyuda = new JLabel("AYUDA");
			}
			else {
				if (Conecta4.getConecta4().getIdioma().equals("Euskera")) {
					lblAyuda = new JLabel("LAGUNTZA");
				}
				else {
					lblAyuda = new JLabel("HELP");
				}
			}
			lblAyuda.setHorizontalAlignment(SwingConstants.CENTER);
			lblAyuda.setBounds(24, 26, 464, 28);
			lblAyuda.setFont(new Font("Tahoma", Font.BOLD, 25));
		}
		return lblAyuda;
	}
	private JLabel getLblInstrucciones1() {
		if (lblInstrucciones1 == null) {
			if (Conecta4.getConecta4().getIdioma().equals("Castellano")) {
				lblInstrucciones1 = new JLabel("<html>El Conecta4 es un juego en el que 2 jugadores tratan de hacer una l�nea con 4 fichas antes que el rival en una matriz 6*9.<html>");
			}
			else {
				if (Conecta4.getConecta4().getIdioma().equals("Euskera")) {
					lblInstrucciones1 = new JLabel("<html>4Konektatu 2 jokalari lerro bat egin behar duten joko bat da. Lerro hori egiteko, 4 fitxa behar dira, eta aurkaria egin baino lehen izan behar da 6x9 trokel batean.<html>");
				}
				else{
					lblInstrucciones1 = new JLabel("<html>The Connect4 is a game where 2 players try to make a line with 4 pieces before the rival in a 6*9 matrix.<html>");
				}
			}
			lblInstrucciones1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblInstrucciones1.setVerticalAlignment(SwingConstants.TOP);
			lblInstrucciones1.setBounds(24, 77, 464, 60);
		}
		return lblInstrucciones1;
	}
	private JLabel getLblInstrucciones2() {
		if (lblInstrucciones2 == null) {
			if (Conecta4.getConecta4().getIdioma().equals("Castellano")) {
				lblInstrucciones2 = new JLabel("<html>Para poder meter una ficha en el tablero, deber�s seleccionar una columna, y autom�ticamente se bajar� la ficha a la posici�n que le corresponda, siempre encima de la �ltima ficha metida en esa columna.<html>");
			}
			else {
				if (Conecta4.getConecta4().getIdioma().equals("Euskera")) {
					lblInstrucciones2 = new JLabel("<html>Fitxa bat sartzeko, kolumna bat aukeratu behar duzu, eta fitxa automatikoki jaitsiko da bere tokira, beti kolumna horretara sartu zen azken fitxaren gainean.<html>");
				}
				else {
					lblInstrucciones2 = new JLabel("<html>To input a piece in the board, you have to select a column, and the piece will automatically fall down to its corresponding position, always on top of the last inputted piece from that column.<html>");
				}
			}
			lblInstrucciones2.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblInstrucciones2.setVerticalAlignment(SwingConstants.TOP);
			lblInstrucciones2.setBounds(24, 159, 464, 86);
		}
		return lblInstrucciones2;
	}
	private JLabel getLblInstrucciones3() {
		if (lblInstrucciones3 == null) {
			if (Conecta4.getConecta4().getIdioma().equals("Castellano")) {
				lblInstrucciones3 = new JLabel("<html>En el juego se podr� jugar en modo 2 jugadores y un jugador. Cuando un jugador quiera jugar solo, podr� seleccionar el nivel de dificultad.<html>");
			}
			else {
				if (Conecta4.getConecta4().getIdioma().equals("Euskera")) {
					lblInstrucciones3 = new JLabel("<html>Jokoa 2 jokalarari eta jokalari bakarra moduak ditu. Jokalari bat bakarrik jolastu nahi badu, zailtasun maila aukeratu ahal du.<html>");
				}
				else {
					lblInstrucciones3 = new JLabel("<html>The game allows either 2 players or just one. Single players can select the difficulty level.<html>");
				}
			}
			lblInstrucciones3.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblInstrucciones3.setVerticalAlignment(SwingConstants.TOP);
			lblInstrucciones3.setBounds(24, 252, 464, 85);
		}
		return lblInstrucciones3;
	}
	private JButton getRdbtnAtras() {
		if (rdbtnAtras == null) {
			rdbtnAtras = new JButton("< Atr�s");
			if (Conecta4.getConecta4().getIdioma().equals("Euskera")) {
				rdbtnAtras.setText("< Atzera");
			}
			else {
				if (Conecta4.getConecta4().getIdioma().equals("English")) {
					rdbtnAtras.setText("< Back");
				}
			}
			rdbtnAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					IU_menu1 menu = new IU_menu1();
					menu.setVisible(true);
				}
			});
			rdbtnAtras.setBounds(403, 339, 97, 25);
		}
		return rdbtnAtras;
	}
}
