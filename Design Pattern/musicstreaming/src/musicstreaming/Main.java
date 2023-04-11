package musicstreaming;

public class Main {

    public static void main(String[] args) {
        Playlist playlist = new Playlist("Khela");
        Song song = new Song("amar gaan");
        ConcreteArtist artist = new ConcreteArtist(null);
        User user = new User("amar gaan");
        MusicLibraryFacade fc = new MusicLibraryFacade(artist, user, song, playlist);
        fc.play();
    }

    
    

    
}
