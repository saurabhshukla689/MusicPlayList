import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import org.example.MusicPlaylist;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MusicPlaylistTest {
    private MusicPlaylist memoryStore;

    @BeforeEach
    public void setUp() {
        int n = 3; // Initial capacity for testing
        memoryStore = new MusicPlaylist(n);
    }

    @Test
    public void testAddSong() {
        memoryStore.addSong("Song 1");
        memoryStore.addSong("Song 2");
        memoryStore.addSong("Song 3");
        memoryStore.addSong("Song 4");

        List<String> recentlyPlayed = memoryStore.returnRecentSongs();
        assertEquals(3, recentlyPlayed.size()); // Capacity is 3, so only the last 3 songs should be stored
        assertEquals("Song 2", recentlyPlayed.get(0));
        assertEquals("Song 3", recentlyPlayed.get(1));
        assertEquals("Song 4", recentlyPlayed.get(2));
    }

    @Test
    public void testCapacityNotExceeded() {
        memoryStore.addSong("Song 1");
        memoryStore.addSong("Song 2");

        List<String> recentlyPlayed = memoryStore.returnRecentSongs();
        assertEquals(2, recentlyPlayed.size());
        assertEquals("Song 1", recentlyPlayed.get(0));
        assertEquals("Song 2", recentlyPlayed.get(1));
    }

    @Test
    public void testCapacityExceeded() {
        memoryStore.addSong("Song 1");
        memoryStore.addSong("Song 2");
        memoryStore.addSong("Song 3");
        memoryStore.addSong("Song 4");

        List<String> recentlyPlayed = memoryStore.returnRecentSongs();
        assertEquals(3, recentlyPlayed.size());
        assertEquals("Song 2", recentlyPlayed.get(0));
        assertEquals("Song 3", recentlyPlayed.get(1));
        assertEquals("Song 4", recentlyPlayed.get(2));
    }

    @Test
    public void testEmptyRecentlyPlayed() {
        List<String> recentlyPlayed = memoryStore.returnRecentSongs();
        assertEquals(0, recentlyPlayed.size());
    }
}
