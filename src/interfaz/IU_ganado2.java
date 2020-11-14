package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import codigo.Conecta4;
import codigo.EnumTipo;
import codigo.Jugador;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;

public class IU_ganado2 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblHaGanado;
	private JLabel lblGanador;
	private JTextArea area;
	private JButton gif;
	
	//private Image imagen = new ImageIcon("fuegos.gif").getImage();
	private Image imagen = new ImageIcon("euskera.png").getImage();
	private JLabel lblFuegos;
	private JLabel lblTrofeo;
	
	
	
	
//	private JScrollPane scroll;
	
	//PANTALLA GANADOR JUGADOR VS JUGADOR
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IU_ganado2 dialog = new IU_ganado2();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public IU_ganado2() {
		Image icono = new ImageIcon("icono.png").getImage();
		setIconImage(icono);
		setTitle("CONECTA 4");
		setResizable(false);
		setBounds(100, 100, 514, 407);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLblHaGanado());
		contentPanel.add(getLblGanador());
		contentPanel.add(getLblTrofeo());
		contentPanel.add(getLblFuegos());
		
		
		
		
		//contentPanel.add(getLbl());
	//	contentPanel.add(getScrollPane());
		//scroll = new JScrollPane(area);
		
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			
			{
				if(Conecta4.getConecta4().getIdioma().equals("Castellano")){
					JLabel texto = new JLabel("¿Quieres jugar otra partida?                       ");
					buttonPane.add(texto);
				}else{
					JLabel texto = new JLabel("Beste partida bat nahi duzu?                       ");
					buttonPane.add(texto);
				}
				
				
				JButton okButton = new JButton("V");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//Jugar otra partida con los mismos jugadores
						
						
						Conecta4.getConecta4().setFin(true);
						
						/*IU_menu1 menu = new IU_menu1();
						menu.setVisible(true);
						setVisible(false);*/
						
						String j1 = Conecta4.getConecta4().getTablero().getJugador1().nombre;
						String j2 = Conecta4.getConecta4().getTablero().getJugador2().nombre;
						
						Jugador jugador1 = new Jugador(EnumTipo.USUARIO, j1, 1);
						Jugador jugador2 = new Jugador(EnumTipo.USUARIO, j2, 2);
						
						Conecta4.getConecta4().empezarPartida();
						Conecta4.getConecta4().getTablero().setJugadores(jugador1, jugador2);
						Conecta4.getConecta4().getTablero().generarTablero();
						Conecta4.getConecta4().getTablero().iniciarPartida();
						
						IU_juego juego = new IU_juego();
						juego.setModo("USUARIO");
						

						setVisible(false);
						juego.setVisible(true);
						
						
						
					}
				});
				
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("X");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						IU_menu1 menu = new IU_menu1();
						menu.setVisible(true);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		}
	
	private JLabel getLblHaGanado() {
		if (lblHaGanado == null) {
			if(Conecta4.getConecta4().getIdioma().equals("Castellano")){
				lblHaGanado = new JLabel("HA GANADO");
			}else{
				lblHaGanado = new JLabel("IRABAZI DU");
			}			
			lblHaGanado.setHorizontalAlignment(SwingConstants.CENTER);
			lblHaGanado.setFont(new Font("Tahoma", Font.BOLD, 40));
			lblHaGanado.setBounds(12, -10, 472, 80);
			lblHaGanado.setForeground(Color.BLACK);
		}
		return lblHaGanado;
	}
	private JLabel getLblGanador() {
		if (lblGanador == null) {
			lblGanador = new JLabel(Conecta4.getConecta4().getTablero().getGanador().getNombre());
			//lblGanador.setForeground(Color.YELLOW);
			//lblGanador.setBackground(Color.GRAY);
		/*	if(Conecta4.getConecta4().getTablero().getGanador().getNum()==1){
				lblGanador.setForeground(SystemColor.RED);
			}else{
				lblGanador.setForeground(SystemColor.BLUE);
			}*/
			lblGanador.setForeground(Color.BLACK);
			lblGanador.setHorizontalAlignment(SwingConstants.CENTER);
			lblGanador.setFont(new Font("Hobo Std", Font.PLAIN, 25));
			lblGanador.setBounds(15, 125, 472, 120);
		}
		return lblGanador;
	}
	private JLabel getLblFuegos() {
		if (lblFuegos == null) {
			lblFuegos = new JLabel("");
			lblFuegos.setBounds(0, 0, 550, 400);
			
			ImageIcon iconGif = new ImageIcon("fuegos.gif");
			lblFuegos.setIcon(iconGif);
		}
		return lblFuegos;
	}
	private JLabel getLblTrofeo() {
		if (lblTrofeo == null) {
			lblTrofeo = new JLabel("");
			lblTrofeo.setBounds(170, 135, 190, 168);
			
			Image trofeo = new ImageIcon("trofeo.png").getImage();
			ImageIcon iconTrofeo = new ImageIcon(trofeo.getScaledInstance(170, 170, Image.SCALE_SMOOTH));
			
			lblTrofeo.setIcon(iconTrofeo);
		}
		return lblTrofeo;
	}
}
