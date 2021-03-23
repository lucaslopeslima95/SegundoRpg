
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import javazoom.jl.player.Player;

public class MP3 {
	File mp3;
	private Player player;
	public MP3(File mp3) {
		this.mp3 = mp3;
	}
	public void play() {
		try {
		//	FileInputStream fis = new FileInputStream(mp3);
		//	BufferedInputStream bis = new BufferedInputStream(fis);
		//	this.player = new Player(bis);
		//	this.player.play();
		
		} catch (Exception e) {
			System.out.println("Problema ao tocar " + mp3);
			e.printStackTrace();
		}
	}
	public void stop() {
		try {
			
			this.player.close();
		
		} catch (Exception e) {
			System.out.println("Problema ao tocar " + mp3);
			e.printStackTrace();
		}
	}
}
