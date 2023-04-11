package musicstreaming;

public class Song {
	private String title;

	public Song(String title) {
		this.title = title;
	}

	public void play() {
		System.out.println("Playing song: " + title);
	}

	public void pause() {
		System.out.println("Pausing song: " + title);
	}

	public void stop() {
		System.out.println("Stopping song: " + title);
	}
	public void add() {
		System.out.println("add song: " + title);
	}
	public void remove() {
		System.out.println("remove song: " + title);
	}
}
