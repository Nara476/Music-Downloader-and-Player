import java.io.File;
import java.io.IOException;

public class MusicPlayer {

    public static void main(String[] args) throws IOException, InterruptedException {

        File MusicFolder = new File("Musics");

        File[] songFiles = MusicFolder.listFiles();

        if (songFiles == null || songFiles.length == 0) {
            System.out.println("No music files found in folder!");
            return;
        }

        for (File musicFile : songFiles) {
            String filePath = musicFile.getAbsolutePath();
            ProcessBuilder musicPlayer = new ProcessBuilder("C:\\Program Files\\VideoLAN\\VLC\\vlc.exe",
                    "--play-and-exit",
                    filePath);
            Process musicPlaying = musicPlayer.start();
            musicPlaying.waitFor();
        }
    }

}
