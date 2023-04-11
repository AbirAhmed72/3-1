package musicstreaming;

import java.util.ArrayList;
import java.util.List;

public abstract class Artist {
    private ArrayList<User> users = new ArrayList<User>();

	private String name;
	private List<Song> releasedSongs;

	public Artist(String name) {
		super();
		this.name = name;
		this.releasedSongs = new ArrayList<Song>();
	}

	public void releaseSong(Song song) {
		releasedSongs.add(song);
	}

	public String getReleasedSong() {
		return "Latest song";
	}

	public void register(User user){
        users.add(user);
    }

    public void unregister(User user){
        users.remove(user);
    }

    public void Notify(){
        for(User user: users) 
	        user.update(this);
    }
}
