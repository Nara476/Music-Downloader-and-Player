import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MusicDownloader {

    public static void main(String[] args) throws FileNotFoundException {

        // a scanner to scan file
        Scanner scanner = new Scanner(
                new File("SongsUrl.txt"));

        final String ytDlpPath = "C:\\Users\\NITRO\\Downloads\\yt-dlp.exe";

        ArrayList<String> ytUrl = new ArrayList<>();

        while (scanner.hasNextLine()) {
            ytUrl.add(scanner.nextLine());
        }

        try {
            for (String url : ytUrl) {
                String[] command = {
                        ytDlpPath,
                        "-x",
                        "--audio-format",
                        "mp3",
                        "-P", "C:\\Users\\NITRO\\Desktop\\JavaProjects\\MusicPlayer\\Musics",
                        "-o", "%(title)s.%(ext)s",
                        url
                };
                ProcessBuilder musicGetter = new ProcessBuilder(command).inheritIO();
                Process downloadProcess = musicGetter.start();
                downloadProcess.waitFor();

            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }

}
