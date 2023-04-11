package musicstreaming;

import java.util.List;

public class User extends abstractUser{
	private String name;

	public User(String name) {
		this.name = name;
	}

	public void update(Artist artist){
        System.out.println("Modified file contents:");
        System.out.println("File " + artist.getReleasedSong() + " is being released.");

    }
	
}
