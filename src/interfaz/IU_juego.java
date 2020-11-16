package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import codigo.Conecta4;
import codigo.Jugador;
//TODO: Solucionar errores y descomentar
//import codigo.Musica;
import codigo.Tablero;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;

//TODO: Solucionar errores y descomentar
//import codigo.Musica;

public class IU_juego extends JFrame implements Observer{

	
	private JPanel contentPane;
	private JPanel panel;
	
	private JMenuBar menuBarra = new JMenuBar();
	private JMenu archivo = new JMenu();
	private JMenu ayuda = new JMenu();
	private JMenuItem nuevo = new JMenuItem();
	private JMenuItem salir = new JMenuItem();
	
	private int ancho = 9;
	private int alto = 6;
	private JButton[][] botones = new JButton[ancho][alto];
	
	private final JPanel panelnorte = new JPanel();
	private final JLabel lblTurnoDe = new JLabel("Turno de:");
	private final JLabel lblTxanda = new JLabel("ren txanda");
	private final JLabel lblJugador = new JLabel();
	
	//TODO: Solucionar errores y descomentar
	//private Musica musica;
	
	private String modo = "";
	
	private boolean fin = false;


	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_juego frame = new IU_juego();
					frame.setVisible(true);
					
					
					
					
					
			/*		System.out.println("EMPEZAMOS");
					Conecta4.getConecta4().empezarPartida();
					Conecta4.getConecta4().getTablero().generarTablero();
					System.out.println(Conecta4.getConecta4().getTablero().getJugador1().getNombre());
					Conecta4.getConecta4().getTablero().iniciarPartida();*/
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	


	/**
	 * Create the frame.
	 */
	public IU_juego() {
		Image icono = new ImageIcon("icono.png").getImage();
		setIconImage(icono);
		setTitle("CONECTA 4");
		
	
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		contentPane.add(panelnorte, BorderLayout.NORTH);
		//TODO: Solucionar errores y descomentar
		//musica = null;

		
		if(Conecta4.getConecta4().getIdioma().equals("Castellano")){
			panelnorte.add(lblTurnoDe);
			lblJugador.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblJugador.setText(Conecta4.getConecta4().getTablero().getJugador1().getNombre());
			lblJugador.setForeground(Color.RED);
			panelnorte.add(lblJugador);
			contentPane.add(getPanelCentro(), BorderLayout.CENTER);
			//TODO: Solucionar errores y descomentar
			//musica = null;

		}else{
			lblJugador.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblJugador.setText(Conecta4.getConecta4().getTablero().getJugador1().getNombre());
			lblJugador.setForeground(Color.RED);
			panelnorte.add(lblJugador);
			panelnorte.add(lblTxanda);
			contentPane.add(getPanelCentro(), BorderLayout.CENTER);
			//TODO: Solucionar errores y descomentar
			//musica = null;

		}
		
		
		
		
/*		
		this.setJMenuBar(menuBarra);
		archivo.setText("Archivo");
		nuevo.setText("Nuevo");
		salir.setText("Salir");
		ayuda.setText("Ayuda");
		
		archivo.add(nuevo);
		archivo.addSeparator();
		archivo.add(salir);
		
		menuBarra.add(archivo);
		menuBarra.add(ayuda);
		
		*/
		
	}
	
	
	private JPanel getPanelCentro() {
		if (panel == null) {
			panel = new JPanel();
			
			Dimension dim = new Dimension(25, 25);
			panel.setLayout(new GridLayout(alto, ancho, 0, 0));
			
			ImageIcon fondoBlanco = null;
			
			Image blanco1 = new ImageIcon("blanco.png").getImage();
			fondoBlanco = new ImageIcon(blanco1.getScaledInstance(50, 50, Image.SCALE_SMOOTH));

			
			
			for (int j = 0; j < alto; j++) {
				for (int i = 0; i < ancho; i++) {
					
				//	Conecta4.getConecta4().getTablero().getCasilla(i, j).addObserver(this);

					
					botones[i][j] = new JButton();
					botones[i][j].setPreferredSize(dim);
					
					botones[i][j].setMargin(new Insets(0, 0, 0, 0));
					
					panel.add(botones[i][j]);
					
					JLabel etiqueta = new JLabel(i + "," + j);
					etiqueta.setVisible(false);
					botones[i][j].add(etiqueta);
					
					botones[i][j].setIcon(fondoBlanco);

					botones[i][j].addMouseListener(new MouseListener() {
						
						@Override
						public void mouseReleased(MouseEvent e) {
						}

						@Override
						public void mousePressed(MouseEvent e) {
						}

						@Override
						public void mouseExited(MouseEvent e) {
						}

						@Override
						public void mouseEntered(MouseEvent e) {
						}

						@Override
						public void mouseClicked(MouseEvent e) {
							if (e.getClickCount() == 1) {
								
								if (e.getButton() == MouseEvent.BUTTON1 && !fin) {
									
									
									if(modo.equals("USUARIO")){
										
										//System.out.println("click izquierdo");
										e.getSource();
										
										String cmd = etiqueta.getText();
										//System.out.println(cmd);
										String splitXY = ",";
										String[] data = cmd.split(splitXY);
										
										int ancho = Integer.parseInt(data[0]);
										int alto = Integer.parseInt(data[1]);
										
										int nuevoAlto = Conecta4.getConecta4().getTablero().meterFicha(ancho, alto);
										
										//System.out.println(Conecta4.getConecta4().getTablero().getCasilla(ancho, alto).getC());
										
										if(nuevoAlto!=-1){
											//String turno = Conecta4.getConecta4().getTablero().getTurno();
											Jugador j = Conecta4.getConecta4().getTablero().getTurnoActual();
		
											ImageIcon color = null;
											
											if(j.getNum()==1){
												lblJugador.setForeground(Color.BLUE);
												//System.out.println(j.getNombre() + " acaba de meter ficha");
												Image rojo1 = new ImageIcon("rojo.png").getImage();
												color = new ImageIcon(rojo1.getScaledInstance(50, 50, Image.SCALE_SMOOTH));

												
												
											}else{
												lblJugador.setForeground(Color.RED);
											//System.out.println(j.getNombre() + " acaba de meter ficha");
												Image azul1 = new ImageIcon("azul.png").getImage();
												color = new ImageIcon(azul1.getScaledInstance(50, 50, Image.SCALE_SMOOTH));

											}
											
											botones[ancho][nuevoAlto].setIcon(color);
	
											
	
											
											Conecta4.getConecta4().getTablero().cambiarTurno();
											Jugador turnoActual = Conecta4.getConecta4().getTablero().getTurnoActual();
											
											lblJugador.setText(turnoActual.getNombre());
											Conecta4.getConecta4().getTablero().comprobarVictoria();
											if(Conecta4.getConecta4().getTablero().hayGanador()){
												//TODO: Solucionar errores y descomentar
												//musica.stopMusica2();
												//musica.playMusica();
												try {
													TimeUnit.SECONDS.sleep(5);
												} catch (InterruptedException e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}
												//musica.playMusica2();
												Jugador ganador = Conecta4.getConecta4().getTablero().getGanador();
											//	System.out.println("Ha ganado " + ganador.getNombre());
												fin = true;
												IU_ganado2 ganado2 = new IU_ganado2();
												setVisible(false);
												ganado2.setVisible(true);
											}
											
											
											
										
										}else{
											
											//System.out.println("VUELVE A SELECCIONAR OTRA CASILLA");
											
										}
								/////////////////////////////////////////////////
										
									}else if(modo.equals("FACIL")){
										
										//System.out.println("ESTAS EN MODO FACIL");
										//System.out.println("click izquierdo");
										e.getSource();
										
										String cmd = etiqueta.getText();
										//System.out.println(cmd);
										String splitXY = ",";
										String[] data = cmd.split(splitXY);
										
										int ancho = Integer.parseInt(data[0]);
										int alto = Integer.parseInt(data[1]);
										
										int nuevoAlto = Conecta4.getConecta4().getTablero().meterFicha(ancho, alto);
										
										//System.out.println(Conecta4.getConecta4().getTablero().getCasilla(ancho, alto).getC());
										
										if(nuevoAlto!=-1){
											//String turno = Conecta4.getConecta4().getTablero().getTurno();
											Jugador j = Conecta4.getConecta4().getTablero().getTurnoActual();
		
											ImageIcon color = null;
											
											
												//lblJugador.setForeground(Color.BLUE);
												//System.out.println(j.getNombre() + " acaba de meter ficha");
											Image rojo1 = new ImageIcon("rojo.png").getImage();
											color = new ImageIcon(rojo1.getScaledInstance(50, 50, Image.SCALE_SMOOTH));

												
											
											
											botones[ancho][nuevoAlto].setIcon(color);
	
											
											
											
											Conecta4.getConecta4().getTablero().cambiarTurno();
											Jugador turnoActual = Conecta4.getConecta4().getTablero().getTurnoActual();
											
											lblJugador.setText(Conecta4.getConecta4().getTablero().getJugador1().getNombre());
											Conecta4.getConecta4().getTablero().comprobarVictoria();
											if(Conecta4.getConecta4().getTablero().hayGanador() && !fin){
												//TODO: Solucionar errores y descomentar
												//musica.stopMusica2();
												//musica.playMusica();
												try {
													TimeUnit.SECONDS.sleep(5);
												} catch (InterruptedException e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}
												//TODO: Solucionar errores y descomentar
												//musica.playMusica2();
												Jugador ganador = Conecta4.getConecta4().getTablero().getGanador();
												//System.out.println("Ha ganado " + ganador.getNombre());
												fin = true;
												//setVisible(false);
												IU_ganado ganado = new IU_ganado();
												ganado.setVisible(true);
												setVisible(false);
												

												
											}
											
											
											
										
										}else{
											
											//System.out.println("VUELVE A SELECCIONAR OTRA CASILLA");
											
										}
										
										
										int[] resultado = Conecta4.getConecta4().getTablero().turnoFacil();
										//System.out.println(resultado[0]);
									//	System.out.println(resultado[1]);
										
										Conecta4.getConecta4().getTablero().cambiarTurno();
										ImageIcon color = null;
										
										Image azul1 = new ImageIcon("azul.png").getImage();
										color = new ImageIcon(azul1.getScaledInstance(50, 50, Image.SCALE_SMOOTH));

									
									
									botones[resultado[0]][resultado[1]].setIcon(color);

									Conecta4.getConecta4().getTablero().comprobarVictoria();
									if(Conecta4.getConecta4().getTablero().hayGanador() && !fin){
										//TODO: Solucionar errores y descomentar
										//musica.stopMusica2();
										//musica.playMusica();
										try {
											TimeUnit.SECONDS.sleep(5);
										} catch (InterruptedException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										//TODO: Solucionar errores y descomentar
										//musica.playMusica2();
										Jugador ganador = Conecta4.getConecta4().getTablero().getGanador();
									//	System.out.println("Ha ganado " + ganador.getNombre());
										fin = true;
										//setVisible(false);
										IU_ganado ganado = new IU_ganado();
										ganado.setVisible(true);
										setVisible(false);
										

										
									}
										
									
									//////////////////
									}else if(modo.equals("DIFICIL")){
										
									//	System.out.println("ESTAS EN MODO DIFICIL");
										//System.out.println("click izquierdo");
										e.getSource();
										
										String cmd = etiqueta.getText();
									//	System.out.println(cmd);
										String splitXY = ",";
										String[] data = cmd.split(splitXY);
										
										int ancho = Integer.parseInt(data[0]);
										int alto = Integer.parseInt(data[1]);
										
										int nuevoAlto = Conecta4.getConecta4().getTablero().meterFicha(ancho, alto);
										
									//	System.out.println(Conecta4.getConecta4().getTablero().getCasilla(ancho, alto).getC());
										
										if(nuevoAlto!=-1){
											//String turno = Conecta4.getConecta4().getTablero().getTurno();
											Jugador j = Conecta4.getConecta4().getTablero().getTurnoActual();
		
											ImageIcon color = null;
											
											
												//lblJugador.setForeground(Color.BLUE);
											//	System.out.println(j.getNombre() + " acaba de meter ficha");
											Image rojo1 = new ImageIcon("rojo.png").getImage();
											color = new ImageIcon(rojo1.getScaledInstance(50, 50, Image.SCALE_SMOOTH));

											
											
											botones[ancho][nuevoAlto].setIcon(color);
	
											
											
											
											Conecta4.getConecta4().getTablero().cambiarTurno();
											Jugador turnoActual = Conecta4.getConecta4().getTablero().getTurnoActual();
											
											lblJugador.setText(Conecta4.getConecta4().getTablero().getJugador1().getNombre());
											Conecta4.getConecta4().getTablero().comprobarVictoria();
											if(Conecta4.getConecta4().getTablero().hayGanador()){
												//TODO: Solucionar errores y descomentar
												//musica.stopMusica2();
												//musica.playMusica();
												try {
													TimeUnit.SECONDS.sleep(5);
												} catch (InterruptedException e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}
												//TODO: Solucionar errores y descomentar
												//musica.playMusica2();
												Jugador ganador = Conecta4.getConecta4().getTablero().getGanador();
												//System.out.println("Ha ganado " + ganador.getNombre());
												fin = true;
												//setVisible(false);
												IU_ganado ganado = new IU_ganado();
												ganado.setVisible(true);
												setVisible(false);
												

												
											}
											
											
											
										
										}else{
											
										//	System.out.println("VUELVE A SELECCIONAR OTRA CASILLA");
											
										}
										
										
										//int[] resultado = 
												Conecta4.getConecta4().getTablero().turnoDificil();
									//	System.out.println(resultado[0]);
									//	System.out.println(resultado[1]);
										
										Conecta4.getConecta4().getTablero().cambiarTurno();
										ImageIcon color = null;
										
										Image azul1 = new ImageIcon("azul.png").getImage();
										color = new ImageIcon(azul1.getScaledInstance(50, 50, Image.SCALE_SMOOTH));

									
									
							//		botones[resultado[0]][resultado[1]].setIcon(new ImageIcon(color));

									Conecta4.getConecta4().getTablero().comprobarVictoria();
									if(Conecta4.getConecta4().getTablero().hayGanador()){
										//TODO: Solucionar errores y descomentar
										//musica.stopMusica2();
										//musica.playMusica();
										try {
											TimeUnit.SECONDS.sleep(5);
										} catch (InterruptedException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										//TODO: Solucionar errores y descomentar
										//musica.playMusica2();
										Jugador ganador = Conecta4.getConecta4().getTablero().getGanador();
										//System.out.println("Ha ganado " + ganador.getNombre());
										fin = true;
										//setVisible(false);
										IU_ganado ganado = new IU_ganado();
										ganado.setVisible(true);
										setVisible(false);
										

										
									}
										
									
									
									
									
									
									
									
									}
									
								////////////////////////////////////////////////////////
								}
									
								}
							
						}
					});
			
				}
			}
			
		}
		return panel;
	}
	
	
	public void setModo(String m) {
		modo = m;
	}
	
	
	/*
	public void crearTablero() {
		Tablero.getTablero().eliminarTablero();
		
		
		getPanelCentro().setSize((faltan dimension x),(falta dimension y));
		setSize();  faltan dimensiones
		
		
		if (timer != null) {
			cont = 0;
			ImageIcon imgD = new ImageIcon("img/r0.png");
			java.awt.Image timerD = imgD.getImage();
			java.awt.Image sizeD = timerD.getScaledInstance(20, 25, 0);
			ImageIcon contador = new ImageIcon(sizeD);
			getLblTiempoC().setIcon(contador);
			getLblTiempoD().setIcon(contador);
			getLblTiempoU().setIcon(contador);

			redimensionarContadorTimer();
			timer.stop();
			timer.restart();
		}
		contadorTimer();
		
		getPanelCentro().removeAll();
		}
	*/	
		
	
	
	@Override
	public void update(Observable o, Object arg) {
		
	/*	if(Conecta4.getConecta4().getTablero().getTurno().equals("Jugador 1")){
			System.out.println("TURNO JUGADOR1 ");
		}
		*/
	}
	
/*	private Timer iniciarTimer() {

		cont = 0;

		
		if (timer == null) {
			timer = new Timer(1000, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					cont++;
					contadorTimer();
				}
			});
			timer.start();
		}
		return timer;
	}

	private void contadorTimer() {

	
		int centenas = cont / 100;
		int decenas = (cont - (centenas * 100)) / 10;
		int unidades = cont - (centenas * 100 + decenas * 10);

		ImageIcon imgD = new ImageIcon("img/r" + decenas + ".png");
		ImageIcon imgU = new ImageIcon("img/r" + unidades + ".png");
		ImageIcon imgC = new ImageIcon("img/r" + centenas + ".png");

		java.awt.Image timerC = imgC.getImage();
		java.awt.Image sizeC = timerC.getScaledInstance(20, 25, 0);
		ImageIcon centena = new ImageIcon(sizeC);

		java.awt.Image timerD = imgD.getImage();
		java.awt.Image sizeD = timerD.getScaledInstance(20, 25, 0);
		ImageIcon decena = new ImageIcon(sizeD);

		java.awt.Image timerU = imgU.getImage();
		java.awt.Image sizeU = timerU.getScaledInstance(20, 25, 0);
		ImageIcon unidad = new ImageIcon(sizeU);

		getLblTiempoC().setIcon(centena);
		getLblTiempoD().setIcon(decena);
		getLblTiempoU().setIcon(unidad);
	
		redimensionarContadorTimer();
	}
	
	private void redimensionarContadorTimer() {

		int width = (getPanelNorte().getWidth()) / 3;
		int inicio = (50 * width) / 100;

		getLblTiempoC().setBounds(inicio - 30, 1, 20, panelNorte.getHeight());
		getLblTiempoD().setBounds(inicio - 10, 1, 20, panelNorte.getHeight());
		getLblTiempoU().setBounds(inicio + 10, 1, 20, panelNorte.getHeight());

	}
*/
	

}
