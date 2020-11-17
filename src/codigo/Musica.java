package codigo;

import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.media.AudioClip;

/**
 * Clase utilizada para reproducir y parar la musica en el juego.
 * Utiliza javafx de java8.
 * @author TeamIGN
 *
 */
public class Musica{
	
	private static AudioClip cancionTablero;
	
	private static BooleanProperty playing = new SimpleBooleanProperty(false);
	
	private Musica() {

	}
	
	public static void playMusica()
	{
	    try
	    {
	    	cancionTablero = new AudioClip(Musica.class.getResource("/musica/VictoryFanfare.wav").toString());
			cancionTablero.play();
	    }
	    catch (Exception exc)
	    {
	        exc.printStackTrace(System.out);
	    }
	}
	
	
	public static void playMusica2()
	{
	    try
	    {
	    	cancionTablero = new AudioClip(Musica.class.getResource("/musica/BandaJuego.wav").toString());
			cancionTablero.play();
	    }
	    catch (Exception exc)
	    {
	        exc.printStackTrace(System.out);
	    }
	}
	
	public static void stopMusica2()
	{
		try
	    {
	    	cancionTablero = new AudioClip(Musica.class.getResource("/musica/BandaJuego.wav").toString());
			cancionTablero.stop();
			playing.setValue(false);
	    }
	    catch (Exception exc)
	    {
	        exc.printStackTrace(System.out);
	    }
	}
	
}
