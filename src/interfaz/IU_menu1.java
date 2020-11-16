package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import codigo.ColorFichas;

import codigo.Conecta4;
import codigo.EnumTipo;
import codigo.Jugador;

import java.awt.FlowLayout;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import java.awt.SystemColor;
//TODO: Solucionar errores y descomentar
//import codigo.Musica;

public class IU_menu1 extends JFrame {

	private JPanel contentPane;
	private JPanel panelsur;
	private JButton eng;
	private JButton eus;
	private JButton esp;
	
	private String idioma = "Castellano";
	private JPanel panelcentral;
	private JPanel panel_1;
	private JLabel lblSeleccioneModoDe;
	private JRadioButton rdbtn2Jugadores;
	private JRadioButton rdbtnModoFacil;
	private JRadioButton rdbtnModoDificil;
	private JButton btnJugar;
	private JButton btnAyuda;
	private JLabel lblSeparador;
	private JLabel lblDebesSeleccionarUn;
	private JLabel lblFondo;
	private JLabel lblJugar;
	//TODO: Solucionar errores y descomentar
	//private static Musica musica;
	
	
	private ColorFichas colores = new ColorFichas();

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_menu1 frame = new IU_menu1();
					frame.setVisible(true);
					//frame.setBackground(Color.WHITE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public IU_menu1() {
		Image icono = new ImageIcon("icono.png").getImage();
		setIconImage(icono);
		setTitle("CONECTA 4");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelsur(), BorderLayout.SOUTH);
		contentPane.add(getPanelcentral(), BorderLayout.CENTER);
		//TODO: Solucionar errores y descomentar
		//musica = null;
		//musica.playMusica2();
		
		
		//Incializamos los colores por si el usuario no quiere personalizar
		colores.colorJ1 = "rojo.png";
		colores.colorJ2 = "azul.png";
		
		
	}

	private JPanel getPanelsur() {
		if (panelsur == null) {
			panelsur = new JPanel();
			FlowLayout fl_panelsur = (FlowLayout) panelsur.getLayout();
			fl_panelsur.setAlignment(FlowLayout.RIGHT);
			panelsur.add(getBtnAyuda());
			panelsur.add(getLblSeparador());
			panelsur.add(getCastellano());
			panelsur.add(getEuskera());
			panelsur.add(getEnglish());
			panelsur.setBackground(Color.WHITE);
		}
		return panelsur;
	}
	

	private JButton getBtnAyuda() {
		if (btnAyuda == null) {
			btnAyuda = new JButton();
			btnAyuda.setBackground(Color.BLACK);


			btnAyuda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
					IU_ayuda ayuda = new IU_ayuda();
					ayuda.setVisible(true);
				}
			});
		
		}
		
		//Image ayuda = null;
		
	/*	try {
			ayuda = ImageIO.read(getClass().getResource("../interfaz/ayuda.png"));
			//ayuda = ImageIO.read(getClass().getResource("C:/Users/Jon/Desktop/ayuda.png"));
			ayuda = ayuda.getScaledInstance(25, 40, Image.SCALE_SMOOTH);

			} catch (IOException e1) {
				e1.printStackTrace();
			}*/
		
		//Image ayuda = new ImageIcon("C:/Users/Jon/Desktop/ayuda.png").getImage();
		Image ayuda = new ImageIcon("ayuda.png").getImage();
		ImageIcon ayuda2 = new ImageIcon(ayuda.getScaledInstance(30, 40, Image.SCALE_SMOOTH));

		btnAyuda.setIcon(ayuda2);
		//btnAyuda.setIcon(new ImageIcon(ayuda));
		
		return btnAyuda;
	}
	
	private JButton getEnglish() {
		if (eng == null) {
			eng = new JButton();
			eng.setBackground(Color.WHITE);
			eng.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					idioma = "English";
					Conecta4.getConecta4().setIdioma("English");
					eng.setBackground(Color.YELLOW);
					eus.setBackground(Color.WHITE);
					esp.setBackground(Color.WHITE);
					lblSeleccioneModoDe.setText("Select a game mode:");
					rdbtn2Jugadores.setText("Player vs Player");
					rdbtnModoFacil.setText("Player vs Easy AI");
					rdbtnModoDificil.setText("Player vs Hard AI");
					lblDebesSeleccionarUn.setText("You must choose a game mode");
				}
			});
		}
		Image eng1 = new ImageIcon("english.jpg").getImage();
		ImageIcon eng2 = new ImageIcon(eng1.getScaledInstance(70, 40, Image.SCALE_SMOOTH));
		eng.setIcon(eng2);
		return eng;
	}
	
	private JButton getEuskera() {
		if (eus == null) {
			eus = new JButton();
			eus.setBackground(Color.WHITE);
			eus.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					idioma = "Euskera";
					Conecta4.getConecta4().setIdioma("Euskera");
					eng.setBackground(Color.WHITE);
					eus.setBackground(Color.YELLOW);
					esp.setBackground(Color.WHITE);
					lblSeleccioneModoDe.setText("Joko modu bat aukeratu:");
					rdbtn2Jugadores.setText("Jokalaria VS Jokalaria");
					rdbtnModoFacil.setText("Jokalaria VS Ordenagailu tentela");
					rdbtnModoDificil.setText("Jokalaria VS Ordenagailu azkarra");
					lblDebesSeleccionarUn.setText("Joko modu bat aukeratu behar duzu");
				}
			});
		}
		Image eusk = new ImageIcon("euskera.png").getImage();
		ImageIcon eus2 = new ImageIcon(eusk.getScaledInstance(70, 40, Image.SCALE_SMOOTH));
		eus.setIcon(eus2);
		return eus;
	}
	
	private JButton getCastellano() {
		if (esp == null) {
			esp = new JButton();
			esp.setBackground(Color.YELLOW);
			esp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					idioma = "Castellano";
					Conecta4.getConecta4().setIdioma("Castellano");
					eng.setBackground(Color.WHITE);
					eus.setBackground(Color.WHITE);
					esp.setBackground(Color.YELLOW);
					lblSeleccioneModoDe.setText("Seleccione modo de juego:");
					rdbtn2Jugadores.setText("Jugador VS Jugador");
					rdbtnModoFacil.setText("Jugador VS Ordenador tonto");
					rdbtnModoDificil.setText("Jugador VS Ordenador listo");
					lblDebesSeleccionarUn.setText("Debes seleccionar un modo de juego");
				}
			});
		}
		Image esp1 = new ImageIcon("castellano.png").getImage();
		ImageIcon esp2 = new ImageIcon(esp1.getScaledInstance(70, 40, Image.SCALE_SMOOTH));
		esp.setIcon(esp2);
		return esp;
	}
	
	private JPanel getPanelcentral() {
		if (panelcentral == null) {
			panelcentral = new JPanel();
			panelcentral.setLayout(new BorderLayout(0, 0));
			panelcentral.add(getPanel_1_1(), BorderLayout.CENTER);
		}
		return panelcentral;
	}
	private JPanel getPanel_1_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.add(getLblSeleccioneModoDe());
			panel_1.add(getRdbtn2Jugadores());
			panel_1.add(getRdbtnModoFacil());
			panel_1.add(getRdbtnModoDificil());
			panel_1.add(getBtnJugar());
			
			ButtonGroup btngroup1 = new ButtonGroup();
			btngroup1.add(getRdbtn2Jugadores());
			btngroup1.add(getRdbtnModoFacil());
			btngroup1.add(getRdbtnModoDificil());
			panel_1.add(getLblDebesSeleccionarUn());
			panel_1.add(getLblJugar());
			
			
			//BOTON PERSONALIZAAAAAAAAARRRRRRRRRRRRRRRR
			JButton btnPersonalizar = new JButton("Personalizar fichas");
			btnPersonalizar.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnPersonalizar.setBackground(Color.WHITE);
			btnPersonalizar.setForeground(Color.MAGENTA);
			btnPersonalizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					//Al hacer click en el botón, se abre la ventana de personalización
					IU_PersonalizarFichas pers = new IU_PersonalizarFichas(colores);
					pers.setVisible(true);
				}
			});
			btnPersonalizar.setBounds(318, 402, 188, 23);
			panel_1.add(btnPersonalizar);
			panel_1.add(getLblFondo());

		}
		return panel_1;
	}
	private JLabel getLblSeleccioneModoDe() {
		if (lblSeleccioneModoDe == null) {
			lblSeleccioneModoDe = new JLabel("Seleccione modo de juego:");
			lblSeleccioneModoDe.setFont(new Font("Arial", Font.PLAIN, 17));
			lblSeleccioneModoDe.setHorizontalAlignment(SwingConstants.CENTER);
			lblSeleccioneModoDe.setBounds(12, 180, 286, 28);
		}
		return lblSeleccioneModoDe;
	}
	private JRadioButton getRdbtn2Jugadores() {
		if (rdbtn2Jugadores == null) {
			rdbtn2Jugadores = new JRadioButton("Jugador VS Jugador");
			rdbtn2Jugadores.setFont(new Font("Tahoma", Font.PLAIN, 15));
			rdbtn2Jugadores.setBounds(95, 224, 176, 25);
			rdbtn2Jugadores.setBackground(Color.WHITE);
			rdbtn2Jugadores.setForeground(Color.BLACK);
		}
		return rdbtn2Jugadores;
	}
	private JRadioButton getRdbtnModoFacil() {
		if (rdbtnModoFacil == null) {
			rdbtnModoFacil = new JRadioButton("Jugador VS Ordenador tonto");
			rdbtnModoFacil.setFont(new Font("Tahoma", Font.PLAIN, 15));
			rdbtnModoFacil.setBounds(95, 259, 240, 25);
			rdbtnModoFacil.setBackground(Color.WHITE);
			rdbtnModoFacil.setForeground(Color.BLACK);
		}
		return rdbtnModoFacil;
	}
	private JRadioButton getRdbtnModoDificil() {
		if (rdbtnModoDificil == null) {
			rdbtnModoDificil = new JRadioButton("Jugador VS Ordenador listo");
			rdbtnModoDificil.setFont(new Font("Tahoma", Font.PLAIN, 15));
			rdbtnModoDificil.setBounds(95, 296, 240, 25);
			rdbtnModoDificil.setBackground(Color.WHITE);
			rdbtnModoDificil.setForeground(Color.BLACK);
		}
		return rdbtnModoDificil;
	}
	private JButton getBtnJugar() {
		if (btnJugar == null) {
			
			btnJugar = new JButton("");
			btnJugar.setBounds(423, 250, 70, 70);
			btnJugar.setBackground(Color.WHITE);
			
			btnJugar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					if(rdbtn2Jugadores.isSelected()){
						IU_2jugadores nombres = new IU_2jugadores();
						setVisible(false);
						
						nombres.ponerColores(colores);
						
						nombres.setVisible(true);
						
						
					}else if(rdbtnModoFacil.isSelected()){
						IU_1jugador interfaz = new IU_1jugador();
						
						//cambio
						interfaz.ponerColores(colores);
						
						interfaz.ponerDificultad("FACIL");
						setVisible(false);
						interfaz.setVisible(true);
						
						
					}else if(rdbtnModoDificil.isSelected()){
						IU_1jugador interfaz = new IU_1jugador();
						
						//cambio
						interfaz.ponerColores(colores);
						
						interfaz.ponerDificultad("DIFICIL");
						setVisible(false);
						interfaz.setVisible(true);
						
						
					}else{
						lblDebesSeleccionarUn.setForeground(SystemColor.RED);
					}

				}
			});
		}
		
		Image play = null;
	/*	
		try {
			play = ImageIO.read(getClass().getResource("../interfaz/play.png"));
			play = play.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		*/
		
		Image play1 = new ImageIcon("play.png").getImage();
		ImageIcon play2 = new ImageIcon(play1.getScaledInstance(50, 50, Image.SCALE_SMOOTH));

		btnJugar.setIcon(play2);
		//btnAyuda.setIcon(new ImageIcon(ayuda));
		

		//btnJugar.setIcon(new ImageIcon(play));
		return btnJugar;
	}
	
	private JLabel getLblSeparador() {
		if (lblSeparador == null) {
			lblSeparador = new JLabel("                               ");
		}
		
		return lblSeparador;
	}
	private JLabel getLblDebesSeleccionarUn() {
		if (lblDebesSeleccionarUn == null) {
			lblDebesSeleccionarUn = new JLabel("Debes seleccionar un modo de juego");
			lblDebesSeleccionarUn.setBackground(Color.WHITE);
			lblDebesSeleccionarUn.setForeground(Color.WHITE);
			lblDebesSeleccionarUn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			lblDebesSeleccionarUn.setBounds(51, 342, 234, 16);
			if (idioma == "Castellano") {
				lblDebesSeleccionarUn.setText("Debes seleccionar un modo de juego");
			}
			else if (idioma == "Euskera") {
				lblDebesSeleccionarUn.setText("Joko modu bat aukeratu behar duzu");
			}
			else if (idioma == "English") {
				lblDebesSeleccionarUn.setText("You must choose a game mode");
			}
		}
		return lblDebesSeleccionarUn;
	}
	private JLabel getLblFondo() {
		if (lblFondo == null) {
			lblFondo = new JLabel("");
			lblFondo.setFont(new Font("Tahoma", Font.BOLD, 17));
			lblFondo.setBounds(0, -70, 684, 604);
			ImageIcon fondo = new ImageIcon("fondo.png");
			lblFondo.setIcon(fondo);
		}
		return lblFondo;
	}
	private JLabel getLblJugar() {
		if (lblJugar == null) {
			lblJugar = new JLabel("JUGAR");
			lblJugar.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblJugar.setBounds(429, 326, 77, 16);
		}
		return lblJugar;
	}
}
