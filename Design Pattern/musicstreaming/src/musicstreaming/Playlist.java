package musicstreaming;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
	private String title;
	private List<Song> songs = new ArrayList<>();

	public Playlist(String title) {
		this.title = title;
	}

	public void play() {
		System.out.println("Playing playlist: " + title);
		for (Song song : songs) {
			song.play();
		}
	}

	public void pause() {
		System.out.println("Pausing playlist: " + title);
		for (Song song : songs) {
			song.pause();
		}
	}

	public void stop() {
		System.out.println("Stopping playlist: " + title);
		for (Song song : songs) {
			song.stop();
		}
	}

	public void create() {
		System.out.println("Stopping playlist: " + title);
		for (Song song : songs) {
			song.stop();
		}
	}

	public void delete() {
		System.out.println("Stopping playlist: " + title);
		for (Song song : songs) {
			song.stop();
		}
	}
}
