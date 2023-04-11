package musicstreaming;


public class MusicLibraryFacade {

    private Artist artist;
    private User user;
    private Song song;
    private Playlist playlist;

    public MusicLibraryFacade(Artist artist, User user, Song song, Playlist playlist){
        this.artist = artist;
        this.user = user;
        this.song = song;
        this.playlist = playlist;

    }

    public void play(){
        playlist.create();
        playlist.delete();
        song.add();
        song.remove();
    }

    
    
}
